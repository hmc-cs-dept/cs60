package com.gradescope.photoeditor;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class PictureTest_ComputeSeam {

	/*
	 * Check the length and contents of the seam generated from Ties.png
	 */
	@Test
	public void testComputeSeam_Ties() {
		Picture pic = Picture.loadPicture("images/Ties.png");
		int[] correctSeam = { 1, 1 };
		int[] computedSeam = pic.computeSeam();
		// Test seam length
		assertEquals(correctSeam.length, computedSeam.length);
		// Test seam contents using a String version of the array
		String correctSeamStr = Arrays.toString(correctSeam);
		String computedSeamStr = Arrays.toString(computedSeam);
		assertEquals(correctSeamStr, computedSeamStr);
	}

	/*
	 * Check the length and contents of the seam generated from Micro.bmp
	 */
	@Test
	public void testComputeSeam_Micro() {
		Picture pic = Picture.loadPicture("images/Micro.bmp");
		int[] correctSeam = { 1, 1, 0, 1, 2 };
		int[] computedSeam = pic.computeSeam();
		// Test seam length
		assertEquals(correctSeam.length, computedSeam.length);
		// Test seam contents using a String version of the array
		String correctSeamStr = Arrays.toString(correctSeam);
		String computedSeamStr = Arrays.toString(computedSeam);
		assertEquals(correctSeamStr, computedSeamStr);
	}

	/*
	 * Check the length and contents of the seam generated from Tiny.bmp
	 */
	@Test
	public void testComputeSeam_Tiny() {
		Picture pic = Picture.loadPicture("images/Tiny.bmp");
		int[] correctSeam = { 5, 6, 5, 4, 3, 2 };
		int[] computedSeam = pic.computeSeam();
		// Test seam length
		assertEquals(correctSeam.length, computedSeam.length);
		// Test seam contents using a String version of the array
		String correctSeamStr = Arrays.toString(correctSeam);
		String computedSeamStr = Arrays.toString(computedSeam);
		assertEquals(correctSeamStr, computedSeamStr);
	}

	/*
	 * Check the length and contents of the seam generated from Okinawa_tiny.bmp
	 */
	@Test
	public void testComputeSeam_Okinawa_Tiny() {
		Picture pic = Picture.loadPicture("images/Okinawa_tiny.bmp");
		int[] correctSeam = { 3, 4, 5, 6, 7, 8 };
		int[] computedSeam = pic.computeSeam();
		// Test seam length
		assertEquals(correctSeam.length, computedSeam.length);
		// Test seam contents using a String version of the array
		String correctSeamStr = Arrays.toString(correctSeam);
		String computedSeamStr = Arrays.toString(computedSeam);
		assertEquals(correctSeamStr, computedSeamStr);
	}

	/*
	 * Check the length and contents of the seam generated from Okinawa.bmp
	 */
	@Test
	public void testComputeSeam_Okinawa() {
		Picture pic = Picture.loadPicture("images/Okinawa.bmp");
		int[] correctSeam = { 93, 92, 92, 93, 93, 92, 93, 93, 94, 94, 94, 95, 96, 95, 94, 93, 93, 94, 94, 93, 93, 93,
				93, 93, 93, 93, 92, 92, 93, 93, 94, 93, 93, 94, 95, 95, 94, 93, 92, 91, 92, 93, 92, 91, 91, 92, 91, 92,
				93, 93, 94, 94, 94, 93, 93, 94, 94, 95, 96, 97, 96, 96, 96, 95, 94, 94, 93, 92, 93, 92, 92, 91, 90, 89,
				89, 88, 88, 87, 86, 87, 86, 86, 86, 85, 84, 84, 84, 85, 85, 85, 84, 85, 86, 86, 87, 88, 88, 89, 89, 90,
				91, 92, 93, 94, 94, 95, 94, 94, 94, 94, 95, 95, 96, 97, 98, 99, 99, 98, 99, 100, 99, 100, 101, 101, 102,
				103, 103, 103, 103, 103, 103, 104, 103, 102, 103, 102, 102, 102, 103, 104, 104, 103, 104, 105, 105, 106,
				106, 107, 108, 108, 107, 107, 107, 106, 106, 105, 104, 103, 102, 101, 101, 102, 103, 103, 104, 103, 102,
				102, 103, 104, 103, 103, 104, 103, 102, 103, 104, 103, 104, 105, 105, 104, 103, 104, 103, 103, 104, 103,
				103, 102, 102, 103, 104, 103, 103, 102, 101, 100, 99, 98, 97, 96, 96, 95, 95, 95, 95, 95, 96, 96, 95,
				94, 94, 93, 92, 91, 91, 91, 91, 92, 93, 94, 93, 92, 91, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80,
				79, 79, 79, 78, 78, 78, 77, 77, 77, 76, 75, 76, 75, 75, 74, 73, 73, 73, 73, 72, 71, 71, 71, 70, 69, 70,
				69, 70, 70, 71, 72, 73, 73, 74, 73, 72, 72, 73, 72, 71, 71, 71, 71, 71, 71, 70, 70, 69, 68, 68, 67, 66,
				66, 67, 67, 67, 67, 66, 65, 64, 63, 63, 63 };
		int[] computedSeam = pic.computeSeam();
		// Test seam length
		assertEquals(correctSeam.length, computedSeam.length);
		// Test seam contents
		for (int i = 0; i < correctSeam.length; i++) {
			assertEquals("Seam difference at index " + i, correctSeam[i], computedSeam[i]);
		}
	}

	/*
	 * Check the length and contents of the seam generated from Camel.bmp
	 */
	@Test
	public void testComputeSeam_Camel() {
		Picture pic = Picture.loadPicture("images/Camel.bmp");
		int[] correctSeam = { 698, 699, 698, 699, 700, 700, 700, 701, 702, 701, 701, 701, 700, 701, 701, 701, 702, 702,
				702, 701, 700, 700, 700, 699, 699, 700, 699, 698, 698, 697, 696, 695, 695, 695, 696, 696, 697, 697, 697,
				697, 697, 698, 698, 698, 697, 696, 697, 698, 698, 699, 699, 699, 700, 699, 699, 700, 699, 698, 697, 696,
				695, 694, 693, 692, 692, 692, 691, 692, 692, 692, 693, 693, 692, 691, 690, 689, 688, 689, 690, 690, 691,
				690, 690, 689, 688, 688, 688, 687, 686, 685, 684, 683, 682, 682, 681, 681, 680, 680, 679, 678, 677, 678,
				677, 678, 677, 677, 677, 678, 679, 679, 680, 679, 680, 681, 682, 683, 684, 685, 686, 686, 687, 688, 688,
				688, 689, 688, 689, 690, 691, 691, 691, 692, 691, 691, 691, 692, 692, 693, 694, 695, 694, 695, 695, 696,
				696, 697, 698, 699, 700, 701, 701, 701, 702, 703, 703, 703, 703, 704, 704, 704, 705, 706, 707, 708, 708,
				708, 708, 707, 707, 707, 707, 708, 708, 708, 708, 708, 707, 706, 707, 707, 707, 708, 708, 708, 709, 709,
				709, 709, 708, 708, 708, 709, 709, 709, 709, 709, 709, 710, 710, 710, 710, 710, 709, 708, 708, 708, 709,
				709, 709, 709, 709, 710, 710, 710, 710, 711, 712, 712, 712, 713, 713, 713, 713, 714, 715, 714, 713, 713,
				713, 714, 715, 715, 716, 717, 718, 718, 718, 719, 720, 721, 722, 722, 723, 724, 725, 726, 726, 727, 727,
				726, 725, 726, 727, 726, 726, 725, 725, 724, 724, 724, 725, 726, 725, 726, 727, 728, 728, 729, 729, 729,
				729, 729, 730, 731, 732, 733, 734, 735, 735, 736, 737, 738, 739, 740, 741, 741, 740, 741, 742, 743, 744,
				745, 746, 747, 747, 747, 748, 749, 750, 749, 748, 747, 747, 747, 748, 748, 748, 748, 747, 747, 748, 749,
				748, 747, 746, 745, 744, 743, 742, 741, 740, 739, 738, 738, 738, 737, 736, 735, 734, 733, 732, 731, 730,
				729, 728, 727, 726, 725, 724, 723, 722, 721, 720, 719, 718, 717, 716, 715, 714, 713, 712, 711, 710, 709,
				708, 707, 706, 705, 705, 706, 707, 707, 707, 707, 708, 707, 707, 707, 706, 705, 704, 704, 705, 705, 705,
				706, 706, 707, 708, 709, 710, 710, 711, 712, 711, 711, 712, 713, 713, 713, 714, 713, 714, 714, 714, 714,
				714, 715, 715, 715, 714, 713, 714, 715, 715, 716, 715, 714, 714, 714, 715, 716, 717, 717, 717, 717, 717,
				717, 716, 715, 714, 714, 714, 715, 714, 714, 715, 714, 714, 713, 714, 714, 713, 714, 715, 716, 716, 715,
				714, 714, 713, 712, 711, 710, 709, 708, 707, 706, 706, 705, 704, 703, 702, 701, 700, 700, 699, 699, 698,
				697, 696, 695, 694, 693, 692, 691, 690, 689, 688, 687, 686, 686, 685, 684, 684, 683, 683, 682, 682, 682,
				682, 683, 683, 682, 682, 682, 681, 680, 679, 678, 677, 676, 676, 676, 676, 676, 677, 677, 677, 678, 678,
				678, 678, 679, 680, 681, 682, 683, 684, 684, 685, 686, 687, 688, 689, 690, 690, 691, 692, 692, 691, 691,
				691, 691, 691, 691, 691, 691, 691, 691, 691, 691, 691, 691, 691, 691, 690, 689, 689, 689, 688, 687, 686,
				686, 686, 686, 687, 686, 685, 684, 683, 682, 681, 681, 682, 682, 682, 682, 682, 682, 682, 682, 682, 682,
				682, 682, 682, 682, 681, 680, 680, 680, 681, 682, 681, 681, 681, 680, 679, 678, 677, 676, 675, 674, 673,
				673, 673, 672, 673, 672, 672, 671, 672, 672, 672, 672, 672, 672, 672, 673, 674, 675, 676, 677, 678, 679,
				680, 679, 678, 677, 678, 677, 678, 678, 679, 680, 681, 682, 682, 681, 680, 681, 682, 683, 684, 684, 683,
				683, 683, 683, 683, 683, 682, 681, 680, 679, 678, 677, 676, 675, 674, 673, 672, 672, 671, 670, 669, 668,
				667, 666, 665, 664, 664, 664, 663, 662, 662, 662, 663, 662, 661, 660, 660, 660, 660, 660, 660, 660, 660,
				660, 660, 660, 660, 660, 661, 662, 662, 662, 662, 662, 661, 661, 660, 661, 661, 661, 662, 662, 662, 662,
				663, 663, 663, 662, 663, 663, 663, 662, 661, 662, 662, 662, 662, 662, 661, 660, 659, 659, 659, 659, 660,
				661, 662, 662, 662, 662, 662, 662, 662, 662 };
		int[] computedSeam = pic.computeSeam();
		// Test seam length
		assertEquals(correctSeam.length, computedSeam.length);
		// Test seam contents
		for (int i = 0; i < correctSeam.length; i++) {
			assertEquals("Seam difference at index " + i, correctSeam[i], computedSeam[i]);
		}
	}

}
