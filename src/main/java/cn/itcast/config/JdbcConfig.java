package cn.itcast.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
//@PropertySource("classpath:application.yml")
//@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig {

    /*@Value("${jdbc.url}")
    String url;
    @Value("${jdbc.driverClassName}")
    String driver;
    @Value("${jdbc.username}")
    String username;
    @Value("${jdbc.password}")
    String password;

    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }*/

    /*@Bean
    public DataSource dataSource(JdbcProperties jdbcProperties){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName(jdbcProperties.getDriverClassName());
        dataSource.setUrl(jdbcProperties.getUrl());
        dataSource.setUsername(jdbcProperties.getUsername());
        dataSource.setPassword(jdbcProperties.getPassword());
        return dataSource;
    }*/

    @Bean
    @ConfigurationProperties(prefix = "jdbc")
    //加载application.properties文件中前缀是jdbc的配置项数据,存放DruidDataSource的属性(配置项目的名称和属性名称一致)中
    public DataSource dataSource(){
        return new DruidDataSource();
    }

}
