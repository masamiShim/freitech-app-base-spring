package com.genius.solar.freitech.present.form;

import lombok.Data;

@Data
public class ValidationResult {
    private String attr;
    private String message;

    public String getAttr() {
        return attr;
    }
    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
