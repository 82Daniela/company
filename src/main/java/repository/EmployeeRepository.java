package repository;

import model.Employee;

public interface EmployeeRepository {

    public Employee getEmployeeById(Long id);
    public Employee getEmployeeByName(String name);
    public void addEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
    public void deleteAllEmployees();
    public void deleteEmployeeByName(String name);

}
