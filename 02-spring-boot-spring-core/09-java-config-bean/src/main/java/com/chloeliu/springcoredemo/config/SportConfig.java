package com.chloeliu.springcoredemo.config;

import com.chloeliu.springcoredemo.common.Coach;
import com.chloeliu.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    //In this example, there is no @Component annotation in SwimCoach class
    //We create a java @Configuration class to configure the bean using @Bean
    //Bean id defaults to the method name, in this case, it's "swimCoach"
    //We can customize the bean id using @Bean("customBeanID")
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }

}
