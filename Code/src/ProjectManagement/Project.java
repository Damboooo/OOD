package ProjectManagement;

import ResourceManagement.ExistingResource;
import ResourceManagement.Resource;
import ResourceManagement.User;
import UI.Predict.Domain;

import java.util.ArrayList;
import java.util.List;

public class Project {

//	public List<Resource> getResources() {
//		return resourceList;
//	}


    private int id;
    private String name;
    private User projectManager;
    // private int size;
    private int numberOfUsers;
    private List<ExistingResource> resourceList;
    private List<Task> taskList;
    private List<Module> moduleList;
    private String technologies;


    public void setResourceList(List<ExistingResource> resourceList) {
        this.resourceList = resourceList;
    }

    public List<ExistingResource> getResourceList() {
        return resourceList;
    }

    public void acceptanceRequest() {

    }

    public int getNumberOfUsers() {
        numberOfUsers = 100;
        return numberOfUsers;
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

    // public int getProjectSize() {
    // return 0;
    // }
    //
    // public void showProjectSize() {
    //
    // }

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

    public User getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(User projectManager) {
        this.projectManager = projectManager;
    }

    // public int getSize() {
    // return size;
    // }
    //
    // public void setSize(int size) {
    // this.size = size;
    // }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }


    public List<Resource> getHumanResourceList() {

        List<Resource> resourceList = new ArrayList<>();
        Resource r = new Resource();
        r.setName("کارمند یک");
        Resource r2 = new Resource();
        r2.setName("کارمند دو");
        Resource r3 = new Resource();
        r3.setName("کارمند سه");
        resourceList.add(r);
        resourceList.add(r2);
        resourceList.add(r3);
        return resourceList;
    }

    public String getTechnologies() {
        return technologies;
    }


    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<Module> getModuleList() {
        List<Module> moduleList = new ArrayList<>();
        Module r = new Module();
        r.setName("ماژول یک");
        Module r2 = new Module();
        r2.setName("ماژول دو");
        Module r3 = new Module();
        r3.setName("ماژول سه");
        moduleList.add(r);
        moduleList.add(r2);
        moduleList.add(r3);
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    public boolean matchSize(Domain humanResources, Domain users, Domain modules) {
        if (isInDomain(getHumanResourceList().size(), humanResources) && isInDomain(getNumberOfUsers(), users)
                && isInDomain(getModuleList().size(), modules))
            return true;
        return false;
    }

    private boolean isInDomain(int n, Domain domain) {
        if (domain.getEnd() == -1 && n > domain.getStart()) {
            // System.out.println("1:match "+n+" "+domain.getStart() );
            return true;
        } else if (n > domain.getStart() && n < domain.getEnd()) {
            // System.out.println("2:match "+n);
            return true;
        }
        // System.out.println("3:not match "+n +" in "+domain.getStart()+" to
        // "+domain.getEnd());
        return false;
    }

    public boolean hasResources(ArrayList<String> resources) {
        for (int j = 0; j < resources.size(); j++) {
            for (int j2 = 0; j2 < this.getResourceList().size(); j2++) {
                if (this.getResourceList().get(j2).getResource().getName().equals((resources.get(j)))) {
                    return true;
                }

            }

        }
        return false;
    }


}