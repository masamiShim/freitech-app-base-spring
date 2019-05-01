package com.genius.solar.freitech.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Getter
@Embeddable
@Access(AccessType.FIELD)
@NoArgsConstructor
public class UserName {

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    public static UserName ofEmptyUser() {
        return new UserName("", "");
    }

    public UserName(@NotNull String firstName, @NotNull String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.valid();
    }

    public String getFullName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }

    // TODO: なんかあれば
    private void valid() {

    }

}
