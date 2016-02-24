package billOrganizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ViewBillsDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewBillsDialog(BillOrganizer organizer) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("View Bills");
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setSize(600, 800);

		JLabel label = new JLabel(" ");
		ButtonGroup group = new ButtonGroup();
		JRadioButton date = new JRadioButton("Sort by due date");
		JLabel[] bills = new JLabel[organizer.getSize()];
		date.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Iterator<Bill> iter = organizer.iteratorByDate();
				//StringBuilder builder = new StringBuilder();
				int count = 0;

				while (iter.hasNext()) {
					bills[count].setText(iter.next().toString());
					count++;
					//builder.append(iter.next().toString());
				}
				//label.setText(builder.toString());
			}

		});
		JRadioButton amount = new JRadioButton("Sort by amount");
		amount.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Iterator<Bill> iter = organizer.iteratorByAmount();
				//StringBuilder builder = new StringBuilder();
				int count = 0;

				while (iter.hasNext()) {
					bills[count].setText(iter.next().toString());
					count++;
					//builder.append(iter.next().toString());
				}
				//label.setText(builder.toString());
			}

		});
		JRadioButton type = new JRadioButton("Sort by bill type");
		type.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Iterator<Bill> iter = organizer.iteratorByType();
				//StringBuilder builder = new StringBuilder();
				int count = 0;

				while (iter.hasNext()) {
					bills[count].setText(iter.next().toString());
					count++;
					//builder.append(iter.next().toString());
				}
				//label.setText(builder.toString());
			}

		});

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		JButton button = new JButton("Close");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});

		group.add(date);
		group.add(amount);
		group.add(type);

		panel.add(date);
		panel.add(amount);
		panel.add(type);

		add(panel);
		//add(label);
		
		
		for (int i = 0; i < organizer.getSize(); i++) {
			bills[i] = new JLabel(" ");
			bills[i].setAlignmentX(JLabel.CENTER_ALIGNMENT);
			add(bills[i]);
		}
		
		add(button);
	}

}
