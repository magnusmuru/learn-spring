package com.example.spring.mvc.controller;

import com.example.spring.mvc.objects.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // add an initbinder to convert and trim input strings
    // remove leading and trailing whitespace
    // resolve issue for empty validation

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/showform")
    public String showForm(Model model) {

        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {

        // How to check for errors
        System.out.println("Binding result: " + bindingResult);
        // Prints in the console what value was rejected and the error codes

        if (bindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "customer-confirmation";
        }

    }
}
