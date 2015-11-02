// Jonathan Parks jqp

import java.util.ListIterator;

public class HuffmanCode {

	// Fields
	HuffmanList tree = null;
	HuffmanNode[] elements;
	int index;

	// Constructors
	public HuffmanCode(byte[] input) {
		tree = new HuffmanList(input);
		elements = new HuffmanNode[tree.size()];
		
		makeTree();
		encode(tree.peek(), new boolean[] {});
	}

	public HuffmanCode(String filename) {
		tree = new HuffmanList(filename);
		elements = new HuffmanNode[tree.size()];

		makeTree();
		encode(tree.peek(), new boolean[] {});
	}

	public HuffmanCode(byte[] characters, int[] counts) {
		tree = new HuffmanList(characters, counts);
		elements = new HuffmanNode[tree.size()];

		makeTree();
		encode(tree.peek(), new boolean[] {});
	}



	// Methods
	public boolean[] code(byte b) {
		for (HuffmanNode node : elements) {
			if (node.b == b) return node.code;
		}
		// Searched whole list of elements, not present
		throw new IllegalArgumentException();
	}

	public String codeString(byte b) {
		boolean[] code = new boolean[] {};
		try {
			code = code(b);
		} catch (Exception e) { throw e; }
		return boolToString(code);
	}

	public String toString() {
		String output = "";
		for (HuffmanNode node : elements) {
			if (node != null) {
				output += node.b;
				output += ": ";
				output += boolToString(node.code);
				output += "\n";
			}
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

	private void encode(HuffmanNode root, boolean[] code) {
		if (root.left == null && root.right == null) {
			root.code = code;
			elements[this.index++] = root;
		} else {
			boolean[] newCode = new boolean[code.length+1];
			System.arraycopy(code, 0, newCode, 0, code.length);
			if (root.left != null) {
				newCode[newCode.length-1] = false;
				encode(root.left, newCode);
			}
			if (root.right != null) {
				newCode[newCode.length-1] = true;
				encode(root.right, newCode);
			}
		}
	}

	private String boolToString(boolean[] data) {
		String output = "";
		for (boolean datum : data) {
			if (datum) output += "1";
			else output += "0";
		}
		return output;
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
		return elements[index].b;
	}
	private HuffmanList getList() {
		return this.tree;
	}
}








