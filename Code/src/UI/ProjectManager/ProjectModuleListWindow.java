package UI.ProjectManager;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import ProjectManagement.Module;
import ProjectManagement.Project;
import ResourceManagement.User;

public class   ProjectModuleListWindow extends UserWindow{
	
//	private JLabel[] labels = new JLabel[6];
	private ArrayList<JButton> editButtons = new ArrayList<JButton>();
	
	private JButton addModuleButton;
	private JLabel label;
	private JButton searchButton;
	private JTextField searchTextField;

	public ProjectModuleListWindow(User user,Project project) {
		super(user);
		setTitle("ثبت اطلاعات تغییر ماژول ها");
//		Rectangle r = new Rectangle(0, 0, 100, 100);
//		super.panel.add(r);

		ArrayList<Module> modules = (ArrayList<Module>) project.getModuleList();
		
        label = new JLabel("لیست ماژول ها");
        label.setSize(160, 25);
        label.setLocation(600, 90);
        super.panel.add(label);

        searchTextField = new JTextField();
        searchTextField.setSize(300, 25);
        searchTextField.setLocation(250, 150);
        super.panel.add(searchTextField);

        searchButton = new JButton("جستجو");
        searchButton.setSize(65, 25);
        searchButton.setLocation(200, 150);
        super.panel.add(searchButton);

//==================================> خوندن از دیتابیس

        for (int i = 0; i < modules.size(); i++) {
            JButton editButton = new JButton(modules.get(i).getName());
            editButton.setSize(180, 25);
            editButton.setLocation(300, 200 + 30 * i);
            editButtons.add(editButton);
            super.panel.add(editButton);
        }

        addModuleButton = new JButton("افزودن ماژول جدید");
        addModuleButton.setSize(280, 25);
        addModuleButton.setLocation(250, 200 + 30 * 8);
        super.panel.add(addModuleButton);


    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paint(g2);
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0);
        g2.setStroke(dashed);
        g2.drawRect(115, 150, 560, 370);

    }

    public void editModule(Module module) {

    }

    public void search() {

    }

    public void addModule() {

    }
}

	


