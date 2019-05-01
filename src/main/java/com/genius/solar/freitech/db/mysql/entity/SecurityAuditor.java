package com.genius.solar.freitech.db.mysql.entity;

import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EntityListeners(value = AuditingEntityListener.class)
@MappedSuperclass
public abstract class SecurityAuditor implements Serializable {

    @Version
    protected long version;

    @CreatedBy
    protected String createdBy;

    @CreatedDate
    protected LocalDateTime created;

    @LastModifiedBy
    protected String modifiedBy;

    @LastModifiedDate
    protected LocalDateTime modified;

    protected String deletedBy;
}
