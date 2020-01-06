package com.venkat.rest.simple.data;

public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private Sex sex;

    public User() { }

    public User(String userId, String fn, String ln, String email, int age, Sex sex) {
        this.userId = userId;
        this.firstName = fn;
        this.lastName = ln;
        this.email = email;
        this.age = age;
        this.sex = sex;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
