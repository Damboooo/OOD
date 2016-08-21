package ResourceManagement;

import java.util.ArrayList;
import java.util.List;
import Main.Main;

public class ResourceCatalogue {

	private ArrayList<Resource> resourceList = new ArrayList<>();

	private static ResourceCatalogue resourceCatalogue = new ResourceCatalogue();

	public static ResourceCatalogue getInstance() {
		return resourceCatalogue;
	}

	public ArrayList<Resource> getResourceList() {
		return resourceList;
	}

	public void showResources() {

	}

	public void update(Resource resource) {
		// TODO Auto-generated method stub
		for (int i = 0; i < resourceList.size(); i++) {
			if (resource.getId() == resourceList.get(i).getId()) {
				resourceList.remove(i);
				resourceList.add(i, resource);
			}
		}
		Main.dbManager.updateResource(resource.getId(), resource);
	}
}
