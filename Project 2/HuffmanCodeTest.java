// Jonathan Parks jqp

import org.junit.*;
import static org.junit.Assert.*;

public class HuffmanCodeTest {

	@Test
	public void testConstructorAndToString() {
		byte[] arr = new byte[] {60,61,61,62,62,62,63,63,63,63};
		HuffmanCode tree = new HuffmanCode(arr);
		String expect = "60: 0\n61: 10\n63: 110\n62: 111\n";
		assertEquals(expect, tree.toString());

		String file = "test2.txt";
		tree = new HuffmanCode(file);
		expect = "65: 1\n66: 1\n67: 1\n68: 1\n69: 1\n70: 1\n71: 1\n72: 1\n73: 1\n74: 1\n75: 1\n";
		assertEquals(expect, tree.toString());

		arr = new byte[] {76,77,78,89,90};
		int[] counts = new int[] {10,8,6,9,7};
		expect = "77: 00\n89: 01\n76: 10\n78: 110\n90: 111\n";
		assertEquals(expect, tree.toString());
	}
}
