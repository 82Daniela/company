import model.Departament;
import model.Employee;
import repository.DepartamentRepository;
import repository.DepartamentRepositoryImpl;
import repository.EmployeeRepositoryImpl;
import util.JpaUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class MainApp {

    public static void main(String[] args) {

        EntityManager manager = JpaUtil.getEntityManager();

        try {

            manager.getTransaction().begin();

            EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl(manager);

            Employee employee = new Employee();
            employee.setName("Josh");
            employee.setLastName("Red");
            employee.setSalary(new BigDecimal(10000));


            Departament departament = new Departament();
            DepartamentRepositoryImpl departamentRepository = new DepartamentRepositoryImpl(manager);
            departament.setName("Marketing");
            departament.setEmployee(employeeRepository.getEmployeeById(1l));
            manager.persist(departament);


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
