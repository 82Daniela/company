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
            departament.setEmployee(employeeRepository.getEmployeeById(1L));
            manager.persist(departament);

            Dependent dependent = new Dependent();
            DependentId dependentId = new DependentId();
            dependentId.setName("Samuel");
            dependentId.setEmployee_id(1L);
            dependent.setId(dependentId);
            dependent.setSex("Male");
            dependent.setRelationship("Son");

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = dateFormat.parse("10/01/2011");
            long time = date.getTime();
            Timestamp birth_date = new Timestamp(time);

            dependent.setBirth_date(birth_date);

            DependentRepositoryImpl
                    dependentRepository = new DependentRepositoryImpl(manager);
            System.out.println(dependentRepository.getDependentById(dependentId).getEmployee().getName());


            Project project = new Project();
            project.setName("System's deploy");
            project.setLocation("Brazil");

            ProjectRepositoryImpl projectRepository = new ProjectRepositoryImpl(manager);
            projectRepository.addProject(project);

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
