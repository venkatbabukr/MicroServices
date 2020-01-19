package com.venkat.rest.simple.data;

public class ExtendedUser extends User {

    private String address;
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

    /*
    public ExtendedUser updateFrom(ExtendedUser other, boolean patch) {
        super.updateFrom(other, patch);
        this.address = (patch && other.address == null) ? this.address : other.address;
        this.phone = (patch && other.phone == null) ? this.phone : other.phone;
        return this;
    }
    */

}
