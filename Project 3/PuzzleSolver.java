// Jonathan Parks jqp

import java.util.*;

public class PuzzleSolver {

	/* Fields */
	PuzzleGame puzzle;
	PuzzleGame goal = new PuzzleGame();			// Initialize a puzzle in the goal state
	HashMap<Integer,PuzzleGame> states;


	/* Constructors */
	public PuzzleSolver() {
		puzzle = new PuzzleGame();
		puzzle.randomize(30);
		System.out.println("Initial puzzle state:");
		System.out.println(puzzle.toString() + "\n");
	}

	public PuzzleSolver(int shuffle) {
		puzzle = new PuzzleGame();
		puzzle.randomize(shuffle);
		System.out.println("Initial puzzle state:");
		System.out.println(puzzle.toString() + "\n");
	}

	public PuzzleSolver(int[] input) {
		try {
			puzzle = new PuzzleGame(input);
			System.out.println("Initial puzzle state:");
			System.out.println(puzzle.toString() + "\n");
		} catch (Exception e) { 
			throw e;
		}
	}


	/* Methods */
	// Use a queue
	public boolean breadthFirstSearch() {
		states = new HashMap<Integer, PuzzleGame>();
		states.put(new Integer(this.puzzle.hashCode()), this.puzzle);
		System.out.println("Breadth-first search solution:");
		Queue queue = new Queue(this.puzzle);
		boolean goalFound = false;
		while (!goalFound && !queue.isEmpty()) {
			PuzzleGame testState = queue.remove();
			// Try each possible next state
			for (int i = 0; i < 4; i++) {
				PuzzleGame tempPuzzle = new PuzzleGame(testState.getState());
				PuzzleGame nextState = new PuzzleGame(shift(tempPuzzle,i), testState);
				if (!states.containsKey(nextState.hashCode())) {
					states.put(nextState.hashCode(), nextState);
					if (!queue.isFull()) queue.add(nextState, testState);
				}
			}
			if (testState.hashCode() == this.goal.hashCode()) {
				goalFound = true;
				testState.printSolution();
			}
		}
		return goalFound;
	}

	// Recursively search for the goal state
	public boolean depthFirstSearch() {
		states = new HashMap<Integer, PuzzleGame>();
		states.put(new Integer(puzzle.hashCode()), puzzle);
		System.out.println("Depth-first search solution:");
		return DFSRecurse(this.puzzle, false);
	}

	private boolean DFSRecurse(PuzzleGame puzzle, boolean goalFound) {
		// Base case: puzzle provided equals goal state
		if (puzzle.hashCode() == this.goal.hashCode()) {
			puzzle.printSolution();
			return true;
		}

		// Try each possible next state
		for (int i = 0; i < 4; i++) {
			if (!goalFound) {
				PuzzleGame nextState = new PuzzleGame(shift(puzzle,i), puzzle);
				// If current next state is unique/unvisited, add to hash table and recurse
				if (!states.containsKey(nextState.hashCode())) {
					states.put(nextState.hashCode(), nextState);
					goalFound = DFSRecurse(nextState, goalFound);
				}
			} else {
				i = 4;
			}
		}

		return goalFound;
	}

	// Helper method to shift "blank" element in array in all four directions
	private int[] shift(PuzzleGame puzzle, int shiftType) {
		switch (shiftType) {
			case 0: 
				puzzle.shiftLeft();
				return puzzle.getState();
			case 1: 
				puzzle.shiftRight();
				return puzzle.getState();
			case 2: 
				puzzle.shiftUp();
				return puzzle.getState();
			case 3: 
				puzzle.shiftDown();
				return puzzle.getState();
			default: return puzzle.getState();
		}
	}


	/* Organizational Classes */
	// Queue, used to organize breadth-first search
	private class Queue {
		private final int maxSize = 100000;
		private PuzzleGame[] arr = new PuzzleGame[maxSize];
		private int total, first, next;

		protected Queue(PuzzleGame element) {
			arr[0] = element;
			total = 1;
			first = 0;
			next = 1;
		}

		protected void add(PuzzleGame element, PuzzleGame parent) {
			arr[next++] = element;
			if (next == arr.length) next = 0;
			total++;
		}

		protected PuzzleGame remove() {
			PuzzleGame output = arr[first];
			arr[first] = null;
			if (++first == arr.length) first = 0;
			total--;
			return output;
		}

		protected boolean isEmpty() {
			return total == 0;
		}

		protected boolean isFull() {
			return total == maxSize;
		}
	}


	// Main method
	public static void main(String[] args) {
		PuzzleSolver solver;
		if (args.length == 1) {
			solver = new PuzzleSolver(Integer.parseInt(args[0]));
		} else {
			solver = new PuzzleSolver(new int[] {4,7,0,6,5,2,1,3,8});
		}
		solver.depthFirstSearch();
		solver.breadthFirstSearch();
	}
}

