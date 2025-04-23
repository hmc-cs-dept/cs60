package com.gradescope.spampede;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;

/**
 * Implements low-level graphics work.
 * 
 * DO NOT MODIFY.
 * 
 * @author CS60 instructors
 */
public class SpampedeImagePanel extends JPanel {

	/** The image that this panel draws */
	private Image image;

	/** Constructs a new SpampedeImagePanel */
	public SpampedeImagePanel(Image image) {
		// store the image
		this.image = image;

		// calculate the dimensions of the panel
		int height = image.getHeight(null);
		int width = image.getWidth(null);
		Dimension dimensions = new java.awt.Dimension(width, height);
		super.setPreferredSize(dimensions);
	}

	/* Draws the image on the panel */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);		
	} 
	
}
