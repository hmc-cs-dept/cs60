package com.gradescope.spampede;

import java.awt.Color;
import java.awt.Font;

/**
 * Represents settings for Spampede. Constants are stored in this file to avoid
 * "magic strings" and "magic numbers".
 * 
 * @author CS60 instructors
 */
final class Preferences {
	/* ------- */
	/* Timing */
	/* ------ */

	public static final int REFRESH_RATE = 2;
	public static final int SPAM_ADD_RATE = 25;
	public static final int SLEEP_TIME = 30; // milliseconds between updates

	/* ------ */
	/* Sizing */
	/* ------ */
	public static final int NUM_CELLS_WIDE = 50;
	public static final int NUM_CELLS_TALL = 30;
	public static final int CELL_SIZE = 10;
	private static final int SPACE_FOR_BUTTONS = 190;
	public static final int GAMEBOARDHEIGHT = NUM_CELLS_TALL * CELL_SIZE + SPACE_FOR_BUTTONS;
	public static final int GAMEBOARDWIDTH = NUM_CELLS_WIDE * CELL_SIZE + 80;

	/* ------ */
	/* Colors */
	/* ------ */
	public static final Color COLOR_BACKGROUND = Color.ORANGE;
	public static final Color COLOR_WALL = Color.BLUE;
	public static final Color COLOR_SPAM = Color.ORANGE;
	public static final Color COLOR_OPEN = Color.WHITE;
	public static final Color COLOR_HEAD = Color.BLACK;
	public static final Color COLOR_BODY = Color.GREEN;

	/* -------------------- */
	/* Text display - Title */
	/* -------------------- */
	public static final int TITLE_X = 100;
	public static final int TITLE_Y = 40;
	public static final Font TITLE_FONT = new Font("Helvetica", Font.PLAIN, 30);
	public static final Color TITLE_COLOR = Color.BLUE;
	/* HW10 Part 1  */
	public static final String TITLE = "Add Title for Part 1"; 

	/* ------------------------ */
	/* Text display - Game Over */
	/* ------------------------ */
	public static final int GAME_OVER_X = 150;
	public static final int GAME_OVER_Y = 200;
	public static final Font GAME_OVER_FONT = new Font("Helvetica", Font.PLAIN, 60);
	public static final Color GAME_OVER_COLOR = Color.BLUE;
	public static final String GAME_OVER_TEXT = "Game Over";

}
