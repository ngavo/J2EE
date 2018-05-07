package Sermina.service;

import java.util.List;

import Sermina.model.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);
	 
    public List<Employee> getAllEmployees();
 
    public void deleteEmployee(int employeeId);
 
    public Employee getEmployee(int employeeid);
 
    public Employee updateEmployee(Employee employee);

}
