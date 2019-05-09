package com.genius.solar.freitech.db.mysql.code;

import lombok.Getter;

import java.util.Optional;
import java.util.stream.Stream;

public enum RoleCode implements EnumCode {
    ADMIN("ADMINISTRATOR", "管理者"),
    OPERATOR("OPERATOR", "オペレータ"),
    CUSTOMER("CUSTOMER", "利用者");

    @Getter
    private String name;
    @Getter
    private String jpName;

    RoleCode(String name, String jpName) {
        this.name = name;
        this.jpName = jpName;
    }

    @Override
    public Optional<RoleCode> fromName(String name) {
        return Stream.of(RoleCode.values())
                .filter(v -> v.getName().equals(name))
                .findFirst();
    }
}
