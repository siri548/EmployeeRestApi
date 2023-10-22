package com.example.employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

// Do not modify the below code

public class EmployeeService implements EmployeeRepository {

    private static HashMap<Integer, Employee> employeeList = new HashMap<>();

    public EmployeeService() {
        employeeList.put(1, new Employee(1, "John Doe", "johndoe@example.com", "Marketing"));
        employeeList.put(2, new Employee(2, "Jane Smith", "janesmith@example.com", "Human Resources"));
        employeeList.put(3, new Employee(3, "Bob Johnson", "bjohnson@example.com", "Sales"));
        employeeList.put(4, new Employee(4, "Alice Lee", "alee@example.com", "IT"));
        employeeList.put(5, new Employee(5, "Mike Brown", "mbrown@example.com", "Finance"));
        employeeList.put(6, new Employee(6, "Sara Lee", "slee@example.com", "Operations"));

    }

    // Do not modify the above code

    // Write your code here
    int uniqueId = 6;
    @Override
    public ArrayList<Employee> getEmployees() {
        Collection<Employee> allEmployees = employeeList.values();
        ArrayList<Employee> employees = new ArrayList<Employee>(allEmployees);
        return employees;
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        Employee employ = employeeList.get(employeeId);
        if (employ == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return employ;
    }

    

    @Override
    public Employee addEmployee(Employee employee) {
        uniqueId += 1;
        employee.setEmployeeId(uniqueId);
        employeeList.put(uniqueId, employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(int employeeId, Employee employee) {
        Employee existing = employeeList.get(employeeId);
        if (existing != null) {
            if (existing.getEmployeeName() != null) {
                existing.setEmployeeName(employee.getEmployeeName());
            }
            if (existing.getEmail() != null) {
                existing.setEmail(employee.getEmail());

            }
            if (existing.getDepartment() != null) {
                existing.setDepartment(employee.getDepartment());
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return existing;
    }

    @Override
    public void deleteEmployee(int employeeId) {
        Employee employ = employeeList.get(employeeId);
        if (employ == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            employeeList.remove(employeeId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}
