import static org.junit.Assert.*;

import org.junit.Test;

public class NumLinkedListFundTest {

    /* 
     * JUnit tests of fundamental functionality.
     *   
     * Use these JUnit tests to ensure that your code compiles
     * and correctly implements the fundamental functionality.
     * 
     * Code that does not pass these tests will not be graded.
     * Your draft submission needs to pass these tests in order
     * to receive a non-zero grade on the assignment.
     */

    @Test
    public void testDefaultConstructorAndToString() {
        NumLinkedList list = new NumLinkedList();       
        assertEquals("With no parameters, your constructors should initialize an list size 0. " + 
            "It also can be the problem in method TOSTRING.", 
            "", list.toString());
    }

    @Test
    public void testAddAndToString() {
        NumLinkedList list = new NumLinkedList();

        list.add(1.0);
        list.add(3.0);
        list.add(2.0);

        assertEquals("Add method should add element to the end of list each time. " +
            "It's also can be the problem in method TOSTRING.",
            "1.0 3.0 2.0", list.toString());
    }

    @Test
    public void testSize() {
        NumLinkedList list = new NumLinkedList();

        assertEquals("Method SIZE should return 0, when list is constructed by default constructor.",
            0, list.size());

        list.add(1.0);
        list.add(2.0);
        list.add(3.0);

        assertEquals("Method SIZE should return the size of the list, " + 
            "i.e. the number of elements, in the sequence.",
            3, list.size());
    }

    @Test
    public void testEquals() {
        NumLinkedList listA = new NumLinkedList();
        NumLinkedList listB = new NumLinkedList();
        NumLinkedList listC = new NumLinkedList();
        
        // Two empty lists, should return true
        assertTrue(listA.equals(listB));

        listA.add(1.0);
        listA.add(3.0);

        assertFalse("EQUALS method should return FALSE, when two lists are not the same.",
            listA.equals(listB));

        listB.add(1.0);
        listB.add(3.0);

        assertTrue("EQUALS method should return TRUE, when two lists are the same.",
            listA.equals(listB));

        listC.add(3.0);
        listC.add(1.0);

        assertFalse("EQUALS method should return FALSE, even if the same " + 
            "numbers are in different order in two lists.",
            listA.equals(listC));
    }

    /* Other JUnit tests.
     * 
     * Write your own JUnit tests below to check the correctness of your implementation.
     * 
     * When you turn in your draft (and final) we will run our own test suite on your code 
     * and provide you with the feedback.
     */
    
    @Test
    public void testInsertAndRemove() {
      NumLinkedList list = new NumLinkedList();
      // Zero case, originally empty arraylist
      list.insert(0,1);
      assertTrue(list.size() == 1);
      assertEquals("1.0", list.toString());
      // One case, list has one element
      list.insert(1,2);
      assertEquals(2, list.size(), 0);
      assertEquals("1.0 2.0", list.toString());
      // Many case, multiple elements in list
      list.insert(1,3);
      assertEquals("1.0 3.0 2.0", list.toString());
    }
    
    @Test
    public void testRemove() {
      NumLinkedList list = new NumLinkedList();
      // Zero case
      list.remove(0);
      assertEquals("", list.toString());
      // One element case
      list.add(1);
      assertEquals("1.0", list.toString());
	  list.remove(1);
	  assertEquals("1.0", list.toString());
      list.remove(0);
      assertEquals("", list.toString());
      assertEquals(0, list.size());
      // Many elements
      list.add(1);
      list.add(2);
      list.add(3);
      assertEquals("1.0 2.0 3.0", list.toString());
      list.remove(1);
      assertEquals("1.0 3.0", list.toString());
	  list.remove(0);
	  assertEquals("3.0", list.toString());
    }
    
    @Test
    public void testContains() {
      NumLinkedList list = new NumLinkedList();
      // Empty list
      assertFalse(list.contains(0));
      // One element
      list.add(1);
      assertTrue(list.contains(1));
      assertFalse(list.contains(0));
      // Multiple elements
      list.add(4);
      list.add(9);
      assertFalse(list.contains(5));
      assertTrue(list.contains(9));
    }
    
    @Test
    public void testLookup() {
      NumLinkedList list = new NumLinkedList();
      // Empty list
      try { 
        list.lookup(0);
        fail();
      }
      catch (IllegalArgumentException e) {}
      // One element
      list.add(1);
      assertEquals(1, list.lookup(0), 0);
      // Many elements
      list.add(4);
      list.add(9);
      assertEquals(4, list.lookup(1), 0);
      try {
        list.lookup(3);
        fail();
      } catch (IllegalArgumentException e) {}
    }
    
    @Test
    public void testRemoveDuplicates() {
      NumLinkedList list = new NumLinkedList();
      // Empty list
      list.removeDuplicates();
      assertEquals("", list.toString());
      // One element
      list.add(10);
      list.removeDuplicates();
      assertEquals("10.0", list.toString());
      // Multiple elements, two identical
      list.add(2);
      list.add(10);
      assertEquals("10.0 2.0 10.0", list.toString());
      list.removeDuplicates();
      assertEquals("10.0 2.0", list.toString());
    }

}


