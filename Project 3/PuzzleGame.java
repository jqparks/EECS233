// Jonathan Parks jqp


public class PuzzleGame {

	/* Fields */
	// Stores orientation of elements
	private int[] elements;
	private final int[] goalState = {0,1,2,3,4,5,6,7,8};
	private PuzzleGame parent;

	/* Constructors */
	// Generate puzzle in the goal state
	public PuzzleGame() {
		this.elements = this.goalState;
		this.parent = null;
	}

	// Generate puzzle in a specified state
	public PuzzleGame(int[] elements) {
		// Check that the input array is correct length and contains valid numbers
		if (elements.length != 9) throw new IllegalArgumentException();
		for (int i = 0; i < 9; i++) {
			boolean check = false;
			for (int j = 0; j < elements.length; j++) {
				if (elements[j] == i) check = true;
			}
			// If the numbers 0-8 aren't present, the input is not valid
			if (!check) throw new IllegalArgumentException();
		}
		this.elements = elements;
		this.parent = null;
	}

	// Generate puzzle with a parent
	public PuzzleGame(int[] elements, PuzzleGame parent) {
		this(elements);
		this.parent = parent;
	}

	/* Methods */
	public int[] getState() {
		int[] output = new int[this.elements.length];
		for (int i = 0; i < this.elements.length; i++) {
			output[i] = elements[i];
		}
		return output;
	}

	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i < this.elements.length; i++) {
			if (i > 0 && i % 3 == 0) output += "\n";
			output += elements[i] + " ";
		}
		return output;
	}

	@Override
	public int hashCode() {
		int output = 0;
		for (int i = 0; i < this.elements.length; i++) {
			output += elements[i] * (i+1);
		}
		return output;
	}

	public void printSolution() {
		System.out.println(this.toString() + "\n");
		if (parent != null) parent.printSolution();
	}

	public void randomize(int shifts) {
		int i = shifts;
		while (i > 0) {
			double select = Math.random();
			if (select < .25 && shiftLeft()) i--;
			else if (select >= .25 && select < .5 && shiftRight()) i--;
			else if (select >= .5 && select < .75 && shiftUp()) i--;
			else if (select >= .75 && shiftDown()) i--;
		}
	}

	public boolean shiftLeft() {
		int blank = getBlankIndex();
		if (blank % 3 != 0) {
			int element = elements[blank-1];
			elements[blank-1] = 0;
			elements[blank] = element;
			return true;
		} else return false;
	}

	public boolean shiftRight() {
		int blank = getBlankIndex();
		if (blank % 3 != 2) {
			int element = elements[blank+1];
			elements[blank+1] = 0;
			elements[blank] = element;
			return true;
		} else return false;
	}

	public boolean shiftUp() {
		int blank = getBlankIndex();
		if (blank / 3 != 0) {
			int element = elements[blank-3];
			elements[blank-3] = 0;
			elements[blank] = element;
			return true;
		} else return false;
	}

	public boolean shiftDown() {
		int blank = getBlankIndex();
		if (blank / 3 != 2) {
			int element = elements[blank+3];
			elements[blank+3] = 0;
			elements[blank] = element;
			return true;
		} else return false;
	}

	private int getBlankIndex() {
		for (int i = 0; i < this.elements.length; i++)
			if (elements[i] == 0) return i;
		return -1;
	}


	public static void main(String[] args) {
		PuzzleGame puzzle;
		if (args.length == 0) {
			puzzle = new PuzzleGame();
			puzzle.randomize(3);
		} else if (args.length == 9) {
			int[] input = new int[9];
			for (int i = 0; i < args.length; i++) {
				input[i] = Integer.parseInt(args[i]);
			}
			puzzle = new PuzzleGame(input);
		} else {
			System.out.println("Zero or nine inputs only please");
			return;
		}
		System.out.println(puzzle.toString());
	}

}










