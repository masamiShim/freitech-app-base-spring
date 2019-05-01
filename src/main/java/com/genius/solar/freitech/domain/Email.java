package com.genius.solar.freitech.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
@Getter
@Access(AccessType.FIELD)
@NoArgsConstructor
public class Email {

    @Column(name = "email")
    private String email;

    public Email(@NotNull String email) {
        this.email = email;
    }

    // TODO:　なんかあれば
    private void valid() {

    }
}
