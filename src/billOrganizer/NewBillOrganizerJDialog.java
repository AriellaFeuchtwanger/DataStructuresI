package billOrganizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NewBillOrganizerJDialog extends JDialog {
	
	private BillOrganizer organizer;
	public NewBillOrganizerJDialog(){
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setTitle("Add Bill Organizer");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(300, 500);
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton newOrg = new JRadioButton("Create a new organizer");
		newOrg.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				organizer = new BillOrganizer();
			}
			
		});
		JRadioButton textOrg = new JRadioButton("Create organizer and add bills from text file");
		JTextField field = new JTextField();
		JButton add = new JButton("Add bills");
		add.setEnabled(false);
		field.setEnabled(false);
		textOrg.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				field.setEnabled(true);
				add.setEnabled(true);
			}
			
		});
		add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String textFile = field.getText();
				try {
					organizer = new BillOrganizer(textFile);
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "File not found. Please try again.");
				}
			}
			
		});
		
		group.add(newOrg);
		group.add(textOrg);
		add(newOrg);
		add(textOrg);
		add(field);
		add(add);
	}
	
	public BillOrganizer getOrganizer(){
		return organizer;
	}
}
