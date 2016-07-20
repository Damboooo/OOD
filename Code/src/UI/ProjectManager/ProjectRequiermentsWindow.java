package UI.ProjectManager;

import java.awt.*;
import javax.swing.*;
import ProjectManagement.Task;
import ResourceManagement.User;

public class   ProjectRequiermentsWindow extends UI.Employee.UserWindow{
	
	//private Requierment[] modules = new Requierment[100];
	private JButton addRequiermentButton;
	private JLabel label;
	private JCheckBox checkBox;
    public ProjectRequiermentsWindow(User user) {
		super(user);
		setTitle("پنل مدیریت پروژه");
//		Rectangle r = new Rectangle(0, 0, 100, 100);
//		super.panel.add(r);
		
		label = new JLabel("فهرست نیازمندی های پروژه یک");
		label.setSize(90, 25);
		label.setLocation(600,90);
		super.panel.add(label);

		
		addRequiermentButton = new JButton("افزودن نیازمندی جدید");
		addRequiermentButton.setSize(280, 25);
		addRequiermentButton.setLocation(250,200+30*8);
		super.panel.add(addRequiermentButton);
		
		
		createLabel("نیازمندی یک" , 510,150+30);
		createLabel("نیازمندی دو" , 510,150+60);
		createLabel("نیازمندی سه" , 510,150+90);
		createLabel("نیازمندی چهار" , 510,150+120);
		createbutton("مشاهده و ویرایش", 180, 150+30);
		createbutton("مشاهده و ویرایش", 180,150+60 );
		createbutton("مشاهده و ویرایش", 180,150+90 );
		createbutton("مشاهده و ویرایش", 180,150+120 );
		
		createLabel("درتاریخ 94/8/12 رفع شد. " , 310,150+30);
		createLabel("درتاریخ 94/8/12 رفع شد. " , 310,150+60);
		checkBox = createCheckBox("در تاریخ             انجام شد", 310, 150+90);
		checkBox = createCheckBox("در تاریخ             انجام شد", 310, 150+120);
		

	}
    private void createLabel(String s , int x , int y ){
		JLabel t = new JLabel(s);
		t.setSize(200,25);
		t.setLocation(x,y);
		panel.add(t);
		//return t;
	}


   private JButton createbutton(String s , int x , int y ){
		JButton t = new JButton(s);
		t.setSize(105,25);
		t.setLocation(x,y);
		panel.add(t);
		return t;
	}
   
	private JCheckBox createCheckBox(String s, int x, int y) {

		JCheckBox checkBoxes = new JCheckBox(s);
		checkBoxes.setSize(150, 20);
		checkBoxes.setLocation(x, y);
		panel.add(checkBoxes);
		return checkBoxes;
	}
	 @Override
	    public void paint(Graphics g){
		    Graphics2D g2 = (Graphics2D) g;
	        super.paint(g2);
	        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0);
	        g2.setStroke(dashed);
	        g2.drawRect(115, 150, 560, 370);
	        
	    }
	
	}
	
	


