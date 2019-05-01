package com.genius.solar.freitech.db.mysql.repository;

import com.genius.solar.freitech.db.mysql.entity.User;
import com.genius.solar.freitech.domain.Email;
import com.genius.solar.freitech.domain.Password;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail(Email email);

    Optional<User> findByUserIdAndPassword(String userId, Password password);
}
