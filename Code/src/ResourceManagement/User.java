package ResourceManagement;


import java.util.Date;

public class User extends Resource {

    private String firstName;
    private String lastName;
    private int natID;
    private Date birthday;
    private int marriageStatus;
    private String licence;
    private int jobExperience;
    private String role;
    private String phoneNumber1;
    private String phoneNumber2;
    private String username;
    private String password;

    public void showSpecifications() {

    }

    public void exit() {

    }

    public void sendingPasswordEmail() {

    }

    public void validation() {

    }

    public void changePassword(String password) {

    }

    public void changeUserPosition(int natID, String role) {

    }

    public void showAcceptanceRequest() {

    }

    public void storeChanges() {

    }

    public void enter() {

    }

    public void updateJobExperience(int jobExperience) {

    }

    public void showSignupForm() {

    }

    public void addToWaitingList() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNatID() {
        return natID;
    }

    public void setNatID(int natID) {
        this.natID = natID;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(int marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public int getJobExperience() {
        return jobExperience;
    }

    public void setJobExperience(int jobExperience) {
        this.jobExperience = jobExperience;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber) {
        this.phoneNumber1 = phoneNumber;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber) {
        this.phoneNumber2 = phoneNumber;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
