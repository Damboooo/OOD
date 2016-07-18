package ProjectManagement;


import ResourceManagement.User;

import java.util.List;

public class ProjectCatalogue {

    private static ProjectCatalogue projectCatalogue = new ProjectCatalogue();

    private List<Project> projectList;

    public static ProjectCatalogue getInstance() {
        return projectCatalogue;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public List<Project> sortProjects() {
        return null;
    }

    public void showProjects() {

    }

    public List<Project> searchProjects(int id) {
        return null;
    }

    public void addNewProject(Project project) {

    }

    public void showProjectFields() {

    }

    public List<Project> undedicatedProjectRetrieval() {
        return null;
    }

    public void showUndedicatedProjects() {
    }

    public void assignProject(Project project, User user) {

    }

}
