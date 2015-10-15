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
}
