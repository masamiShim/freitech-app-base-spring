package com.genius.solar.freitech.domain.crypt;

public interface ICryptService {
    String encryptWithSalt(String password);

    boolean notMatch(String password, String cryptPass);

}
