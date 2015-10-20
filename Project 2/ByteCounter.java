// Jonathan Parks jqp

import java.nio.file.*;

public class ByteCounter {
	
	// Fields
	AVLTree byteCounter;
	Order order = Order.Byte;

	// Constructors
	public ByteCounter(byte[] input) {
		UpdateADT(input);
	}

	public ByteCounter(String filename) {
		// Read data from file in binary form
		try {
			UpdateADT(Files.readAllBytes(Paths.get(filename)));
		} catch (Exception e) {	}
	}



	/* Methods */
	// Return # of occurences of b
	public int getCount(byte b) {
		return byteCounter.getCount(b);
	}

	// Return array of occurences of characters in b
	public int[] getCount(byte[] b) {
		int[] counts = new int[b.length];
		for (int i = 0; i < counts.length; i ++) {
			counts[i] = byteCounter.getCount(b[i]);
		}
		return counts;
	}

	// Determines order of character output of toString() methods
	public void setOrder(String order) {
		if (order.equals("byte"))
			this.order = Order.Byte;
		else if (order.equals("countInc"))
			this.order = Order.CountInc;
		else if (order.equals("countDec"))
			this.order = Order.CountDec;
		else throw new IllegalArgumentException();
	}

	// Returns array of elements present, ordered by # occurences
	public byte[] getElements() {
		byte[] bytes = byteCounter.getElements();
		int[] counts = getCount(bytes);
		// Sort by counts
		return counts;
	}

	// Return 
	public String toString() {
		return null;
	}

	public String toString(String format) {
		return null;
	}



	/* Private methods */
	private void UpdateADT(byte[] data) {
		this.byteCounter = new AVLTree(data[0]);
		for (int i = 1; i < data.length; i++) {
			byteCounter.insert(data[i]);
		}
	}

	private enum Order {
		Byte, CountInc, CountDec
	}
}
