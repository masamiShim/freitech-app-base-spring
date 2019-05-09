package com.genius.solar.freitech.db.mysql.code;

import java.util.Optional;

public interface EnumCode<T> {
    Optional<T> fromName(String name);
}
