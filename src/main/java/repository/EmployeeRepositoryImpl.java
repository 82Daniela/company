package repository;

import model.Employee;
import util.JpaUtil;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.*;
import java.lang.reflect.Executable;


public class EmployeeRepositoryImpl implements EmployeeRepository {

    private EntityManager manager;

    public EmployeeRepositoryImpl (EntityManager manager){
        this.manager = manager;
    }


    @Override
    public Employee getEmployeeById(Long id) {
        return manager.find(Employee.class,id);
    }

    @Override
    public void addEmployee(Employee employee) {
        if(employee.getId()==null){
            manager.persist(employee);
        }else{
            manager.merge(employee);
        }
    }


    @Override
    public void deleteEmployee(Employee employee) {

        if(manager.contains(employee)){
            manager.remove(employee);
        }else{
            System.out.println("Can't find  the employee" + employee.getName());
        }

    }
}
