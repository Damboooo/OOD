package ProjectManagement;


import ResourceManagement.Resource;

import java.util.Date;
import java.util.List;

public class Module {

    private String name;
    private List<String> changeList;
    private Date startTime;
    private Date endTime;
    private List<Resource> resourceList;

    public void showChangeModulesFields(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getChangeList() {
        return changeList;
    }

    public void setChangeList(List<String> changeList) {
        this.changeList = changeList;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }
}
