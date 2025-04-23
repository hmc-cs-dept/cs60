package com.gradescope.spampede;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpampedeModelTest_GetNextCellFromBFS {
	/**
	 * Pictures of test boards at http://tinyurl.com/spampedeTestBoards
	 */

	@Test
	public void testG1_BFS() {
		SpampedeModel model = new SpampedeModel(TestGame.G1);
    BoardCell nextCell = model.getNextCellFromBFS();    
		assertEquals("[1, 3, X]", nextCell.toString());
	}

	@Test
	public void testG2_BFS() {
	  SpampedeModel model = new SpampedeModel(TestGame.G2);
    BoardCell nextCell = model.getNextCellFromBFS();    
    assertEquals("[2, 2, X]", nextCell.toString());
	}

	@Test
	public void testG3_BFS() {
	  SpampedeModel model = new SpampedeModel(TestGame.G3);
    BoardCell nextCell = model.getNextCellFromBFS();    
    assertEquals("[1, 3,  ]", nextCell.toString());
	}

	@Test
	public void testG4_BFS() {
	  SpampedeModel model = new SpampedeModel(TestGame.G4);
    BoardCell nextCell = model.getNextCellFromBFS();    
    assertEquals("[2, 2,  ]", nextCell.toString());
	}

	@Test
	public void testG5_BFS() {
	  SpampedeModel model = new SpampedeModel(TestGame.G5);
    BoardCell nextCell = model.getNextCellFromBFS();    
    assertEquals("[2, 2,  ]", nextCell.toString());
	}

	@Test
	public void testG6_BFS() {
	  SpampedeModel model = new SpampedeModel(TestGame.G6);
    BoardCell nextCell = model.getNextCellFromBFS();    
    assertEquals("[1, 3, X]", nextCell.toString());
	}

	@Test
	public void testG7_BFS() {
	  SpampedeModel model = new SpampedeModel(TestGame.G7);
    BoardCell nextCell = model.getNextCellFromBFS();    
    assertEquals("[2, 2, X]", nextCell.toString());
	}

	@Test
	public void testG8_BFS() {
	  SpampedeModel model = new SpampedeModel(TestGame.G8);
    BoardCell nextCell = model.getNextCellFromBFS();    
    assertEquals("[1, 3,  ]", nextCell.toString());
	}

	@Test
	public void testG9_BFS() {
	  SpampedeModel model = new SpampedeModel(TestGame.G9);
    BoardCell nextCell = model.getNextCellFromBFS();    
		assertEquals("[2, 2,  ]", nextCell.toString());
	}

	@Test
	public void testG10_BFS() {
	  SpampedeModel model = new SpampedeModel(TestGame.G10);
    BoardCell nextCell = model.getNextCellFromBFS();    
    assertEquals("[2, 2,  ]", nextCell.toString());
	}

	@Test
	public void testG11_BFS() {
	  SpampedeModel model = new SpampedeModel(TestGame.G11);
    BoardCell nextCell = model.getNextCellFromBFS();    
		// NEED AN OR!
		String possibleResult1 = "[1, 3,  ]";
		String possibleResult2 = "[2, 2,  ]";
		String nextCellString = nextCell.toString();
		assertTrue(possibleResult1.equals(nextCellString) || possibleResult2.equals(nextCellString));
	}

}
