package com.chloeliu.springcoredemo.rest;

import com.chloeliu.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a private field for the dependency
    private Coach myCoach;

    //define a constructor for dependency injection
    //@Autowired
    //public DemoController(Coach theCoach) {
    //    myCoach = theCoach;
    //}

    //setter injection example
    //the method name doesn't need to be "setCoach", you can name anything like "doSomeStuff"
    @Autowired
    public void setCoach(Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping
    public String homePage() {
        return "This is Home Page.";
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
