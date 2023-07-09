package com.training.demo.repository;

import com.training.demo.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppRepository {
    public List<Employee> findAll();

    public Employee saveEmp(Employee employee);
}
