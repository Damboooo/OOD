package ProjectManagement;

import java.util.ArrayList;
import java.util.List;

import MainPackage.Main;

public class TaskCatalogue {

    static ArrayList<Task> taskList;

    private static TaskCatalogue taskCatalogue = new TaskCatalogue();

    public static TaskCatalogue getInstance() {
    	taskList = (ArrayList<Task>) Main.dbManager.getTasks();
        return taskCatalogue;
    }

    public void addNewTask(Task task) {

    }

    public void showSortingStandards() {

    }

    public List<Task> sort(){
    return  null;
    }

    public void showTasks(){

    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }
}
