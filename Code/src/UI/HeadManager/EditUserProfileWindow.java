package UI.HeadManager;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ResourceManagement.User;
import ResourceManagement.UserCatalogue;

public class EditUserProfileWindow extends UI.Accounting.UserDetailsWindow {

	private User user;
	
    private JLabel nameLabel = new JLabel();
    private JLabel familyNameLabel = new JLabel();
    private JLabel nationalIDLabel = new JLabel();
    private JTextField jobPositionTextfield;

    private JButton firstButton = new JButton();
    private JButton secondButton = new JButton();

    private JLabel phoneNumber1 = new JLabel();
    private JLabel phoneNumber2 = new JLabel();
    private JTable educationalResume = new JTable();
    private JLabel usernameLabel = new JLabel();
    private JLabel jobPositionLabel = new JLabel();
    private JLabel jobExperienceLabel = new JLabel();
//	private JRadioButton marriageStatusButton = new JRadioButton("وضعیت تاهل");
    //private JDatePicker birthDate = new JDatePicker;=================================>

    public EditUserProfileWindow(final User user) {
        super(user);
        
        this.user = user;
        setTitle("ویرایش اطلاعات");
        createLabel("سمت:", 630, 10);

        jobPositionTextfield = new JTextField(user.getRole());
        jobPositionTextfield.setSize(120, 25);
        jobPositionTextfield.setLocation(470, 10);
        panel.add(jobPositionTextfield);

        nameLabel = createLabel(user.getFirstName(), 480, 40);
        familyNameLabel = createLabel(user.getLastName(), 480, 40 + 30);
        nationalIDLabel = createLabel(user.getNatID(), 480, 40 + 30 * 2);

        phoneNumber1 = createLabel(user.getPhoneNumber1(), 480, 40 + 30 * 9);
        phoneNumber2 = createLabel(user.getPhoneNumber2(), 330, 40 + 30 * 9);
        jobExperienceLabel = createLabel(user.getJobExperience()+"", 480, 40 + 30 * 10);
        jobExperienceLabel = createLabel(user.getJobExperience()+"", 480, 40 + 30 * 10);
        createLabel("سابقه کار", 630, 40 + 30 * 10);
        jobExperienceLabel.setEnabled(false);


//		  	JPanel radioPanel = new JPanel();
//		  	add(radioPanel); 	
//		      JRadioButton married = new JRadioButton("متاهل");
//		      JRadioButton single = new JRadioButton("مجرد");
//		      ButtonGroup bG = new ButtonGroup();
//		      bG.add(married);
//		      bG.add(single);
//		      radioPanel.setLocation(600,160);
//		      radioPanel.setLayout( new FlowLayout());
//		     
//		      radioPanel.add(married);
//		      radioPanel.add(single);
//		      married.setSelected(true);


        usernameLabel = new JLabel(user.getUsername());
        usernameLabel.setSize(90, 25);
        usernameLabel.setLocation(40, 20);
        panel.add(usernameLabel);


        firstButton = new JButton("ثبت تغییرات");
        firstButton.setSize(110, 25);
        firstButton.setLocation(500, 40 + 30 * 13);
        firstButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveChanges(user);
			}
		});
        panel.add(firstButton);

        secondButton = new JButton("بازگشت");
        secondButton.setSize(90, 25);
        secondButton.setLocation(400, 40 + 30 * 13);
        secondButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
        panel.add(secondButton);

    }

    private JLabel createLabel(String s, int x, int y) {
        JLabel t = new JLabel(s);
        t.setSize(120, 25);
        t.setLocation(x, y);
        panel.add(t);
        return t;
    }

    public boolean saveChanges(User user) {
    	user.setRole(jobPositionTextfield.getText());
    	UserCatalogue.getInstance().updateUser(user);
    	dispose();
        return false;
    }

    public void back() {
    	dispose();
    }

}
 

