package com.springvalidation;

import com.springvalidation.util.DBManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jesus Lord Almighty
 * at 19.01.18
 */

@Configuration
public class AppConfig {

    @Bean
    public DBManager dbManager() {

        return new DBManager();
    }
}
