// Jonathan Parks jqp

public class AVLTree {
	
	public Node root;

	/* Constructor */
	public AVLTree(byte key) {
		this.root = new Node(key, null);
	}



	/* Methods */
	// Helper method to insert a new element
	public void insert(byte key) {
		insertRecursive(key, this.root, null);
	}

	private void insertRecursive(byte key, Node root, Node parent) {
		if (root == null) {
			root = new Node(key, parent);
			if (key > parent.key)
				parent.right = root;
			else
				parent.left = root;
			balance(parent);
		}
		else if (key > root.key)
			insertRecursive(key, root.right, root);
		else if (key < root.key)
			insertRecursive(key, root.left, root);
		else
			root.count = root.count + 1;
	}

	// Check and restore balance to the tree after insertion/deletion
	private void balance(Node root) {
		int newBalance = getHeight(root.left) - getHeight(root.right);
		if (newBalance != root.balance) {
			root.balance = newBalance;

			// Do rotations to restore balance, checking for double rotations
			if (newBalance > 1) {
				if (root.right != null && root.right.balance < 0)
					RightRotation(root.right);
				LeftRotation(root);
			} else if (newBalance < -1) {
				if (root.left != null && root.left.balance > 0)
					LeftRotation(root.left);
				RightRotation(root);
			}

			// Recursively call function to balance ancestors
			if (root.parent != null) balance(root.parent);
		}
	}

	private boolean LeftRotation(Node y) {
		if (y == null || y.right == null) return false;
		Node z = y.right;
		z.parent = y.parent;
		y.right = z.left;
		z.left = y;
		y.parent = z;
		return true;
	}

	private boolean RightRotation(Node z) {
		if (z == null || z.left == null) return false;
		Node y = z.left;
		y.parent = z.parent;
		z.left = y.right;
		y.right = z;
		z.parent = y;
		return true;
	}

	private int getHeight(Node root) {
		if (root == null) return -1;
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		return (leftHeight > rightHeight) ? leftHeight+1 : rightHeight+1;
	}

	// Return in-order traversal print-out of tree
	public String inorder(Node root) {
		String output = "";
		if (root.left != null)
			output += inorder(root.left);
		output += Byte.toString(root.key) + " ";
		if (root.right != null)
			output += inorder(root.right);
		return output;
	}

	// Return pre-order traversal print-out of tree
	public String preorder(Node root) {
		String output = "";
		output += Byte.toString(root.key) + " ";
		if (root.left != null)
			output += preorder(root.left);
		if (root.right != null)
			output += preorder(root.right);
		return output;
	}




	/*******************/
	private class Node {
		private byte key;
		private Node left;
		private Node right;
		private Node parent;
		private int balance;
		private int count;

		// Make a new leaf node
		protected Node(byte key, Node parent) {
			this.key = key;
			left = null;
			right = null;
			this.parent = parent;
			balance = 0;
			count = 0;
		}
	}
}
