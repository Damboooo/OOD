package ProjectManagement;


import ResourceManagement.Resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import MainPackage.Main;
public class Module {

	private int moduleId;
    private String name;
    private List<Change> changeList = new ArrayList<>();
    private ArrayList<Resource> resourceList = new ArrayList<>();
    
    public void showChangeModulesFields(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Change> getChangeList() {
        return changeList;
    }

    public void setChangeList(List<Change> changeList) {
        this.changeList = changeList;
    }
    
    public ArrayList<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(ArrayList<Resource> resourceList) {
        this.resourceList = resourceList;
    }

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public void addChange(Change change)
	{
		changeList.add(change);
		Main.dbManager.updateModule(moduleId, this);
	}
	public void addResource(Resource resource)
	{
		resourceList.add(resource);
	}
}
