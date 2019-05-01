package com.genius.solar.freitech.present.form.exception;

public class PasswordRuleException extends RuntimeException {
    public PasswordRuleException(String password) {
        super("illegal password error: [password] -> " + password);
    }
}
