package Main;
import DB.DBManager;
import ProjectManagement.Module;
import ResourceManagement.User;
import UI.Accounting.*;
import UI.Employee.EditModuleWindow;
import UI.Employee.*;
import UI.Predict.PredictMainWindow;
import UI.Report.ReportMainWindow;

public class Main {

	public static DBManager dbManager;
    public static void main(String[] args) throws Exception {


        dbManager = new DBManager();
//        User user = new User();
//        user.setId(8);
//        user.setUsername("Shamim");
//
//        dbManager.addUser(user);
//
//        User result = dbManager.getUser(1);
//
//        System.out.println(result.getUsername());

//        new FirstWindow();

        // Accounting
//        new ChangePasswordWindow(dbManager.getUser(1));
//        new EditProfileWindow(dbManager.getUser(1));
//        new ForgetPasswordWindow();
//        new ProfileWindow(dbManager.getUser(1));
//        new RegisterWindow(new User());
//        new UserDetailsWindow(new User());

        // Employee
//        dbManager.getResources();
//        new EditModuleWindow(new Module(), dbManager.getUser(1));
//        new EmployeeMainWindow(dbManager.getUser(1));
        new ModuleListWindow(dbManager.getUser(1));
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