package stringBag;

public class StringBagTest {
	public static void main(String[] args) {
		StringBagImplementation bag = new StringBagImplementation(5);
		bag.insert("A");
		bag.insert("B");
		bag.insert("C");
		if (!bag.isEmpty()) {
			System.out.println("Removed: " + bag.remove());
		}
		if (!bag.isEmpty()) {
			System.out.println(bag.toString());
		}
	}
}
