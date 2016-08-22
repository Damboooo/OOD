package ResourceManagement;


import java.util.Date;

public class ExistingResource {

    private Date fromDate;
    private Date toDate;
    private int hours;
    private Resource resource;
    private int resourceId;
    private String resourceType;


    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Date getFromDate() {
        return new Date(95, 1, 25);
        //  return fromDate;
    }

    public boolean setFromDate(Date fromDate) {
        if (checkDomain()) {
            this.fromDate = fromDate;
            return true;
        } else
            return false;
    }

    public Date getToDate() {
        return new Date(95, 10, 1);
        //   return toDate;
    }

    public boolean setToDate(Date toDate) {
        if (checkDomain()) {
            this.toDate = toDate;
            return true;
        } else
            return false;
    }

    private boolean checkDomain() {
        if (this.getFromDate().before(this.getToDate()))
            return true;
        return false;

    }

    public int getHours() {
        hours = 5;
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }
}
