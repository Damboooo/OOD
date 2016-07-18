import javax.swing.*;

public class UserDetailsWindow extends JFrame {
	private JTextField nameTextField = new JTextField();
	private JTextField familyNameTextField = new JTextField();
	private JTextField nationalIDTextField = new JTextField();
	private JTextField jobExperienceTextField = new JTextField();
	private JTextField phoneNumber1 = new JTextField();
	private JTextField phoneNumber2 = new JTextField();
	private JTable educationalResume = new JTable();
	private JPanel panel= new JPanel();
	private JRadioButton marriageStatusButton = new JRadioButton("وضعیت تاهل");
	//private JDatePicker birthDate = new JDatePicker;
//====================================>>>>>>>>
	
	public UserDetailsWindow(){
		setBounds(300, 100, 800, 600);
		panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		setVisible(true);
		
		 createLabel("نام:" , 630,40,70,25);
		 createLabel("نام خانوادگی:" , 630,40+30,70,25);
		 createLabel("کد ملی:" , 630,40+30*2,70,25);
			}
	
	
	
	
	
	private void createLabel(String s , int x , int y , int w , int h){
		JLabel label = new JLabel(s);
		label.setSize(w,h);
		label.setLocation(x,y);
		panel.add(label);
	}
   private void createTextField(String s , int x , int y , int w , int h){
		JTextField t = new JTextField(s);
		t.setSize(w,h);
		t.setLocation(x,y);
		panel.add(t);
	}
}
