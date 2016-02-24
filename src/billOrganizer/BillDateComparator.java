package billOrganizer;

import java.time.LocalDate;
import java.util.Comparator;

public class BillDateComparator implements Comparator<Bill>{

	@Override
	public int compare(Bill bill1, Bill bill2) {
		LocalDate billDate1 = bill1.getDateDue();
		LocalDate billDate2 = bill2.getDateDue();
		
		return billDate1.compareTo(billDate2);
	}

}
