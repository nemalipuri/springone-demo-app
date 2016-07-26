package com.dish.ext.demo.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@Component
public class JdbcConfig {

//    @Primary
//    @Bean(name = "db1DataSource")
//    @ConfigurationProperties(prefix = "database.connection.db1") public DataSource db1DataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "db2DataSource") @ConfigurationProperties(prefix = "database.connection.db2")
//    public DataSource db2DataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "db2JdbcTemplate")
//    public JdbcTemplate db2JdbcTemplate(@Qualifier("db2DataSource") DataSource ds) {
//        return new JdbcTemplate(ds);
//    }
//
//    @Bean(name = "db1JdbcTemplate")
//    public JdbcTemplate db1JdbcTemplate(@Qualifier("db1DataSource") DataSource ds) {
//        return new JdbcTemplate(ds);
//    }

}
