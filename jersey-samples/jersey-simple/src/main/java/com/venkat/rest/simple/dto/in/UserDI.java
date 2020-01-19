package com.venkat.rest.simple.dto.in;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.QueryParam;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.venkat.rest.simple.data.Sex;
import com.venkat.rest.simple.data.User;
import com.venkat.rest.simple.dto.in.UserDI;
import com.venkat.rest.simple.util.StringUtils;
import com.venkat.rest.simple.validation.ValidationGroups;

public class UserDI<U extends User> implements ISearchInput<U>, IEntityInput<U> {

    @NotBlank(groups = ValidationGroups.CreateOperation.class, message = "{com.venkat.rest.simple.dto.in.UserDI.userId.required}")
    @Pattern(regexp = "\\w+", message = "{com.venkat.rest.simple.dto.in.UserDI.userId.pattern}")
    private String userId;

    @NotBlank(groups = { ValidationGroups.CreateOperation.class, ValidationGroups.UpdateOperation.class },
              message = "{com.venkat.rest.simple.dto.in.UserDI.firstName.required}")
    @Pattern(regexp = "[a-zA-Z ]+", message = "{com.venkat.rest.simple.dto.in.UserDI.firstName.pattern}")
    @QueryParam("fn")
    private String firstName;

    @NotBlank(groups = { ValidationGroups.CreateOperation.class, ValidationGroups.UpdateOperation.class },
              message = "{com.venkat.rest.simple.dto.in.UserDI.lastName.required}")
    @Pattern(regexp = "[a-zA-Z ]+", message = "{com.venkat.rest.simple.dto.in.UserDI.lastName.pattern}")
    @QueryParam("ln")
    private String lastName;

    @NotBlank(groups = { ValidationGroups.CreateOperation.class, ValidationGroups.UpdateOperation.class },
              message = "{com.venkat.rest.simple.dto.in.UserDI.email.required}")
    @Email(message = "{com.venkat.rest.simple.dto.in.UserDI.email.pattern}")
    @QueryParam("email")
    private String email;

    @NotNull(groups = { ValidationGroups.CreateOperation.class, ValidationGroups.UpdateOperation.class },
             message = "{com.venkat.rest.simple.dto.in.UserDI.age.required}")
    @Range(min = 18, max = 75, message = "{com.venkat.rest.simple.dto.in.UserDI.age.range}")
    @QueryParam("age")
    private Integer age;

    @QueryParam("sex")
    private Sex sex;

    @JsonIgnore
    @AssertTrue(groups = { ValidationGroups.PatchOperation.class, ValidationGroups.UpdateOperation.class },
                message = "{com.venkat.rest.simple.dto.in.UserDI.userId.updateError}")
    public boolean isUserIdNull() {
        return this.userId == null;
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

    public void setFirstName(String fn) {
        this.firstName = fn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String ln) {
        this.lastName = ln;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public boolean matchEntity(U user) {
        return (firstName == null || user.getFirstName().matches(StringUtils.getContainsRegex(firstName))) &&
               (lastName == null || user.getLastName().matches(StringUtils.getContainsRegex(lastName))) &&
               (email == null || user.getEmail().matches(StringUtils.getContainsRegex(email))) &&
               (age == null || age == user.getAge()) &&
               (sex == null || sex.equals(user.getSex()));
    }

    @Override
    @SuppressWarnings("unchecked")
    public U toEntity() {
        return (U) new User(userId, firstName, lastName, email, age, sex);
    }

    @Override
    public U patchEntity(U user, boolean patchUpdate) {
        if (!patchUpdate || firstName != null) user.setFirstName(firstName);
        if (!patchUpdate || lastName != null) user.setLastName(lastName);
        if (!patchUpdate || email != null) user.setEmail(email);
        if (!patchUpdate || age != null) user.setAge(age);
        return user;
    }

}
