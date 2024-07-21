package com.example.passkeylogindemo.service;

import java.security.*;
import java.util.Base64;

/**
 * 这个类负责使用用户的密钥对签名和验证数据
 */
public class PasskeyVerification {
    /**
     * 使用私钥对数据进行签名
     * 
     * @param data - 要签名的数据
     * @param privateKey - 用于签名的私钥
     * @return String - Base64编码的签名
     * @throws NoSuchAlgorithmException 如果指定的算法不可用时抛出异常
     * @throws InvalidKeyException 如果提供的密钥无效时抛出异常
     * @throws SignatureException 如果签名操作失败时抛出异常
     */
    public static String signData(String data, PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        // 创建Signature对象，使用SHA256withRSA算法
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        // 初始化Signature对象，用私钥进行签名
        privateSignature.initSign(privateKey);
        // 更新要签名的数据
        privateSignature.update(data.getBytes());
        // 生成签名并进行Base64编码
        byte[] signature = privateSignature.sign();
        return Base64.getEncoder().encodeToString(signature);
    }

    /**
     * 使用公钥验证数据和签名
     * 
     * @param data - 要验证的数据
     * @param signature - Base64编码的签名
     * @param publicKey - 用于验证的公钥
     * @return boolean - 如果签名有效，返回true；否则返回false
     * @throws NoSuchAlgorithmException 如果指定的算法不可用时抛出异常
     * @throws InvalidKeyException 如果提供的密钥无效时抛出异常
     * @throws SignatureException 如果签名操作失败时抛出异常
     */
    public static boolean verifyData(String data, String signature, PublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        // 创建Signature对象，使用SHA256withRSA算法
        Signature publicSignature = Signature.getInstance("SHA256withRSA");
        // 初始化Signature对象，用公钥进行验证
        publicSignature.initVerify(publicKey);
        // 更新要验证的数据
        publicSignature.update(data.getBytes());
        // 解码Base64编码的签名
        byte[] signatureBytes = Base64.getDecoder().decode(signature);
        // 验证签名并返回结果
        return publicSignature.verify(signatureBytes);
    }
}

