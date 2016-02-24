package billOrganizer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class BillOrganizerJFrame extends JFrame {

	private String selection;
	private JTextField field;

	public BillOrganizerJFrame() {
		setSize(300, 250);
		setTitle("Bill Organizer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		JLabel label1 = new JLabel("Welcome to the Bill Organizer!");
		JLabel label2 = new JLabel("Choose an option from below:");
		JRadioButton newOrganizer = new JRadioButton(
				"Create new Bill Organizer");
		JRadioButton textOrganizer = new JRadioButton(
				"Create new Bill Organizer from text file");
		JRadioButton oldOrganizer = new JRadioButton(
				"Use existing Bill Organizer");
		ButtonGroup group = new ButtonGroup();
		group.add(newOrganizer);
		group.add(textOrganizer);
		group.add(oldOrganizer);

		field = new JTextField();
		field.setMaximumSize(new Dimension(600, 25));
		field.setPreferredSize(new Dimension(600, 25));
		field.setEditable(false);

		newOrganizer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				selection = "New";
			}
		});
		textOrganizer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				field.setEditable(true);
				selection = "Text";
			}

		});
		oldOrganizer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selection = "Old";
			}

		});

		JButton start = new JButton("Start");
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				createOrganizer();
			}

		});
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});

		add(label1);
		add(label2);
		add(newOrganizer);
		add(textOrganizer);
		add(field);
		add(oldOrganizer);
		add(start);
		add(exit);
	}

	private void createOrganizer() {
		switch (selection) {
		case "New":
			new BillOrganizerDetailJFrame(new BillOrganizer()).setVisible(true);
			dispose();
			break;
		case "Text":
			String text = field.getText();
			try {
				BillOrganizer organizer = new BillOrganizer(text);
				new BillOrganizerDetailJFrame(organizer).setVisible(true);
			} catch (FileNotFoundException e) {
				JOptionPane
						.showMessageDialog(null,
								"The text file could not be found.\nWe will now create a new organizer.");
				new BillOrganizerDetailJFrame(new BillOrganizer())
						.setVisible(true);
			}
			dispose();
			break;
		case "Old":
			try {
				FileInputStream in = new FileInputStream(new File("bills.ser"));
				new BillOrganizerDetailJFrame(new BillOrganizer(in))
						.setVisible(true);
			} catch (IOException e) {
				JOptionPane
						.showMessageDialog(
								null,
								"We can't seem to find the file.\nYou may have changed the file.\nWe will create a new organizer for you.");
				new BillOrganizerDetailJFrame(new BillOrganizer()).setVisible(true);
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Big error. Contact IT.");
			}
			dispose();
		}
	}

	public static void main(String[] args) {
		new BillOrganizerJFrame().setVisible(true);
	}
}
