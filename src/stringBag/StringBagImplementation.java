package stringBag;

import java.util.Random;

public class StringBagImplementation implements StringBag {
	private String[] bag;
	private int count;

	public StringBagImplementation(int num) {
		this.bag = new String[num];
		count = 0;
	}

	public void insert(String word) {
		if (count <= bag.length) {
			bag[count] = word;
			count++;
		}
	}

	public String remove() {
		Random rand = new Random();
		int elementNum = rand.nextInt(count);
		String word = bag[elementNum];

		for (int i = elementNum; i < bag.length-1; i++) {
			bag[i] = bag[i + 1]; // no nulls in the array }
		}

		count--;
		bag[elementNum] = null;
		return word;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < count; i++) {
			if (bag[i] != null) {
				buffer.append(bag[i] + " \n");
			}
		}

		return buffer.toString();
	}

	@Override
	public boolean isEmpty() {
		if (count == 0) {
			return true;
		}
		return false;
	}
}
