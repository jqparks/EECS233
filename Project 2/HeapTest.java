// Jonathan Parks jqp

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {
	
	@Test
	public void testInsertAndResize() {
		Heap test = new Heap((byte)10);
		test.insert((byte)10);
	}

}
