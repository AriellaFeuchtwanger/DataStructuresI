package binaryTrees;

import java.util.ArrayList;

public class BinaryTree<T extends Comparable<T>> {
	private BNode<T> root;
	private boolean found;
	private ArrayList<T> tree;

	public BinaryTree() {
		this.root = null;
	}

	public void insert(T data) {
		this.root = addElement(data, root);
	}

	private BNode<T> addElement(T data, BNode<T> current) {
		if (current == null) {
			current = new BNode<T>(data);
		} else if (data.compareTo(current.getData()) > 0) {
			current.setRC(addElement(data, current.getRC()));
		} else if (data.compareTo(current.getData()) < 0) {
			current.setLC(addElement(data, current.getLC()));
		}
		
		//If it's equal, don't add it.

		return current;
	}

	public boolean remove(T data) {
		if(root == null){
			throw new NullRootException();
		}
		root = removeElement(data, root);
		return found;
	}

	private BNode<T> removeElement(T data, BNode<T> current) {
		if (current == null) {
			found = false;
		} else if (data.compareTo(current.getData()) > 0) {
			current.setRC(removeElement(data, current.getRC()));
		} else if (data.compareTo(current.getData()) < 0) {
			current.setLC(removeElement(data, current.getLC()));
		} else {
			current = removeNode(current);
			found = true;
		}

		return current;
	}

	private BNode<T> removeNode(BNode<T> node) {
		T data;

		if (node.getLC() == null) {
			return node.getRC();
		} else if (node.getRC() == null) {
			return node.getLC();
		} else {
			data = getPredecessor(node.getLC());
			node.setData(data);
			node.setLC(removeElement(data, node.getLC()));
			return node;
		}
	}

	private T getPredecessor(BNode<T> node) {
		while (node.getRC() != null) {
			node = node.getRC(); // The logical predecessor would be the next
			// highest value - the rightmost value
		}

		return node.getData();
	}

	public T get(T data) {
		if(root == null){
			throw new NullRootException();
		}
		return findInfo(data, root);
	}

	private T findInfo(T data, BNode<T> current) {
		if (current == null) {
			return null;
		} else if (data.compareTo(current.getData()) < 0) {
			return findInfo(data, current.getLC());
		} else if (data.compareTo(current.getData()) > 0) {
			return findInfo(data, current.getRC());
		} else {
			return current.getData();
		}
	}

	public ArrayList<T> traverseTree() {
		if(root == null){
			throw new NullRootException();
		}
		tree = new ArrayList<T>(getSize());
		traverseRoot(root);
		return tree;
	}
	
	private void traverseRoot(BNode<T> current) {
		if (current == null) {
			return;
		}
		traverseRoot(current.getLC()); //first get e/t in the left branch
		tree.add(current.getData()); //original node
		traverseRoot(current.getRC()); //then get e/t in the right branch - e/t 
		//that's greater
	}

	public int getSize() {
		int size = findSize(root);
		return size;
	}

	private int findSize(BNode<T> current) {
		if (current == null) {
			return 0;
		} else {
			return findSize(current.getLC()) + findSize(current.getRC()) + 1;
		}
	}
	
	public void balance(){
		int size = getSize();
		if(size == 0){
			throw new NullRootException();
		}
		traverseTree(); //get all the values into 'tree'
		root = null;
		rearrange(0, size - 1);
	}
	
	private void rearrange(int low, int high){
		if(low == high){
			insert(tree.get(low));
		} else if((low + 1) == high){
			insert(tree.get(low));
			insert(tree.get(high));
		} else{
			int mid = (low + high)/2;
			insert(tree.get(mid));
			rearrange(low, mid - 1);
			rearrange(mid + 1, high);
		}
	}
}
