package com.genius.solar.freitech.controller;

import com.genius.solar.freitech.present.form.ValidationResult;
import org.springframework.ui.Model;

import java.util.List;

public class ControllerBase {
    public void errorView(List<ValidationResult> errors, Model model) {
    }
}
