import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class NumSetTest {
  
  @Test
  public void testConstructorAndToString() {
    // Zero case
    NumSet set = new NumSet(new double[] {});
    assertEquals("", set.toString());
    // One case
    set = new NumSet(new double[] {1});
    assertEquals("1.0", set.toString());
    // Many case
    set = new NumSet(new double[] {1,2,3,4});
    assertEquals("1.0 2.0 3.0 4.0", set.toString());
  }
  
  @Test
  public void testSize() {
    // Zero case
    NumSet set = new NumSet(new double[] {});
    assertEquals(0, set.size(), 0);
    // One case
    set = new NumSet(new double[] {1});
    assertEquals(1, set.size(), 0);
    // Many case
    set = new NumSet(new double[] {1, 2, 3});
    assertEquals(3, set.size(), 0);
  }
  
  @Test
  public void testContains() {
    // Zero case
    NumSet set = new NumSet(new double[] {});
    assertFalse(set.contains(1));
    // One case
    set = new NumSet(new double[] {1});
    assertTrue(set.contains(1));
    assertFalse(set.contains(2));
    // Many case
    set = new NumSet(new double[] {1,4,9});
    assertTrue(set.contains(4));
    assertFalse(set.contains(2));
  }
  
  @Test
  public void testIntersectAndToString() {
    // Zero case
    NumSet set1 = new NumSet(new double[] {});
    NumSet set2 = new NumSet(new double[] {});
    NumSet intersect = NumSet.intersect(set1, set2);
    assertEquals("", intersect.toString());
    // One case
    set1 = new NumSet(new double[] {1,2});
    set2 = new NumSet(new double[] {1});
    intersect = NumSet.intersect(set1, set2);
    assertEquals("1.0", intersect.toString());
    // Many case
    set1 = new NumSet(new double[] {1,2,3});
    set2 = new NumSet(new double[] {3,2});
    intersect = NumSet.intersect(set1, set2);
    assertEquals("2.0 3.0", intersect.toString());
  }
  
  @Test
  public void testUnionAndToString() {
    // Zero case
    NumSet set1 = new NumSet(new double[] {});
    NumSet set2 = new NumSet(new double[] {});
    NumSet union = NumSet.union(set1, set2);
    assertEquals("", union.toString());
    // One case
    set1 = new NumSet(new double[] {1});
    set2 = new NumSet(new double[] {1});
    union = NumSet.union(set1, set2);
    assertEquals("1.0", union.toString());
    // Many case
    set1 = new NumSet(new double[] {1,2});
    set2 = new NumSet(new double[] {3,4});
    union = NumSet.union(set1, set2);
    assertEquals("1.0 2.0 3.0 4.0", union.toString());
  }
  
	@Test
	public void testEquivalence() {
		NumSet set1 = new NumSet(new double[] {});
		NumSet set2 = new NumSet(new double[] {});
		// Zero case
		assertTrue(NumSet.equivalence(set1, set2));
		// Different sizes
		set1 = new NumSet(new double[] {1});
		set2 = new NumSet(new double[] {1,2});
		assertFalse(NumSet.equivalence(set1, set2));
		// Equal
		set1 = new NumSet(new double[] {1,2,3});
		set2 = new NumSet(new double[] {1,2,3});
		assertTrue(NumSet.equivalence(set1, set2));
		// Not equal
		set1 = new NumSet(new double[] {1,3});
		set2 = new NumSet(new double[] {1,2});
		assertFalse(NumSet.equivalence(set1, set2));
	}
}
