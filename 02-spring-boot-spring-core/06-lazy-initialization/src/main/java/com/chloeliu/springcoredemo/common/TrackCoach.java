package com.chloeliu.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//there are multiple implementations of Coach, we are making TrackCoach as Primary
//we can only have a single @Primary implementation, otherwise, get error message:
//more than one 'primary' bean found among candidates: [baseballCoach, cricketCoach, tennisCoach, trackCoach]
//@Qualifier has higher priority than @Primary
@Component
//@Primary
@Lazy
public class TrackCoach implements Coach {

    public TrackCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k! :)";
    }

}
