import model.*;
import repository.DepartamentRepositoryImpl;
import repository.DependentRepositoryImpl;
import repository.EmployeeRepositoryImpl;
import repository.ProjectRepositoryImpl;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.sql.Time;
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

            EmployeeRepositoryImpl employeeRepository =
                    new EmployeeRepositoryImpl(manager);

            Employee e = employeeRepository.getEmployeeByName("Olive");

            System.out.println("Employee name:" + " " + e.getName());

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
