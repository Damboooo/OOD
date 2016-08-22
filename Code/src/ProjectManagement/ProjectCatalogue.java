package ProjectManagement;


import ResourceManagement.User;

import java.util.ArrayList;
import java.util.List;
import MainPackage.Main;
public class ProjectCatalogue {

    private static ProjectCatalogue projectCatalogue = new ProjectCatalogue();

    private static ArrayList<Project> projectList;

    public static ProjectCatalogue getInstance() {
    	projectList = (ArrayList<Project>)Main.dbManager.getProjects();
        return projectCatalogue;
    }

    public ArrayList<Project> getProjectList() {
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
