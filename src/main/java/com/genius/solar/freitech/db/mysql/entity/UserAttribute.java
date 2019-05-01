package com.genius.solar.freitech.db.mysql.entity;

import com.genius.solar.freitech.domain.Email;
import com.genius.solar.freitech.domain.UserId;
import com.genius.solar.freitech.domain.UserName;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Access(AccessType.FIELD)
@NoArgsConstructor
public class UserAttribute extends SecurityAuditor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Embedded
    private UserId userId;

    @Embedded
    private UserName userName;

    public UserAttribute(UserName userName) {
        this.userName = userName;
    }

}
