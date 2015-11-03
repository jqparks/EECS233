// Jonathan Parks jqp

import org.junit.*;
import static org.junit.Assert.*;

public class HuffmanCodeTest {

	@Test
	public void testConstructorAndToString() {
		byte[] arr = new byte[] {60,61,61,62,62,62,63,63,63,63};
		HuffmanCode tree = new HuffmanCode(arr);
		String expect = "63: 0\n62: 10\n60: 110\n61: 111\n";
		assertEquals(expect, tree.toString());

		String file = "test2.txt";
		tree = new HuffmanCode(file);
		expect = "66: 000\n10: 0010\n65: 0011\n69: 01\n70: 10\n67: 110\n68: 111\n";
		assertEquals(expect, tree.toString());

		arr = new byte[] {76,77,78,89,90};
		int[] counts = new int[] {10,8,6,9,7};
		expect = "77: 00\n89: 01\n76: 10\n78: 110\n90: 111\n";
		assertEquals(expect, tree.toString());
	}
}
