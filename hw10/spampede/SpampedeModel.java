package com.gradescope.spampede;

import java.awt.Color;
import java.lang.Math;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The "model" in MVC that is responsible for storing all the data for the
 * board.
 * 
 * @author CS60 instructors
 */
class SpampedeModel {
	/**
	 * The model needs to call the controller to play sounds and to end the game.
	 */
	private SpampedeController controller;
	
	/**
	 * The model needs to call the view to update graphics.
	 */
	private SpampedeView view;
	
	/**
	 * The collection of all the BoardCells in the program, indexed by row and
	 * column.
	 * 
	 * <p>
	 * All BoardCells needed by the program are created by the SpampedeModel
	 * constructor, so you do not need to create any new BoardCells in your code.
	 * Instead, you will pass around (references to) existing cells, and change the
	 * contents of some of these cells.
	 * </p>
	 */
	private final BoardCell[][] boardCells2D;

	/**
	 * The number of non-wall cells in the initial board.
	 */
	private int freeSpots = 0;

	/**
	 * The current movement "mode" of the snake, i.e. whether it is headed in a
	 * particular direction or in AI mode.
	 */
	private SnakeMode currentMode = SnakeMode.GOING_EAST;

	/**
	 * A list of (references to) cells that currently contain spam, ordered from
	 * oldest (first) to youngest (last).
	 */
	private LinkedList<BoardCell> spamCells = new LinkedList<BoardCell>();

	/**
	 * A list of (references to) the cells that contain the snake. The head is the
	 * last element of the list.
	 */
	private LinkedList<BoardCell> snakeCells = new LinkedList<BoardCell>();

	/**
	 * Whether the game is over.
	 */
	private boolean gameOver = false;

	/** The number of animated frames displayed so far. */
	private int cycleNum = 0;

	/* -------------------------------------- */
	/* Constructor and initialization methods */
	/* -------------------------------------- */

	/**
	 * Creates a new "board" with walls on the boundary and open in the interior.
	 */
	public SpampedeModel(SpampedeController controller, SpampedeView view) {
		this.controller = controller;
		this.view = view;
		int height = Preferences.NUM_CELLS_TALL;
		int width = Preferences.NUM_CELLS_WIDE;
		boardCells2D = new BoardCell[height][width];

		// Place walls around the outside
		addWalls();

		// Fill the remaining cells not already filled!
		fillRemainingCells();
	}

	/**
	 * Adds walls around the edges of this board.
	 */
	private void addWalls() {
		int height = getNumRows();
		int width = getNumColumns();

		// Add left and right walls
		for (int row = 0; row < height; row++) {
			boardCells2D[row][0] = new BoardCell(row, 0, CellType.WALL);
			boardCells2D[row][width - 1] = new BoardCell(row, width - 1, CellType.WALL);
		}
		// Add top and bottom walls
		for (int column = 0; column < width; column++) {
			boardCells2D[0][column] = new BoardCell(0, column, CellType.WALL);
			boardCells2D[height - 1][column] = new BoardCell(height - 1, column, CellType.WALL);
		}
	}

