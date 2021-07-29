import model.Employee;
import repository.EmployeeRepository;
import util.JpaUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class MainApp {

    public static void main(String[] args) {

        EntityManager manager = JpaUtil.getEntityManager();

        Employee employee = new Employee();

        employee.setName("Joshua");
        employee.setLastName("Blue");
        employee.setAddress("USA");
        employee.setSalary(new BigDecimal(10000));
        employee.setSex('M');

        EmployeeRepository.saveEmployee(manager, employee);


    }


}
