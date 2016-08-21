package MainPackage;

import DB.DBManager_2;
import ProjectManagement.Project;
import ResourceManagement.User;

import java.util.Date;

public class DatabaseTest {

    DBManager_2 dbManager;

    public DatabaseTest() {
        dbManager = new DBManager_2();
        userTest();
        projectTest();
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

    }


}
