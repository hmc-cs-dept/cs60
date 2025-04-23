package com.gradescope.spampede;

import java.awt.Color;

/**
 * Represents a single cell within a board.
 * 
 * @author CS60 instructors
 */
class BoardCell {

	/* ----------------------------- */
	/* Basic contents of a BoardCell */
	/* ----------------------------- */

	/** The row and column of this cell within the board (non-negative). */
	private final int row; 
	private final int column;

	/** The current contents of this cell. */
	private CellType type;

	/* ---------------------------- */
	/* Variables used during search */
	/* ---------------------------- */

	/** Has this cell been added to the search queue yet? */
	private boolean addedToSearchList = false;

	/** Where did we came from, when search first reached this BoardCell? */
	private BoardCell parent = null;

	/**
	 * Creates a new BoardCell.
	 * 
	 * @param row         the row of this cell
	 * @param column      the column of this cell
	 * @param type        the initial contents of this cell
	 */
	public BoardCell(int row, int column, CellType type) {
		this.row = row;
		this.column = column;
		this.type = type;
	}

	/* ------------------------------------- */
	/* Access basic information about a cell */
	/* ------------------------------------- */

	/** Returns the row of this cell. */
	public int getRow() {
		return row;
	}

	/** Returns the column of this cell. */
	public int getColumn() {
		return column;
	}

	/** Returns true if this cell is a wall. */
	public boolean isWall() {
		return type == CellType.WALL;
	}

	/** Returns true if this cell is open (not a wall or a snake body part). */
	public boolean isOpen() {
		return type == CellType.OPEN || isSpam();
	}

	/** Returns true if this cell contains spam. */
	public boolean isSpam() {
		return type == CellType.SPAM;
	}

	/** Returns true if this cell contains a snake body part (not the head). */
	public boolean isBody() {
		return type == CellType.BODY;
	}

	/** Returns true if this cell contains the head of the snake. */
	public boolean isHead() {
		return type == CellType.HEAD;
	}

	/** Returns the color for drawing this cell. */
	public Color getCellColor() {
		if (isWall()) {
			return Preferences.COLOR_WALL;
		} else if (isSpam()) {
			return Preferences.COLOR_SPAM;
		} else if (isOpen()) {
			return Preferences.COLOR_OPEN;
		} else if (isHead()) {
			return Preferences.COLOR_HEAD;
		} else if (isBody()) {
			return Preferences.COLOR_BODY;
		} else {
			return Preferences.COLOR_OPEN;
		}
	}

	/* ------------------------------ */
	/* Modify basic info about a cell */
	/* ------------------------------ */

	/** Marks this BoardCell as spam. */
	public void becomeSpam() {
		type = CellType.SPAM;
	}

	/** Marks this BoardCell as open. */
	public void becomeOpen() {
		type = CellType.OPEN;
	}

	/** Marks this BoardCell as the snake's head. */
	public void becomeHead() {
		type = CellType.HEAD;
	}

	/** Marks this BoardCell as part of the snake's body. */
	public void becomeBody() {
		type = CellType.BODY;
	}

	/* -------------------------- */
	/* Access and set search info */
	/* -------------------------- */

	/** Marks this cell as having been added to our BFS search queue. */
	public void setAddedToSearchList() {
		addedToSearchList = true;
	}

	/** Returns true if this cell has been added to our BFS search queue. */
	public boolean inSearchListAlready() {
		return addedToSearchList;
	}

	/** Clear the search-related info for this cell (to allow a new search). */
	public void clear_RestartSearch() {
		addedToSearchList = false;
		parent = null;
	}

	/** Sets the parent of this cell in our BFS search. */
	public void setParent(BoardCell p) {
		parent = p;
	}

	/** Returns the parent of this cell in our BFS search. */
	public BoardCell getParent() {
		return parent;
	}

	/* ---------------------------- */
	/* Helper functions for testing */
	/* ---------------------------- */

	/** Returns this cell as a string "[row, col, type]". */
	public String toString() {
		return "[" + row + ", " + column + ", " + toStringType() + "]";
	}

	/** Returns the contents of this cell, as a single character. */
	public String toStringType() {
		return type.getDisplayChar();
	}

	/** Returns the parent of this cell, as a string "[null]" or "[row, col]". */
	public String toStringParent() {
		if (parent == null) {
			return "[null]";
		} else {
			return "[" + parent.row + ", " + parent.column + "]";
		}
	}

}
