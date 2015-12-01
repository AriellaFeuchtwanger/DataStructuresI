package linkedList;

public class UseDoubleLinkList {
	public static void main(String[] args) {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		list.add(5);
		list.add(20);
		list.add(15);
		list.add(10);
		list.add(25);

		ReverseIterator<Integer> iter = list.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}
