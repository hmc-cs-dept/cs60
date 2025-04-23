package com.gradescope.spampede;

import static org.junit.Assert.*;
import org.junit.Test;

public class BoardCellTest {

	/************************************
	 * toString and toString Helper
	 ************************************/

	@Test
	public void testToString() {
		BoardCell wallCell = new BoardCell(10, 15, CellType.WALL);
		BoardCell openCell = new BoardCell(10, 15, CellType.OPEN);
		BoardCell spamCell = new BoardCell(10, 15, CellType.SPAM);
		BoardCell bodyCell = new BoardCell(10, 15, CellType.BODY);
		BoardCell headCell = new BoardCell(10, 15, CellType.HEAD);
		assertEquals("[10, 15, *]", wallCell.toString());
		assertEquals("[10, 15,  ]", openCell.toString());
		assertEquals("[10, 15, X]", spamCell.toString());
		assertEquals("[10, 15, B]", bodyCell.toString());
		assertEquals("[10, 15, H]", headCell.toString());
	}

	@Test
	public void testToStringHelper() {
		BoardCell wallCell = new BoardCell(10, 15, CellType.WALL);
		BoardCell openCell = new BoardCell(10, 15, CellType.OPEN);
		BoardCell spamCell = new BoardCell(10, 15, CellType.SPAM);
		BoardCell bodyCell = new BoardCell(10, 15, CellType.BODY);
		BoardCell headCell = new BoardCell(10, 15, CellType.HEAD);
		assertEquals("*", wallCell.toStringType());
		assertEquals(" ", openCell.toStringType());
		assertEquals("X", spamCell.toStringType());
		assertEquals("B", bodyCell.toStringType());
		assertEquals("H", headCell.toStringType());
	}

	/************************************
	 * Access basic information about a cell
	 ************************************/

	// Row and Column Tests
	@Test
	public void testGetRow() {
		BoardCell wallCell = new BoardCell(10, 15, CellType.WALL);
		assertEquals(10, wallCell.getRow());
	}

	@Test
	public void testGetColumn() {
		BoardCell wallCell = new BoardCell(10, 15, CellType.WALL);
		assertEquals(15, wallCell.getColumn());
	}

	// Tests for type
	@Test
	public void testType_Wall() {
		BoardCell wallCell = new BoardCell(10, 15, CellType.WALL);
		assertTrue(wallCell.isWall());
		assertFalse(wallCell.isOpen());
		assertFalse(wallCell.isSpam());
		assertFalse(wallCell.isBody());
		assertFalse(wallCell.isHead());
	}

	@Test
	public void testType_Open() {
		BoardCell openCell = new BoardCell(10, 15, CellType.OPEN);
		assertFalse(openCell.isWall());
		assertTrue(openCell.isOpen());
		assertFalse(openCell.isSpam());
		assertFalse(openCell.isBody());
		assertFalse(openCell.isHead());
	}

	@Test
	public void testType_Spam() {
		BoardCell spamCell = new BoardCell(10, 15, CellType.SPAM);
		assertFalse(spamCell.isWall());
		assertTrue(spamCell.isOpen()); // Spam is open
		assertTrue(spamCell.isSpam());
		assertFalse(spamCell.isBody());
		assertFalse(spamCell.isHead());
	}

	@Test
	public void testType_Body() {
		BoardCell bodyCell = new BoardCell(10, 15, CellType.BODY);
		assertFalse(bodyCell.isWall());
		assertFalse(bodyCell.isOpen());
		assertFalse(bodyCell.isSpam());
		assertTrue(bodyCell.isBody());
		assertFalse(bodyCell.isHead());
	}

	@Test
	public void testType_Head() {
		BoardCell headCell = new BoardCell(10, 15, CellType.HEAD);
		assertFalse(headCell.isWall());
		assertFalse(headCell.isOpen());
		assertFalse(headCell.isSpam());
		assertFalse(headCell.isBody());
		assertTrue(headCell.isHead());
	}

	// Test color
	@Test
	public void testCellColor_Wall() {
		BoardCell wallCell = new BoardCell(10, 15, CellType.WALL);
		assertEquals(Preferences.COLOR_WALL, wallCell.getCellColor());
	}

	@Test
	public void testCellColor_Open() {
		BoardCell openCell = new BoardCell(10, 15, CellType.OPEN);
		assertEquals(Preferences.COLOR_OPEN, openCell.getCellColor());
	}

	@Test
	public void testCellColor_Spam() {
		BoardCell spamCell = new BoardCell(10, 15, CellType.SPAM);
		assertEquals(Preferences.COLOR_SPAM, spamCell.getCellColor());
	}

