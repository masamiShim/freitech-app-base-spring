package com.genius.solar.freitech.db.mysql.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class UserRole extends SecurityAuditor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId", referencedColumnName = "id")
    private Role role;

}
