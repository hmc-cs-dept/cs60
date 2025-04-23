package com.gradescope.spampede;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpampedeModelTest_UpdateSnake {

	@Test
	public void test_eatSpam() {
	  SpampedeModel data = new SpampedeModel(TestGame.G1);
	  data.moveSnakeForward(data.getNextCellInDir());
	  String boardString = data.toString();
		String correctBoardString = "******\n" + "*BBH *\n" + "*    *\n" + "*    *\n" + "*    *\n" + "******\n";
		// Sample debugging output:
		// System.out.println("G1");
		// System.out.println("Expected:");
		// System.out.println(correctBoardString);
		// System.out.println("Actual:");
		// System.out.println(boardString);
		assertEquals(correctBoardString, boardString);
	}

	@Test
	public void test_noSpamEaten() {
    SpampedeModel data = new SpampedeModel(TestGame.G2);
    data.moveSnakeForward(data.getNextCellInDir());
    String boardString = data.toString();
		String correctBoardString = "******\n" + "* BH *\n" + "* X  *\n" + "*    *\n" + "*    *\n" + "******\n";
		// Sample debugging output:
		// System.out.println("G2");
		// System.out.println("Expected:");
		// System.out.println(correctBoardString);
		// System.out.println("Actual:");
		// System.out.println(boardString);
		assertEquals(correctBoardString, boardString);
	}
}
