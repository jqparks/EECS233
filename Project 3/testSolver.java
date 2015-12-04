// Jonathan Parks jqp

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class testSolver {

	@Test
	public void testInputGoalState() {
		PuzzleSolver solver = new PuzzleSolver(new int[] {0,1,2,3,4,5,6,7,8});
		assertTrue(solver.depthFirstSearch());
		assertTrue(solver.breadthFirstSearch());
	}

	@Test
	public void testOneAway() {
		PuzzleSolver solver = new PuzzleSolver(new int[] {1,0,2,3,4,5,6,7,8});
		assertTrue(solver.depthFirstSearch());
		assertTrue(solver.breadthFirstSearch());
	}

	@Test
	public void testThreeAway() {
		PuzzleSolver solver = new PuzzleSolver(new int[] {1,2,5,3,4,0,6,7,8});
		assertTrue(solver.depthFirstSearch());
		assertTrue(solver.breadthFirstSearch());
	}

	@Test
	public void testRandom() {
		PuzzleSolver solver = new PuzzleSolver();
//		assertTrue(solver.depthFirstSearch());
		assertTrue(solver.breadthFirstSearch());
	}
}

