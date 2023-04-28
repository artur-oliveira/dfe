package com.softart.dferestapi.services.encrypt;

import com.softart.dfe.util.Base64Utils;
import com.softart.dferestapi.configuration.properties.EncryptionProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;

@Service
@Getter
@Setter
public final class EncryptServiceImpl implements EncryptService {
    private final static String SECRET_KEY_ALG = "PBKDF2WithHmacSHA256";
    private final static int ITERATION_COUNT = 65536;
    private final static int KEY_LENGTH = 256;
    private final static int SALT_BYTE_LENGHT = 32;
    private final static String SECRET_KEY_SPEC_ALG = "AES";
    private final static String CYPHER_TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private final Random random = new SecureRandom();

    private final EncryptionProperties encryptionProperties;

    public EncryptServiceImpl(
            EncryptionProperties encryptionProperties
    ) {
        this.encryptionProperties = encryptionProperties;
    }

    Cipher getCipher(String salt, int mode) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {
        IvParameterSpec ivspec = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

        SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_ALG);
        KeySpec spec = new PBEKeySpec(getEncryptionProperties().getKey().toCharArray(), salt.getBytes(), ITERATION_COUNT, KEY_LENGTH);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), SECRET_KEY_SPEC_ALG);
        Cipher cipher = Cipher.getInstance(CYPHER_TRANSFORMATION);

        cipher.init(mode, secretKey, ivspec);

        return cipher;
    }

    @SneakyThrows
    @Override
    public String encrypt(String string, String salt) {
        Cipher cipher = getCipher(salt, Cipher.ENCRYPT_MODE);
        return Base64Utils.encodeToString(cipher.doFinal(string.getBytes(StandardCharsets.UTF_8)));
    }

    @SneakyThrows
    @Override
    public String decrypt(String string, String salt) {
        Cipher cipher = getCipher(salt, Cipher.DECRYPT_MODE);
        return new String(cipher.doFinal(Base64Utils.decode(string)));
    }

    @Override
    public String generateSalt() {
        final byte[] salt = new byte[32];
        getRandom().nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
}