	@Test
	public void testCellColor_Body() {
		BoardCell bodyCell = new BoardCell(10, 15, CellType.BODY);
		assertEquals(Preferences.COLOR_BODY, bodyCell.getCellColor());
	}

	@Test
	public void testCellColor_Head() {
		BoardCell headCell = new BoardCell(10, 15, CellType.HEAD);
		assertEquals(Preferences.COLOR_HEAD, headCell.getCellColor());
	}

	/************************************
	 * Modify basic info about a cell
	 ************************************/

	@Test
	public void testBecomeOpen_Wall() {
		BoardCell cell = new BoardCell(10, 15, CellType.WALL);
		cell.becomeOpen();
		assertFalse(cell.isWall());
		assertTrue(cell.isOpen());
		assertFalse(cell.isSpam());
		assertFalse(cell.isBody());
		assertFalse(cell.isHead());
	}

	@Test
	public void testBecomeOpen_Spam() {
		BoardCell cell = new BoardCell(10, 15, CellType.SPAM);
		cell.becomeOpen();
		assertFalse(cell.isWall());
		assertTrue(cell.isOpen());
		assertFalse(cell.isSpam());
		assertFalse(cell.isBody());
		assertFalse(cell.isHead());
	}

	@Test
	public void testBecomeOpen_Body() {
		BoardCell cell = new BoardCell(10, 15, CellType.BODY);
		cell.becomeOpen();
		assertFalse(cell.isWall());
		assertTrue(cell.isOpen());
		assertFalse(cell.isSpam());
		assertFalse(cell.isBody());
		assertFalse(cell.isHead());
	}

	@Test
	public void testBecomeOpen_Head() {
		BoardCell cell = new BoardCell(10, 15, CellType.HEAD);
		cell.becomeOpen();
		assertFalse(cell.isWall());
		assertTrue(cell.isOpen());
		assertFalse(cell.isSpam());
		assertFalse(cell.isBody());
		assertFalse(cell.isHead());
	}

	@Test
	public void testBecomeSpam_Open() {
		BoardCell cell = new BoardCell(10, 15, CellType.OPEN);
		cell.becomeSpam();
		assertFalse(cell.isWall());
		assertTrue(cell.isOpen());
		assertTrue(cell.isSpam());
		assertFalse(cell.isBody());
		assertFalse(cell.isHead());
	}

	@Test
	public void testBecomeHead_Open() {
		BoardCell cell = new BoardCell(10, 15, CellType.OPEN);
		cell.becomeHead();
		assertFalse(cell.isWall());
		assertFalse(cell.isOpen());
		assertFalse(cell.isSpam());
		assertFalse(cell.isBody());
		assertTrue(cell.isHead());
	}

	@Test
	public void testBecomeHead_Body() {
		BoardCell cell = new BoardCell(10, 15, CellType.BODY);
		cell.becomeHead();
		assertFalse(cell.isWall());
		assertFalse(cell.isOpen());
		assertFalse(cell.isSpam());
		assertFalse(cell.isBody());
		assertTrue(cell.isHead());
	}

	@Test
	public void testBecomeBody_Open() {
		BoardCell cell = new BoardCell(10, 15, CellType.OPEN);
		cell.becomeBody();
		assertFalse(cell.isWall());
		assertFalse(cell.isOpen());
		assertFalse(cell.isSpam());
		assertTrue(cell.isBody());
		assertFalse(cell.isHead());
	}

	@Test
	public void testBecomeBody_Head() {
		BoardCell cell = new BoardCell(10, 15, CellType.HEAD);
		cell.becomeBody();
		assertFalse(cell.isWall());
		assertFalse(cell.isOpen());
		assertFalse(cell.isSpam());
		assertTrue(cell.isBody());
		assertFalse(cell.isHead());
	}

	/************************************
	 * Methods used to access and set search info
	 ************************************/

	@Test
	public void testSearchListMethods() {
		BoardCell cell = new BoardCell(10, 15, CellType.OPEN);
		assertFalse(cell.inSearchListAlready());
		cell.setAddedToSearchList();
		assertTrue(cell.inSearchListAlready());
		cell.clear_RestartSearch();
		assertFalse(cell.inSearchListAlready());
	}

	@Test
	public void testParentMethods() {
		BoardCell cell1 = new BoardCell(10, 15, CellType.OPEN);
		BoardCell cell2 = new BoardCell(10, 15, CellType.OPEN);
		cell1.setParent(cell2);
		assertEquals(cell2, cell1.getParent());
	}

}
