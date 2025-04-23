package com.gradescope.spampede;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.*; 

/**
 * The "view" in MVC that is responsible for drawing the board on the screen.
 * 
 * @author CS60 instructors
 */
class SpampedeView {

	/** The board/spampede data being drawn. */
	private SpampedeModel model;

	/** The controller, receiving actions from buttons/menus */
	private final SpampedeController controller;

	/** The display where the board is drawn. */
	private final Graphics screen;

	/** The width and height of the display in pixels. */
	private final int width;
	private final int height;

	/** The overall game window */
	private JFrame frame;

	/** The off-screen buffer of image */
	private BufferedImage image;

	/** The panel to display the image */
	SpampedeImagePanel panel;

	/** Buttons */
	private JButton newGameButton;
	private JButton pauseButton;
	private JButton startButton;

	/** Drop-down menu */
	private JMenu gameMenu;
	private JMenuItem newGameItem;
	private JMenuItem pauseItem;
	private JMenuItem startItem;

	/** A picture of a can of spam. */
	private static Image imageSpam;

	/**
	 * Creates a new SpampedeView.
	 * 
	 * @param model  the data being displayed
	 * @param screen the display on which to draw the board
	 * @param width     the width of the display (in pixels)
	 * @param height    the height of the display (in pixels)
	 */
	public SpampedeView(SpampedeController controller, SpampedeModel model, int width, int height) {
		this.controller = controller;
		this.model = model;
		this.height = height;
		this.width = width;

		// Initialize the frame
        frame = new JFrame("Spampede Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

		// Initialize controls
        initializeButtons();
        initializeMenu();
		initializeImage();

        // Set up the (off-screen) buffer for drawing, named image
        //image = createImage(Preferences.GAMEBOARDWIDTH, Preferences.GAMEBOARDHEIGHT); 
		image = new BufferedImage(Preferences.GAMEBOARDWIDTH, Preferences.GAMEBOARDHEIGHT, BufferedImage.TYPE_INT_RGB); 
        screen = image.getGraphics(); // screen holds the drawing routines
		panel = new SpampedeImagePanel(image);

        // Add a central panel which holds the buffer (the game board)
        frame.add(panel, BorderLayout.SOUTH);

		frame.pack();
        frame.setSize(Preferences.GAMEBOARDWIDTH, 600);
        frame.setVisible(true);
	}

	/**
	 * Initializes all buttons.
	 */
	private void initializeButtons() {
		// add a panel for buttons
		JPanel buttonPane = new JPanel(new FlowLayout());
		buttonPane.setBackground(Preferences.COLOR_BACKGROUND);

		newGameButton = new JButton("New Game"); // the text in the button
		newGameButton.addActionListener(controller); // watch for button presses
		newGameButton.setActionCommand("New Game"); // command to send when button is pressed
		newGameButton.setFocusable(false);
		buttonPane.add(newGameButton); // add button to the panel

		pauseButton = new JButton("Pause"); // a second button
		pauseButton.addActionListener(controller);
		pauseButton.setActionCommand("Pause");
		pauseButton.addKeyListener(controller);  // unclear why Java likes listener here but doesn't work with it on other buttons
		buttonPane.add(pauseButton);

		startButton = new JButton("Start"); // a third button
		startButton.addActionListener(controller);
		startButton.setActionCommand("Start");
		//startButton.addKeyListener(controller); // something needs a KeyListener
		buttonPane.add(startButton);

		frame.add(buttonPane);
	}

	/**
	 * Initializes all menu items.
	 */
	private void initializeMenu() {
		// set up the menu bar
		JMenuBar menuBar = new JMenuBar();

		// add a menu to contain items
		gameMenu = new JMenu("Game"); // the menu name
		menuBar.add(gameMenu); // add the menu to the menu bar

		newGameItem = new JMenuItem("New Game"); // the text in the menu
		newGameItem.addActionListener(controller); // watch for button presses
		newGameItem.setActionCommand("New Game");
		gameMenu.add(newGameItem); // add the item to the menu

		pauseItem = new JMenuItem("Pause"); // a second menu item
		pauseItem.addActionListener(controller);
		pauseItem.setActionCommand("Pause");
		gameMenu.add(pauseItem);

		startItem = new JMenuItem("Start"); // a third menu item
		startItem.addActionListener(controller);
		startItem.setActionCommand("Start");
		gameMenu.add(startItem);

		frame.add(menuBar, BorderLayout.PAGE_START);
	}

	private void initializeImage() {
		try {
			File spamFile = new File("Spam.gif").getAbsoluteFile();
            imageSpam = new ImageIcon(spamFile.toString()).getImage(); 
        } catch (Exception e) {
           	System.out.println("Problem loading image!");
            imageSpam = null; 
        } 
	}

	public void updateModel(SpampedeModel model) {
		this.model = model;
		updateGraphics();
	}
	/* -------------------- */
	/* Displaying the board */
	/* -------------------- */

	/**
	 * Re-draws the board, spam, and snake (but not the buttons).
	 */
	public void updateGraphics() {
		// Draw the background -- DO NOT REMOVE!
		clear();

		// Draw the title
		displayTitle();

		// Draw 5 squares of increasing size
		/*
		 * screen.setColor(Color.BLUE); int xPos = 20; int yPos = 100; int
		 * numSquares = 5; for (int i = 0; i <= numSquares; i++) {
		 * screen.fillRect(xPos, yPos, 5*i, 5*i); xPos += 10*i; }
		 */

		// Draw the board
		// The method drawSquare (below) will likely be helpful :)
		/* HW10 Part 1: Draw the board */

		// Display an image, just for fun
		if (SpampedeView.imageSpam != null) {
			screen.drawImage(SpampedeView.imageSpam, 200, 370, null);
		}

		// Draw the game-over message, if appropriate
		if (model.getGameOver()) {
			displayGameOver();
		}

		// send the new drawing to the screen
		panel.repaint();
	}

	/**
	 * Draws a cell-sized square with its upper-left corner at the specified pixel
	 * coordinates (i.e. x pixels to the right and y pixels below the upper-left
	 * corner) on the display.
	 * 
	 * @param x         the x-coordinate, between 0 and width-1 inclusive
	 * @param y         the y-coordinate, between 0 and height-1 inclusive
	 * @param cellColor the color of the square being drawn
	 */
	private void drawSquare(int x, int y, Color cellColor) {
		int xPad = (width - Preferences.NUM_CELLS_WIDE * Preferences.CELL_SIZE) / 2;
		int yPad = Preferences.TITLE_Y + Preferences.CELL_SIZE;
		screen.setColor(cellColor);
		screen.fillRect(x + xPad, y + yPad, Preferences.CELL_SIZE,
				Preferences.CELL_SIZE);
	}

	/**
	 * Draws the background. DO NOT MODIFY!
	 */
	private void clear() {
		screen.setColor(Preferences.COLOR_BACKGROUND);
		screen.fillRect(0, 0, width, height);
		screen.setColor(Preferences.TITLE_COLOR);
		screen.drawRect(0, 0, width - 1, Preferences.GAMEBOARDHEIGHT - 1);
	}

	/* ------------ */
	/* Text Display */
	/* ------------ */

	/**
	 * Displays the title of the game.
	 */
	private void displayTitle() {
		screen.setFont(Preferences.TITLE_FONT);
		screen.setColor(Preferences.TITLE_COLOR);
		screen.drawString(Preferences.TITLE, Preferences.TITLE_X, Preferences.TITLE_Y);
	}

	/**
	 * Displays the game-over message.
	 */
	private void displayGameOver() {
		screen.setFont(Preferences.GAME_OVER_FONT);
		screen.setColor(Preferences.GAME_OVER_COLOR);
		screen.drawString(Preferences.GAME_OVER_TEXT, Preferences.GAME_OVER_X, Preferences.GAME_OVER_Y);
	}

}
