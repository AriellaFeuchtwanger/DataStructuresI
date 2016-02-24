package billOrganizer;

import java.util.Comparator;

public class BillAmountComparator implements Comparator<Bill>{

	@Override
	public int compare(Bill bill1, Bill bill2) {
		double bill1Amount = bill1.getAmountDue();
		double bill2Amount = bill2.getAmountDue();
		
		if(bill1Amount == bill2Amount){
			return 0;
		} else if(bill1Amount > bill2Amount){
			return 1;
		} else{
			return -1;
		}
	}

}
