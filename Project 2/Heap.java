// Jonathan Parks jqp

public class Heap {
	
	/* Fields */
	int[] byteCount = new int[100];
	byte[] values = new byte[100];
	int numElements;

	/* Constructors */
	public Heap(byte b) {
		numElements = 1;
		byteCount[0] = 1;
		values[0] = b;
	}


	/* Public methods */
	public void insert(byte b) {
		if (byteCount.length == numElements-1) resize();

	}


	/* Private methods */
	private void resize() {
		int newSize = numElements + 100;
		int[] newByteCount = new int[newSize];
		byte[] newValues = new byte[newSize];
		for (int i = 0; i < numElements; i++) {
			newByteCount[i] = byteCount[i];
			newValues[i] = values[i];
		}
		byteCount = newByteCount;
		values = newValues;
	}

}