	/**
	 * Adds open cells to the interior of this board.
	 */
	private void fillRemainingCells() {
		int height = getNumRows();
		int width = getNumColumns();

		freeSpots = 0;
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				if (boardCells2D[row][column] == null) {
					boardCells2D[row][column] = new BoardCell(row, column, CellType.OPEN);
					freeSpots++;
				}
			}
		}
	}

	/**
	 * Puts the snake in the upper-left corner of the walls, facing east.
	 */
	public void placeSnakeAtStartLocation() {
		BoardCell body = getCell(1, 1);
		BoardCell head = getCell(1, 2);
		snakeCells.addLast(body);
		snakeCells.addLast(head);
		head.becomeHead();
		body.becomeBody();
	}

	/* -------- */
	/* Gameplay */
	/* -------- */

	/**
	 * Moves the game forward one step.
	 * 
	 * One step is one frame of animation, which occurs every Preferences.SLEEP_TIME
	 * milliseconds.
	 */
	public void cycle() {
		// move the snake
		updateSnake();

		// update the list of spam
		updateSpam();

		// draw the board
		view.updateGraphics();

		// update the cycle counter
		cycleNum++;
	}

	/* ---------------------- */
	/* Snake movement methods */
	/* ---------------------- */

	/**
	 * Moves the snake.
	 * 
	 * <p>
	 * This method is called once every REFRESH_RATE cycles, either in the current
	 * direction, or as directed by the AI's breadth-first search.
	 * 
	 * Called by cycle()
	 * <p>
	 */
	private void updateSnake() {
		if (cycleNum % Preferences.REFRESH_RATE == 0) {
			BoardCell nextCell;
			if (inAImode()) {
				nextCell = getNextCellFromBFS();
			} else {
				nextCell = getNextCellInDir();
			}
			advanceTheSnake(nextCell);
		}
	}

	/**
	 * Moves the snake to the next cell (and possibly eat spam).
	 * 
	 * @param nextCell - the new location of the snake head (which must be
	 *                 horizontally or vertically adjacent to the old location of
	 *                 the snake head)
	 */
	private void advanceTheSnake(BoardCell nextCell) {
		// Note - do not modify provided code.
		if (nextCell.isWall() || nextCell.isBody()) {
			// Oops...we hit something.
			controller.gameOver();
			return;
		} else if (nextCell.isSpam()) {
			// the snake ate spam!
			controller.playSound_spamEaten();
		} 
		moveSnakeForward(nextCell);
	}

	/**
	 * Moves the snake forward 
	 * 
	 */
	 public void moveSnakeForward(BoardCell cell) { 
		/* HW10 Part 3 */

 	}

	/**
	 * Adds more spam every SPAM_ADD_RATE cycles.
	 */
	private void updateSpam() {
		if (noSpam()) {
			addSpam();
		} else if (cycleNum % Preferences.SPAM_ADD_RATE == 0) {
			addSpam();
		}
	}

	/* ---------------------------------------------- */
	/* Methods to access information about this board */
	/* ---------------------------------------------- */

	/**
	 * Returns true if we are in AI mode.
	 */
	private boolean inAImode() {
		return currentMode == SnakeMode.AI_MODE;
	}

	/**
	 * Returns the height of this board (including walls) in cells.
	 */
	public int getNumRows() {
		return boardCells2D.length;
	}

	/**
	 * Returns the width of this board (including walls) in cells.
	 */
	public int getNumColumns() {
		return boardCells2D[0].length;
	}

	/**
	 * Accesses a cell at a particular location.
	 * 
	 * <p>
	 * This method should really be private. We make it public to allow our unit
	 * tests to use it, but it should not be called from SpampedeController or
	 * SpampedeView.
	 * </p>
	 * 
	 * @param r - the row to access, between 0 and numRows-1 inclusive
	 * @param c - the column to access, between 0 and numCols-1 inclusive
	 * @return the cell in row r and column c
	 */
	protected BoardCell getCell(int r, int c) {
		if (r >= getNumRows() || c >= getNumColumns() || r < 0 || c < 0) {
			System.err.println("Trying to access cell outside of the Board:");
			System.err.println("row: " + r + " col: " + c);
			System.exit(0);
		}
		return boardCells2D[r][c];
	}

	/* ------------------------------ */
	/* Helper method used by the view */
	/* ------------------------------ */

	/**
	 * Gets the color of the cell at a particular location.
	 * 
	 * @param r - the row to access, between 0 and numRows-1 inclusive
	 * @param c - the column to access, between 0 and numCols-1 inclusive
	 * @return the color of cell at row r and column c
	 */
	public Color getCellColor(int row, int col) {
		BoardCell cell = getCell(row, col);
		return cell.getCellColor();
	}

	/* ---------------- */
	/* Game over status */
	/* ---------------- */

	/**
	 * Sets the game status as game over.
	 */
	public void setGameOver() {
		gameOver = true;
	}

	/**
	 * Returns true if the game over message should be displayed.
	 */
	public boolean getGameOver() {
		return gameOver;
	}

	/* -------------------- */
	/* Spam-related methods */
	/* -------------------- */

	/**
	 * Returns true if there is zero spam.
	 */
	private boolean noSpam() {
		return spamCells.isEmpty();
	}

	/**
	 * Adds spam to a random open spot.
	 */
	private void addSpam() {
		// Pick a random cell
		int row = (int) (getNumRows() * Math.random());
		int column = (int) (getNumColumns() * Math.random());
		BoardCell cell = getCell(row, column);

		if (cell.isOpen()) {
			// If the random cell is open, put spam there
			cell.becomeSpam();
			spamCells.addLast(cell);
		} else {
			// If the random cell is occupied and this board is not already
			// too full of spam, try to place spam again
			double totalSize = getNumColumns() * getNumRows();
			double currentFreeSpots = freeSpots - snakeCells.size() - spamCells.size();
			double ratioFree = currentFreeSpots / totalSize;
			if (ratioFree < 0.2) {
				System.err.println("Not adding more spam");
			} else {
				addSpam();
			}
		}
	}

	/**
	 * Removes the oldest piece of un-eaten spam.
	 * 
	 * <p>
	 * The function is not used in the given code, but it might be useful if you
	 * want to extend the game.
	 * </p>
	 */
	@SuppressWarnings("unused")
	private void removeSpam() {
		if (!spamCells.isEmpty()) {
			spamCells.peekFirst().becomeOpen();
			spamCells.removeFirst();
		}
	}

	/* -------------------- */
	/* Snake access methods */
	/* -------------------- */

	/**
	 * Returns the cell containing the snake's head.
	 */
	private BoardCell getSnakeHead() {
		return snakeCells.peekLast();
	}

	/**
	 * Returns the cell containing the snake's tail.
	 */
	private BoardCell getSnakeTail() {
		return snakeCells.peekFirst();
	}

	/**
	 * Returns the cell contains the snake body adjacent to the head.
	 */
	private BoardCell getSnakeNeck() {
		int lastSnakeCellIndex = snakeCells.size() - 1;
		return snakeCells.get(lastSnakeCellIndex - 1);
	}

	/* ------------------------------------------ */
	/* Methods to set the snake's (movement) mode */
	/* ------------------------------------------ */

	/**
	 * Makes the snake head north.
	 */
	public void setDirectionNorth() {
		currentMode = SnakeMode.GOING_NORTH;
	}

	/**
	 * Makes the snake head south.
	 */
	public void setDirectionSouth() {
		currentMode = SnakeMode.GOING_SOUTH;
	}

	/**
	 * Makes the snake head east.
	 */
	public void setDirectionEast() {
		currentMode = SnakeMode.GOING_EAST;
	}

	/**
	 * Makes the snake head west.
	 */
	public void setDirectionWest() {
		currentMode = SnakeMode.GOING_WEST;
	}

	/**
	 * Makes the snake switch to AI mode.
	 */
	public void setMode_AI() {
		currentMode = SnakeMode.AI_MODE;
	}

	/**
	 * Picks an initial movement mode for the snake.
	 */
	public void setStartDirection() {
		setDirectionEast();
	}

	/* -------------------------------------- */
	/* Methods to support movement without AI */
	/* -------------------------------------- */

	/**
	 * These methods should really be private. We make them public to allow access
	 * by our unit tests, but the methods should not be called from SpampedeController or
	 * SpampedeView.
	 */

	/**
	 * Returns the cell north of the specified cell, which must not be on the
	 * boundary.
	 */
	protected BoardCell getNorthNeighbor(BoardCell cell) {
		/* HW10 Part 2 */
		return null; // replace with the desired BoardCell
	}

	/**
	 * Returns the cell south of the specified cell, which must not be on the
	 * boundary.
	 */
	protected BoardCell getSouthNeighbor(BoardCell cell) {
		/* HW 10 Part 2 */
		return null; // replace with the desired BoardCell
	}

	/**
	 * Returns the cell east of the specified cell, which must not be on the
	 * boundary.
	 */
	protected BoardCell getEastNeighbor(BoardCell cell) {
		/* HW10 Part 2 */
		return null; // replace with the desired BoardCell
	}

	/**
	 * Returns the cell west of the specified cell, which must not be on the
	 * boundary.
	 */
	protected BoardCell getWestNeighbor(BoardCell cell) {
		/* HW10 Part 2 */
		return null; // replace with the desired BoardCell
	}

	/**
	 * Returns the cell north of the snake's head.
	 */
	protected BoardCell getNorthNeighbor() {
		return getNorthNeighbor(getSnakeHead());
	}

	/**
	 * Returns the cell south of the snake's head.
	 */
	protected BoardCell getSouthNeighbor() {
		return getSouthNeighbor(getSnakeHead());
	}

	/**
	 * Returns the cell east of the snake's head.
	 */
	protected BoardCell getEastNeighbor() {
		return getEastNeighbor(getSnakeHead());
	}

	/**
	 * Returns the cell west of the snake's head.
	 */
	protected BoardCell getWestNeighbor() {
		return getWestNeighbor(getSnakeHead());
	}

	/**
	 * Returns the cell north, south, east, or west of the snake head based on the
	 * current direction of travel. This method should not be called when in AI
	 * mode, though Java requires the method to return a value regardless.
	 */
	protected BoardCell getNextCellInDir() {
		/* HW10 Part 2 */
		return null;
	}

	/* -------------------------------------------------- */
	/* Public methods to get all or one (random) neighbor */
	/* -------------------------------------------------- */

	/**
	 * Returns an array of the four neighbors of the specified cell.
	 */
	private BoardCell[] getNeighbors(BoardCell center) {
		BoardCell[] neighborsArray = { getNorthNeighbor(center), getSouthNeighbor(center), getEastNeighbor(center),
				getWestNeighbor(center) };
		return neighborsArray;
	}

	/**
	 * Returns a random open neighbor of the specified cell (or some other neighbor
	 * if there are no open neighbors).
	 */
	private BoardCell getRandomNeighboringCell(BoardCell start) {
		BoardCell[] neighborsArray = getNeighbors(start);
		for (BoardCell mc : neighborsArray) {
			if (mc.isOpen()) {
				return mc;
			}
		}
		// if we did not find an open space, return the first neighbor
		return neighborsArray[0];
	}

	/* ---------------------------- */
	/* Helper method(s) for reverse */
	/* ---------------------------- */

	/**
	 * Reverses the snake.
	 */
	public void reverseSnake() {
		/* HW10 Part 5 */
	}

	/* ------------------------------------- */
	/* Methods to reset the model for search */
	/* ------------------------------------- */

	/**
	 * Clears the search-related fields in all the cells, in preparation for a new
	 * breadth-first search.
	 */
	private void resetCellsForNextSearch() {
		for (BoardCell[] row : boardCells2D) {
			for (BoardCell cell : row) {
				cell.clear_RestartSearch();
			}
		}
	}

	/**
	 * Searches for the spam closest to the snake head using BFS.
	 * 
	 * @return the cell to move the snake head to, if the snake moves *one step*
	 *         along the shortest path to (the nearest) spam cell
	 */
	protected BoardCell getNextCellFromBFS() {
		// initialize the search
		resetCellsForNextSearch();

		// initialize the cellsToSearch queue with the snake head;
		// as with any cell, we mark the head cells as having been added
		// to the queue
		Queue<BoardCell> cellsToSearch = new LinkedList<BoardCell>();
		BoardCell snakeHead = getSnakeHead();
		snakeHead.setAddedToSearchList();
		cellsToSearch.add(snakeHead);

		// search!
		/* HW10 Part 6*/	
		
		// if the search fails, just move somewhere
		return getRandomNeighboringCell(snakeHead);
	}

		/**
	 * Follows the traceback pointers from the closest spam cell to decide where the
	 * head should move. Specifically, follows the parent pointers back from the
	 * spam until we find the cell whose parent is the snake head (and which must
	 * therefore be adjacent to the previous snake head location).
	 * 
	 * @param start - the cell from which to start following pointers, typically the
	 *              location of the spam closest to the snake head
	 * @return the cell to move the snake head to, which should be a neighbor of the
	 *         head
	 */
	private BoardCell getFirstCellInPath(BoardCell start) {
		/* HW10 Part 6 */
		return null; // replace with the desired BoardCell

	}

	/* -------------------------------------------------------------------- */
	/* Testing Infrastructure - You do not need to understand these methods */
	/* -------------------------------------------------------------------- */

	/**
	 * Pictures of test boards at http://tinyurl.com/spampedeTestBoards
	 */

	// Constructor used exclusively for testing!
	public SpampedeModel(TestGame gameNum) {
		boardCells2D = new BoardCell[6][6];
		addWalls();
		fillRemainingCells();
		if (gameNum.snakeAtStart()) {
			testing_snakeAtStartLocation(gameNum);
			setDirectionEast();
		} else {
			testing_snakeNotAtStartLocation(gameNum);
		}

	}

	private void testing_snakeAtStartLocation(TestGame gameNum) {
		placeSnakeAtStartLocation();
		if (gameNum == TestGame.G1) {
			getCell(1, 3).becomeSpam();
		} else if (gameNum == TestGame.G2) {
			getCell(2, 2).becomeSpam();
		} else if (gameNum == TestGame.G3) {
			getCell(1, 4).becomeSpam();
		} else if (gameNum == TestGame.G4) {
			getCell(2, 1).becomeSpam();
		} else if (gameNum == TestGame.G5) {
			getCell(4, 1).becomeSpam();
		} else if (gameNum == TestGame.G6) {
			getCell(1, 3).becomeSpam();
			getCell(3, 1).becomeSpam();
		} else if (gameNum == TestGame.G7) {
			getCell(2, 2).becomeSpam();
			getCell(1, 4).becomeSpam();
		} else if (gameNum == TestGame.G8) {
			getCell(1, 4).becomeSpam();
			getCell(4, 2).becomeSpam();
		} else if (gameNum == TestGame.G9) {
			getCell(2, 1).becomeSpam();
			getCell(2, 4).becomeSpam();
		} else if (gameNum == TestGame.G10) {
			getCell(4, 1).becomeSpam();
			getCell(4, 4).becomeSpam();
		} else if (gameNum == TestGame.G11) {
			// No spam :)
		}
		// Add all spam to the spam cells
		int height = getNumRows();
		int width = getNumColumns();
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				BoardCell cell = getCell(row, column);
				if (cell.isSpam()) {
					spamCells.add(cell);
				}
			}
		}
	}

	private void testing_snakeNotAtStartLocation(TestGame gameNum) {
		if (gameNum == TestGame.G12) {
			BoardCell body2 = getCell(2, 3);
			BoardCell body1 = getCell(2, 2);
			BoardCell head = getCell(2, 1);
			snakeCells.add(body2);
			snakeCells.add(body1);
			snakeCells.add(head);
			head.becomeHead();
			body2.becomeBody();
			body1.becomeBody();
		} else if (gameNum == TestGame.G13) {
			BoardCell body2 = getCell(3, 2);
			BoardCell body1 = getCell(2, 2);
			BoardCell head = getCell(2, 1);
			snakeCells.add(body2);
			snakeCells.add(body1);
			snakeCells.add(head);
			head.becomeHead();
			body2.becomeBody();
			body1.becomeBody();
		} else if (gameNum == TestGame.G14) {
			BoardCell body2 = getCell(2, 2);
			BoardCell body1 = getCell(3, 2);
			BoardCell head = getCell(3, 1);
			snakeCells.add(body2);
			snakeCells.add(body1);
			snakeCells.add(head);
			head.becomeHead();
			body2.becomeBody();
			body1.becomeBody();
		} else if (gameNum == TestGame.G15) {
			BoardCell body2 = getCell(3, 2);
			BoardCell body1 = getCell(3, 3);
			BoardCell head = getCell(3, 4);
			snakeCells.add(body2);
			snakeCells.add(body1);
			snakeCells.add(head);
			head.becomeHead();
			body2.becomeBody();
			body1.becomeBody();
		}
	}

	public String toString() {
		String result = "";
		for (int r = 0; r < getNumRows(); r++) {
			for (int c = 0; c < getNumColumns(); c++) {
				BoardCell cell = getCell(r, c);
				result += cell.toStringType();
			}
			result += "\n";
		}
		return result;
	}

	public String toStringParents() {
		String result = "";
		for (int r = 0; r < getNumRows(); r++) {
			for (int c = 0; c < getNumColumns(); c++) {
				BoardCell cell = getCell(r, c);
				result += cell.toStringParent() + "\t";
			}
			result += "\n";
		}
		return result;
	}

}
