package com.example.residueixappmobil.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

/**
 * Classe per gestionar el xifrat de la paraula clau.
 *
 * @author Daniel Garcia Ruiz
 * @version 02/05/2023
 */
public class xifratParaulaClau {
    private static final String ALGORITHM = "AES";
    private static final String KEY = "R3s1d831XK3yX1fr4t32Byt3sS3c8r1t";

    public static SecretKey generateSecretKey() {
        byte[] keyBytes = KEY.getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec(keyBytes, ALGORITHM);
    }

    public static String encrypt(String value) throws Exception {
        SecretKey key = generateSecretKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedByteValue = cipher.doFinal(value.getBytes("utf-8"));
        return Base64.getEncoder().encodeToString(encryptedByteValue);
    }

    public static String decrypt(String value) throws Exception {
        SecretKey key = generateSecretKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedByteValue = cipher.doFinal(Base64.getDecoder().decode(value));
        return new String(decryptedByteValue, "utf-8");
    }

}
