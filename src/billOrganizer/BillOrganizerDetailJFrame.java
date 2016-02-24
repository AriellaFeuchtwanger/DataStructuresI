package billOrganizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BillOrganizerDetailJFrame extends JFrame{
	private BillOrganizer organizer;
	
	public BillOrganizerDetailJFrame(BillOrganizer organizer){
		setSize(200, 200);
		setTitle("Bill Organizer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		this.organizer = organizer;
		
		JButton addBill = new JButton("Add bill");
		addBill.setAlignmentX(CENTER_ALIGNMENT);
		addBill.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				addBill();
			}
			
		});
		JButton viewBills = new JButton("View Bills");
		viewBills.setAlignmentX(CENTER_ALIGNMENT);
		viewBills.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				viewBills();
			}
			
		});
		JButton payBills = new JButton("Pay Bill");
		payBills.setAlignmentX(CENTER_ALIGNMENT);
		payBills.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				payBills();
			}
			
		});
		JButton exit = new JButton("Exit");
		exit.setAlignmentX(CENTER_ALIGNMENT);
		exit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					organizer.closeOrganizer();
				} catch (IOException e1) {
					//Dialog box - very doubtful that this will happen.
				}
				dispose();
			}
			
		});
		
		add(addBill);
		add(viewBills);
		add(payBills);
		add(exit);
	}
	
	private void addBill(){
		new AddBillDialog(organizer).setVisible(true);
	}
	
	private void viewBills(){
		new ViewBillsDialog(organizer).setVisible(true);
	}
	
	private void payBills(){
		new PayBillsDialog(organizer).setVisible(true);
	}
}
