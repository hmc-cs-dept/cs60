package com.gradescope.photoeditor;

import static org.junit.Assert.*;

import org.junit.Test;


public class PictureTest_Carve {
        /*
         * Validate that carve works and does not modify the
         * original Picture object.
         *
         * Test with a small image that has few colors
         */
        @Test
        public void testCarve_Micro()
        {
                Picture pic             = Picture.loadPicture("images/Micro.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/MicroCarve.bmp");
                Picture picTest         = pic.carve();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }

        /*
         * Validate that carve works and does not modify the
         * original Picture object.
         *
         * Test with a small image that has few colors
         */
        @Test
        public void testCarve_Tiny()
        {
                Picture pic             = Picture.loadPicture("images/Tiny.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/TinyCarve1.bmp");
                Picture picTest         = pic.carve();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }

        /*
         * Validate that carve works and does not modify the
         * original Picture object.
         *
         * Test with a small image
         */
        @Test
        public void testCarve_Okinawa_Tiny()
        {
                Picture pic             = Picture.loadPicture("images/Okinawa_tiny.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/OkinawaTinyCarve1.bmp");
                Picture picTest         = pic.carve();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that carve works and does not modify the
         * original Picture object.
         *
         * Test with a large image
         */
        @Test
        public void testCarve_Okinawa()
        {
                Picture pic             = Picture.loadPicture("images/Okinawa.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/OkinawaCarve1.bmp");
                Picture picTest         = pic.carve();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that carve works and does not modify the
         * original Picture object.
         *
         * Test with a large image
         */
        @Test
        public void testCarve_Camel()
        {
                Picture pic             = Picture.loadPicture("images/Camel.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/CamelCarve1.bmp");
                Picture picTest         = pic.carve();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }


}
