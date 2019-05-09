package com.genius.solar.freitech.db.mysql.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Role extends SecurityAuditor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Authority> authorities;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<UserRole> userRoles;

}
