package repository;

import model.Project;

public interface ProjectRepository {


    public Project getProjectByNumber (Long number);
    public void addProject (Project project);
    public void deleteProject (Project project);

}
