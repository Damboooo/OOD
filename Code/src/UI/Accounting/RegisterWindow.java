package UI.Accounting;
//import java.awt.*;
//import java.text.*;
//import java.util.*;

import javax.swing.*;
//
//import org.jdatepicker.*;
//import org.jdatepicker.impl.*;

import ResourceManagement.User;

public class RegisterWindow extends UserDetailsWindow {
    //   private JPanel panel = new JPanel();
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JTextField nameTextField = new JTextField();
    private JTextField familyNameTextField = new JTextField();
    private JTextField nationalIDTextField = new JTextField();
    private JTextField userNameTextField = new JTextField();

    private JButton firstButton = new JButton();
    private JButton secondButton = new JButton();

    //	private JTextField jobExperienceTextField = new JTextField();
    private JTextField phoneNumber1 = new JTextField();
    private JTextField phoneNumber2 = new JTextField();
    private JTable educationalResume = new JTable();
//	private JRadioButton marriageStatusButton = new JRadioButton("وضعیت تاهل");
    //private JDatePicker birthDate = new JDatePicker;=================================>

    public RegisterWindow(User user) {
        super(user);
        setTitle("ثبت نام");

        nameTextField = createTextField("", 480, 40);
        familyNameTextField = createTextField("", 480, 40 + 30);
        nationalIDTextField = createTextField("", 480, 40 + 30 * 2);
        userNameTextField = createTextField("", 480 - 300, 40);
        phoneNumber1 = createTextField("", 480, 40 + 30 * 9);
        phoneNumber2 = createTextField("", 330, 40 + 30 * 9);


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


        createLabel("نام کاربری:", 630 - 300, 40);
        createLabel("کلمه عبور:", 630 - 300, 40 + 30 * 1);
        createLabel("تکرار کلمه عبور:", 630 - 300, 40 + 30 * 2);

        passwordField1 = new JPasswordField();
        passwordField1.setSize(120, 25);
        passwordField1.setLocation(180, 70);
        panel.add(passwordField1);

        passwordField2 = new JPasswordField();
        passwordField2.setSize(120, 25);
        passwordField2.setLocation(180, 100);
        panel.add(passwordField2);

        firstButton = new JButton("ثبت اطلاعات");
        firstButton.setSize(90, 25);
        firstButton.setLocation(500, 40 + 30 * 13);
        panel.add(firstButton);

        secondButton = new JButton("انصراف");
        secondButton.setSize(90, 25);
        secondButton.setLocation(400, 40 + 30 * 13);
        panel.add(secondButton);

    }

    private void createLabel(String s, int x, int y) {
        JLabel label = new JLabel(s);
        label.setSize(70, 25);
        label.setLocation(x, y);
        panel.add(label);
    }

    private JTextField createTextField(String s, int x, int y) {
        JTextField t = new JTextField(s);
        t.setSize(120, 25);
        t.setLocation(x, y);
        panel.add(t);
        return t;
    }

    public boolean register() {
        return false;
    }

    public void cancel() {

    }

}
 

