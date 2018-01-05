package org.crosslifebiblechurch.clifeserver.service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.crosslifebiblechurch.clifeserver.utils.MongoUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class MongoUserDetailsService implements UserDetailsService {

    @Autowired
    private MongoClient mongoClient;

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MongoDatabase database = mongoClient.getDatabase("springsecurity");
        MongoCollection<org.bson.Document> collection = database.getCollection("users");
        System.out.println("===Got user: " + username + "===");
        //Find by username, get rest of info based on that
        Document document = collection.find(Filters.eq("username", username)).first();
        if(document!=null) {
            String password = document.getString("password");
            List<String> authorities = (List<String>) document.get("authorities");
            return new MongoUserDetails(username, password, authorities.toArray(new String[authorities.size()]));
        } else {
            throw new UsernameNotFoundException("username not found");
        }
    }
}
