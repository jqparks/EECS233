// Jonathan Parks jqp

import java.nio.file.*;

public class HuffmanCoder {
	
	// Fields
	HuffmanCode tree = null;
	String inputFile;
	String outputFile;
	
	// Constructor
	public HuffmanCoder(String inputFile, String outputFile) {
		tree = new HuffmanCode(inputFile);
		this.inputFile = inputFile;
		this.outputFile = outputFile;
	}



	// Methods
	public void compress() {
		BinaryWriter binaryWriter = null;
		try {
			binaryWriter = new BinaryWriter(this.outputFile);
		} catch (Exception e) {
			System.out.println("The requested output file does not exist");
			return;
		}

		byte[] data = new byte[] {};
		try {
			data = Files.readAllBytes(Paths.get(this.inputFile));
		} catch (Exception e) {
			System.out.println("The input file cannot be read");
			return;
		}

		try {
			for (byte datum : data) {
				boolean[] code = tree.code(datum);
				binaryWriter.writeBinaryArray(code);
			}
		} catch (Exception e) {
			System.out.println("There was a problem writing to the output file");
			return;
		}

		try {
			binaryWriter.close();
		} catch (Exception e) {
			System.out.println("There was a problem closing the output file");
			return;
		}
	}
}
