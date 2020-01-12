package com.venkat.rest.simple.dto;

import javax.ws.rs.QueryParam;

import com.venkat.rest.simple.data.ExtendedUser;
import com.venkat.rest.simple.data.UserSearchCriteria;
import com.venkat.rest.simple.util.StringUtils;

public class ExtendedUserSearchRequest<U extends ExtendedUser> extends UserSearchRequest<U> implements UserSearchCriteria<U> {

    @QueryParam("addr")
    private String addr;

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

    public boolean equals(U user) {
        return super.equals(user) &&
                   (addr == null || (user.getAddress() != null && user.getAddress().matches(StringUtils.getContainsRegex(addr)))) &&
                   (phone == null || user.getPhone().contains(phone));
    }

}
