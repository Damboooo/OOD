package MainPackage;

import DB.DBManager;
import ResourceManagement.User;
import UI.Predict.*;
import UI.Report.ReportMainWindow;
import UI.Report.UsageReportWindow;

public class Main {

    public static DBManager dbManager;

    public static void main(String[] args) throws Exception {
    	dbManager = new DBManager();
//    	Main.dbManager.getResources();

      //  DatabaseTest databaseTest = new DatabaseTest();

//       new FirstWindow();

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
      //  new PredictMainWindow(new User());
        //    new RequirementPredictWindow(new User());
        //   new ResourcePredictWindow(new User());
//        new ResultPredictWindow(new User());

        // Report
    //    new ReportMainWindow(new User());
//        new ReportWindow(new User());
//        new RequirementReportWindow(new User());
        new UsageReportWindow(new User());


    }
}