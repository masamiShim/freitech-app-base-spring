package com.genius.solar.freitech.domain.crypt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Service("cryptService")
@ConditionalOnExpression("${application.demo:} eq false")
public class CryptServiceImpl implements ICryptService {
    @Value("login.password.salt")
    private String SALT;

    @Value("login.password.stretch")
    private String STRETCH_CNT;

    private static final String SHA_256 = "SHA-256";

    @Override
    public String encryptWithSalt(String password) {

        // TODO: saltとストレッチ入れる場合はこの前にでも
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean notMatch(String password, String cryptPass) {
        return !cryptPass.equals(encryptWithSalt(password));
    }

    private String getSha256(String target) {
        MessageDigest md = null;
        StringBuffer buf = new StringBuffer();
        try {
            md = MessageDigest.getInstance(SHA_256);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("illegal crypt method");
        }

        md.update(target.getBytes());
        byte[] digest = md.digest();

        for (int i = 0; i < digest.length; i++) {
            buf.append(String.format("%02x", digest[i]));
        }

        return buf.toString();
    }
}
