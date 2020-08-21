package com.example.springboot.thymeleafdemo.controller;

import com.example.springboot.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // load employee data
    private List<Employee> employees;

    @PostConstruct
    private void loadData() {

        // create employees
        Employee emp1 = new Employee(1, "Black", "Pearl", "masterofcode@sevenseas.com");
        Employee emp2 = new Employee(2, "Flying", "Dutchman", "deathdefying@sevenseas.com");
        Employee emp3 = new Employee(3, "World", "Ender", "isleofnull@sevenseas.com");

        // create the list
        employees = new ArrayList<>();

        // add to the list
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model model) {

        // add to the spring model
        model.addAttribute("employees", employees);

        return "list-employees";
    }
}
