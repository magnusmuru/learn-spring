package com.example.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/showform")
    public String showForm() {
        return "showform";
    }

    @RequestMapping("/processForm")
    public String processForm(@RequestParam(name = "studentName") String studentName, Model model) {

        return "helloworld";
    }

    // new controller method to read form data
    // add data to the model

    @RequestMapping("/processFormVersionTwo")
    public String loudSpeaker(HttpServletRequest request, Model model) {

        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");
        String studentName = request.getParameter("studentName");

        // convert data to uppercase
        theName = theName.toUpperCase();

        // create the message
        String result = "Hello friend " + theName;

        // add the message to the model
        model.addAttribute("message", result);
        model.addAttribute("studentName", studentName);

        return "helloworld";
    }
}
