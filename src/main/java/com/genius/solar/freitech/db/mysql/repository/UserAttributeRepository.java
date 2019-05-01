package com.genius.solar.freitech.db.mysql.repository;

import com.genius.solar.freitech.db.mysql.entity.UserAttribute;
import com.genius.solar.freitech.domain.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAttributeRepository extends JpaRepository<UserAttribute, UserId> {
}
