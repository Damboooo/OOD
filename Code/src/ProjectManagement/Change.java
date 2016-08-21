package ProjectManagement;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;
import ResourceManagement.*;

public class Change {
	private String discribtion;
    private Date startTime;
    private Date endTime;
    private ArrayList<Resource> resources = new ArrayList<>();
    
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
	public String getDiscribtion() {
		return discribtion;
	}
	public void setDiscribtion(String discribtion) {
		this.discribtion = discribtion;
	}
	public ArrayList<Resource> getResources() {
		return resources;
	}
	public void setResources(ArrayList<Resource> resources) {
		this.resources = resources;
	}
}
