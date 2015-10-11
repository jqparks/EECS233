// Jonathan Parks jqp

import java.nio.file.*;

public class ByteCounter {
	
	// Fields
	byte[] array;
	Order order = Order.Byte;

	// Constructors
	public ByteCounter(byte[] input) {
		this.array = input;
	}

	public ByteCounter(String filename) {
		// Read data from file in binary form
		try {
			this.array = Files.readAllBytes(Paths.get(filename));
		} catch (Exception e) {	}
	}



	/* Methods */
	// Return # of occurences of b
	public int getCount(byte b) {
		return 0;
	}

	// Return array of occurences of characters in b
	public int[] getCount(byte[] b) {
		return new int[] {0};
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
		return null;
	}

	// Return 
	public String toString() {
		return null;
	}

	public String toString(String format) {
		return null;
	}



	/* Private methods */
	private enum Order {
		Byte, CountInc, CountDec
	}
}