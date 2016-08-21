package DB;

import ProjectManagement.Module;
import ProjectManagement.Project;
import ProjectManagement.Task;
import ResourceManagement.Resource;
import ResourceManagement.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Main.Main;

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

		// try {
		//
		// String query = "select * from ood_database.test where ID=?";
		//
		// preparedStatement = connect
		// .prepareStatement(query);
		// preparedStatement.setInt(1, id);
		// resultSet = preparedStatement.executeQuery();
		//
		//
		// User user = new User();
		// user.setId(id);
		//
		//
		// while (resultSet.next()) {
		// user.setUsername(resultSet.getString("username"));
		// }

		// ///////////alaki
		User user = new User();
		user.setFirstName("Ali");
		user.setId(1);
		user.setBirthday(new Date());
		user.setJobExperience(5);
		user.setLastName("Alavi");
		user.setLicence("LISANSE");
		user.setMarriageStatus(1);
		user.setUsername("ALA");
		user.setNatID("2");
		user.setPassword("1234");
		user.setPhoneNumber1("0912456789");
		user.setPhoneNumber2("0215678976");
		user.setRole("Modir");

		return user;

		// } catch (Exception ignored) {
		//
		// } finally {
		// close();
		// }
		// return null;
	}

	public Project getProject(int id) {
		return null;
	}

	public List<Project> getProjects() {
		// ///////////alaki
		List<Project> p = new ArrayList<>();
		Project r = new Project();
		r.setName("پروژه همراه اول");
		Project r2 = new Project();
		r2.setName("پروژه پیامک رسان پیشرو");
		p.add(r);
		p.add(r2);

		return p;
	}

	public List<Project> getProjects(User user) {
		return null;
	}

	public List<Project> getUndedicatedProjects() {
		return null;
	}

	public void addProject(Project project) {

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

		// ///////////alaki
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
		Resource resource = new Resource();
		resource.setId(11);
		resource.setName("دیتابیس");
		return resource;
	}

	public List<Task> getTasks(int projectID) {
		return null;
	}
	
	public ArrayList<Task> getTasks() {
		
		User user = new User();
		user.setFirstName("Ali");
		user.setId(1);
		user.setBirthday(new Date());
		user.setJobExperience(5);
		user.setLastName("Alavi");
		user.setLicence("LISANSE");
		user.setMarriageStatus(1);
		user.setUsername("ALA");
		user.setNatID("2");
		user.setPassword("1234");
		user.setPhoneNumber1("0912456789");
		user.setPhoneNumber2("0215678987");
		user.setRole("Modir");
		
		ArrayList<Task> t = new ArrayList<>();
		Task t1 = new Task();
		t1.setName("تنظیم ساختار");
		t1.addUser(user);
		Task t2 = new Task();
		t2.setName("زیر ساخت اساسی");
		t2.setDescription("این ذداذسخ عذ اذ لات  لبفغ عه که غف ل ات هب لذ ات .");
		t2.addUser(user);
		Task t3 = new Task();
		t3.setName("تکمیل فرآیند فروش");
		t3.addUser(user);
		t.add(t1);
		t.add(t2);
		t.add(t3);
		return t;
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

	public void close() {
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

	public static User getUserByUsername(String username) {
		User user = new User();
		return user;
	}

	public static User getUserByEmail(String email) {
		// ///////////alaki
		User user = new User();
	    user.setFirstName("Ali");
        user.setId(1);
        user.setBirthday(new Date());
        user.setJobExperience(5);
        user.setLastName("Alavi");
        user.setLicence("LISANSE");
        user.setMarriageStatus(1);
        user.setUsername("ALA");
        user.setNatID("9879782");
        user.setPassword("1234");
        user.setPhoneNumber1("0912456789");
        user.setPhoneNumber2("0215678987");
        user.setRole("Modir");
                 
        return user;
    }
	public List<Resource> getTechnologies() {
		// ///////////alaki
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

	public ArrayList<Module> getModules() {
		// TODO Auto-generated method stub
		// ///////////alaki
		
		User user = new User();
		user.setFirstName("Ali");
		user.setId(1);
		user.setBirthday(new Date());
		user.setJobExperience(5);
		user.setLastName("Alavi");
		user.setLicence("LISANSE");
		user.setMarriageStatus(1);
		user.setUsername("ALA");
		user.setNatID("2");
		user.setPassword("1234");
		user.setPhoneNumber1("0912456789");
		user.setPhoneNumber2("0215678987");
		user.setRole("Modir");
		
		
		
		Module m1 = new Module();
		m1.setName("تغییر ساختار");
		m1.addResource(user);
		Module m2 = new Module();
		m2.setName("ماژول بهبود سازمانی");
		m2.addResource(user);
		Module m3 = new Module();
		m3.setName("ماژول فرسایش عملکرد");
		ArrayList<Module> m = new ArrayList<Module>();
		m.add(m1);
		m.add(m2);
		m.add(m3);
		return m;
	}

	public ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<>();
		User user = new User();
		user.setFirstName("مریم");
		user.setLastName("غضنفری");
		user.setUsername("damboooo");
		users.add(user);
		User user1 = new User();
		user1.setFirstName("میرزا");
		user1.setLastName("کوچک خانی");
		user1.setUsername("jimboooo");
		users.add(user1);
		User user2 = new User();
		user2.setFirstName("عباس");
		user2.setLastName("عبوس");
		user2.setUsername("zknazana");
		users.add(user2);
		return users;
		// TODO Auto-generated method stub
	}

	public void removeUser(User user) {
		// TODO Auto-generated method stub
		
	}
}
