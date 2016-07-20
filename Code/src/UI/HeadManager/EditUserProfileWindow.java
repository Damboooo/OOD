package UI.HeadManager;

import javax.swing.*;

import ResourceManagement.User;
import UI.Accounting.UserDetailsWindow;

public class EditUserProfileWindow extends UserDetailsWindow {


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
//	private JRadioButton marriageStatusButton = new JRadioButton("وضعیت تاهل");
    //private JDatePicker birthDate = new JDatePicker;=================================>

    public EditUserProfileWindow(User user) {
        super(user);
        setTitle("ویرایش اطلاعات");

        nameTextField = createTextField("", 480, 40);
        familyNameTextField = createTextField("", 480, 40 + 30);
        nationalIDTextField = createTextField("", 480, 40 + 30 * 2);

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


        changePasswordButton = new JButton("تغییر رمز عبور");
        changePasswordButton.setSize(100, 25);
        changePasswordButton.setLocation(100, 20);
        panel.add(changePasswordButton);

        usernameLabel = new JLabel("majidK");
        usernameLabel.setSize(90, 25);
        usernameLabel.setLocation(40, 20);
        panel.add(usernameLabel);


        firstButton = new JButton("ثبت اطلاعات");
        firstButton.setSize(90, 25);
        firstButton.setLocation(500, 40 + 30 * 13);
        panel.add(firstButton);

        secondButton = new JButton("انصراف");
        secondButton.setSize(90, 25);
        secondButton.setLocation(400, 40 + 30 * 13);
        panel.add(secondButton);

    }

    private JTextField createTextField(String s, int x, int y) {
        JTextField t = new JTextField(s);
        t.setSize(120, 25);
        t.setLocation(x, y);
        panel.add(t);
        return t;
    }


    public boolean saveChanges() {
        return false;
    }

    public void back() {

    }


}
 

