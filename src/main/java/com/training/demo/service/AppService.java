package com.training.demo.service;

import com.training.demo.model.Employee;
import com.training.demo.repository.AppRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AppService {
    @Autowired
    private AppRepository appRepository;
    public List<Employee> getEmployeeList() {
        log.info("Request received AppService.getEmployeeList");
       return appRepository.findAll();
    }

    public Employee saveEmp(Employee employee) {
        log.info("Request navigated to service AppService.saveEmp");
        return appRepository.saveEmp(employee);
    }
}
