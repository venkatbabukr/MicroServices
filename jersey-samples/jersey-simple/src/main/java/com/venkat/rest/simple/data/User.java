package com.venkat.rest.simple.data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

public class User {

    @NotBlank(message =  "{com.venkat.rest.simple.data.User.userId.required}")
    @Pattern(regexp = "\\w+", message = "{com.venkat.rest.simple.data.User.userId.pattern}")
    private String userId;

    @NotBlank(message = "{com.venkat.rest.simple.data.User.firstName.required}")
    @Pattern(regexp = "[a-zA-Z]+", message = "{com.venkat.rest.simple.data.User.firstName.pattern}")
    private String firstName;

    @NotBlank(message = "{com.venkat.rest.simple.data.User.lastName.required}")
    @Pattern(regexp = "[a-zA-Z]+", message = "{com.venkat.rest.simple.data.User.lastName.pattern}")
    private String lastName;

    @NotBlank(message = "{com.venkat.rest.simple.data.User.email.required}")
    @Email(message = "{com.venkat.rest.simple.data.User.email.pattern}")
    private String email;

    @Range(min = 18, max = 75, message = "{com.venkat.rest.simple.data.User.age.pattern}")
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
