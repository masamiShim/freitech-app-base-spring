package com.genius.solar.freitech.exception;

import javax.validation.constraints.NotNull;

public class ExistEmailException extends RuntimeException {
    public ExistEmailException(@NotNull String email) {
        super("email address has registered: [emailAddress] -> " + email);
    }
}
