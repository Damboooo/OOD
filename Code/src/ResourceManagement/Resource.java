package ResourceManagement;

import ResourceManagement.*;

public class Resource {

    private String name;
    private int id;

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public int getResourceType() {
		// TODO Auto-generated method stub
		if(this instanceof Asset)
			return 1;
		if(this instanceof Finance)
			return 2;
		if(this instanceof Knowledge)
			return 3;
		if(this instanceof User)
			return 4;
		return 0;
	}

}
