// Jonathan Parks jqp

import java.util.Iterator;
import java.util.ListIterator;
import java.util.LinkedList;

public class HuffmanList {
	
	// Fields
	private LinkedList<HuffmanNode> list = new LinkedList<HuffmanNode>();

	// Constructors
	public HuffmanList(byte[] input) {
		ByteCounter counter = new ByteCounter(input);
		counter.setOrder("countInc");
		byte[] elements = counter.getElements();
		int[] counts = counter.getCount(elements);
		for (int i = 0; i < elements.length; i++) {
			HuffmanNode newNode = new HuffmanNode(elements[i], counts[i]);
			list.add(newNode);
		}
	}

	public HuffmanList(String filename) {
		ByteCounter counter = new ByteCounter(filename);
		counter.setOrder("countInc");
		byte[] elements = counter.getElements();
		int[] counts = counter.getCount(elements);
		for (int i = 0; i < elements.length; i++) {
			HuffmanNode newNode = new HuffmanNode(elements[i], counts[i]);
			list.add(newNode);
		}
	}

	public HuffmanList(byte[] characters, int[] counts) {
		// Check for illegal parameters
		// Provided arrays are not equal length
		if (characters.length != counts.length) {
			throw new IllegalArgumentException();
		}
		// One or more provided counts is negative
		for (int count : counts) {
			if (count < 0) throw new IllegalArgumentException();
		}
		// Repeated characters in input byte array
		ByteCounter counter = new ByteCounter(characters);
		if (characters.length != counter.getElements().length) {
			throw new IllegalArgumentException();
		}

		// Add elements based on count, ordered by increasing count
		counter.setOrder("countInc");
		for (int i = 0; i < characters.length; i++) {
			HuffmanNode newNode = new HuffmanNode(characters[i], counts[i]);
			list.add(newNode);
		}
	}



	/* methods */
	public HuffmanNode peek() { return list.peek(); }
	public int size() { return list.size(); }
	public HuffmanNode poll() { return list.poll(); }
	public HuffmanNode get(int index) { return list.get(index); }
	public void add(int index, HuffmanNode node) { list.add(index, node); }
	public Iterator<HuffmanNode> iterator() { return list.iterator(); }


	// Main method
	public static void main(String[] args) {
		byte[] arr = new byte[] {60,60,60,60,61,61,61,62,62,63};
		HuffmanList list = new HuffmanList(arr);
		System.out.println("size: " + list.size());
		HuffmanNode front = list.peek();
		System.out.println("front key: " + front.b);
		HuffmanNode three = list.get(2);
		System.out.println("Third element: " + three.b);
	}
}













