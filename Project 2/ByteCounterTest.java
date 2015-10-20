// Jonathan Parks jqp

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ByteCounterTest {
	
	@Test
	public void testCount() {
		byte[] arr = new byte[] {32,32,44,55};
		ByteCounter counter = new ByteCounter(arr);
		int[] expect = new int[] {2,1,1,0};
		byte[] test = new byte[] {32,44,55,66};
		int[] actual = counter.getCount(test);
		assertEquals("44 32 55 ", counter.toString());
		for (int i = 0; i < expect.length; i++) {
			//assertEquals(expect[i], actual[i]);
		}
	}
}
