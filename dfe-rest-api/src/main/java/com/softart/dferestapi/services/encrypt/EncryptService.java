package com.softart.dferestapi.services.encrypt;

public interface EncryptService {
    String encrypt(String string, String salt);

    String decrypt(String string, String salt);

    String generateSalt();
}
