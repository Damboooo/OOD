package UI.HeadManager;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ResourceManagement.User;


public class ManageResourcesWindow extends UI.Employee.UserWindow {


	private JButton[] editButtons = new JButton[100];
	private JButton searchButton;
	private JButton addResourceButton;
	private JTextField searchTextField;
	private JCheckBox checkBoxFree;
	private JCheckBox checkBoxBusy;
	
	public ManageResourcesWindow(User user) {
		super(user);
		setTitle("پنل مدیریت");
		
		createLabel("فهرست منابع انسانی " , 560,98);
		createLabel("نیروی انسانی یک" , 410,98+30);
		createLabel("نیروی انسانی دو" , 410,98+60);
		
		createLabel("فهرست منابع فیزیکی " , 560,198);
		createLabel("سرور" , 410,198+30);
		createLabel("دیتابیس" ,410,198+60);
		
		createLabel("فهرست منابع مالی " , 560,298);
		createLabel("هزینه مالی یک" , 410,298+30);
		createLabel("هزینه مالی دو" , 410,298+60);
		
		createLabel("فهرست منابع دانشی " , 560,398);
		createLabel("دانش یک" , 410,398+30);
		createLabel("دانش دو" , 410,398+60);
		
		createbutton("مشاهده و ویرایش", 280, 98+30);
		createbutton("مشاهده و ویرایش", 280,98+60 );
		createbutton("مشاهده و ویرایش", 280,198+30 );
		createbutton("مشاهده و ویرایش", 280, 198+60);
		createbutton("مشاهده و ویرایش", 280,298+30 );
		createbutton("مشاهده و ویرایش", 280, 298+60);
		createbutton("مشاهده و ویرایش", 280,398+30 );
		createbutton("مشاهده و ویرایش", 280,398+60 );
		
		checkBoxFree = createCheckBox("آزاد", 160, 75,40);
		checkBoxBusy = createCheckBox("در حال استفاده", 80, 75,90);

		
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
