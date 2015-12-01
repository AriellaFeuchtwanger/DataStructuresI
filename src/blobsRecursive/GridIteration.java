package blobsRecursive;

import java.util.Random;
import java.util.Stack;
import java.util.Vector;

public class GridIteration<E> {
	// a Vector of Vectors of Cells
	private Vector<Vector<Cell<E>>> cells;

	public GridIteration(int rows, int columns) {
		cells = new Vector<Vector<Cell<E>>>();

		// initialize each cell of the grid
		for (int row = 0; row < rows; row++) {
			// set up a Vector that will represent a new row in a two
			// dimensional grid
			Vector<Cell<E>> tempVector = new Vector<Cell<E>>();

			for (int col = 0; col < columns; col++) {
				tempVector.add(new Cell<E>(row, col)); // add a Cell to this
														// Vector
			}
			// add this new vector to the Vector of Vectors
			cells.add(tempVector);
		}

	}

	public void setGrid(int percentage, E value) {
		Random randomGenerator = new Random(System.currentTimeMillis());
		int randomNum;

		for (int row = 0; row < cells.size(); row++) {
			for (int col = 0; col < cells.get(row).size(); col++) {
				randomNum = randomGenerator.nextInt(100);
				if (randomNum < percentage) {
					// first get() , gets access to the Vector on a particular
					// row
					// second get() , gets access to a particular Cell in the
					// Vector on a particular row
					cells.get(row).get(col).setData(value);
				}
			}
		}
	}

	public int countBlobs(E value) {

		int count = 0;

		for (int row = 0; row < cells.size(); row++) {
			for (int col = 0; col < cells.get(row).size(); col++) {
				Cell<E> startCell = cells.get(row).get(col);
				System.out.println("starting at cell [" + row + "][" + col
						+ "]");
				if (!startCell.isVisited() && startCell.hasData()) {
					count++;
					// mark the blob connected to starting cell
					markBlob(startCell);
				}
			}
		}
		return count;
	}

	public void markBlob(Cell<E> currentCell) {
		Stack<Cell<E>> stack = new Stack<Cell<E>>();

		stack.push(currentCell);

		while (!stack.isEmpty()) {
			currentCell.setVisited();
			if(checkAbove(currentCell)){
				stack.push(this.cells.get(currentCell.getRow() - 1).get(currentCell.getCol()));
			}
			
			if(checkBelow(currentCell)){
				stack.push(this.cells.get(currentCell.getRow() + 1).get(currentCell.getCol()));
			}
			
			if(checkRight(currentCell)){
				stack.push(this.cells.get(currentCell.getRow()).get(currentCell.getCol() + 1));
			}
			
			if(checkLeft(currentCell)){
				stack.push(this.cells.get(currentCell.getRow()).get(currentCell.getCol() - 1));
			}
			
			currentCell = stack.pop();
		}
	}

	private boolean checkAbove(Cell<E> currCell) {
		if (currCell.getRow() - 1 >= 0) {
			return (cells.get(currCell.getRow() - 1).get(currCell.getCol())
					.hasData());
		} else {
			return false;
		}
	}

	private boolean checkBelow(Cell<E> currCell) {
		if (currCell.getRow() + 1 < cells.size()) {
			return (cells.get(currCell.getRow() + 1).get(currCell.getCol())
					.hasData());
		} else {
			return false;
		}
	}

	private boolean checkRight(Cell<E> currCell) {
		if (currCell.getCol() + 1 < cells.get(currCell.getRow()).size()) {
			return (cells.get(currCell.getRow()).get(currCell.getCol() + 1)
					.hasData());
		} else {
			return false;
		}
	}

	private boolean checkLeft(Cell<E> currCell) {
		if (currCell.getCol() - 1 >= 0) {
			return (cells.get(currCell.getRow()).get(currCell.getCol() + 1)
					.hasData());
		} else {
			return false;
		}
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (int row = 0; row < cells.size(); row++) {
			buffer.append("\n");
			for (int col = 0; col < cells.get(row).size(); col++) {

				buffer.append(" " + cells.get(row).get(col).toString());
			}
		}
		return buffer.toString();
	}

	static public void main(String[] args) {
		Character character = new Character('X');
		GridRecursive<Character> theGrid = new GridRecursive<Character>(10, 10);
		theGrid.setGrid(40, 'X');
		System.out.println(theGrid.toString());
		System.out.println(theGrid.countBlobs(character));
		System.out.println(theGrid);

	}
}
