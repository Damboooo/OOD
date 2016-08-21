package DB;

import ProjectManagement.Module;
import ProjectManagement.Project;
import ProjectManagement.Task;
import ResourceManagement.Resource;
import ResourceManagement.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBManager_2 {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;


    public DBManager_2() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/ood?"
                            + "user=root&password=1234");
        } catch (Exception ignored) {
        }
    }

    public void addUser(User user) {

        try {
            String query = "insert into ood.user values (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setString(6, user.getPhoneNumber1());
            preparedStatement.setString(7, user.getPhoneNumber2());
            preparedStatement.setString(8, user.getNatID());
            preparedStatement.setInt(9, user.getJobExperience());
            preparedStatement.setString(10, user.getRole());
            preparedStatement.setInt(11, user.getMarriageStatus());
            preparedStatement.setDate(12, new java.sql.Date(user.getBirthday().getTime()));

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            close();
        }
    }

    public User getUser(int id) {

        try {

            String query = "select * from ood.user where id=?";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            return setUserResults(resultSet);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
        return null;
    }

    public User getUserByUsername(String username) {
        try {
            String query = "select * from ood.user where username=?";

            preparedStatement = connect
                    .prepareStatement(query);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            return setUserResults(resultSet);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
        return null;
    }

    public User getUserByEmail(String email) {
        try {
            String query = "select * from ood.user where email=?";

            preparedStatement = connect
                    .prepareStatement(query);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            return setUserResults(resultSet);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
        return null;
    }

    private User setUserResults(ResultSet resultSet) {

        User user = new User();
        try {
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setNatID(resultSet.getString("nat_id"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setMarriageStatus(resultSet.getInt("married"));
                user.setJobExperience(resultSet.getInt("job_experience"));
                user.setRole(resultSet.getString("role"));
                user.setPhoneNumber1(resultSet.getString("phone_number_1"));
                user.setPhoneNumber2(resultSet.getString("phone_number_2"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return user;
    }

    public void addProject(Project project) {
        try {
            String query = "insert into ood.project values (DEFAULT, ?, ?, ?, ?)";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setInt(1, project.getNumberOfUsers());
            preparedStatement.setString(2, project.getName());
            preparedStatement.setString(3, project.getTechnologies());
            preparedStatement.setInt(4, project.getProjectManager().getId());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            close();
        }
    }


    private Project setProjectResults(ResultSet resultSet) {

        Project project = new Project();
        try {
            while (resultSet.next()) {
                project.setId(resultSet.getInt("id"));
                project.setNumberOfUsers(resultSet.getInt("number_of_users"));
                project.setName(resultSet.getString("name"));
                project.setTechnologies(resultSet.getString("technologies"));
                project.setProjectManager(getUser(resultSet.getInt("manager_id")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return project;

    }


    public Project getProject(int id) {
        try {
            String query = "select * from ood.project where id=?";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            return setProjectResults(resultSet);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
        return null;
    }

    public List<Project> getProjects() {

        try {
//            String query = "select * from ood.project";
//            statement = connect.createStatement();
//            resultSet = statement.executeQuery(query);
//
//            return setProjectResults(resultSet);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
        return null;

    }

    public List<Project> getProjects(User user) {
        return null;
    }

    public List<Project> getUndedicatedProjects() {
        return null;
    }


    public List<User> getProjectManagers() {
        return null;
    }

    public List<Resource> getRequirements(int ProjectID) {
        return null;
    }

    public List<Resource> getResources(int ProjectID) {
        return null;
    }

    public List<Resource> getResources(int ProjectID, int from, int to) {
        return null;
    }

    public List<Resource> getResources() {

        /////////////alaki
        List<Resource> resources = new ArrayList<>();
        Resource r = new Resource();
        r.setName("منبع یک");
        Resource r2 = new Resource();
        r2.setName("منبع دو");
        Resource r3 = new Resource();
        r3.setName("منبع سه");
        resources.add(r);
        resources.add(r2);
        resources.add(r3);

        return resources;
    }

    public Resource getResource(int ResourceID) {
        return null;
    }

    public List<Task> getTasks(int projectID) {
        return null;
    }

    public Task getTask(int taskID) {
        return null;
    }


    public void addResource(Resource resource) {

    }

    public void addTask(Task task) {

    }

    public void addModule(Module module) {

    }

    public void updateTask(int taskID, Task task) {

    }

    public void updateResource(int resourceID, Resource resource) {

    }

    public void updateProject(int projectID, Project project) {

    }

    public void updateUser(int userID, User user) {

    }

    public void updateModule(int moduleID, Module module) {

    }

    public Module getModule(int moduleID) {
        return null;
    }


    public List<Resource> getTechnologies() {
        /////////////alaki
        List<Resource> technologies = new ArrayList<>();
        Resource r = new Resource();
        r.setName("تکنولوژی یک");
        Resource r2 = new Resource();
        r2.setName("تکنولوژی دو");
        Resource r3 = new Resource();
        r3.setName("تکنولوژی سه");
        technologies.add(r);
        technologies.add(r2);
        technologies.add(r3);

        return technologies;
    }


    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

        } catch (Exception ignored) {

        }
    }
}