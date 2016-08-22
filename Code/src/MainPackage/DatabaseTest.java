package MainPackage;

import DB.DBManager_2;
import ProjectManagement.Project;
import ProjectManagement.Task;
import ResourceManagement.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseTest {

    DBManager_2 dbManager;

    public DatabaseTest() {
        dbManager = new DBManager_2();
        userTest();
        projectTest();
        resourceTest();
        taskTest();
    }

    public User userTest() {

        User user = new User();
        user.setId(1);
        user.setUsername("my username");
        user.setEmail("my email");
        user.setFirstName("my firstname");
        user.setLastName("my lastname");
        user.setNatID("my NATID");
        user.setBirthday(new Date());
        user.setMarriageStatus(0);
        user.setLicence("my licence");
        user.setJobExperience(5);
        user.setRole("my role");
        user.setPhoneNumber1("676464");
        user.setPhoneNumber2("676464");
        user.setPassword("my password");

        dbManager.addUser(user);

        User resultUser = dbManager.getUserByUsername("my username");
        System.out.println(resultUser.getUsername());

        resultUser = dbManager.getUser(1);
        System.out.println(resultUser.getId());

        resultUser = dbManager.getUserByEmail("my email");
        System.out.println(resultUser.getEmail());

        return user;
    }

    public void projectTest() {
        Project project = new Project();
        project.setNumberOfUsers(18);
        project.setName("project name");
        project.setTechnologies("technology 1, technology 2");
        project.setProjectManager(userTest());

        dbManager.addProject(project);

        Project resultProject = dbManager.getProject(1);
        System.out.println(resultProject.getId() + " " + resultProject.getName());

        List<Project> projects = dbManager.getProjects();

//        for (Project project1: projects){
//            System.out.print(project1.getId() + ", " + project1.getProjectManager().getUsername() + ", ");
//        }

    }

    public void resourceTest() {

        Finance finance = new Finance();
        finance.setName("finance name");
        finance.setAmount(200);

        dbManager.addFinance(finance);

        Finance financeResult = (Finance) dbManager.getResource(1, "Finance");
        System.out.println(financeResult.getId() + " " + financeResult.getName());

        Knowledge knowledge = new Knowledge();
        knowledge.setName("knowledge name");
        knowledge.setType("knowledge type");
        knowledge.setDescription("knowledge description");

        dbManager.addKnowledge(knowledge);

        Knowledge knowledgeResult = (Knowledge) dbManager.getResource(1, "Knowledge");
        System.out.println(knowledgeResult.getId() + " " + knowledgeResult.getName() + " " + knowledgeResult.getDescription());

        Asset asset = new Asset();
        asset.setName("asset Name");
        asset.setFreeTimes("free times");
        asset.setType("asset type");

        dbManager.addAsset(asset);

        Asset assetResult = (Asset) dbManager.getResource(1, "Asset");
        System.out.println(assetResult.getId() + " " + assetResult.getName() + " " + assetResult.getFreeTimes());

        List<Resource> resources = dbManager.getResources();
        System.out.println(resources.size());


    }

    public void taskTest() {

        Task task = new Task();
        task.setName("task name");
        task.setDescription("task description");
        task.setIsFinished(false);
        ArrayList<User> users = new ArrayList<>();
        users.add(userTest());
        task.setUsers(users);

        dbManager.addTask(task, 1);

        List<Task> taskResult = dbManager.getTasks(1);
        System.out.println(taskResult.size());


    }


}
