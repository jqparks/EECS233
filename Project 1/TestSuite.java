

package eecs233project1;
//import eecs233project1.*;

public class TestSuite {
	
	// Fields
	static int failCount = 0;

	// Main method
	public static void main(String[] args) {
		
		/* NumArrayList test */
		System.out.println("========== NumArrayList test ==========");
		NumArrayList testArrayList = new NumArrayList();
		
		System.out.println("[]");
		ArrayZero(testArrayList);
		testArrayList.add(123);
		System.out.println("["+testArrayList.toString()+"]");
		ArrayOne(testArrayList);
		testArrayList.insert(0, 3.14);
		testArrayList.add(6.9);
		testArrayList.insert(2, 1.1235);
		testArrayList.add(7);
		testArrayList.remove(4);
		System.out.println("["+testArrayList.toString()+"]");
		ArrayMany(testArrayList);
		System.out.println();

		/* NumLinkedList test */
		System.out.println("========== NumLinkedList test ==========");
		NumLinkedList testLinkedList = new NumLinkedList();

		System.out.println("[]");
		LinkedZero(testLinkedList);
		testLinkedList.add(123);
		System.out.println("["+testLinkedList.toString()+"]");
		LinkedOne(testLinkedList);
		testLinkedList.insert(0, 3.14);
		testLinkedList.add(6.9);
		testLinkedList.insert(2, 1.1235);
		testLinkedList.add(7);
		testLinkedList.remove(4);
		System.out.println("["+testLinkedList.toString()+"]");
		LinkedMany(testLinkedList);
		System.out.println();
		
		/* NumList.equal() */
		System.out.println("========== Equal methods ==========");
		try {
			System.out.print("NumArrayList.equals(): ");
			AssertTrue(testArrayList.equals(testLinkedList));
			System.out.print("NumLinkedList.equals(): ");
			AssertTrue(testLinkedList.equals(testArrayList));
		} catch (IllegalArgumentException e) {
			System.out.println("FAILED");
			failCount++;
		}
		System.out.println();

		System.out.println("========== End Test ==========");
		System.out.println("    " + failCount + " failure(s)");
	}
	


	/* Test Blocks */
	private static void ArrayZero(NumArrayList list) {
		System.out.print("size() zero case: ");
		AssertTrue(list.size() == 0);
		System.out.print("capacity() zero case: ");
		AssertTrue(list.capacity() == 0);
		System.out.print("contains() zero case: ");
		AssertFalse(list.contains(3.14));
		System.out.print("lookup() zero case: ");
		try {
			list.lookup(0);
			System.out.println("FAILED");
			failCount++;
		} catch (IllegalArgumentException e) {
			System.out.println("---");
		}
		System.out.print("toString() zero case: ");
		AssertEquals(list.toString(), "");
	}

	private static void ArrayOne(NumArrayList list) {
		System.out.print("size() one case: ");
		AssertTrue(list.size() == 1);
		System.out.print("capacity() one case: ");
		AssertTrue(list.capacity() == 1);
		System.out.print("contains() one case: ");
		AssertTrue(list.contains(123));
		System.out.print("contains() one case: ");
		AssertFalse(list.contains(3.14));
		try {
			System.out.print("lookup() one case: ");
			list.lookup(0);
			System.out.println("---");
		} catch (IllegalArgumentException e) {
			System.out.println("FAILED");
			failCount++;
		}
		try {
			System.out.print("lookup() one case: ");
			list.lookup(1);
			System.out.println("FAILED");
			failCount++;
		} catch (IllegalArgumentException e) {
			System.out.println("---");
		}
		System.out.print("toString() one case: ");
		AssertEquals(list.toString(), "123.0");
	}

	private static void ArrayMany(NumArrayList list) {
		System.out.print("size() many case: ");
		AssertTrue(list.size() == 4);
		System.out.print("capacity() many case: ");
		AssertTrue(list.capacity() == 5);
		System.out.print("contains() many case: ");
		AssertFalse(list.contains(1));
		System.out.print("contains() many case: ");
		AssertTrue(list.contains(3.14));
		try {
			System.out.print("lookup() many case: ");
			double lookup = list.lookup(3);
			AssertTrue(lookup == 6.9);
		} catch (IllegalArgumentException e) {
			System.out.println("FAILED");
			failCount++;
		}
		try {
			System.out.print("lookup() many case: ");
			list.lookup(5);
			System.out.println("FAILED");
			failCount++;
		} catch (IllegalArgumentException e) {
			System.out.println("---");
		}
		System.out.print("toString() many case: ");
		AssertEquals(list.toString(), "3.14 123.0 1.1235 6.9");
	}

	private static void LinkedZero(NumLinkedList list) {
		System.out.print("size() zero case: ");
		AssertTrue(list.size() == 0);
		System.out.print("contains() zero case: ");
		AssertFalse(list.contains(3.14));
		System.out.print("lookup() zero case: ");
		try {
			list.lookup(0);
			System.out.println("FAILED");
			failCount++;
		} catch (IllegalArgumentException e) {
			System.out.println("---");
		}
		System.out.print("toString() zero case: ");
		AssertEquals(list.toString(), "");
	}

	private static void LinkedOne(NumLinkedList list) {
		System.out.print("size() one case: ");
		AssertTrue(list.size() == 1);
		System.out.print("contains() one case: ");
		AssertTrue(list.contains(123));
		System.out.print("contains() one case: ");
		AssertFalse(list.contains(3.14));
		try {
			System.out.print("lookup() one case: ");
			list.lookup(0);
			System.out.println("---");
		} catch (IllegalArgumentException e) {
			System.out.println("FAILED");
			failCount++;
		}
		try {
			System.out.print("lookup() one case: ");
			list.lookup(1);
			System.out.println("FAILED");
			failCount++;
		} catch (IllegalArgumentException e) {
			System.out.println("---");
		}
		System.out.print("toString() one case: ");
		AssertEquals(list.toString(), "123.0");
	}

	private static void LinkedMany(NumLinkedList list) {
		System.out.print("size() many case: ");
		AssertTrue(list.size() == 4);
		System.out.print("contains() many case: ");
		AssertFalse(list.contains(0));
		System.out.print("contains() many case: ");
		AssertTrue(list.contains(3.14));
		try {
			System.out.print("lookup() many case: ");
			double lookup = list.lookup(3);
			AssertTrue(lookup == 6.9);
		} catch (IllegalArgumentException e) {
			System.out.println("FAILED");
			failCount++;
		}
		try {
			System.out.print("lookup() many case: ");
			list.lookup(5);
			System.out.println("FAILED");
			failCount++;
		} catch (IllegalArgumentException e) {
			System.out.println("---");
		}
		System.out.print("toString() many case: ");
		AssertEquals(list.toString(), "3.14 123.0 1.1235 6.9");
	}

	private static void SetZero(NumSet set) {

	}

	private static void SetOne(NumSet set) {

	}

	private static void SetMany(NumSet set) {

	}



	/* Assertion methods */
	private static void AssertTrue(boolean test) {
		if (test) System.out.println("---");
		else {
			System.out.println("FAILED");
			failCount++;
		}
	}

	private static void AssertFalse(boolean test) {
		if (!test) System.out.println("---");
		else {
			System.out.println("FAILED");
			failCount++;
		}
	}

	private static void AssertEquals(String test, String expected) {
		if (test.equals(expected))
			System.out.println("---");
		else {
			System.out.println("FAILED");
			failCount++;
			System.out.println("    '" + test + "'");
		}
	}
}

