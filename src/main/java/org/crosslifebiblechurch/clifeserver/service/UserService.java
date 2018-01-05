package org.crosslifebiblechurch.clifeserver.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joshuaji on 1/4/18.
 */
@Service("userService")
public class UserService {
    public Map<String, Object> findUserByUsername(String username) {
        Map<String, Object> userMap = null;
        //logic here to get your user from the database
        if (username.equals("admin") || username.equals("user")) {
            userMap = new HashMap();
            userMap.put("username", "admin");
            userMap.put("password", "password");
            //if username is admin, role will be admin, else role is user only
            userMap.put("role", (username.equals("admin")) ? "admin" : "user");
            //return the usermap
            return userMap;
        }
        //if username is not equal to admin, return null
        return null;
    }
}
