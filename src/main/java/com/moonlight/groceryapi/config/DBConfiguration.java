package com.moonlight.groceryapi.config;

import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration;
import dev.miku.r2dbc.mysql.MySqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.transaction.ReactiveTransactionManager;

@Configuration
@Slf4j
@RequiredArgsConstructor
@EnableR2dbcRepositories
public class DBConfiguration extends AbstractR2dbcConfiguration {

    final DBProperties dbProperties;
//    @Bean
//    ConnectionFactory connectionFactory(DBProperties dbProperties) {
//        log.info("Bean[connectionFactory] DBProperties : {}", dbProperties);
//        return MySqlConnectionFactory.from(
//                MySqlConnectionConfiguration.builder()
//                        .database(dbProperties.getDatabase())
//                        .host(dbProperties.getHost())
//                        .port(dbProperties.getPort())
//                        .username(dbProperties.getUsername())
//                        .password(dbProperties.getPassword())
//                        .build()
//        );
//    }

//    @Bean
//    public DatabaseClient databaseClient(MySqlConnectionFactory connectionFactory) {
//        return DatabaseClient.builder()
//                .connectionFactory(connectionFactory)
//                .build();
//    }
//
//    @Bean
//    R2dbcEntityTemplate r2dbcEntityTemplate(ConnectionFactory connectionFactory) {
//        log.info("[r2dbcEntityTemplate]: connectionFactory : {}", connectionFactory);
//        return new R2dbcEntityTemplate(connectionFactory);
//    }

    @Bean
    @Override
    public ConnectionFactory connectionFactory() {
        log.info("Bean[connectionFactory] DBProperties : {}", dbProperties);
        return MySqlConnectionFactory.from(
                MySqlConnectionConfiguration.builder()
                        .database(dbProperties.getDatabase())
                        .host(dbProperties.getHost())
                        .port(dbProperties.getPort())
                        .username(dbProperties.getUsername())
                        .password(dbProperties.getPassword())
                        .unixSocket(dbProperties.getSocketPath())
                        .build()
        );
    }

//    @Bean
//    ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
//        return new R2dbcTransactionManager(connectionFactory);
//    }
//
//    @Bean
//    public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
//        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
//        initializer.setConnectionFactory(connectionFactory);
//        CompositeDatabasePopulator populator = new CompositeDatabasePopulator();
//        populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("src/main/resources/scema.sql")));
//        initializer.setDatabasePopulator(populator);
//        return initializer;
//    }

}
