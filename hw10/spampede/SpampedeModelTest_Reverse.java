package com.gradescope.spampede;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpampedeModelTest_Reverse {
	/**
	 * Pictures of test boards at http://tinyurl.com/spampedeTestBoards
	 */
	
	@Test
	public void test_ReverseNorth() {
		SpampedeModel model = new SpampedeModel(TestGame.G14);
		model.reverseSnake();
		BoardCell nextCell = model.getNextCellInDir();
		assertEquals("[1, 2,  ]", nextCell.toString());
	}

	@Test
	public void test_ReverseSouth() {
	  SpampedeModel model = new SpampedeModel(TestGame.G13);
    model.reverseSnake();
    BoardCell nextCell = model.getNextCellInDir();
    assertEquals("[4, 2,  ]", nextCell.toString());
	}

	@Test
	public void test_ReverseEast() {
	  SpampedeModel model = new SpampedeModel(TestGame.G12);
    model.reverseSnake();
    BoardCell nextCell = model.getNextCellInDir();
    assertEquals("[2, 4,  ]", nextCell.toString());
	}

	@Test
	public void test_ReverseWest() {
	  SpampedeModel model = new SpampedeModel(TestGame.G15);
    model.reverseSnake();
    BoardCell nextCell = model.getNextCellInDir();
    assertEquals("[3, 1,  ]", nextCell.toString());
	}

}
