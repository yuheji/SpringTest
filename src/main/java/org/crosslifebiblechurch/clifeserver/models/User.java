package org.crosslifebiblechurch.clifeserver.models;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.List;

/**
 * Created by joshuaji on 12/1/17.
 */
public class User {
    @Id
    private String id;
    private String password;
    private String userName;
    private List<GrantedAuthority> grantedAuthorities;

    public User(String username,String password,String[] authorities) {
        this.userName = username;
        this.password = password;
        this.grantedAuthorities = AuthorityUtils.createAuthorityList(authorities);
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
