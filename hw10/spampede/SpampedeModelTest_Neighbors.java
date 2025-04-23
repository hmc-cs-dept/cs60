package com.gradescope.spampede;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpampedeModelTest_Neighbors {
	/**
	 * Pictures of test boards at http://tinyurl.com/spampedeTestBoards
	 */

	@Test
	public void test_NorthNeighborWithArgument() {
		SpampedeModel model = new SpampedeModel(TestGame.G1);
		BoardCell focalCell = model.getCell(2, 3);
		BoardCell neighborCell = model.getNorthNeighbor(focalCell);
		assertEquals("[1, 3, X]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == model.getCell(1, 3));
	}

	@Test
	public void test_NorthNeighborWithoutArgument() {
		SpampedeModel model = new SpampedeModel(TestGame.G1);
		BoardCell neighborCell = model.getNorthNeighbor();
		assertEquals("[0, 2, *]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == model.getCell(0, 2));

	}

	@Test
	public void test_SouthNeighborWithArgument() {
		SpampedeModel model = new SpampedeModel(TestGame.G1);
		BoardCell focalCell = model.getCell(2, 3);
		BoardCell neighborCell = model.getSouthNeighbor(focalCell);
		assertEquals("[3, 3,  ]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == model.getCell(3, 3));
	}

	@Test
	public void test_SouthNeighborWithoutArgument() {
		SpampedeModel model = new SpampedeModel(TestGame.G1);
		BoardCell neighborCell = model.getSouthNeighbor();
		assertEquals("[2, 2,  ]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == model.getCell(2, 2));
	}

	@Test
	public void test_EastNeighborWithArgument() {
		SpampedeModel model = new SpampedeModel(TestGame.G1);
		BoardCell focalCell = model.getCell(2, 3);
		BoardCell neighborCell = model.getEastNeighbor(focalCell);
		assertEquals("[2, 4,  ]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == model.getCell(2, 4));
	}

	@Test
	public void test_EastNeighborWithoutArgument() {
		SpampedeModel model = new SpampedeModel(TestGame.G1);
		BoardCell neighborCell = model.getEastNeighbor();
		assertEquals("[1, 3, X]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == model.getCell(1, 3));
	}

	@Test
	public void test_WestNeighborWithArgument() {
		SpampedeModel model = new SpampedeModel(TestGame.G1);
		BoardCell focalCell = model.getCell(2, 3);
		BoardCell neighborCell = model.getWestNeighbor(focalCell);
		assertEquals("[2, 2,  ]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == model.getCell(2, 2));
	}

	@Test
	public void test_WestNeighborWithoutArgument() {
		SpampedeModel model = new SpampedeModel(TestGame.G1);
		BoardCell neighborCell = model.getWestNeighbor();
		assertEquals("[1, 1, B]", neighborCell.toString());
		// check they're the same object (Not a new BoardCell!)
		assertTrue(neighborCell == model.getCell(1, 1));
	}
}
