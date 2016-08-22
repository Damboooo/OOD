package ResourceManagement;

import java.util.ArrayList;
import java.util.List;

import MainPackage.Main;

public class UserCatalogue {

	private static UserCatalogue userCatalogue = new UserCatalogue();

	private static ArrayList<User> userAccountList;
	private ArrayList<User> waitingList;

	public static UserCatalogue getInstance() {
		userAccountList = Main.dbManager.getUsers();
		return userCatalogue;
	}

	public void deleteUser(User user) {
		Main.dbManager.removeUser(user);
	}

	public void addUser(User user) {

	}

	public User getUser(int natID) {
		return null;
	}

	public List<User> sortUsers() {
		return null;
	}

	public void showUsers() {

	}

	public void showProjectManagers() {

	}

	public List<User> getProjectManagers() {
		return null;
	}

	public ArrayList<User> getUserAccountList() {
		return userAccountList;
	}

	public void setUserAccountList(ArrayList<User> userAccountList) {
		this.userAccountList = userAccountList;
	}

	public ArrayList<User> getWaitingList() {
		return waitingList;
	}

	public void setWaitingList(ArrayList<User> waitingList) {
		this.waitingList = waitingList;
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		for (int i = 0; i < userAccountList.size(); i++) {
			if (user.getId() == userAccountList.get(i).getId()) {
				userAccountList.remove(i);
				userAccountList.add(i, user);
			}
		}
		Main.dbManager.updateUser(user.getId(), user);
	}
}
