package linkedList;

import java.io.Serializable;

public class DoubleLinkedList<T extends Serializable & Comparable<T>>
		implements Serializable {
	private DoubleLinkNode<T> head;
	private DoubleLinkNode<T> last;

	public DoubleLinkedList() {
		head = null;
		last = null;
	}

	public void add(T data) {
		DoubleLinkNode<T> previous;
		DoubleLinkNode<T> currentNode;

		if (head == null) {
			this.head = new DoubleLinkNode<T>(data);
		} else {
			DoubleLinkNode<T> newNode = new DoubleLinkNode<T>(data);
			currentNode = previous = head;

			while (currentNode != null
					&& data.compareTo(currentNode.getData()) > 0) {
				previous = currentNode;
				currentNode = currentNode.getNext();
			}
			previous.setNext(newNode);
			newNode.setPrev(previous);
			if (currentNode != null) {
				newNode.setNext(currentNode);
				currentNode.setPrev(newNode);
			}
		}
	}

	public void remove(T data) throws NotFoundException {
		DoubleLinkNode<T> previous = head;
		DoubleLinkNode<T> current = head;

		while (current != null) {
			if (current.getData().equals(data)) {
				if (current == head) {
					head = head.getNext();
					return;
				} else {
					previous.setNext(current.getNext());
					current.getNext().setPrev(previous);
					return;
				}
			} else {
				previous = current;
				current = current.getNext();
			}
		}
		throw new NotFoundException();
	}

	public T find(T data) throws NotFoundException {
		DoubleLinkNode<T> current = head;

		while (current != null) {
			if (current.getData().equals(data)) {
				return current.getData();
			}
			current = current.getNext();
		}

		throw new NotFoundException();
	}

	public ReverseIterator<T> iterator() {
		DoubleLinkNode<T> current = head;
		DoubleLinkNode<T> last = null;
		while (current != null) {
			last = current;
			current = current.getNext();
		}
		return new ReverseIterator<T>(last);
	}

}
