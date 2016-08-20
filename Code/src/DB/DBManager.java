package DB;

import ProjectManagement.Module;
import ProjectManagement.Project;
import ProjectManagement.Task;
import ResourceManagement.Resource;
import ResourceManagement.User;

import java.sql.*;
import java.util.List;

public class DBManager {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public DBManager() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/ood_database?"
                            + "user=root&password=1234");

        } catch (Exception ignored) {

        }
    }

    public void addUser(User user) {

        try {

            preparedStatement = connect
                    .prepareStatement("insert into ood_database.test values (?, ?)");
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.executeUpdate();

        } catch (Exception ignored) {

        } finally {
            close();
        }
    }

    public User getUser(int id) {

        try {

            String query = "select * from ood_database.test where ID=?";

            preparedStatement = connect
                    .prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();


            User user = new User();
            user.setId(id);


            while (resultSet.next()) {
                user.setUsername(resultSet.getString("username"));
            }


            return user;

        } catch (Exception ignored) {

        } finally {
            close();
        }
        return null;
    }


    private Project getProject(int id) {
        return null;
    }

    private List<Project> getProjects() {
        return null;
    }

    private List<Project> getProjects(User user) {
        return null;
    }

    private List<Project> getUndedicatedProjects() {
        return null;
    }

    private void addProject(Project project) {

    }


    private List<User> getProjectManagers() {
        return null;
    }

    private List<Resource> getRequirements(int ProjectID) {
        return null;
    }

    private List<Resource> getResources(int ProjectID) {
        return null;
    }

    private List<Resource> getResources(int ProjectID, int from, int to) {
        return null;
    }

    private List<Resource> getResources() {
        return null;
    }

    private Resource getResource(int ResourceID) {
        return null;
    }

    private List<Task> getTasks(int projectID) {
        return null;
    }

    private Task getTask(int taskID) {
        return null;
    }


    private void addResource(Resource resource) {

    }

    private void addTask(Task task) {

    }

    private void addModule(Module module) {

    }

    private void updateTask(int taskID, Task task) {

    }

    private void updateResource(int resourceID, Resource resource) {

    }

    private void updateProject(int projectID, Project project) {

    }

    public void updateUser(int userID, User user) {

    }

    private void updateModule(int moduleID, Module module) {

    }

    private Module getModule(int moduleID) {
        return null;
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

        } catch (Exception e) {

        }
    }
    
    public static User getUserByUsername(String username){
    	User user = new User();
    	return user;
    }
    public static User getUserByEmail(String email){
    	User user = new User();
    	return user;
    }
}
