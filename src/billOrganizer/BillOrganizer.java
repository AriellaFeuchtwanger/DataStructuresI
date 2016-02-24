package billOrganizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;

public class BillOrganizer {
	private SortedLinkedList<Bill> billList;
	private PriorityQueue<Bill> dateQueue;
	private PriorityQueue<Bill> amountQueue;
	private PriorityQueue<Bill> typeQueue;
	private int count;

	public BillOrganizer() {
		billList = new SortedLinkedList<Bill>();
		dateQueue = new PriorityQueue<Bill>(new BillDateComparator());
		amountQueue = new PriorityQueue<Bill>(new BillAmountComparator());
		typeQueue = new PriorityQueue<Bill>(new BillTypeComparator());
		count = 0;
	}

	public BillOrganizer(FileInputStream in) throws IOException,
			ClassNotFoundException {
		ObjectInputStream inputStream = new ObjectInputStream(in);
		billList = (SortedLinkedList<Bill>) inputStream.readObject();
		dateQueue = new PriorityQueue<Bill>(new BillDateComparator());
		amountQueue = new PriorityQueue<Bill>(new BillAmountComparator());
		typeQueue = new PriorityQueue<Bill>(new BillTypeComparator());

		Iterator<Bill> iterator = new LLIterator(billList.getFirst());
		count = 0;
		
		Bill bill;
		while (iterator.hasNext()) {
			bill = iterator.next();
			amountQueue.enqueue(bill);
			typeQueue.enqueue(bill);
			dateQueue.enqueue(bill);
			count++;
		}
	}

	public BillOrganizer(String fileName) throws FileNotFoundException {
		billList = new SortedLinkedList<Bill>();
		dateQueue = new PriorityQueue<Bill>(new BillDateComparator());
		amountQueue = new PriorityQueue<Bill>(new BillAmountComparator());
		typeQueue = new PriorityQueue<Bill>(new BillTypeComparator());

		File file = new File(fileName);
		Scanner reader = new Scanner(file);
		String vendor;
		double amtDue;
		LocalDate billDate;
		BillType type;
		
		String date;
		count = 0;
		Bill bill;

		while (reader.hasNext()) {
			vendor = reader.nextLine();
			//String amt = reader.next();
			//amtDue = 0.0;
			amtDue = reader.nextDouble();
			date = reader.next();
			type = getBillType(reader.next());
			bill = new Bill(vendor, amtDue, date, type);
			billList.insert(bill);
			amountQueue.enqueue(bill);
			typeQueue.enqueue(bill);
			dateQueue.enqueue(bill);
			count++;
			reader.nextLine();
		}
		
	}

	public void insert(Bill bill) {
		count++;
		billList.insert(bill);
		amountQueue.enqueue(bill);
		typeQueue.enqueue(bill);
		dateQueue.enqueue(bill);
	}
	
	public Bill payNextBill(Integer billID){
		Iterator<Bill> iter = new LLIterator(billList.getFirst());
		Bill bill = iter.next();
		
		while(iter.hasNext()){
			if(bill.getBillID().equals(billID)){
				billList.remove(bill);
				break;
			}
			bill = iter.next();
		}
		
		if(bill == null){
			throw new NotFoundException();
		} else{
			amountQueue.remove(bill);
			typeQueue.remove(bill);
			dateQueue.remove(bill);
			return bill;
		}
	}

	public Bill payNextBill(BillCriteria criteria) {
		Bill bill;
		switch (criteria) {
		case BILLDUEDATE:
			bill = dateQueue.dequeue();
			amountQueue.remove(bill);
			typeQueue.remove(bill);
			billList.remove(bill);
			return bill;
		case BILLAMOUNT:
			bill = amountQueue.dequeue();
			typeQueue.remove(bill);
			dateQueue.remove(bill);
			billList.remove(bill);
			return bill;
		case BILLTYPE:
			bill = typeQueue.dequeue();
			amountQueue.remove(bill);
			dateQueue.remove(bill);
			billList.remove(bill);
			return bill;
		}

		throw new ListEmptyException();
	}

	public double totalBills() {
		double amount = 0.0;

		Iterator<Bill> iterator = new LLIterator(billList.getFirst());

		while (iterator.hasNext()) {
			amount += iterator.next().getAmountDue();
		}

		return amount;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("Bills: ");

		Iterator<Bill> iterator = new LLIterator(billList.getFirst());

		while (iterator.hasNext()) {
			buffer.append(iterator.next().toString());
		}

		return buffer.toString();
	}

	public Iterator<Bill> iteratorByDate() {
		Iterator<Bill> iterator = new LLIterator(dateQueue.getFirst());

		return iterator;
	}

	public Iterator<Bill> iteratorByAmount() {
		Iterator<Bill> iterator = new LLIterator(amountQueue.getFirst());

		return iterator;
	}

	public Iterator<Bill> iteratorByType() {
		Iterator<Bill> iterator = new LLIterator(typeQueue.getFirst());

		return iterator;
	}

	public void closeOrganizer() throws IOException  {
		ObjectOutputStream outputStream = new ObjectOutputStream(
				new FileOutputStream("bills.ser"));

		outputStream.writeObject(billList);

		outputStream.close();
	}
	
	private BillType getBillType(String type) {
		for (BillType billType : BillType.values()) {
			if (billType.getName().equalsIgnoreCase(type)) {
				return billType;
			}
		}

		return null;
	}
	
	public int getSize(){
		return count;
	}
}
