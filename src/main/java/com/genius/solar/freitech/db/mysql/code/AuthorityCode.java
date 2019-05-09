package com.genius.solar.freitech.db.mysql.code;

import lombok.Getter;

import java.util.Optional;
import java.util.stream.Stream;

public enum AuthorityCode implements EnumCode {
    UPLOAD_CSV("UPLOAD_CSV", "CSVアップロード"),
    REGISTER_ROLE("REGISTER_ROLE", "役割登録"),
    REGISTER_AUTHORITY("REGISTER_AUTHORITY", "権限登録"),
    SEND_INVITE_MAIL("SEND_INVITE_MAIL", "招待メール送信");

    @Getter
    private String name;
    @Getter
    private String jpName;

    AuthorityCode(String name, String jpName) {
        this.name = name;
        this.jpName = jpName;
    }

    @Override
    public Optional<AuthorityCode> fromName(String name) {
        return Stream.of(AuthorityCode.values())
                .filter(v -> v.getName().equals(name))
                .findFirst();
    }
}
