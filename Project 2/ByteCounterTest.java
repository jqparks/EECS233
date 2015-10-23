// Jonathan Parks jqp

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.nio.file.*;

public class ByteCounterTest {
	
	@Test
	public void testStringConstructor() {
		String filename = "test.txt";
		ByteCounter counter = new ByteCounter(filename);
		String expect = "A:1 B:1 C:1 D:1 E:1 F:1 G:1 H:1 I:1 J:1 K:1";
		assertEquals(expect, counter.toString());
	}

	@Test
	public void testCount() {
		byte[] arr = new byte[] {32,32,44,55};
		ByteCounter counter = new ByteCounter(arr);
		assertEquals(2, counter.getCount((byte)32));
		int[] expect = new int[] {2,1,1,0};
		byte[] test = new byte[] {32,44,55,66};
		int[] actual = counter.getCount(test);
		for (int i = 0; i < expect.length; i++) {
			assertEquals(expect[i], actual[i]);
		}
	}

	@Test
	public void testGetElements() {
		byte[] arr = new byte[] {12,11,14,15,13};
		ByteCounter counter = new ByteCounter(arr);
		byte[] expect = new byte[] {11,12,13,14,15};
		byte[] actual = counter.getElements();
		assertEquals(expect.length, actual.length);
		for (int i = 0; i < expect.length; i++) {
			assertEquals(expect[i], actual[i]);
		}
	}

	@Test
	public void testSetOrderAndGetElements() {
		byte[] arr = new byte[] {12,11,14,15,13,11,11,11,12,12,13};
		ByteCounter counter = new ByteCounter(arr);
		byte[] expect = new byte[] {11,12,13,14,15};
		byte[] actual = counter.getElements();
		assertEquals(expect.length, actual.length);
		for (int i = 0; i < expect.length; i++) {
			assertEquals(expect[i], actual[i]);
		}
		counter.setOrder("countInc");
		expect = new byte[] {14,15,13,12,11};
		actual = counter.getElements();
		for (int i = 0; i < expect.length; i++) {
			assertEquals(expect[i], actual[i]);
		}
		counter.setOrder("countDec");
		expect = new byte[] {11,12,13,14,15};
		actual = counter.getElements();
		for (int i = 0; i < expect.length; i++) {
			assertEquals(expect[i], actual[i]);
		}
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetOrderThrowsException() {
		ByteCounter counter = new ByteCounter(new byte[] {11});
		counter.setOrder("not a valid input");
	}

	@Test
	public void testToString() {
		byte[] elements = new byte[] {65,65,66,66,66,67};
		ByteCounter counter = new ByteCounter(elements);
		String expect = "65:2 66:3 67:1";
		String expectChar = "A:2 B:3 C:1";
		assertEquals(expect, counter.toString());
		assertEquals(expectChar, counter.toString("char"));
		counter.setOrder("countInc");
		expect = "67:1 65:2 66:3";
		expectChar = "C:1 A:2 B:3";
		assertEquals(expect, counter.toString());
		assertEquals(expectChar, counter.toString("char"));
		counter.setOrder("countDec");
		expect = "66:3 65:2 67:1";
		expectChar = "B:3 A:2 C:1";
		assertEquals(expect, counter.toString());
		assertEquals(expectChar, counter.toString("char"));
	}

	@Test
	public void longTestToString() {
		byte[] elements = new byte[9999];
		int k = 0;
		for (int i = 67; i < 127; i++) {
			for (int j = 67; j < i; j++) {
				elements[k] = (byte)i;
				k++;
			}
		}
		ByteCounter counter = new ByteCounter(elements);
	}
}

