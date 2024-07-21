package com.example.passkeylogindemo.service;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/**
 * 这个类负责生成公钥/私钥对
 */
public class PasskeyRegistration {
    /**
     * 生成一个RSA算法的公钥/私钥对
     * 
     * @return KeyPair - 生成的公钥/私钥对
     * @throws NoSuchAlgorithmException 如果指定的算法不可用时抛出异常
     */
    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        // 创建一个KeyPairGenerator对象，用于生成密钥对
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥生成器，密钥大小为2048位
        keyGen.initialize(2048);
        // 生成密钥对并返回
        return keyGen.genKeyPair();
    }
}

