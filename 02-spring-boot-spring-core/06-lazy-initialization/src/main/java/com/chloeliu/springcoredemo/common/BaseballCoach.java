package com.chloeliu.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//if "Component" is not marked, this class wouldn't be included in the scanning
@Component
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice! :)";
    }

}
