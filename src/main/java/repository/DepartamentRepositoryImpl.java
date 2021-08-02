package repository;

import model.Departament;

import javax.persistence.EntityManager;

public class DepartamentRepositoryImpl implements DepartamentRepository {

    private EntityManager manager;

    public DepartamentRepositoryImpl(EntityManager manager){
        this.manager = manager;
    }

    @Override
    public Departament getDepartamentById(Long id) {
        return manager.find(Departament.class,id);
    }

    @Override
    public void addDepartament(Departament departament) {

        if(departament.getNumber()==null){
            manager.persist(departament);
        }else{
            manager.merge(departament);
        }
    }

    @Override
    public void deleteDepartament(Departament departament) {
        if(manager.contains(departament)){
            manager.remove(departament);
        }else{
            System.out.println("Can't find the departament "+ departament.getNumber());
        }
    }
}
