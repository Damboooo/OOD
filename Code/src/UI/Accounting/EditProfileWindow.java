package UI.Accounting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

import Main.Main;
import ResourceManagement.User;
import UI.Employee.EmployeeMainWindow;
import UI.HeadManager.HeadManagerMainWindow;
import UI.HeadManager.ProjectsListWindow;

public class EditProfileWindow extends UserDetailsWindow {


	private int controler;
    private ProjectsListWindow pl;
    private HeadManagerMainWindow hm;
    private EmployeeMainWindow em;

    private JTextField nameTextField = new JTextField();
    private JTextField familyNameTextField = new JTextField();
    private JTextField nationalIDTextField = new JTextField();

    private JButton firstButton = new JButton();
    private JButton secondButton = new JButton();
    private JButton changePasswordButton = new JButton();

    private JTextField phoneNumber1 = new JTextField();
    private JTextField phoneNumber2 = new JTextField();
    private JTable educationalResume = new JTable();
    private JLabel usernameLabel = new JLabel();

    // private JRadioButton marriageStatusButton = new
    // JRadioButton("وضعیت تاهل");
    // private JDatePicker birthDate = new
    // JDatePicker;=================================>

    public EditProfileWindow(final User user, int controler) {
        super(user);
        setTitle("ویرایش اطلاعات");
        
        this.controler = controler;

        nameTextField = createTextField("", 480, 40);
        nameTextField.setText(user.getFirstName());
        familyNameTextField = createTextField("", 480, 40 + 30);
        familyNameTextField.setText(user.getLastName());
        nationalIDTextField = createTextField("", 480, 40 + 30 * 2);
        nationalIDTextField.setText(user.getNatID() + "");

        phoneNumber1 = createTextField(user.getPhoneNumber1(), 480, 40 + 30 * 9);
        phoneNumber2 = createTextField(user.getPhoneNumber2(), 330, 40 + 30 * 9);

        // JPanel radioPanel = new JPanel();
        // add(radioPanel);
        // JRadioButton married = new JRadioButton("متاهل");
        // JRadioButton single = new JRadioButton("مجرد");
        // ButtonGroup bG = new ButtonGroup();
        // bG.add(married);
        // bG.add(single);
        // radioPanel.setLocation(600,160);
        // radioPanel.setLayout( new FlowLayout());
        //
        // radioPanel.add(married);
        // radioPanel.add(single);
        // married.setSelected(true);

        changePasswordButton = new JButton("تغییر رمز عبور");
        changePasswordButton.setSize(100, 25);
        changePasswordButton.setLocation(100, 20);
        panel.add(changePasswordButton);

        usernameLabel = new JLabel(user.getUsername());
        usernameLabel.setSize(90, 25);
        usernameLabel.setLocation(40, 20);
        panel.add(usernameLabel);

        firstButton = new JButton("ثبت اطلاعات");
        firstButton.setSize(90, 25);
        firstButton.setLocation(500, 40 + 30 * 13);
        firstButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                confirm(user);
            }
        });
        panel.add(firstButton);

        secondButton = new JButton("انصراف");
        secondButton.setSize(90, 25);
        secondButton.setLocation(400, 40 + 30 * 13);
        secondButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cancel(user);
            }
        });
        panel.add(secondButton);

    }

    private JTextField createTextField(String s, int x, int y) {
        JTextField t = new JTextField(s);
        t.setSize(120, 25);
        t.setLocation(x, y);
        panel.add(t);
        return t;
    }

    public boolean confirm(User user) {
    	if(controler == 1)
    	{
    		dispose();
    		return false;
    	}
        user.setFirstName(nameTextField.getText());
        user.setLastName(familyNameTextField.getText());
        user.setNatID(nationalIDTextField.getText());
        user.setPhoneNumber1(phoneNumber1.getText());
        user.setPhoneNumber2(phoneNumber2.getText());
        Main.dbManager.updateUser(user.getId(), user);
        switch (user.getRole()) {
            case "مدیر":
                pl = new ProjectsListWindow(new User());
                break;
            case "مدیرکل":
                hm = new HeadManagerMainWindow(user);
                break;
            case "کارمند":
                em = new EmployeeMainWindow(new User());
                break;
            default:
                em = new EmployeeMainWindow(new User());
                break;
        }
        dispose();
        return true;
    }

    public boolean cancel(User user) {
    	if(controler == 1)
    	{
    		dispose();
    		return false;
    	}
        // display/center the jdialog when the button is pressed
        switch (user.getRole()) {
            case "مدیر":
                pl = new ProjectsListWindow(new User());
                break;
            case "مدیرکل":
                hm = new HeadManagerMainWindow(user);
                break;
            case "کارمند":
                em = new EmployeeMainWindow(new User());
                break;
            default:
                em = new EmployeeMainWindow(new User());
                break;
        }
        dispose();
        return false;
    }
}