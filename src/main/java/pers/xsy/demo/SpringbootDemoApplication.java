package pers.xsy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pers.xsy.demo.properties.SpringSecurityProperties;

@SpringBootApplication
@EnableConfigurationProperties(SpringSecurityProperties.class)
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}
