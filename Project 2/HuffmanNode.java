// Jonathan Parks jqp

public class HuffmanNode {
	
	// Fields
	public byte b;
	public int count;
	public boolean[] code;
	public HuffmanNode left;
	public HuffmanNode right;

	// Constructor
	public HuffmanNode(byte b, int c) {
		this.b = b;
		this.count = c;
		this.left = null;
		this.right = null;
	}
}
