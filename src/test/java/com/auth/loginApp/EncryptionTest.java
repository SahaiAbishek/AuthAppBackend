package com.auth.loginApp;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.text.AES256TextEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;

public class EncryptionTest {

    private String password = "TennisApp";
    public static void main(String[] args) {
        EncryptionTest test = new EncryptionTest();
        String text = "mongodb+srv://SahaiAbhi:Easy2Guess!@cluster0.ywskn.mongodb.net/?retryWrites=true&w=majority";
        String enc = test.encrypt(text);
        String dec = test.decrypt(enc);

        System.out.println(enc);
        System.out.println(dec);

    }

    private  String encrypt(String text) {
        AES256TextEncryptor encryptor = new AES256TextEncryptor();
        encryptor.setPassword(password);
        String encryptedText = encryptor.encrypt(text);

        return encryptedText;
    }

    private  String decrypt(String text) {
        AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
        textEncryptor.setPassword(password);
        String decryptedText = textEncryptor.decrypt(text);

        return decryptedText;
    }
}
