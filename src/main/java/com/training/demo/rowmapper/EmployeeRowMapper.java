package com.training.demo.rowmapper;

import com.training.demo.exception.AppException;
import com.training.demo.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Slf4j
public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee;
        try {
            int id = rs.getInt("id");
            String firstName = rs.getString("firstname");
            String lastName = rs.getString("lastname");
            String department = rs.getString("department");
            employee = Employee.builder()
                    .id(id)
                    .firstName(firstName)
                    .lastName(lastName)
                    .department(department)
                    .build();
        } catch (Exception e) {
            log.error("EmployeeRowMapper::mapRow - {}", e.getMessage());
            throw new AppException("Error in Row Mapper");
        }
        return employee;
    }
}
