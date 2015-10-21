// Jonathan Parks jqp

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
		list.add(new HuffmanNode(characters[0], counts[0]));
		for (int i = 1; i < characters.length; i++) {
			ListIterator<HuffmanNode> iter = list.listIterator(0);
			HuffmanNode currentNode = iter.next();
			while (currentNode != null && counts[i] > currentNode.count) {
				currentNode = iter.next();
			}
			if (currentNode != null && counts[i] == currentNode.count) {
				if (characters[i] < currentNode.b) {
					iter.previous();
				}
			}
			iter.add(new HuffmanNode(characters[i], counts[i]));
		}
	}
}













