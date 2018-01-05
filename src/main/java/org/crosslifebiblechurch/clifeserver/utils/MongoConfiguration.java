package org.crosslifebiblechurch.clifeserver.utils;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by joshuaji on 1/4/18.
 */

@Configuration
@Profile("mongouserdetails")
public class MongoConfiguration {

    @Bean
    public MongoClient createConnection() {
        return new MongoClient();
    }
}
