package com.genius.solar.freitech.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Getter
@Embeddable
@Access(AccessType.FIELD)
@NoArgsConstructor
public class Password {
    private String password;

    public Password(String password) {
        this.password = password;
    }
}
