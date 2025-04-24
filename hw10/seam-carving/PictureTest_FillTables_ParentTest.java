package com.gradescope.photoeditor;

import static org.junit.Assert.*;

import org.junit.Test;

public class PictureTest_FillTables_ParentTest {

	/*
	 * Check the contents of the "parent" array generated from a picture with a
	 * lot of ties!
	 */
	@Test
	public void testFillParentTable_Ties() {
		Picture pic = Picture.loadPicture("images/Ties.png");
		int[][] computedArray = pic.getParentAfterFillTables();
		int[][] correctArray = { { 0, 1 }, { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 3 }, { 0, 5 } };
		int width = computedArray.length;
		int height = computedArray[0].length;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				assertEquals("Mistake at (" + x + "," + y + "):", correctArray[x][y], computedArray[x][y]);
			}
		}
	}
	/*
	 * Check the contents of the "parent" array generated from a picture with a
	 * lot of ties!
	 */
	@Test
	public void testFillParentTable_Ties2() {
		Picture pic = Picture.loadPicture("images/Ties2.png");
		int[][] computedArray = pic.getParentAfterFillTables();
		int[][] correctArray = { { 0, 0 }, { 0, 0 }, { 0, 1 }, { 0, 3 }, { 0, 3 }, { 0, 5 } };
		int width = computedArray.length;
		int height = computedArray[0].length;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				assertEquals("Mistake at (" + x + "," + y + "):", correctArray[x][y], computedArray[x][y]);
			}
		}
	}

	/*
	 * Check the contents of the "parent" array generated from Micro.bmp
	 */
	@Test
	public void testFillParentTable_Micro() {
		Picture pic = Picture.loadPicture("images/Micro.bmp");
		int[][] computedArray = pic.getParentAfterFillTables();
		int[][] correctArray = { { 0, 1, 1, 0, 0 }, { 0, 1, 1, 0, 1 }, { 0, 1, 1, 1, 1 } };
		int width = computedArray.length;
		int height = computedArray[0].length;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				assertEquals("Mistake at (" + x + "," + y + "):", correctArray[x][y], computedArray[x][y]);
			}
		}
	}

	/*
	 * Check the contents of the "parent" array generated from Tiny.bmp
	 */
	@Test
	public void testFillParentTable_Tiny() {
		Picture pic = Picture.loadPicture("images/Tiny.bmp");
		int[][] computedArray = pic.getParentAfterFillTables();
		int[][] correctArray = { { 0, 0, 0, 1, 0, 0 }, { 0, 1, 1, 1, 1, 1 }, { 0, 2, 2, 2, 2, 3 }, { 0, 3, 3, 3, 4, 3 },
				{ 0, 4, 4, 5, 4, 4 }, { 0, 5, 6, 5, 4, 5 }, { 0, 5, 6, 5, 6, 5 }, { 0, 7, 6, 7, 6, 6 },
				{ 0, 8, 8, 7, 7, 8 }, { 0, 9, 9, 9, 8, 8 } };
		int width = computedArray.length;
		int height = computedArray[0].length;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				assertEquals("Mistake at (" + x + "," + y + "):", correctArray[x][y], computedArray[x][y]);
			}
		}
	}

	/*
	 * Check the contents of the "parent" array generated from Okinawa_tiny.bmp
	 */
	@Test
	public void testFillParentTable_Okinawa_Tiny() {
		Picture pic = Picture.loadPicture("images/Okinawa_tiny.bmp");
		int[][] computedArray = pic.getParentAfterFillTables();
		int[][] correctArray = { { 0, 0, 1, 0, 1, 1 }, { 0, 0, 1, 2, 2, 1 }, { 0, 3, 3, 3, 2, 3 }, { 0, 3, 4, 3, 4, 3 },
				{ 0, 3, 4, 3, 4, 5 }, { 0, 6, 4, 5, 6, 5 }, { 0, 6, 5, 5, 6, 5 }, { 0, 8, 6, 8, 6, 6 },
				{ 0, 8, 7, 8, 8, 7 }, { 0, 8, 9, 8, 9, 9 } };
		int width = computedArray.length;
		int height = computedArray[0].length;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				assertEquals("Mistake at (" + x + "," + y + "):", correctArray[x][y], computedArray[x][y]);
			}
		}
	}

}
