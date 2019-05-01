package com.genius.solar.freitech.domain;

import lombok.Getter;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Embeddable
@Access(AccessType.FIELD)
public class UserId implements Serializable {

    private String userId;

    public UserId(String userId) {
        this.userId = userId;
    }

}
