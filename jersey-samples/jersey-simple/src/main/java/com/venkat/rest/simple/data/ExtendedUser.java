package com.venkat.rest.simple.data;

import javax.validation.constraints.NotBlank;

public class ExtendedUser extends User {

    private String address;

    @NotBlank(message = "Phone is required...")
    private String phone;

    public ExtendedUser() { }

    public ExtendedUser(String userId, String fn, String ln, String email, int age,
                            Sex sex, String address, String phone) {
        super(userId, fn, ln, email, age, sex);
        this.address = address;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
