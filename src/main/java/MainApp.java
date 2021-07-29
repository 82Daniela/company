import model.Employee;
import repository.EmployeeRepository;
import util.JpaUtil;

import javax.persistence.EntityManager;

public class MainApp {

    public static void main(String[] args) {

        EntityManager manager = JpaUtil.getEntityManager();

        Employee employee = new Employee();

        employee.setName("Joshua");
        employee.setLastName("Blue");
        employee.setSex('M');

       EmployeeRepository.saveEmployee(manager, employee);


    }


}
