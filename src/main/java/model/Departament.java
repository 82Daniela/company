package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity(name="departament")
public class Departament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column
    private String name;
    @OneToOne
    @JoinColumn(name = "manager_id")
    private Employee employee;
    @Column
    private Timestamp start_date;

    @OneToMany(mappedBy = "departament")
    private List<Employee> employeeList;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Timestamp getStart_date() {
        return start_date;
    }

    public void setStart_date(Timestamp start_date) {
        this.start_date = start_date;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departament)) return false;
        Departament that = (Departament) o;
        return getNumber().equals(that.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
