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

	// Returns array of elements present, ordered by setOrder()
	public byte[] getElements() {
		byte[] bytes = byteCounter.getElements();
		int[] counts = getCount(bytes);
		mergeSort(bytes, counts, 0, bytes.length);
		return bytes;
	}

	// Return string with order selected by setOrder(), or default by increasing byte
	public String toString() {
		return byteCounter.preorder(byteCounter.root);
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

	private void mergeSort(byte[] bytes, int[] count, int left, int right) {
		if (right-left < 1) return;
		int middle = (left+right)/2;
		mergeSort(bytes, count, left, middle);
		mergeSort(bytes, count, middle+1, right);
		merge(bytes, count, left, middle, right);
	}

	private void merge(byte[] bytes, int[] count, int left, int middle, int right) {
		int[] L = new int[middle-left + 1];
		int[] R = new int[right-middle];
		byte[] Lb = new byte[middle-left+1];
		byte[] Rb = new byte[right-middle];

		for (int i = 0; i < L.length; i++) {
			L[i] = count[left+i];
			Lb[i] = bytes[left+i];
		}
		for (int i = 0; i < R.length; i++) {
			R[i] = count[1+middle+i];
			Rb[i] = bytes[1+middle+i];
		}

		int i = 0;
		int j = 0;
		int k = left;
		while (i < L.length && j < R.length) {
			if ((order == Order.Byte && Lb[i] <= Rb[j]) ||
				(order == Order.CountInc && L[i] < R[j]) ||
				(order == Order.CountDec && L[i] > R[j])) {
				bytes[k] = Lb[i];
				count[k] = L[i];
				i++;
			} else if ((order == Order.CountInc && L[i] == R[j]) ||
						(order == Order.CountDec && L[i] == R[j])) {
				if (Lb[i] <= Rb[j]) {
					bytes[k] = Lb[i];
					count[k] = L[i];
					i++;
				} else {
					bytes[k] = Rb[j];
					count[k] = R[j];
					j++;
				}
			} else {
				bytes[k] = Rb[j];
				count[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < L.length) {
			bytes[k] = Lb[i];
			i++;
			k++;
		}
		while (j < R.length) {
			bytes[k] = Rb[j];
			j++;
			k++;
		}
	}

	private enum Order {
		Byte, CountInc, CountDec
	}
}
