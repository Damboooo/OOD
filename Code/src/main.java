import DB.DBManager;
import ResourceManagement.User;

public class main {


    public static void main(String[] args) throws Exception {


        DBManager dbManager = new DBManager();
        User user = new User();
        user.setId(8);
        user.setUsername("Shamim");

        dbManager.addUser(user);

        User result = dbManager.getUser(1);

        System.out.println(result.getUsername());


//        new FirstWindow();

        // Accounting
//        new ChangePasswordWindow(new User());
//        new EditProfileWindow(new User());
//        new ForgetPasswordWindow(new User());
//        new ProfileWindow(new User());
//        new RegisterWindow(new User());
//        new UserDetailsWindow(new User());

        // Employee
//        new EditModuleWindow(new Module(), new User());
//        new EmployeeMainWindow(new User());
//        new ModuleListWindow(new User());
//        new TasksListWindow(new User());

        // Head Manager
//        new AccountsListWindow(new User());
//        new AddProjectResourcesWindow(new User());
//        new EditResourceWindow(new User(), new Resource());
//        new EditUserProfileWindow(new User());
//        new GuestsListWindow(new User());
//        new HeadManagerMainWindow(new User());
//        new ManageAccountsWindow(new User());
//        new ManageProjectsWindow(new User());
//        new ManageResourcesWindow(new User());
//        new NewProjectWindow(new User());
//        new ProjectsListWindow(new User());

        // Predict
//        new PredictMainWindow(new User());
//        new RequirementPredictWindow(new User());
//        new ResourcePredictWindow(new User());
//        new ResultPredictWindow(new User());

        // Report
//        new ReportMainWindow(new User());
//        new ReportWindow(new User());
//        new RequirementReportWindow(new User());
//        new UsageReportWindow(new User());


    }
}