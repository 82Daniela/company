package repository;

import model.Departament;

public interface DepartamentRepository {

    public Departament getDepartamentByNumber(Long number);
    public void addDepartament(Departament departament);
    public void deleteDepartament (Departament departament);


}
