package ProjectManagement;

import java.util.List;

public class TaskCatalogue {

    List<Task> taskList;

    private static TaskCatalogue taskCatalogue = new TaskCatalogue();

    public static TaskCatalogue getInstance() {
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

    public List<Task> getTaskList() {
        return taskList;
    }
}
