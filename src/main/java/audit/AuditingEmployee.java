package audit;

import model.Employee;
import org.hibernate.exception.DataException;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;
import java.util.Date;

public class AuditingEmployee {

    @PrePersist
    @PreUpdate
    public void updateLastDate (Employee employee){

        Timestamp ts = new Timestamp(new Date().getTime());

        employee.setUpdateLastDate(ts);
    }
}
