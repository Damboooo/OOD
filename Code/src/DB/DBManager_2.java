package DB;

import ProjectManagement.Module;
import ProjectManagement.Project;
import ProjectManagement.Task;
import ResourceManagement.*;

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
            project.setId(resultSet.getInt("id"));
            project.setNumberOfUsers(resultSet.getInt("number_of_users"));
            project.setName(resultSet.getString("name"));
            project.setTechnologies(resultSet.getString("technologies"));
            project.setProjectManagerId(resultSet.getInt("manager_id"));
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
            resultSet.next();
            Project project = setProjectResults(resultSet);
            project.setTaskList(getTasks(project.getId()));

            return project;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
        return null;
    }

    public List<Project> getProjects() {

        List<Project> projects = new ArrayList<>();

        try {
            String query = "select * from ood.project";
            statement = connect.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                projects.add(setProjectResults(resultSet));
            }

            for (Project project : projects) {
                project.setProjectManager(getUser(project.getProjectManagerId()));
            }

            for (Project project : projects) {
                project.setResourceList(getExistingResourcesOfProject(project.getId()));
            }

            for (Project project : projects) {
                project.setTaskList(getTasks(project.getId()));
            }


            return projects;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
        return null;

    }

    public List<ExistingResource> getExistingResourcesOfProject(int projectId) {

        List<ExistingResource> existingResources = new ArrayList<>();

        try {
            String query = "select * from ood.existing_resource where project_id=?";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setInt(1, projectId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                existingResources.add(setExistingResourceList(resultSet));
            }

            for (ExistingResource existingResource : existingResources) {
                existingResource.setResource(getResource(existingResource.getResourceId(), existingResource.getResourceType()));
            }

            return existingResources;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
        return null;

    }

    public ExistingResource setExistingResourceList(ResultSet resultSet) {
        ExistingResource existingResource = new ExistingResource();
        try {
            existingResource.setFromDate(resultSet.getDate("from_date"));
            existingResource.setToDate(resultSet.getDate("to_date"));
            existingResource.setHours(resultSet.getInt("hours"));
            existingResource.setResourceId(resultSet.getInt("resource_id"));
            existingResource.setResourceType(resultSet.getString("resource_type"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return existingResource;
    }

    public Resource getResource(int resourceID, String resourceType) {
        switch (resourceType) {

            case "User":
                return getUser(resourceID);
            case "Finance":
                return getFinance(resourceID);
            case "Knowledge":
                return getKnowledge(resourceID);
            case "Asset":
                return getAsset(resourceID);
        }
        return null;
    }

    public void addFinance(Finance finance) {

        try {
            String query = "insert into ood.finance values (DEFAULT, ?, ?)";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, finance.getName());
            preparedStatement.setInt(2, finance.getAmount());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            close();
        }

    }

    public Finance getFinance(int resourceId) {
        try {
            String query = "select * from ood.finance where id=?";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setInt(1, resourceId);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return setFinanceResult(resultSet);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
        return null;
    }

    public Finance setFinanceResult(ResultSet resultSet) {
        Finance finance = new Finance();
        try {
            finance.setName(resultSet.getString("name"));
            finance.setAmount(resultSet.getInt("amount"));
            finance.setId(resultSet.getInt("id"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return finance;
    }

    public void addKnowledge(Knowledge knowledge) {

        try {
            String query = "insert into ood.knowledge values (DEFAULT, ?, ?, ?)";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, knowledge.getName());
            preparedStatement.setString(2, knowledge.getType());
            preparedStatement.setString(3, knowledge.getDescription());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            close();
        }

    }

    public Knowledge getKnowledge(int resourceId) {
        try {
            String query = "select * from ood.knowledge where id=?";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setInt(1, resourceId);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return setKnowledgeResult(resultSet);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
        return null;
    }

    public Knowledge setKnowledgeResult(ResultSet resultSet) {
        Knowledge knowledge = new Knowledge();
        try {
            knowledge.setName(resultSet.getString("name"));
            knowledge.setType(resultSet.getString("type"));
            knowledge.setDescription(resultSet.getString("description"));
            knowledge.setId(resultSet.getInt("id"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return knowledge;
    }

    public void addAsset(Asset asset) {
        try {
            String query = "insert into ood.asset values (DEFAULT, ?, ?, ?)";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, asset.getName());
            preparedStatement.setString(2, asset.getType());
            preparedStatement.setString(3, asset.getFreeTimes());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            close();
        }
    }

    public Asset getAsset(int resourceId) {
        try {
            String query = "select * from ood.asset where id=?";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setInt(1, resourceId);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return setAssetResult(resultSet);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
        return null;
    }

    public Asset setAssetResult(ResultSet resultSet) {
        Asset asset = new Asset();
        try {
            asset.setName(resultSet.getString("name"));
            asset.setType(resultSet.getString("type"));
            asset.setId(resultSet.getInt("id"));
            asset.setFreeTimes(resultSet.getString("free_times"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return asset;
    }

    public List<Resource> getResources() {

        List<Resource> resources = new ArrayList<>();

        try {
            String query = "select * from ood.user";
            statement = connect.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                resources.add(setUserResults(resultSet));
            }

            query = "select * from ood.finance";
            statement = connect.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                resources.add(setFinanceResult(resultSet));
            }

            query = "select * from ood.knowledge";
            statement = connect.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                resources.add(setKnowledgeResult(resultSet));
            }

            query = "select * from ood.asset";
            statement = connect.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                resources.add(setAssetResult(resultSet));
            }

            return resources;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
        return null;
    }

    public void addTask(Task task, int projectId) {

        try {
            String query = "insert into ood.task values (DEFAULT, ?, ?, ?, ?)";
            preparedStatement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setBoolean(3, task.getIsFinished());
            preparedStatement.setInt(4, projectId);
            preparedStatement.executeUpdate();

            int taskId = 1;
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                taskId = resultSet.getInt(1);
            }

            for (User user : task.getUsers()) {

                query = "insert into ood.user_task values (DEFAULT, ?, ?)";
                preparedStatement = connect.prepareStatement(query);
                preparedStatement.setInt(1, taskId);
                preparedStatement.setInt(2, user.getId());
                preparedStatement.executeUpdate();
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            close();
        }
    }

    public List<Task> getTasks(int projectID) {

        List<Task> tasks = new ArrayList<>();
        try {
            String query = "select * from ood.task where project_id=?";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setInt(1, projectID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                tasks.add(setTaskResult(resultSet));
            }

            for (Task task : tasks) {
                task.setUsers(getTaskUsers(task));
            }

            return tasks;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
        return null;
    }

    public ArrayList<User> getTaskUsers(Task task) {

        ArrayList<User> users = new ArrayList<>();
        try {
            String query = "select * from ood.user_task where task_id=?";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setInt(1, task.getId());
            resultSet = preparedStatement.executeQuery();

            List<Integer> userIds = new ArrayList<>();

            while (resultSet.next()) {
                userIds.add(resultSet.getInt("user_id"));
            }

            for (Integer id : userIds) {
                users.add(getUser(id));
            }

            return users;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
        return null;
    }

    public Task setTaskResult(ResultSet resultSet) {
        Task task = new Task();
        try {
            task.setName(resultSet.getString("name"));
            task.setDescription(resultSet.getString("description"));
            task.setIsFinished(resultSet.getBoolean("is_finished"));
            task.setId(resultSet.getInt("id"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return task;
    }

    public void addModule(Module module) {

    }

    public Module getModule(int moduleID) {
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