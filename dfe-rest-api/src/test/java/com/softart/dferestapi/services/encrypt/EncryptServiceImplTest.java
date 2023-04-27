package com.softart.dferestapi.services.encrypt;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Getter
@Setter
class EncryptServiceImplTest {

    @Autowired
    EncryptService encryptService;


    @Test
    void encrypt() {
        // Testing the encrypt method.
        Assertions.assertEquals("NRukmxeKh9omN9ukSULYBQ==", getEncryptService().encrypt("ABCDEFGH", "2jF5fJTQvUXRg3IYwe926VlrXYiS6P3k5P7B6BcoxfI="));
    }

    @Test
    void decrypt() {
        Assertions.assertEquals("ABCDEFGH", getEncryptService().decrypt("NRukmxeKh9omN9ukSULYBQ==", "2jF5fJTQvUXRg3IYwe926VlrXYiS6P3k5P7B6BcoxfI="));
    }

}