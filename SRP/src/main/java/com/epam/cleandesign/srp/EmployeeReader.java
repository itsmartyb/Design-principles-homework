package com.epam.cleandesign.srp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeReader {


    static List<Employee> readEmployees(Connection connection) {

            List<Employee> cache = new ArrayList<>();
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM Employees")) {

                while (resultSet.next()) {

                    Employee employee = new Employee();

                    String firstName = resultSet.getString("FIRST_NAME");
                    String lastName = resultSet.getString("LAST_NAME");
                    String role = resultSet.getString("ROLE");
                    String seniority = resultSet.getString("SENIORITY");

                    employee.setFirstName(firstName);
                    employee.setLastName(lastName);
                    employee.setRole(EmployeeRole.valueOf(role));
                    employee.setSeniority(EmployeeSeniority.valueOf(seniority));
                    cache.add(employee);
                }
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }

        return cache;
    }
}
