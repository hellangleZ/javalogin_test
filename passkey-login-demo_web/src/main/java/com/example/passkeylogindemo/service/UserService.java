package com.example.passkeylogindemo.service;

import com.example.passkeylogindemo.model.User;
import com.example.passkeylogindemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;

/**
 * 用户服务类，处理用户注册和查找逻辑。
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(String username, String password) throws NoSuchAlgorithmException {
        // 生成密钥对
        KeyPair keyPair = PasskeyRegistration.generateKeyPair();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPublicKey(Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()));
        user.setPrivateKey(Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded()));
        return userRepository.save(user);
    }

    public Optional<User> findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
