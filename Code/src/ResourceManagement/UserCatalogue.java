package ResourceManagement;


import java.util.List;

public class UserCatalogue {

    private static UserCatalogue userCatalogue = new UserCatalogue();

    private List<User> userAccountList;
    private List<User> waitingList;

    public static UserCatalogue getInstance() {
        return userCatalogue;
    }

    public void deleteUser(int natID) {

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

    public List<User> getUserAccountList() {
        return userAccountList;
    }

    public void setUserAccountList(List<User> userAccountList) {
        this.userAccountList = userAccountList;
    }

    public List<User> getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(List<User> waitingList) {
        this.waitingList = waitingList;
    }
}
