package com.clteam.security.dto;

import com.clteam.security.validation.PasswordMatches;
import com.clteam.security.validation.ValidPassword;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Khanh Nguyen on 16/5/2017.
 */
@PasswordMatches
public class AccountDto {

    private String email;

    @ValidPassword
    private String password;

    @NotNull
    @Size(min = 1)
    private String confirmPassword;

    @NotNull
    @Size(min = 1)
    private String fullName;

    private String address;

    private String dateOfBirth;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AccountDto [email = ").append(email)
                .append(", password = ").append(password)
                .append(", confirmPassword = ").append(confirmPassword)
                .append(", fullName = ").append(fullName)
                .append(", address = ").append(address)
                .append(", dateOfBirth = ").append(dateOfBirth)
                .append("]");
        return builder.toString();
    }
}
