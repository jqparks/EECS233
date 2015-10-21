// Jonathan Parks jqp

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ByteCounterTest {
	
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
}

