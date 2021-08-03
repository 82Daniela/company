package repository;

import model.Project;

import javax.persistence.EntityManager;

public class ProjectRepositoryImpl implements ProjectRepository {

    private static EntityManager manager;

    public ProjectRepositoryImpl(EntityManager manager){
        this.manager=manager;
    }


    @Override
    public Project getProjectByNumber(Long number) {
        return manager.find(Project.class, number);
    }

    @Override
    public void addProject(Project project) {
        if(project.getNumber()==null){
            manager.persist(project);
        }else{
            manager.merge(project);
        }
    }

    @Override
    public void deleteProject(Project project) {

        if(manager.contains(project)){
            manager.remove(project);
        }else{
            System.out.println("Can't find the project" +
                    project.getName());
        }

    }
}
