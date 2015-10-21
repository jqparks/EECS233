// Jonathan Parks jqp

public class HuffmanCode {


	// Constructors
	public HuffmanCode(byte[] input) {
		HuffmanList list = new HuffmanList(input);
	}

	public HuffmanCode(String filename) {
		HuffmanList list = new HuffmanList(filename);
	}

	public HuffmanCode(byte[] characters, int[] counts) {
		HuffmanList list = new HuffmanList(characters, counts);
	}



	// Methods
	public boolean[] code(byte b) {
		return new boolean[] {true};
	}

	public String codeString(byte b) {
		return null;
	}

	public String toString() {
		return null;
	}
}
