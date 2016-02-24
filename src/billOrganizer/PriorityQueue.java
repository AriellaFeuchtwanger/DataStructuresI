package billOrganizer;

import java.io.Serializable;
import java.util.Comparator;

public class PriorityQueue<T extends Serializable & Comparable<T>> {
	private SortedLinkedList<T> queue;
	private Comparator<T> comparator;
	
	public PriorityQueue(Comparator<T> comparator){
		queue = new SortedLinkedList<T>();
		this.comparator = comparator;
	}
	
	public void enqueue(T data){
		queue.insert(data, comparator);
	}
	
	public T dequeue(){
		T data = queue.getFirst().getData();
		queue.remove(data);
		return data;
	}
	
	public T peek(){
		return queue.getFirst().getData();
	}
	
	public void remove(T data){
		queue.remove(data);
	}
	
	public Node<T> getFirst(){
		return queue.getFirst();
	}
}
