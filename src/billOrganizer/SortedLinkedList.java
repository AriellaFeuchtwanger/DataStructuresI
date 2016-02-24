package billOrganizer;

import java.io.Serializable;
import java.util.Comparator;

public class SortedLinkedList<T extends Serializable & Comparable<T>> extends LinkedList<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private Node<T> head;

	public SortedLinkedList() {
		super();
	}

	@Override
	public void insert(T data){
		Node<T> current = head;
		Node<T> previous = head;
		Node<T> newNode = new Node<T>(data);
		
		if (head == null) {
			head = new Node<T>(data);
		} else {
			while (current != null && data.compareTo(current.getData()) > 0) {
				previous = current;
				current = current.getNode();
			}
			if(current == head){
				
				newNode.setNext(head);
				head = newNode;
			} else{
				previous.setNext(newNode);
				newNode.setNext(current);
			}
		}
	}
	
	public void insert(T data, Comparator<T> comparator){
		Node<T> current = head;
		Node<T> previous = head;
		Node<T> newNode = new Node<T>(data);
		
		if (head == null) {
			head = new Node<T>(data);
		} else {
			while (current != null && comparator.compare(data, current.getData()) >= 0) {
				previous = current;
				current = current.getNode();
			}
			if(current == head){
				
				newNode.setNext(head);
				head = newNode;
			} else{
				previous.setNext(newNode);
				newNode.setNext(current);
			}
		}
	}
	
	public Node<T> find(T data){
		Node<T> current = head;
		
		while(current != null){
			if(current.getData().equals(data)){
				return current;
			}
			current = current.getNode();
		}
		throw new NotFoundException();
	}
	
	
}
