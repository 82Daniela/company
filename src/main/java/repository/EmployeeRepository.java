package repository;

import model.Employee;
import util.JpaUtil;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.swing.*;


public class EmployeeRepository {

    public static void saveEmployee(EntityManager manager, Employee employee) {

        manager.getTransaction().begin();

        manager.persist(employee);

        manager.getTransaction().commit();

        JpaUtil.close();

    }


}
