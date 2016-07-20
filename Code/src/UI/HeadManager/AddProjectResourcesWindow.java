package UI.HeadManager;

import java.awt.BasicStroke;
import java.awt.*;
import javax.swing.*;
import ResourceManagement.User;
public class AddProjectResourcesWindow extends UI.Employee.UserWindow {

	private JButton[] editButtons = new JButton[100];
	private JButton searchButton;
	private JButton addResourceButton;
	private JTextField searchTextField;
	private JCheckBox checkBoxFree;
	private JCheckBox checkBoxBusy;
    private JComboBox<String> typeComboBox = new JComboBox<String>();

	
	public AddProjectResourcesWindow(User user) {
		super(user);
		setTitle("پنل مدیریت");
		
		createLabel("فهرست منابع انسانی " , 510,98);
		createLabel("نیروی انسانی یک" , 410,98+30);
	    createComboBox("نیروی انسانی دو", 460,120+35);
	   
		
		createLabel("فهرست منابع فیزیکی " , 510,198);
		createLabel("سرور" , 410,198+30);
	    createComboBox("دیتابیس", 460,220+35);
		
		createLabel("فهرست منابع مالی " , 510,298);
		createLabel("هزینه مالی یک" , 410,298+30);
	    createComboBox("هزینه مالی دو", 460,320+35);

		
		createLabel("فهرست منابع دانشی " , 510,398);
		createLabel("دانش یک" , 410,398+30);
	    createComboBox("دانش دو", 460,420+35);

		
		
		for (int i = 0; i < 4; i++) {
			
		createbutton("مشاهده و ویرایش", 280, 98+30+100*i);
		createLabel("از تاریخ", 270+30*3,120+35+100*i);
		createLabel("تا تاریخ", 240+30,120+35+100*i);
	    createbutton("افزودن", 280, 120+35+100*i);
		
		}
		searchButton = new JButton("جستجو");
		searchButton.setSize(65, 25);
		searchButton.setLocation(200, 75);
		super.panel.add(searchButton);
		
		searchTextField = new JTextField();
		searchTextField.setSize(300, 25);
		searchTextField.setLocation(250, 75);
		super.panel.add(searchTextField);
		
		addResourceButton = new JButton("افزودن منبع جدید");
		addResourceButton.setSize(280, 25);
		addResourceButton.setLocation(250,270+30*8);
		super.panel.add(addResourceButton);
		
	}
	   private JComboBox<String> createComboBox(String s,int x , int y) {
		  JComboBox<String> cb = new JComboBox<String>();
		    cb.addItem(s);
			panel.add(cb);
			cb.setSelectedIndex(0);
			cb.setBounds(x, y, 200, 20);
			return cb;
		
	}
	private void createLabel(String s , int x , int y ){
			JLabel t = new JLabel(s);
			t.setSize(200,25);
			t.setLocation(x+50,y);
			panel.add(t);
			//return t;
		}


	   private JButton createbutton(String s , int x , int y ){
			JButton t = new JButton(s);
			t.setSize(105,18);
			t.setLocation(x-120,y);
			panel.add(t);
			return t;
		}
	   
	   @Override
	    public void paint(Graphics g){
		    Graphics2D g2 = (Graphics2D) g;
	        super.paint(g2);
	        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0);
	        g2.setStroke(dashed);
	        g2.drawRect(115, 150, 560, 70);
	        g2.drawRect(115, 250, 560, 70);
	        g2.drawRect(115, 350, 560, 70);
	        g2.drawRect(115, 450, 560, 70);
	        
	    }
	   
	   private JCheckBox createCheckBox(String s, int x, int y,int size) {

			JCheckBox checkBoxes = new JCheckBox(s);
			checkBoxes.setSize(size, 20);
			checkBoxes.setLocation(x, y);
			panel.add(checkBoxes);
			return checkBoxes;
		}

	

}
