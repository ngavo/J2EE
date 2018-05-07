package Sermina.dao;

import java.util.List;

import Sermina.model.Employee;

public interface EmployeeDAO {
	
	public void addEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public void deleteEmployee(int employeeId);
	 
    public Employee updateEmployee(Employee employee);
 
    public Employee getEmployee(int employeeid);

}
