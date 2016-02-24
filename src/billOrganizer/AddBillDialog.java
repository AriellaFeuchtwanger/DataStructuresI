package billOrganizer;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddBillDialog extends JDialog {

	private BillType billType;

	public AddBillDialog(BillOrganizer organizer) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("View Bills");
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setSize(300, 400);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2));

		Font font = new Font("Times New Roman", 24, Font.PLAIN);
		JLabel vendor = new JLabel("Enter Vendor");
		JTextField vendorField = new JTextField();
		vendorField.setMaximumSize(new Dimension(100, 25));
		JLabel dueDate = new JLabel("Enter Due Date (MM/DD/YYYY format)");
		JTextField dateField = new JTextField();
		dateField.setMaximumSize(new Dimension(300, 25));
		JLabel amount = new JLabel("Enter amount");
		JTextField amountField = new JTextField();
		amountField.setMaximumSize(new Dimension(300, 25));
		JLabel type = new JLabel("Choose type");
		JComboBox<BillType> typeList = new JComboBox<BillType>(
				BillType.values());
		typeList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				billType = (BillType) typeList.getSelectedItem();
			}

		});

		JButton exit = new JButton("Close");
		exit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
			
		});
		
		panel.add(vendor);
		panel.add(vendorField);
		panel.add(dueDate);
		panel.add(dateField);
		panel.add(amount);
		panel.add(amountField);
		panel.add(typeList);

		JButton button = new JButton("Add bill");
		JLabel total = new JLabel();
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String vendorName = vendorField.getText();
				String amountMoney = amountField.getText();
				String date = dateField.getText();

				if (vendorName == null || amountMoney == null || date == null
						|| billType == null) {
					JOptionPane
							.showMessageDialog(
									null,
									"There is missing information. Please fill in the blank spaces or select a type from the menu.");
				} else {
					
					organizer.insert(new Bill(vendorField.getText(), Double
							.parseDouble(amountField.getText()), dateField
							.getText(), billType));
					total.setText("$" + organizer.totalBills());
				}
				
				vendorField.setText("");
				amountField.setText("");
				dateField.setText("");
			}
		});

		add(panel);
		add(button);
		add(exit);
		add(total);
	}
}
