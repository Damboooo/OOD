package UI.HeadManager;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ResourceManagement.Resource;
import ResourceManagement.User;
import UI.ProjectManager.UserWindow;

public class EditResourceWindow extends UserWindow{
	private int id;
   //asset
	private List<Date> freeTimes;
    private String type;
//    //finance
//    private int amount;
    //knowledge
    private String description;
//    //user
//    private String firstName;
//    private String lastName;
//    private int natID;
//    private Date birthday;
//    private int marriageStatus;
//    private String licence;
//    private int jobExperience;
//    private String role;
//    private String phoneNumber;
//    private String username;
//    private String password;
    
    
	 private JTextField freeTimesTextField;
	    private JTextField idTextField;
	    private JTextField nameTextField;
	    private JTextField typeTextField;
	    private JTextField descriptionTextField;
	   
	    private JButton saveButton;
	    
    public EditResourceWindow(User user ,Resource resource) {

    	super(user);
        setTitle("پنل مدیریت");
        createLabel("ویرایش منبع", 550, 90);
        
        createLabel("نام منبع:", 540, 180 + 28 * 0);
        createLabel("شناسا:", 540, 180 + 28 * 2);
        createLabel("نوع منبع:", 540, 180 + 28 * 4);
        createLabel("زمان های آزاد:", 540, 180 + 28 * 6);
        createLabel("توصیف:", 540, 180 + 28 * 8);


        nameTextField = createTextField("myServer", 320, 180 + 28 * 0);
        idTextField = createTextField("11", 320, 180 + 28 * 2);
        typeTextField = createTextField("سرور", 320, 180 + 28 * 4);
        freeTimesTextField = createTextField("200", 320, 180 + 28 * 6);
        descriptionTextField = createTextField("این یک سرور است.", 320, 180 + 28 * 8);

        saveButton = new JButton("ثبت تغییرات");
        saveButton.setSize(80, 25);
        saveButton.setLocation(100, 520);
        panel.add(saveButton);


    }

    private void createLabel(String s, int x, int y) {
        JLabel t = new JLabel(s);
        t.setSize(120, 25);
        t.setLocation(x, y);
        panel.add(t);
        //return t;
    }

    private JTextField createTextField(String s, int x, int y) {
        JTextField t = new JTextField(s);
        t.setSize(180, 25);
        t.setLocation(x, y);
        panel.add(t);
        return t;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paint(g2);
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0);
        g2.setStroke(dashed);
        g2.drawRect(115, 150, 560, 370);

    }
    

    public boolean saveChanges() {
        return false;
    }

}
