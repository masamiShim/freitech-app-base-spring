package com.genius.solar.freitech.present.form;

import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class LoginForm {
    private String email;
    private String password;

    public Optional<List<ValidationResult>> valid() {
        return Optional.empty();
    }
}
