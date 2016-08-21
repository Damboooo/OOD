package ProjectManagement;

import java.util.ArrayList;

import ResourceManagement.User;

public class Task {

	private String name;
	private String description;
	private boolean isFinished;
	private ArrayList<User> users = new ArrayList<>();

	public void showFields() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void addUser(User user) {
		users.add(user);
	}
}
