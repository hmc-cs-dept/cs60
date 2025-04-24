package com.gradescope.photoeditor;

import static org.junit.Assert.*;

import org.junit.Test;


public class PictureTest_Energy {
        /*
         * Validate that energy() works and does not modify the
         * original Picture object.
         *
         * Test with a small image that has few colors
         */
        @Test
        public void testEnergy_Micro()
        {
                Picture pic             = Picture.loadPicture("images/Micro.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/MicroEnergy.bmp");
                Picture picTest         = pic.energy();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that energy() works and does not modify the
         * original Picture object.
         *
         * Test with a small image that has few colors
         */
        @Test
        public void testEnergy_Tiny()
        {
                Picture pic             = Picture.loadPicture("images/Tiny.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/TinyEnergy.bmp");
                Picture picTest         = pic.energy();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that energy() works and does not modify the
         * original Picture object.
         *
         * Test with a small image
         */
        @Test
        public void testEnergy_Okinawa_Tiny()
        {
                Picture pic             = Picture.loadPicture("images/Okinawa_tiny.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/OkinawaTinyEnergy.bmp");
                Picture picTest         = pic.energy();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that energy() works and does not modify the
         * original Picture object.
         *
         * Test with a large image
         */
        @Test
        public void testEnergy_Okinawa()
        {
                Picture pic             = Picture.loadPicture("images/Okinawa.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/OkinawaEnergy.bmp");
                Picture picTest         = pic.energy();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }
        /*
         * Validate that energy() works and does not modify the
         * original Picture object.
         *
         * Test with a large image
         */
        @Test
        public void testEnergy_Camel()
        {
                Picture pic             = Picture.loadPicture("images/Camel.bmp");
                Picture picCopy         = new Picture(pic);
                Picture picCorrect      = Picture.loadPicture("images/CamelEnergy.bmp");
                Picture picTest         = pic.energy();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }

}
