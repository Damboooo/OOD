package ProjectManagement;


import ResourceManagement.Resource;
import ResourceManagement.User;

import java.util.List;

public class Project {

    private String name;
    private User projectManager;
    private int size;
    private List<Resource> resourceList;
    private List<Task> taskList;
    private List<Module> moduleList;

    public List<Resource> getResources() {
        return resourceList;
    }

    public void acceptanceRequest() {

    }

    public void showResources() {

    }

    public List<Resource> requirementRetrieval() {
        return null;
    }

    public void showRequirement() {

    }

    public void showRequirementFields() {

    }

    public void removeRequirement(int id) {

    }

    public void addRequirement(Resource resource) {

    }

    public int getProjectSize() {
        return 0;
    }

    public void showProjectSize() {

    }

    public void showChangeSizeFields() {

    }

    public void showProjectDetails() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getProjectManager(){
        return projectManager;
    }

    public void setProjectManager(User projectManager) {
        this.projectManager = projectManager;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }
}
