// Jonathan Parks jqp

import java.util.ListIterator;

public class HuffmanCode {

	// Fields
	HuffmanList tree = null;
	byte[] elements;
	String[] codes;
	int index;

	// Constructors
	public HuffmanCode(byte[] input) {
		tree = new HuffmanList(input);
		elements = new byte[tree.size()];
		codes = new String[tree.size()];
		
		makeTree();
		encode(tree.peek(), "");
	}

	public HuffmanCode(String filename) {
		tree = new HuffmanList(filename);
		elements = new byte[tree.size()];
		codes = new String[tree.size()];

		makeTree();
		encode(tree.peek(), "");
	}

	public HuffmanCode(byte[] characters, int[] counts) {
		tree = new HuffmanList(characters, counts);
		elements = new byte[tree.size()];
		codes = new String[tree.size()];

		makeTree();
		encode(tree.peek(), "");
	}



	// Methods
	public boolean[] code(byte b) {
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] == b) {
				boolean[] output = new boolean[codes[i].length()];
				for (int j = 0; j < codes[i].length(); j++) {
					char aChar = codes[i].charAt(j);
					if (aChar == 1) output[j] = true;
					else output[j] = false;
				}
				return output;
			}
		}
		// Searched whole list of elements, not present
		throw new IllegalArgumentException();
	}

	public String codeString(byte b) {
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] == b) return codes[i];
		}
		// Searched whole list of elements, not present
		throw new IllegalArgumentException();
	}

	public String toString() {
		// Implement a queue here to display shortest codes first
		String output = "";
		for (byte element : elements) {
			output += element;
			output += ": ";
			output += codeString(element);
			output += "\n";
		}
		return output;
	}

	// Private methods
	private void makeTree() {
		// Tree will have only one visible element when complete
		while (tree.size() > 1) {
			// Remove the front two elements for processing
			HuffmanNode element1 = tree.poll();
			HuffmanNode element2 = tree.poll();

			// Create a new node that represents their sum
			int sum = element1.count + element2.count;
			HuffmanNode sumNode = new HuffmanNode((byte)0, sum);
			element1.code = new boolean[] { false };
			element2.code = new boolean[] { true };
			sumNode.left = element1;
			sumNode.right = element2;

			// Determine location of new node in list and insert the node
			int index = tree.size();
			while (index > 0 && sum < tree.get(index-1).count) {
				index--;
			}
			tree.add(index, sumNode);
		}
	}

	private void encode(HuffmanNode root, String code) {
		if (root.left == null && root.right == null) {
			boolean[] boolcode = new boolean[code.length()];
			for (int i = 0; i < code.length(); i++) {
				if (code.charAt(i) == 49) boolcode[i] = true;
				else boolcode[i] = false;
			}
			root.code = boolcode;
			codes[this.index] = code;
			elements[this.index++] = root.b;
		} else {
			if (root.left != null) {
				encode(root.left, code + "0");
			}
			if (root.right != null) {
				encode(root.right, code + "1");
			}
		}
	}


	// Main method
	public static void main(String[] args) {
		byte[] arr = new byte[] {60,60,60,60,61,61,61,62,62,63};
		HuffmanCode tree = new HuffmanCode(arr);
		System.out.println(tree.toString());
		System.out.println("\n");

		String file = "test.txt";
		tree = new HuffmanCode(file);
		System.out.println(tree.toString());
	}

	private int size() {
		return elements.length;
	}
	private byte get(int index) {
		return elements[index];
	}
	private HuffmanList getList() {
		return this.tree;
	}


	// Implement a queue to store elements in tree in an array
	private class Queue {
		private HuffmanNode[] arr = new HuffmanNode[256];
		private int total, first, next;

		protected Queue(HuffmanNode element) {
			arr[0] = element;
			total = 1;
			first = 0;
			next = 1;
		}
		
		protected void add(HuffmanNode element) {
			arr[next++] = element;
			if (next == arr.length) next = 0;
			total++;
		}

		protected HuffmanNode remove() {
			HuffmanNode output = arr[first];
			arr[first] = null;
			if (++first == arr.length) first = 0;
			total--;
			return output;
		}

		protected boolean isEmpty() {
			return total == 0;
		}
	}
}








