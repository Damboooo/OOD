package ProjectManagement;


import java.util.ArrayList;
import java.util.List;
import Main.Main;

public class ModuleCatalogue {

    private static ModuleCatalogue moduleCatalogue = new ModuleCatalogue();

    private static ArrayList<Module> moduleList;

    public static ModuleCatalogue getInstance() {
    	moduleList = Main.dbManager.getModules();
        return moduleCatalogue;
    }

    public void showNewModuleFields() {

    }
    
    public ArrayList<Module> getModuleList()
    {
    	return moduleList;
    }

    public void setModuleList(ArrayList<Module> moduleList)
    {
    	this.moduleList = moduleList;
    }
    
    public void addModule(Module module){
    	moduleList.add(module);
    }

}
