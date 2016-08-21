package ProjectManagement;


import ResourceManagement.Resource;
import ResourceManagement.User;
import UI.Predict.Domain;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;
    private User projectManager;
    //private int size;
    private int numberOfUsers;
    private List<Resource> resourceList;
    private List<Task> taskList;
    private List<Module> moduleList;

    public List<Resource> getResources() {
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

//    public int getProjectSize() {
//        return 0;
//    }
//
//    public void showProjectSize() {
//
//    }

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

//    public int getSize() {
//        return size;
//    }
//
//    public void setSize(int size) {
//        this.size = size;
//    }

    public List<Resource> getResourceList() {
    
    	List<Resource> resources = new ArrayList<>();
    	Resource r = new Resource();
    	r.setName("منبع یک");
    	Resource r2 = new Resource();
    	r2.setName("منبع دو");
    	Resource r3 = new Resource();
    	r3.setName("منبع سه");
    	resources.add(r);
    	resources.add(r2);
    	resources.add(r3);
        return resources;
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
		if(isInDomain(getHumanResourceList().size(),humanResources)
				&& isInDomain(getNumberOfUsers(),users)
				&& isInDomain(getModuleList().size() , modules))
			return true;
		return false;
	}
	
	private boolean isInDomain(int n , Domain domain){
		if(domain.getEnd() == -1 && n > domain.getStart()){
//			System.out.println("1:match "+n+" "+domain.getStart() );
			return true;
		}
		else if(n > domain.getStart() && n < domain.getEnd()){
//			System.out.println("2:match "+n);
			return true;
		}
//		System.out.println("3:not match  "+n +" in "+domain.getStart()+" to "+domain.getEnd());
		return false;
	}
}
