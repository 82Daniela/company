import model.*;
import repository.DepartamentRepositoryImpl;
import repository.DependentRepositoryImpl;
import repository.EmployeeRepositoryImpl;
import repository.ProjectRepositoryImpl;
import util.JpaUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        EntityManager manager = JpaUtil.getEntityManager();

        try {

            manager.getTransaction().begin();

            Employee employee = new Employee();
            employee.setName("Elsie");
            employee.setLastName("Brown");
            employee.setSalary(new BigDecimal(100000));
            employee.setAddress("New York, USA");
            Departament departament = manager.find(Departament.class,21L);
            employee.setDepartament(departament);
            employee.setSex("Female");
            employee.setSupervisor_id(1L);

            EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl(manager);
            employeeRepository.addEmployee(employee);

            Employee supervisor = employeeRepository.getEmployeeById(1L);
            supervisor.getEmployeeList().forEach(e->System.out.println(e));

            manager.getTransaction().commit();

        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            manager.close();
            JpaUtil.close();
        }

    }


}
