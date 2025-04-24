package com.gradescope.photoeditor;

import static org.junit.Assert.*;

import org.junit.Test;


public class PictureTest_CarveMany {

        /*
         * Validate that carveMany works and does not modify the
         * original Picture object.
         *
         * Test with a small image that has few colors
         */
        @Test
        public void testCarve2_Micro()
        {
                Picture pic             = Picture.loadPicture("images/Micro.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/MicroCarve2.bmp");
                Picture picTest         = pic.carveMany(2);
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that carveMany works and does not modify the
         * original Picture object.
         *
         * Test with a small image that has few colors
         */
        @Test
        public void testCarve5_Tiny()
        {
                Picture pic             = Picture.loadPicture("images/Tiny.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/TinyCarve5.bmp");
                Picture picTest         = pic.carveMany(5);
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that carveMany works and does not modify the
         * original Picture object.
         *
         * Test with a small image
         */
        @Test
        public void testCarve5_Okinawa_Tiny()
        {
                Picture pic             = Picture.loadPicture("images/Okinawa_tiny.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/OkinawaTinyCarve5.bmp");
                Picture picTest         = pic.carveMany(5);
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that carveMany works and does not modify the
         * original Picture object.
         *
         * Test with a large image
         */
        @Test
        public void testCarve5_Okinawa()
        {
                Picture pic             = Picture.loadPicture("images/Okinawa.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/OkinawaCarve5.bmp");
                Picture picTest         = pic.carveMany(5);
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that carveMany works and does not modify the
         * original Picture object.
         *
         * Test with a large image
         */
        @Test
        public void testCarve5_Camel()
        {
                Picture pic             = Picture.loadPicture("images/Camel.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/CamelCarve5.bmp");
                Picture picTest         = pic.carveMany(5);
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }

}
