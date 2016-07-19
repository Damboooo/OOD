package UI.Accounting;
import javax.swing.*;

import ResourceManagement.User;

public class UserDetailsWindow extends JFrame {
//	private JTextField nameTextField = new JTextField();
//	private JTextField familyNameTextField = new JTextField();
//	private JTextField nationalIDTextField = new JTextField();
//	private JTextField jobExperienceTextField = new JTextField();
//	private JTextField phoneNumber1 = new JTextField();
//	private JTextField phoneNumber2 = new JTextField();
	//private JTable educationalResume = new JTable();
	protected JPanel panel= new JPanel();
	//private JRadioButton marriageStatusButton = new JRadioButton("وضعیت تاهل");
	//private JDatePicker birthDate = new JDatePicker;
//====================================>>>>>>>>
	
	public UserDetailsWindow(User user){
		setBounds(300, 100, 800, 600);
		panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		setVisible(true);
		
		 createLabel("نام:" , 630,40);
		 createLabel("نام خانوادگی:" , 630,40+30);
		 createLabel("کد ملی:" , 630,40+30*2);
		 createLabel("تاریخ تولد:" , 630,40+30*3);
		 createLabel("وضعیت تاهل:" , 630,40+30*4);
		 createLabel("مدرک تحصیلی:" , 630,40+30*5);
		 createLabel("شماره تلفن:" , 630,40+30*9);
		
			}
	
	
	private void createLabel(String s , int x , int y){
		JLabel label = new JLabel(s);
		label.setSize(70,25);
		label.setLocation(x,y);
		panel.add(label);
	}

}
