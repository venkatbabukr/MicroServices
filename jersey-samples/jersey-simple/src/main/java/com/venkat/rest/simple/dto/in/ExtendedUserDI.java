package com.venkat.rest.simple.dto.in;

import javax.validation.constraints.NotBlank;
import javax.ws.rs.QueryParam;

import com.venkat.rest.simple.data.ExtendedUser;
import com.venkat.rest.simple.util.StringUtils;
import com.venkat.rest.simple.validation.ValidationGroups;

public class ExtendedUserDI<U extends ExtendedUser> extends UserDI<U> implements ISearchInput<U>, IEntityInput<U> {

    @QueryParam("addr")
    private String addr;

    @NotBlank(groups = { ValidationGroups.CreateOperation.class, ValidationGroups.UpdateOperation.class },
              message = "{com.venkat.rest.simple.dto.in.ExtendedUserDI.phone.required}")
    @QueryParam("ph")
    private String phone;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean matchEntity(U extendedUser) {
        return super.matchEntity(extendedUser) &&
                   (addr == null || (extendedUser.getAddress() != null && extendedUser.getAddress().matches(StringUtils.getContainsRegex(addr)))) &&
                   (phone == null || extendedUser.getPhone().matches(StringUtils.getContainsRegex(phone)));
    }

    @Override
    @SuppressWarnings("unchecked")
    public U toEntity() {
        return (U) new ExtendedUser(getUserId(), getFirstName(), getLastName(), getEmail(), getAge(), getSex(), addr, phone);
    }

    @Override
    public U patchEntity(U extendedUser, boolean patchUpdate) {
        super.patchEntity(extendedUser, patchUpdate);
        if (!patchUpdate || addr != null) extendedUser.setAddress(addr);
        if (!patchUpdate || phone != null) extendedUser.setPhone(phone);
        return extendedUser;
    }

}
