import model.Employee;
import repository.EmployeeRepository;
import util.JpaUtil;

import javax.persistence.EntityManager;

public class MainApp {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        Employee employee = new Employee();

        employee.setName("Joao");
        employee.setLastName("Silva Rocha Dourado");
        employee.setSex('M');

       EmployeeRepository.updateEmployee(em,1L,employee);


    }


}
