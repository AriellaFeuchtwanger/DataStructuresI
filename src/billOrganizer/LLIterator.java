package billOrganizer;

import java.io.Serializable;
import java.util.Iterator;

public class LLIterator<T extends Comparable<T> & Serializable> implements Iterator{

	private Node<T> currentNode;
	private Node<T> head;
	
	public LLIterator(Node<T> head){
		this.head = head;
		this.currentNode = head;
	}
	@Override
	public boolean hasNext() {
		if(currentNode == null){
			return false;
		}
		else{
			return true;
		}
	}

	@Override
	public T next() {
		T data = currentNode.getData();
		currentNode = currentNode.getNode();
		return data;
	}
	
	public void reset(){
		this.currentNode = head;
	}
}
