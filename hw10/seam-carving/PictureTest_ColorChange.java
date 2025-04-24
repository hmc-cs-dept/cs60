package com.gradescope.photoeditor;

import static org.junit.Assert.*;

import org.junit.Test;

public class PictureTest_ColorChange {
        /*
         * Validate that grayscale works and does not modify the original Picture
         * object.
         */
        @Test
        public void testGrayscale_Micro() {
                Picture pic = Picture.loadPicture("images/Micro.bmp");
                Picture picCopy = new Picture(pic);
                Picture picCorrect = Picture.loadPicture("images/MicroGray.bmp");
                Picture picTest = pic.grayscale();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }

        /*
         * Validate that grayscale works and does not modify the original Picture
         * object.
         */
        @Test
        public void testGrayscale() {
                Picture pic = Picture.loadPicture("images/Creek.bmp");
                Picture picCopy = new Picture(pic);
                Picture picCorrect = Picture.loadPicture("images/Creek_grayscale.bmp");
                Picture picTest = pic.grayscale();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }

        /*
         * Validate that negate works and does not modify the original Picture
         * object.
         */
        @Test
        public void testNegateCreek() {
                Picture pic = Picture.loadPicture("images/Creek.bmp");
                Picture picCopy = new Picture(pic);
                Picture picCorrect = Picture.loadPicture("images/Creek_negate.bmp");
                Picture picTest = pic.negate();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }

        /*
         * Validate that negate works and does not modify the original Picture
         * object.
         */
        @Test
        public void testNegateMaria() {
                Picture pic = Picture.loadPicture("images/Maria1.bmp");
                Picture picCopy = new Picture(pic);
                Picture picCorrect = Picture.loadPicture("images/Maria1_negate.bmp");
                Picture picTest = pic.negate();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }

        /*
         * Tests the color changing a solid color: darken
         */
        @Test
        public void testColorTranslationsDarker() {
                Picture pic = Picture.loadPicture("images/Gray.bmp");
                Picture darker = Picture.loadPicture("images/Gray_darker.bmp");
                assertTrue(darker.equals(pic.darken(30)));

        }

        /*
         * Tests the color changing a solid color: lighten
         */
        @Test
        public void testColorTranslationsLighter() {
                Picture pic = Picture.loadPicture("images/Gray.bmp");
                Picture lighter = Picture.loadPicture("images/Gray_lighter.bmp");
                assertTrue(lighter.equals(pic.lighten(30)));

        }

        /*
         * Tests the color changing a solid color: addGreen
         */
        @Test
        public void testColorTranslationsGreener() {
                Picture pic = Picture.loadPicture("images/Gray.bmp");
                Picture greener = Picture.loadPicture("images/Gray_more_green.bmp");
                assertTrue(greener.equals(pic.addGreen(30)));

        }

        /*
         * Tests the color changing a solid color: addBlue
         */
        @Test
        public void testColorTranslationsBluer() {
                Picture pic = Picture.loadPicture("images/Gray.bmp");
                Picture bluer = Picture.loadPicture("images/Gray_more_blue.bmp");
                assertTrue(bluer.equals(pic.addBlue(30)));

        }

        /*
         * Tests the color changing a solid color: addRed
         */
        @Test
        public void testColorTranslationsRedder() {
                Picture pic = Picture.loadPicture("images/Gray.bmp");
                Picture redder = Picture.loadPicture("images/Gray_more_red.bmp");
                assertTrue(redder.equals(pic.addRed(30)));

        }

        /*
         * Validate that luminosity() works and does not modify the original Picture
         * object.
         *
         * Test with a small image that has few colors
         */
        @Test
        public void testLuminosity_Micro() {
                Picture pic = Picture.loadPicture("images/Micro.bmp");
                Picture picCopy = new Picture(pic);
                Picture picCorrect = Picture.loadPicture("images/MicroLum.bmp");
                Picture picTest = pic.luminosity();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }

        /*
         * Validate that luminosity() works and does not modify the original Picture
         * object.
         *
         * Test with a small image that has few colors
         */
        @Test
        public void testLuminosity_Tiny() {
                Picture pic = Picture.loadPicture("images/Tiny.bmp");
                Picture picCopy = new Picture(pic);
                Picture picCorrect = Picture.loadPicture("images/TinyLuminosity.bmp");
                Picture picTest = pic.luminosity();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }

        /*
         * Validate that luminosity() works and does not modify the original Picture
         * object.
         *
         * Test with a small image
         */
        @Test
        public void testLuminosity_Okinawa_Tiny() {
                Picture pic = Picture.loadPicture("images/Okinawa_tiny.bmp");
                Picture picCopy = new Picture(pic);
                Picture picCorrect = Picture.loadPicture("images/OkinawaTinyLuminosity.bmp");
                Picture picTest = pic.luminosity();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }

        /*
         * Validate that luminosity() works and does not modify the original Picture
         * object.
         *
         * Test with a large image
         */
        @Test
        public void testLuminosity_Okinawa() {
                Picture pic = Picture.loadPicture("images/Okinawa.bmp");
                Picture picCopy = new Picture(pic);
                Picture picCorrect = Picture.loadPicture("images/OkinawaLuminosity.bmp");
                Picture picTest = pic.luminosity();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }

        /*
         * Validate that luminosity() works and does not modify the original Picture
         * object.
         *
         * Test with a large image
         */
        @Test
        public void testLuminosity_Camel() {
                Picture pic = Picture.loadPicture("images/Camel.bmp");
                Picture picCopy = new Picture(pic);
                Picture picCorrect = Picture.loadPicture("images/CamelLuminosity.bmp");
                Picture picTest = pic.luminosity();
                assertTrue(pic.equals(picCopy));
                assertTrue(picCorrect.equals(picTest));
        }

}
