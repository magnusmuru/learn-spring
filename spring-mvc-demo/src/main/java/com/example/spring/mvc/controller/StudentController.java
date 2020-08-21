package com.example.spring.mvc.controller;

import com.example.spring.mvc.objects.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{'${countries}'.split(',')}")
    private List<String> countries;

    @Value("#{'${languages}'.split(',')}")
    private List<String> programmingLanguages;

    @Value("#{'${opSys}'.split(',')}")
    private List<String> operatingSystems;

    @RequestMapping("/studentform")
    public String showForm(Model model) {

        Student theStudent = new Student();
        // add a new student object to the model
        model.addAttribute("student", theStudent);

        // add countries to the model

        // List<String> countries = Arrays.asList("United States", "Germany", "Sweden", "United Kingdom", "Russia");
        model.addAttribute("countries", countries);

        model.addAttribute("programmingLanguages", programmingLanguages);

        model.addAttribute("opSys", operatingSystems);



        return "student-form";
    }

    @PostMapping("/studentresults")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        return "student-confirmation";
    }

}
