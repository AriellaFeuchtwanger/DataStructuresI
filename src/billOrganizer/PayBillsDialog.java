package billOrganizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PayBillsDialog extends JDialog{

	private String paymentType;
	private BillOrganizer organizer;
	private JLabel billInfo;
	private JTextField enterID;
	
	public PayBillsDialog(BillOrganizer org){
		this.organizer = org;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Pay Bills");
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setSize(300, 500);
		
		ButtonGroup group = new ButtonGroup();
		
		enterID = new JTextField();
		enterID.setEnabled(false);
		JButton button = new JButton("Pay");
		button.setEnabled(false);
		
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				payBill();
			}
			
		});
		
		JRadioButton byID = new JRadioButton("Pay specific bill");
		byID.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				enterID.setEnabled(true);
				button.setEnabled(true);
				paymentType = "ID";
			}
			
		});

		ButtonGroup criteriaGroup = new ButtonGroup();
		billInfo = new JLabel();
		JRadioButton date = new JRadioButton("First bill due");
		date.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				paymentType = "Date";
				button.setEnabled(true);
			}
			
		});
		JRadioButton amount = new JRadioButton("Largest bill due");
		amount.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				paymentType = "Amount";
				button.setEnabled(true);
			}
			
		});
		JRadioButton type = new JRadioButton("Next bill by type");
		type.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				paymentType = "Type";
				button.setEnabled(true);
			}
			
		});
		
		criteriaGroup.add(date);
		criteriaGroup.add(amount);
		criteriaGroup.add(type);
		
		JPanel criteriaPanel = new JPanel();
		criteriaPanel.setLayout(new BoxLayout(criteriaPanel, BoxLayout.Y_AXIS));
		
		criteriaGroup.add(byID);
		criteriaPanel.add(date);
		criteriaPanel.add(amount);
		criteriaPanel.add(type);
		
		
		add(byID);
		add(enterID);
		add(criteriaPanel);
		add(button);
	}
	
	private void payBill(){
		Bill bill;
		switch(paymentType){
		case "ID":
			organizer.payNextBill(Integer.parseInt(enterID.getText()));
			break;
		case "Date":
			bill = organizer.payNextBill(BillCriteria.BILLDUEDATE);
			billInfo.setText(bill.toString());
			break;
		case "Type":
			bill = organizer.payNextBill(BillCriteria.BILLTYPE);
			billInfo.setText(bill.toString());
			break;
		case "Amount":
			bill = organizer.payNextBill(BillCriteria.BILLAMOUNT);
			billInfo.setText(bill.toString());
			break;
		}
		
		dispose();
	}
}
