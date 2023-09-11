package com.chloeliu.springdemo.mvc.controller;

import com.chloeliu.springdemo.mvc.entity.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    //The @InitBinder annotation is a Spring MVC annotation
    //that is used to customize the data binding process in your controller.
    //Method Signature: You annotate a method in your controller class with @InitBinder.
    //This method typically takes a WebDataBinder as a parameter.

    //Pre-process every String from data
    //Remove leading and trailing white space
    //If String only has white space, trim it to null
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }



    //Model allows us to share information between Controllers and view pages(Thymeleaf)
    @GetMapping("/")
    public String showForm(Model theModel) {
        //add data to the Model
        //name - "customers" - we will use the attribute name in our view pages like our html forms
        //value - a empty Customer instance
        //name and value are important because we are using html data binding
        theModel.addAttribute("customer", new Customer());

        return "customer-form"; //logical name of view page - will map to: customer-form.html
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult theBindingResult) {

        System.out.println("Last name: | " + theCustomer.getLastName() + "|");  //debug

        System.out.println("Binding result: " + theBindingResult.toString());

        System.out.println("\n\n\n\n");

        if (theBindingResult.hasErrors()) {
            return "customer-form";
        }
        else {
            return "customer-confirmation";
        }
    }
}
