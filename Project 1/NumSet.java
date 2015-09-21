// Jonathan Parks jqp

package eecs233project1;
import eecs233project1.*;

public class NumSet {

	// Fields
	NumLinkedList set = new NumLinkedList();

	// Constructor
	public NumSet(double[] set) {
		for (int i = 0; i < set.length; i++) {
			if (!this.set.contains(set[i])) {
				this.set.add(set[i]);
			}
		}
	}


	// Methods
	public int size() {
		return set.size();
	}

	public boolean contains(double value) {
		return set.contains(value);
	}

	public static NumSet intersect(NumSet S1, NumSet S2) {
		int length = S1.size();
		double[] tempSet = new double[length];
		int index = 0;
		for (int i = 0; i < length; i++) {
			double num = S1.set.lookup(i);
			if (S2.contains(num)) tempSet[index++] = num;
		}
		return new NumSet(tempSet);
	}

	public static NumSet union(NumSet S1, NumSet S2) {
		double[] tempSet = new double[S1.size() + S2.size()];
		int index = 0;
		for (int i = 0; i < S1.size(); i++) {
			tempSet[index++] = S1.set.lookup(i);
		}
		for (int j = 0; j < S2.size(); j++) {
			if (!S1.contains(S2.set.lookup(j))) tempSet[index++] = S2.set.lookup(j);
		}
		return new NumSet(tempSet);
	}

	public String toString() {
		return set.toString();
	}

	// Extra Credit
	public boolean equivalence(NumSet S1, NumSet S2) {
		return false;
	}


	// Main method
	public static void main(String[] args) {

	}
}
