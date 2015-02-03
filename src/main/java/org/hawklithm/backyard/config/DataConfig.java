package org.hawklithm.backyard.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by bluehawky on 2014/12/16 0016.
 */
@Configuration
@MapperScan("org.hawklithm.backyard.persistence")
@EnableTransactionManagement
@PropertySource("file:/home/app.properties")
public class DataConfig {
    private static SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
    @Value("${test}")
    String test;
    static {
        dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUsername("sa");
        dataSource.setUrl("jdbc:h2:mem");
        dataSource.setPassword("");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        System.out.println("Creating tables");
        jdbcTemplate.execute("DROP TABLE IF EXISTS article_detail");
        jdbcTemplate.execute("CREATE TABLE article_detail (" +
                "  article_code varchar(1024) NOT NULL ,"+
                "  article_content varchar(10240) DEFAULT NULL,"+
                "  gmt_created datetime NOT NULL," +
                "  gmt_modified datetime NOT NULL," +
                "  sort_id int(11) NOT NULL,"+
                "  article_id int(11) PRIMARY KEY AUTO_INCREMENT,"+
                "  status tinyint(4) NOT NULL DEFAULT 1,"+
                "  PRIMARY KEY (article_id)" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8");
        jdbcTemplate.execute("DROP TABLE IF EXISTS `article_info`");
        jdbcTemplate.execute("CREATE TABLE `article_info` (\n" +
                "  `article_info_id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `article_code` varchar(1024) NOT NULL,\n" +
                "  `creator_id` int(11) NOT NULL COMMENT '作者id',\n" +
                "  `gmt_created` datetime NOT NULL COMMENT '创建时间',\n" +
                "  `gmt_modified` datetime NOT NULL COMMENT '修改时间',\n" +
                "  `article_title` varchar(1024) NOT NULL COMMENT '文章标题',\n" +
                "  `article_size` int(11) NOT NULL,\n" +
                "  PRIMARY KEY (`article_info_id`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8");
    }
    @Bean
    public DataSource dataSource() {

        // create a table and populate some data
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        System.out.println("Creating tables");
//        jdbcTemplate.execute("drop table users if exists");
//        jdbcTemplate.execute("create table users(id serial, firstName varchar(255), lastName varchar(255), email varchar(255))");
//        jdbcTemplate.update("INSERT INTO users(firstName, lastName, email) values (?,?,?)", "Mike", "Lanyon", "lanyonm@gmail.com");

        System.out.println(test);
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("org.hawklithm.backyard.domain");
        return sessionFactory;
    }
}
