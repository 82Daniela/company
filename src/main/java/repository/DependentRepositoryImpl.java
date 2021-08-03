package repository;

import model.Dependent;
import model.DependentId;

import javax.persistence.EntityManager;

public class DependentRepositoryImpl implements DependentRepository {

    private EntityManager manager;

    public DependentRepositoryImpl(EntityManager manager){
        this.manager = manager;
    }


    @Override
    public Dependent getDependentById(DependentId id) {
        return manager.find(Dependent.class,id);
    }

    @Override
    public void addDependent(Dependent dependent) {

        if(dependent.getId()==null){
            manager.persist(dependent);
        }else{
            manager.merge(dependent);
        }

    }

    @Override
    public void deleteDependent(Dependent dependent) {
        if(manager.contains(dependent)){
            manager.remove(dependent);
        }else{
            System.out.println("Can't find the dependent: " +
                    dependent.getId().getName());
        }
    }
}
