package UI.HeadManager;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ResourceManagement.Asset;
import ResourceManagement.Finance;
import ResourceManagement.Knowledge;
import ResourceManagement.Resource;
import ResourceManagement.ResourceCatalogue;
import ResourceManagement.User;
import UI.ProjectManager.UserWindow;

public class EditResourceWindow extends UserWindow {
	private int id;
	// asset
	private List<Date> freeTimes;
	private String type;
	// //finance
	// private int amount;
	// knowledge
	private String description;
	// //user
	// private String firstName;
	// private String lastName;
	// private int natID;
	// private Date birthday;
	// private int marriageStatus;
	// private String licence;
	// private int jobExperience;
	// private String role;
	// private String phoneNumber;
	// private String username;
	// private String password;

	private JTextField freeTimesTextField;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField typeTextField;
	private JTextField descriptionTextField;

	private JButton saveButton;

	public EditResourceWindow(User user, final Resource resource) {

		super(user);
		setTitle("پنل مدیریت");
		createLabel("ویرایش منبع", 550, 90);

		createLabel("نام منبع:", 540, 180 + 28 * 0);
		createLabel("شناسا:", 540, 180 + 28 * 2);
		createLabel("نوع منبع:", 540, 180 + 28 * 4);

		nameTextField = createTextField(resource.getName(), 320, 180 + 28 * 0);
		idTextField = createTextField(resource.getId() + "", 320, 180 + 28 * 2);
		switch (resource.getResourceType()) {
		case 1:
			typeTextField = createTextField("فیزیکی", 320, 180 + 28 * 4);
			createLabel("زمان های آزاد:", 540, 180 + 28 * 6);
			createLabel("زیرنوع:", 540, 180 + 28 * 8);
			freeTimesTextField = createTextField("200", 320, 180 + 28 * 6);
			descriptionTextField = createTextField(
					((Asset) resource).getType(), 320, 180 + 28 * 8);

			break;
		case 2:
			typeTextField = createTextField("مالی", 320, 180 + 28 * 4);
			freeTimesTextField = createTextField("200", 320, 180 + 28 * 6);
			createLabel("مقدار :", 540, 180 + 28 * 6);
			descriptionTextField = createTextField(
					((Finance) resource).getAmount() + "", 320, 180 + 28 * 8);
			break;
		case 3:
			typeTextField = createTextField("دانشی", 320, 180 + 28 * 4);
			createLabel("زیرنوع :", 540, 180 + 28 * 6);
			createLabel("توصیف :", 540, 180 + 28 * 8);
			freeTimesTextField = createTextField(
					((Knowledge) resource).getType(), 320, 180 + 28 * 6);
			descriptionTextField = createTextField(
					((Knowledge) resource).getDescription(), 320, 180 + 28 * 8);
			break;
		case 4:
			typeTextField = createTextField("انسانی", 320, 180 + 28 * 4);
			createLabel("نقش :", 540, 180 + 28 * 6);
			createLabel("مدرک :", 540, 180 + 28 * 8);
			freeTimesTextField = createTextField(((User) resource).getRole(),
					320, 180 + 28 * 6);
			descriptionTextField = createTextField(
					((User) resource).getLicence(), 320, 180 + 28 * 8);
			break;

		default:
			typeTextField = createTextField("نامشخص", 320, 180 + 28 * 4);
			break;
		}
		;
		saveButton = new JButton("ثبت تغییرات");
		saveButton.setSize(80, 25);
		saveButton.setLocation(100, 520);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveChanges(resource);
			}
		});
		panel.add(saveButton);

	}

	private void createLabel(String s, int x, int y) {
		JLabel t = new JLabel(s);
		t.setSize(120, 25);
		t.setLocation(x, y);
		panel.add(t);
		// return t;
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
		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL, 0, new float[] { 5 }, 0);
		g2.setStroke(dashed);
		g2.drawRect(115, 150, 560, 370);

	}

	public boolean saveChanges(Resource resource) {
		resource.setName(nameTextField.getText());
		resource.setId(Integer.parseInt(idTextField.getText()));
		switch (resource.getResourceType()) {
		case 1:
			((Asset) resource).setType(descriptionTextField.getText());
			break;
		case 2:
			((Finance) resource).setAmount(Integer
					.parseInt(descriptionTextField.getText()));
			break;
		case 3:
			((Knowledge) resource).setType(freeTimesTextField.getText());
			((Knowledge) resource).setDescription(descriptionTextField
					.getText());
			break;
		case 4:
			((User) resource).setRole(freeTimesTextField.getText());
			((User) resource).setLicence(descriptionTextField.getText());
			break;
		default:
			break;
		}
		ResourceCatalogue.getInstance().update(resource);
		new HeadManagerMainWindow(user);
		dispose();
		return false;
	}

}
