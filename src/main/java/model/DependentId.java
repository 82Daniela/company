package model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DependentId implements Serializable {

    private Long employee_id;
    private String name;

    public DependentId(Long employee_id, String name){
        this.employee_id=employee_id;
        this.name=name;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DependentId)) return false;
        DependentId that = (DependentId) o;
        return Objects.equals(getEmployee_id(), that.getEmployee_id()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployee_id(), getName());
    }
}
