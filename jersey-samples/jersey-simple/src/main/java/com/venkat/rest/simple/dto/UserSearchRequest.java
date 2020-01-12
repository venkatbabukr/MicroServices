package com.venkat.rest.simple.dto;

import javax.ws.rs.QueryParam;

import com.venkat.rest.simple.data.Sex;
import com.venkat.rest.simple.data.User;
import com.venkat.rest.simple.data.UserSearchCriteria;
import com.venkat.rest.simple.util.StringUtils;

public class UserSearchRequest<U extends User> implements UserSearchCriteria<U> {

    @QueryParam("fn")
    private String fn;

    @QueryParam("ln")
    private String ln;

    @QueryParam("email")
    private String email;

    @QueryParam("age")
    private int age;

    @QueryParam("sex")
    private Sex sex;

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
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

    @Override
    public boolean equals(U user) {
        return (fn == null || user.getFirstName().matches(StringUtils.getContainsRegex(fn))) &&
               (ln == null || user.getLastName().matches(StringUtils.getContainsRegex(ln))) &&
               (email == null || user.getEmail().matches(StringUtils.getContainsRegex(email))) &&
               (age == 0 || age == user.getAge()) &&
               (sex == null || sex.equals(user.getSex()));
    }

}
