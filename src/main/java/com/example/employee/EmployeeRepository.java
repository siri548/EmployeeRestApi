// Write your code here
package com.example.employee;

import com.example.employee.Employee;
import java.util.*;

public interface EmployeeRepository {
    ArrayList<Employee> getEmployees();

    Employee getEmployeeById(int employeeId);

    Employee updateEmployee(int employeeId, Employee employee);

    Employee addEmployee(Employee employee);

    void deleteEmployee(int employeeId);
}