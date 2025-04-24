package com.gradescope.photoeditor;

import static org.junit.Assert.*;

import org.junit.Test;

public class PictureTest_FillTables_Table {

	/*
	 * Check the contents of the "table" array generated from a picture with a
	 * lot of ties!
	 */
	@Test
	public void testFillTable_Ties() {
		Picture pic = Picture.loadPicture("images/Ties.png");
		int[][] computedArray = pic.getTableAfterFillTables();
		int[][] correctArray = { { 150, 250 }, { 50, 100 }, { 50, 100 }, { 50, 200 }, { 150, 300 }, { 50, 200 } };
		int width = computedArray.length;
		int height = computedArray[0].length;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				assertEquals("Mistake at (" + x + "," + y + "):", correctArray[x][y], computedArray[x][y]);
			}
		}
	}
	/*
	 * Check the contents of the "table" array generated from a picture with a
	 * lot of ties!
	 */
	@Test
	public void testFillTable_Ties2() {
		Picture pic = Picture.loadPicture("images/Ties2.png");
		int[][] computedArray = pic.getTableAfterFillTables();
		int[][] correctArray = { { 0, 0 }, { 50, 150 }, { 150, 300 }, { 50, 50 }, { 100, 100 }, { 50, 50 } };
		int width = computedArray.length;
		int height = computedArray[0].length;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				assertEquals("Mistake at (" + x + "," + y + "):", correctArray[x][y], computedArray[x][y]);
			}
		}
	}

	/*
	 * Check the contents of the "table" array generated from Micro.bmp
	 */
	@Test
	public void testFillTable_Micro() {
		Picture pic = Picture.loadPicture("images/Micro.bmp");
		int[][] computedArray = pic.getTableAfterFillTables();
		int[][] correctArray = { { 20, 60, 50, 90, 140 }, { 10, 30, 80, 90, 150 }, { 20, 70, 120, 100, 130 } };
		int width = computedArray.length;
		int height = computedArray[0].length;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				assertEquals("Mistake at (" + x + "," + y + "):", correctArray[x][y], computedArray[x][y]);
			}
		}
	}

	/*
	 * Check the contents of the "table" array generated from Tiny.bmp
	 */
	@Test
	public void testFillTable_Tiny() {
		Picture pic = Picture.loadPicture("images/Tiny.bmp");
		int[][] computedArray = pic.getTableAfterFillTables();
		int[][] correctArray = { { 0, 7, 14, 14, 14, 14 }, { 0, 7, 7, 14, 14, 14 }, { 0, 7, 7, 14, 14, 7 },
				{ 0, 7, 7, 14, 7, 7 }, { 0, 7, 7, 0, 7, 14 }, { 0, 14, 0, 7, 7, 14 }, { 7, 0, 7, 7, 14, 14 },
				{ 7, 7, 7, 14, 21, 21 }, { 7, 7, 14, 21, 14, 14 }, { 7, 7, 14, 28, 21, 14 } };
		int width = computedArray.length;
		int height = computedArray[0].length;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				assertEquals("Mistake at (" + x + "," + y + "):", correctArray[x][y], computedArray[x][y]);
			}
		}
	}

	/*
	 * Check the contents of the "table" array generated from Okinawa_tiny.bmp
	 */
	@Test
	public void testFillTable_Okinawa_Tiny() {
		Picture pic = Picture.loadPicture("images/Okinawa_tiny.bmp");
		int[][] computedArray = pic.getTableAfterFillTables();
		int[][] correctArray = { { 2, 116, 148, 181, 213, 227 }, { 6, 19, 164, 176, 207, 244 },
				{ 5, 20, 97, 148, 228, 274 }, { 4, 9, 12, 170, 201, 249 }, { 6, 8, 16, 84, 249, 246 },
				{ 6, 13, 16, 269, 102, 164 }, { 5, 15, 180, 45, 106, 170 }, { 8, 33, 155, 109, 122, 164 },
				{ 4, 96, 78, 108, 137, 146 }, { 8, 84, 126, 108, 130, 147 } };
		int width = computedArray.length;
		int height = computedArray[0].length;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				assertEquals("Mistake at (" + x + "," + y + "):", correctArray[x][y], computedArray[x][y]);
			}
		}
	}

}
