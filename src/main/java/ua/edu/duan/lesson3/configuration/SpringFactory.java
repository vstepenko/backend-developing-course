package ua.edu.duan.lesson3.configuration;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import ua.edu.duan.lesson3.controller.TestController;
import ua.edu.duan.lesson3.service.TestService;
import ua.edu.duan.lesson3.service.TestServiceTwo;

@Configuration
public class SpringFactory {


    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public TestService testService() {
        return new TestService(){
            @Override
            protected TestServiceTwo getTestServiceTwo() {
                return testServiceTwo();
            }
        };
    }


    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public TestServiceTwo testServiceTwo() {
        return new TestServiceTwo();
    }
}
