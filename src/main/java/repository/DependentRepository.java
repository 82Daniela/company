package repository;

import model.Dependent;
import model.DependentId;

public interface DependentRepository {

    public Dependent getDependentById(DependentId id);
    public void addDependent(Dependent dependent);
    public void deleteDependent(Dependent dependent);

}
