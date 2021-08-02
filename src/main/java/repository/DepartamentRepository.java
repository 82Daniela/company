package repository;

import model.Departament;

public interface DepartamentRepository {

    public Departament getDepartamentById(Long id);
    public void addDepartament(Departament departament);
    public void deleteDepartament (Departament departament);

}
