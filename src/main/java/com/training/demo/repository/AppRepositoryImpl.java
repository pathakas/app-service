package com.training.demo.repository;

import com.training.demo.model.Employee;
import com.training.demo.rowmapper.EmployeeRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class AppRepositoryImpl implements AppRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Employee> findAll() {
        String sql = "select * from employee";
        log.info("fetching data");
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public Employee saveEmp(Employee employee) {
        String sql = "insert into employee (id,firstname,lastname,department) values(?,?,?,?)";
        try {
            jdbcTemplate.update(sql, employee.getId(),employee.getFirstName(), employee.getLastName(), employee.getDepartment());
            log.info("data saved successfully");
        }
        catch(Exception e){
            log.error("Error in employee insertion",e);
        }
        return employee;
    }
}
