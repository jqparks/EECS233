// Jonathan Parks jqp

package eecs233project1;

public class NumArrayList implements NumList {
	
	// Fields
	private double[] numArray;
	private int numElements;
	private int capacity;
	
	// Constructors
	public NumArrayList() {
		numElements = 0;
		capacity = 0;
		numArray = new double[0];
	}

	public NumArrayList(int capacity) {
		numElements = 0;
		this.capacity = capacity;
		numArray = new double[capacity];
	}



	// Public methods
	public int size() {
		return this.numElements;
	}

	public int capacity() {
		return this.capacity;
	}

	public void add(double value) {
		if (numElements >= capacity) {
			capacity = numElements+1;
			double[] tempArray = new double[capacity];
			for (int i = 0; i < numElements; i++) tempArray[i] = numArray[i];
			numArray = tempArray;
		}
		numArray[numElements++] = value;
	}

	public void insert(int i, double value) {
		if (numElements >= capacity) capacity = numElements+1;
		double[] tempArray = new double[capacity];
		for (int j = 0; j < i; j++) tempArray[j] = numArray[j];
		tempArray[i] = value;
		for (int j = i; j < numElements; j++) tempArray[j+1] = numArray[j];
		numArray = tempArray;
		numElements++;
	}

	public void remove(int i) {
		double[] tempArray = new double[capacity];
		for (int j = 0; j < i; j++) tempArray[j] = numArray[j];
		for (int j = i+1; j < numElements; j++) tempArray[j] = numArray[j];
		numArray = tempArray;
		numElements--;
	}

	public boolean contains(double value) {
		for (double element : numArray) {
			if (element == value) return true;
		}
		return false;
	}

	public double lookup(int i) {
		if (i < numElements) return numArray[i];
		throw new IllegalArgumentException("Requested index does not exist");
	}

	public boolean equals(NumList otherList) {
		int thisSize = this.size();
		try {
			if (thisSize != otherList.size()) return false;
			for (int i = 0; i < thisSize; i++) {
				if (this.lookup(i) != otherList.lookup(i)) return false;
			}
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	public void removeDuplicates() {
		double[] tempArray = new double[capacity];
		int index = 0;
		for (int i = 0; i < numElements; i++) {
			for (int j = 0; j < i; j++) {
				if (numArray[j] == numArray[i]) j = i;  // Break out of inner loop
				if (j == i-1) tempArray[index++] = numArray[j];
			}
		}
		numArray = tempArray;
	}

	public String toString() {
		String output = "";
		for (int i = 0; i < numElements; i++) {
			output += Double.toString(numArray[i]);
			if (i < numElements-1) output += " ";
		}
		return output.toString();
	}



	// Main method
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}
