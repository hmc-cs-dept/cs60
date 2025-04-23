package com.gradescope.spampede;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpampedeModelTest_CellInDir {

	@Test
	public void test_getNextCellNorth() {
		SpampedeModel model = new SpampedeModel(TestGame.G1);
		model.setDirectionNorth();
		BoardCell neighborCell = model.getNextCellInDir();
		assertEquals("[0, 2, *]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == model.getCell(0, 2));
	}

	@Test
	public void test_getNextCellSouth() {
		SpampedeModel model = new SpampedeModel(TestGame.G1);
		model.setDirectionSouth();
		BoardCell neighborCell = model.getNextCellInDir();
		assertEquals("[2, 2,  ]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == model.getCell(2, 2));
	}

	@Test
	public void test_getNextCellEast() {
		SpampedeModel model = new SpampedeModel(TestGame.G1);
		model.setDirectionEast();
		BoardCell neighborCell = model.getNextCellInDir();
		assertEquals("[1, 3, X]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == model.getCell(1, 3));
	}

	@Test
	public void test_getNextCellWest() {
		SpampedeModel model = new SpampedeModel(TestGame.G1);
		model.setDirectionWest();
		BoardCell neighborCell = model.getNextCellInDir();
		assertEquals("[1, 1, B]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == model.getCell(1, 1));
	}

}
