package com.gradescope.photoeditor;

import java.awt.Color;

import junit.framework.TestCase;

/*
 * This testing framework provides basic level tests for
 * each of the methods, however additional testing will be
 * required, along with extensive testing of ALL helper methods
 * that you write.
 */
public class PictureTest_ExtraCredit extends TestCase {

        /*
         * Validate that flip(Picture.HORIZONTAL) works and does not modify the
         * original Picture object.
         */
        public void testFlipHorizontal_Logos()
        {
                Picture pic             = Picture.loadPicture("images/Logos.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/Logos_flipHorizontally.bmp");
                Picture picTest         = pic.flip(Picture.HORIZONTAL);
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that flip(Picture.HORIZONTAL) works and does not modify the
         * original Picture object.
         */
        public void testFlipHorizontal_Maria()
        {
                Picture pic             = Picture.loadPicture("images/Maria1.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/Maria1_flipHorizontally.bmp");
                Picture picTest         = pic.flip(Picture.HORIZONTAL);
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }

        /*
         * Validate that flip(Picture.VERTICAL) works and does not modify the
         * original Picture object.
         */
        public void testFlipVertical_Logos()
        {
                Picture pic             = Picture.loadPicture("images/Logos.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/Logos_flipVertically.bmp");
                Picture picTest         = pic.flip(Picture.VERTICAL);
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that flip(Picture.VERTICAL) works and does not modify the
         * original Picture object.
         */
        public void testFlipVertical_Maria()
        {
                Picture pic             = Picture.loadPicture("images/Maria1.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/Maria1_flipVertically.bmp");
                Picture picTest         = pic.flip(Picture.VERTICAL);
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that flip(Picture.FORWARD_DIAGONAL) works and
         * does not modify the original Picture object.
         */
        public void testFlipForwardDiagonal_Logos()
        {
                Picture pic             = Picture.loadPicture("images/Logos.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/Logos_flipForwardSlash.bmp");
                Picture picTest         = pic.flip(Picture.FORWARD_DIAGONAL);
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that flip(Picture.FORWARD_DIAGONAL) works and
         * does not modify the original Picture object.
         */
        public void testFlipForwardDiagonal_Maria()
        {
                Picture pic             = Picture.loadPicture("images/Maria1.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/Maria1_flipForwardSlash.bmp");
                Picture picTest         = pic.flip(Picture.FORWARD_DIAGONAL);
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that flip(Picture.BACKWARD_DIAGONAL) works and
         * does not modify the original Picture object.
         */
        public void testFlipBackwardDiagonal_Logos()
        {
                Picture pic             = Picture.loadPicture("images/Logos.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/Logos_flipBackwardSlash.bmp");
                Picture picTest         = pic.flip(Picture.BACKWARD_DIAGONAL);
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that flip(Picture.BACKWARD_DIAGONAL) works and
         * does not modify the original Picture object.
         */
        public void testFlipBackwardDiagonal_Maria()
        {
                Picture pic             = Picture.loadPicture("images/Maria1.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/Maria1_flipBackwardSlash.bmp");
                Picture picTest         = pic.flip(Picture.BACKWARD_DIAGONAL);
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that blur works and does not modify the
         * original Picture object.
         */
        public void testBlur()
        {
                Picture pic             = Picture.loadPicture("images/Creek.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/Creek_blur.bmp");
                Picture picTest         = pic.blur(3);
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that chromaKey works and does not modify the
         * original Picture object.
         */
        public void testChromaKey_Logos()
        {
                Picture pic             = Picture.loadPicture("images/Logos.bmp");
                Picture bg                      = Picture.loadPicture("images/Creek.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/Logos_chromaKeyCreek.bmp");
                Picture picTest         = pic.chromaKey(118, 54, bg, 30);
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that chromaKey works and does not modify the
         * original Picture object.
         */
        public void testChromaKey_Maria()
        {
                Picture pic             = Picture.loadPicture("images/Maria1.bmp");
                Picture bg                      = Picture.loadPicture("images/HMC.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/Maria1_ChromaKeyHMC.bmp");
                Picture picTest         = pic.chromaKey(118, 54, bg, 30);
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }


        /*
         * Validate that paintBucket works and does not modify the
         * original Picture object.
         */
        public void testPaintBucket()
        {
                Picture pic             = Picture.loadPicture("images/Maria1.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/Maria_paintBucket.bmp");
                Picture picTest         = pic.paintBucket(118, 54, 30, new Color(0, 255, 0));
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }

        /*
         * Validate that showEdges works and does not modify the
         * original Picture object
         */
        public void testShowEdgesMickey()
        {
                Picture pic         = Picture.loadPicture("images/mickey.bmp");
                Picture picCopy     = new Picture(pic);
                Picture picCorrect  = Picture.loadPicture("images/mickey_showEdges.bmp");
                Picture picTest     = pic.showEdges(20);
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that showEdges works and does not modify the
         * original Picture object.
         */
        public void testShowEdges_Geese()
        {
                // These are geese painted by Maria Klawe
                Picture pic             = Picture.loadPicture("images/SnowGeese.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/SnowGeese_ShowEdges20.bmp");
                Picture picTest         = pic.showEdges(20);
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }


}
