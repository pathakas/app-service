package com.training.demo.controller;

import com.training.demo.model.Employee;
import com.training.demo.service.AppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class AppController {
    @Autowired
    private AppService appService;
    @GetMapping("message")
    public List<Employee> getMessage() {
        log.info("Request received AppController.getMessage");
       return appService.getEmployeeList();
    }
    @PostMapping("save")
    public Employee saveEmp(Employee employee) {
        log.info("Request received AppController.saveEmp");
        return appService.saveEmp(employee);
    }
}
