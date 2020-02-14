package pers.xsy.demo.exception;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Test implements ApplicationRunner, EnvironmentAware {

    private Environment env;

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("test");
    }

    @Override
    public void setEnvironment(Environment environment) {
        env = environment;
    }

}
