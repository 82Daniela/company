package repository;

import model.Employee;
import util.JpaUtil;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.*;
import java.lang.reflect.Executable;
import java.util.List;


public class EmployeeRepositoryImpl implements EmployeeRepository {

    private EntityManager manager;

    public EmployeeRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }


    @Override
    public Employee getEmployeeById(Long id) {
        return manager.find(Employee.class, id);
    }

    @Override
    public Employee getEmployeeByName(String name) {

        Query query = manager.createQuery
                ("select employee from Employee employee where " +
                        "employee.name=:name");
        query.setParameter("name", name);
        Object employee = query.getSingleResult();

        return (Employee) employee;
    }

    @Override
    public void addEmployee(Employee employee) {
        if (employee.getId() == null) {
            manager.persist(employee);
        } else {
            manager.merge(employee);
        }
    }


    @Override
    public void deleteEmployee(Employee employee) {

        if (manager.contains(employee)) {
            manager.remove(employee);
        } else {
            System.out.println("Can't find tthe employee" + employee.getName());
        }

    }

    @Override
    public void deleteAllEmployees() {

        Query q = manager.createQuery(
                "delete from Employee e "
        );

        int rowsExecuted = q.executeUpdate();

        System.out.println(rowsExecuted + " rows have been deleted!");

    }

    @Override
    public void deleteEmployeeByName(String name) {

        Query q = manager.createQuery(
                "delete from Employee e where e.name=:employeeName"
        );

        q.setParameter("employeeName", name);

        int rowsExecuted = q.executeUpdate();

        System.out.println(rowsExecuted + " row(s)" +
                " have been updated!");


    }

    @Override
    public void paginationEmployee(int number) {

        Query query =
                manager.createQuery("select employee from Employee employee");

        query.setFirstResult(0);
        query.setMaxResults(number);

        List<Employee> employeeList = query.getResultList();

        employeeList.forEach
                (employee->System.out.println(employee.getName()));

    }


}
