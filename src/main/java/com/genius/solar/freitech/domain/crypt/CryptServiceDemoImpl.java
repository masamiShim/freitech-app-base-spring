package com.genius.solar.freitech.domain.crypt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@ConditionalOnExpression("${application.demo:} eq true")
public class CryptServiceDemoImpl implements ICryptService {
    @Override
    public String encryptWithSalt(String password) {
        return password;
    }

    @Override
    public boolean notMatch(String password, String cryptPass) {
        return !cryptPass.equals(encryptWithSalt(password));
    }

}
