// Jonathan Parks jqp

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class testPuzzle {

	@Test
	public void testDefaultConstructor() {
		PuzzleGame puzzleGame = new PuzzleGame();
		int[] state = puzzleGame.getState();
		int[] expectedState = {0,1,2,3,4,5,6,7,8};
		assertArrayEquals(expectedState, state);
	}

	@Test
	public void testConstructorWithInput() {
		int[] input = {0,1,2,3,4,5,6,7,8};
		PuzzleGame puzzleGame = new PuzzleGame(input);
		int[] actualState = puzzleGame.getState();
		assertArrayEquals(input, actualState);

		input = new int[] {8,7,6,5,4,3,2,1,0};
		puzzleGame = new PuzzleGame(input);
		actualState = puzzleGame.getState();
		assertArrayEquals(input, actualState);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testInvalidConstructorInput_TooShort() {
		int[] input = {10};
		PuzzleGame puzzleGame = new PuzzleGame(input);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testInvalidConstructorInput_TooLong() {
		int[] input = {0,1,2,3,4,5,6,7,8,9};
		PuzzleGame puzzleGame = new PuzzleGame(input);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testInvalidConstructorInput_RepeatedDigits() {
		int[] input = {0,0,0,0,0,0,0,0,0};
		PuzzleGame puzzleGame = new PuzzleGame(input);
	}

	@Test
	public void testShiftLeft() {
		PuzzleGame puzzleGame = new PuzzleGame();
		puzzleGame.shiftLeft();
		int[] actualState = puzzleGame.getState();
		int[] expectedState = {0,1,2,3,4,5,6,7,8};
		assertArrayEquals(expectedState, actualState);
		int[] input = {8,7,6,5,4,3,2,1,0};
		puzzleGame = new PuzzleGame(input);
		puzzleGame.shiftLeft();
		actualState = puzzleGame.getState();
		expectedState = new int[] {8,7,6,5,4,3,2,0,1};
		assertArrayEquals(expectedState, actualState);
	}

	@Test
	public void testShiftRight() {
		PuzzleGame puzzleGame = new PuzzleGame();
		puzzleGame.shiftRight();
		int[] actualState = puzzleGame.getState();
		int[] expectedState = {1,0,2,3,4,5,6,7,8};
		assertArrayEquals(expectedState, actualState);
		int[] input = {8,7,6,5,4,3,2,1,0};
		puzzleGame = new PuzzleGame(input);
		puzzleGame.shiftRight();
		actualState = puzzleGame.getState();
		expectedState = new int[] {8,7,6,5,4,3,2,1,0};
		assertArrayEquals(expectedState, actualState);
	}

	@Test
	public void testShiftUp() {
		PuzzleGame puzzleGame = new PuzzleGame();
		puzzleGame.shiftUp();
		int[] actualState = puzzleGame.getState();
		int[] expectedState = {0,1,2,3,4,5,6,7,8};
		assertArrayEquals(expectedState, actualState);
		int[] input = {8,7,6,5,4,3,2,1,0};
		puzzleGame = new PuzzleGame(input);
		puzzleGame.shiftUp();
		actualState = puzzleGame.getState();
		expectedState = new int[] {8,7,6,5,4,0,2,1,3};
		assertArrayEquals(expectedState, actualState);
	}

	@Test
	public void testShiftDown() {
		PuzzleGame puzzleGame = new PuzzleGame();
		puzzleGame.shiftDown();
		int[] actualState = puzzleGame.getState();
		int[] expectedState = {3,1,2,0,4,5,6,7,8};
		assertArrayEquals(expectedState, actualState);
		int[] input = {8,7,6,5,4,3,2,1,0};
		puzzleGame = new PuzzleGame(input);
		puzzleGame.shiftDown();
		actualState = puzzleGame.getState();
		expectedState = new int[] {8,7,6,5,4,3,2,1,0};
		assertArrayEquals(expectedState, actualState);
	}
}

