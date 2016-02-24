package billOrganizer;

import java.util.Comparator;

public class BillTypeComparator implements Comparator<Bill>{

	@Override
	public int compare(Bill bill1, Bill bill2) {
		String billType1 = bill1.getBillType().getName();
		String billType2 = bill2.getBillType().getName();
		
		return billType1.compareTo(billType2);
	}

}
