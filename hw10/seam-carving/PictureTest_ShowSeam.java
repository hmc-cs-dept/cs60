package com.gradescope.photoeditor;

import static org.junit.Assert.*;

import org.junit.Test;


public class PictureTest_ShowSeam {

        /*
         * Validate that showSeam works and does not modify the
         * original Picture object.
         *
         * Test with a small image that has few colors
         */
        @Test
        public void testShowSeam_Micro()
        {
                Picture pic             = Picture.loadPicture("images/Micro.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/MicroShowSeam.bmp");
                Picture picTest         = pic.showSeam();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }

        /*
         * Validate that showSeam works and does not modify the
         * original Picture object.
         *
         * Test with a small image that has few colors
         */
        @Test
        public void testShowSeam_Tiny()
        {
                Picture pic             = Picture.loadPicture("images/Tiny.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/TinySeam.bmp");
                Picture picTest         = pic.showSeam();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that showSeam works and does not modify the
         * original Picture object.
         *
         * Test with a small image
         */
        @Test
        public void testShowSeam_Okinawa_Tiny()
        {
                Picture pic             = Picture.loadPicture("images/Okinawa_tiny.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/OkinawaTinySeam.bmp");
                Picture picTest         = pic.showSeam();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that showSeam works and does not modify the
         * original Picture object.
         *
         * Test with a large image
         */
        @Test
        public void testShowSeam_Okinawa()
        {
                Picture pic             = Picture.loadPicture("images/Okinawa.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/OkinawaSeam.bmp");
                Picture picTest         = pic.showSeam();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that showSeam works and does not modify the
         * original Picture object.
         *
         * Test with a large image
         */
        @Test
        public void testShowSeam_Camel()
        {
                Picture pic             = Picture.loadPicture("images/Camel.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/CamelSeam.bmp");
                Picture picTest         = pic.showSeam();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }

}
