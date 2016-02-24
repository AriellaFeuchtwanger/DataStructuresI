package billOrganizer;

import java.io.Serializable;
import java.time.LocalDate;

public class Bill implements Serializable, Comparable<Bill> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer billID;
	private String vendorName;
	private double amountDue;
	private LocalDate dateDue;
	private BillType type;
	private static int LASTID = 0;

	public Bill(String vendorName, double amountDue, String dateDue,
			BillType type) {
		this.billID = LASTID++;
		if (vendorName == null) {
			throw new InvalidDataException();
		} else
			this.vendorName = vendorName;
		if (amountDue < 0) {
			throw new InvalidDataException();
		} else
			this.amountDue = amountDue;
		if (dateDue == null) {
			throw new InvalidDataException();
		} else {
			String[] dateValues = dateDue.split("/");
			this.dateDue = LocalDate.of(Integer.parseInt(dateValues[2]),
					Integer.parseInt(dateValues[0]),
					Integer.parseInt(dateValues[1]));
		}
		if (type == null) {
			throw new InvalidDataException();
		} else
			this.type = type;
	}

	public int compareTo(Bill other) {
		return this.billID.compareTo(other.getBillID());
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();

		String billID = String.format("%-5d", getBillID());
		String vendor = String.format("%50s", getVendorName());
		String date = getDateDue().toString();
		String billType = String.format("%40s", getBillType().getName());

		buffer.append(billID + " ");
		buffer.append("$" + getAmountDue());
		buffer.append("" + vendor);
		buffer.append("  " + date + "  ");
		buffer.append(billType + "\n");

		return buffer.toString();
	}

	public Integer getBillID() {
		return billID;
	}

	public String getVendorName() {
		return vendorName;
	}

	public double getAmountDue() {
		return amountDue;
	}

	public LocalDate getDateDue() {
		return dateDue;
	}

	public BillType getBillType() {
		return type;
	}

	
}
