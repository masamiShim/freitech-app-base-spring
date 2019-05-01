package com.genius.solar.freitech.domain.valueobject;


import com.genius.solar.freitech.domain.Email;
import com.genius.solar.freitech.domain.Password;
import lombok.Getter;

@Getter
public class VoSignIn {
    private Email email;
    private Password password;

    public VoSignIn(Email email, Password password) {
        this.email = email;
        this.password = password;
    }
}
