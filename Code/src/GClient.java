import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

public class GClient extends JFrame {

	static JTextField HostPort;
	static JTextField m;
	static JTextField m2;
	static JTextField HostIP;
	boolean isCommand;
	Client client;
	static JFrame jf;
	static JTextField q2;
//	static boolean ok = false;
//	static boolean okset = false;

	public static void main(String[] args) {
		new GClient();
	}

	public GClient() {
		setLayout(new BorderLayout());
		setLocation(500, 400);
		HostPort = new JTextField("");
		HostIP = new JTextField("");
		add(HostPort, BorderLayout.NORTH);
		add(HostIP, BorderLayout.CENTER);
		HostPort.setEditable(true);
		HostIP.setEditable(true);
		HostIP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isCommand) {
					if (HostIP.getText().equals("GetList"))
						client.getList();
					else if (HostIP.getText().startsWith("Connect"))
						client.connect(Integer.parseInt(HostIP.getText().split(
								" ")[1]));
					else if (HostIP.getText().startsWith("Terminate")) {
						client.send("CHAT_TERMINATED", client.id, Integer
								.parseInt(HostIP.getText().split(" ")[1]));
						jf.setVisible(false);
					} else if (HostIP.getText().startsWith("Block")) {
						client.blocklist.add(HostIP.getText().split(" ")[1]);
						jf.setVisible(false);
					} else if (HostIP.getText().startsWith("Unblock")) {
						client.blocklist.remove(HostIP.getText().split(" ")[1]);
					}
				} else {
					String command = HostPort.getText();
					String IP = HostIP.getText();
					try {
						client = new Client(Integer.parseInt(command), IP);
					} catch (NumberFormatException e1) {
						System.out.println("servesocket error");
					}
					setTitle("Enter Your Command");
					HostPort.setVisible(false);
					HostIP.setText("");
					isCommand = true;
				}
			}
		});
		setTitle("Enter Server Port" + " & " + "Server IP");
		setSize(400, 100);
		setVisible(true);
	}

	public static void openChat(final int otherId) {
		// TODO Auto-generated method stub
		System.out.println("Chating With " + otherId);
		jf = new JFrame();
		jf.setLayout(new BorderLayout());
		jf.setLocation(500, 400);
		final JTextField text = new JTextField("");
		jf.add(text, BorderLayout.SOUTH);
		m = new JTextField("");
		m.setEditable(false);
		m2 = new JTextField("");
		m2.setEditable(false);
		jf.add(m, BorderLayout.NORTH);
		jf.add(m2, BorderLayout.CENTER);
		text.setEditable(true);
		text.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String command = text.getText();
				Client.send(command, Client.id, otherId);
				m2.setText(command);
				System.out.println(command);
				m.setVisible(true);
				text.setText("");
			}
		});

		jf.setTitle(Client.id + "(you) Chat With " + otherId);
		jf.setSize(300, 500);
		jf.setVisible(true);
	}

	public static void show(String string) {
		// TODO Auto-generated method stub
		m.setText(string.split(" ")[1]);
		System.out.println(string.split(" ")[1]);
		m.setVisible(true);
		;
	}

//	public static void answer(int otherId) {
//		// TODO Auto-generated method stub
//		final JFrame question = new JFrame();
//		question.setLayout(new BorderLayout());
//		question.setLocation(500, 500);
//		JTextField q1 = new JTextField(otherId
//				+ " Wants To Chat. Do You Agree? (y/n)");
//		q1.setEditable(false);
//		q2 = new JTextField("");
//		q2.setEditable(true);
//		q2.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (q2.getText().equals("y"))
//					ok = true;
//				else
//					ok = false;
//				question.setVisible(false);
//				okset = true;
//			}
//		});
//		question.add(q1, BorderLayout.NORTH);
//		question.add(q2, BorderLayout.CENTER);
//		question.setTitle("QUESTION");
//		question.setSize(500, 100);
//		question.setVisible(true);
//		while (true) {
//			if (ok) {
//				ok = false;
//				question.setVisible(false);
//				return true;
//			}
//			if (nok) {
//				nok = false;
//				question.setVisible(false);
//				return false;
//			}
//		}
//	}
}
