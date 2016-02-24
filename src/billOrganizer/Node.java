package billOrganizer;

import java.io.Serializable;

public class Node<T> implements Serializable{
	private T data;
	private Node<T> nextNode;
	
	public Node(T data){
		this.data = data;
		nextNode = null;
	}
	
	public Node(T data, Node<T> next){
		this.data = data;
		this.nextNode = next;
	}
	
	public T getData(){
		return data;
	}
	
	public Node<T> getNode(){
		return nextNode;
	}
	
	public void setNext(Node<T> next){
		nextNode = next;
	}
	
	public void setData(T data){
		this.data = data;
	}
}

