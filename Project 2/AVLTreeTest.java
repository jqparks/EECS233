// Jonathan Parks jqp

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class AVLTreeTest {
	
	@Test
	public void testConstructor() {
		byte value = 121;
		AVLTree tree = new AVLTree(value);
		String expect = "121 ";
		assertEquals(expect, tree.inorder(tree.root));
	}

	@Test
	public void testInsert() {
		AVLTree tree = new AVLTree((byte)121);
		tree.insert((byte)120);
		String expect = "120 121 ";
		assertEquals(expect, tree.inorder(tree.root));
		tree.insert((byte)126);
		tree.insert((byte)124);
		expect = "120 121 124 126 ";
		assertEquals(expect, tree.inorder(tree.root));
	}

	@Test
	public void testInsertAndBalance() {
		AVLTree tree = new AVLTree((byte)10);
		tree.insert((byte)11);
		String expect = "10 11 ";
		assertEquals(expect, tree.preorder(tree.root));
		tree.insert((byte)12);
		expect = "11 10 12 ";
		assertEquals(expect, tree.preorder(tree.root));
	}

	@Test
	public void testDelete() {
		AVLTree tree = new AVLTree((byte)10);
		tree.insert((byte)9);
		tree.insert((byte)11);
		assertEquals("10 9 11 ", tree.preorder(tree.root));
		tree.delete((byte)10);
		assertEquals("11 9 ", tree.preorder(tree.root));
	}

	@Test
	public void testCount() {
		byte[] data = new byte[] {32,32,33,33,33,34};
		AVLTree tree = new AVLTree(data[0]);
		for (int i = 1; i < data.length; i++) {
			tree.insert(data[i]);
		}
		assertEquals("33 32 34 ", tree.preorder(tree.root));
		assertEquals(2, tree.getCount((byte)32));
		assertEquals(3, tree.getCount((byte)33));
		assertEquals(0, tree.getCount((byte)35));
	}

	@Test
	public void testGetElements() {
		AVLTree tree = new AVLTree((byte)120);
		byte[] expect = new byte[] {120};
		byte[] actual = tree.getElements();
		assertEquals(expect[0], actual[0]);
		tree.insert((byte)121);
		tree.insert((byte)122);
		actual = tree.getElements();
		assertEquals((byte)121, actual[0]);
		assertEquals((byte)120, actual[1]);
		assertEquals((byte)122, actual[2]);
	}
}
