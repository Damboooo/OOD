package ResourceManagement;

import java.util.List;

public class ResourceCatalogue {

    private List<Resource> resourceList;

    private static ResourceCatalogue resourceCatalogue = new ResourceCatalogue();

    public static ResourceCatalogue getInstance() {
        return resourceCatalogue;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void showResources() {

    }
}
