package linkedList;

import java.io.Serializable;
import java.util.Iterator;

public class ReverseIterator<T extends Comparable<T> & Serializable> implements
		Iterator {
	private DoubleLinkNode<T> last;
	private DoubleLinkNode<T> current;

	public ReverseIterator(DoubleLinkNode<T> last) {
		this.last = last;
		current = last;
	}

	public void reset() {
		current = last;
	}

	public boolean hasNext() {
		if (current != null)
			return true;
		else
			return false;

	}

	public T next() {
		T temp = current.getData();
		current = current.getPrev();
		return temp;
	}
}