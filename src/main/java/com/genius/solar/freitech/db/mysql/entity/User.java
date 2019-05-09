package com.genius.solar.freitech.db.mysql.entity;

import com.genius.solar.freitech.domain.Email;
import com.genius.solar.freitech.domain.Password;
import com.genius.solar.freitech.domain.UserId;
import com.genius.solar.freitech.domain.valueobject.VoSignIn;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Data
@ToString(exclude = {"email"})
@Access(AccessType.FIELD)
@NoArgsConstructor
public class User extends SecurityAuditor implements UserDetails {

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Id
    @Column(name = "userId")
    private String userId;

    @Embedded
    private Email email;

    @Embedded
    @Column(name = "password")
    private Password password;

    @Column(name = "expired")
    private boolean expired;

    @Column(name = "locked")
    private boolean locked;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "userId")
    private UserRole userRole;

    public User(Email email, Password password) {
        this.email = email;
        this.password = password;
    }

    public static User from(VoSignIn signIn) {
        return new User(signIn.getEmail(), signIn.getPassword());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return this.password.getPassword();
    }

    @Override
    public String getUsername() {
        return this.userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
