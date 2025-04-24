package com.gradescope.spampede;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioInputStream;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import java.awt.event.*;

/**
 *  SpampedeController 
 * @author CS60 instructors
 */

public class SpampedeController extends JPanel implements ActionListener, KeyListener, Runnable {
	/** The "view" in MVC. */
	private SpampedeView view;

	/** The "model" in MVC. */
	public SpampedeModel model;

	/* sounds for the game */
	public AudioInputStream audioSpam, audioCrunch; // spam sound

	/* --------------------------------------------------------------- */
	/* Fields and methods are used to implement the Runnable interface */
	/* and to support pausing and resuming the applet. */
	/* --------------------------------------------------------------- */

	Thread thread; // the thread controlling the updates
	boolean threadSuspended; // whether or not the thread is suspended
	boolean running; // whether or not the thread is stopped

	/** The mappings between direction (names) and keys. */
	private static final char REVERSE = 'r';
	private static final char UP = 'i';
	private static final char DOWN = 'k';
	private static final char LEFT = 'j';
	private static final char RIGHT = 'l';
	private static final char AI_MODE = 'a';
	private static final char PLAY_SPAM_NOISE = 's';
	

	/**
	 * Helper function for loading audio clips. Returns null if unable to load clip. 
	 */
	private AudioInputStream loadClip(String fileString) {
		
		try {
			File audioFile = new File(fileString).getAbsoluteFile();
			return AudioSystem.getAudioInputStream(audioFile);
		} catch (NullPointerException e) {
			System.out.println("Problem loading audio " + fileString + " : file is Null");
		} catch (UnsupportedAudioFileException e) {
			System.out.println("Problem loading audio " + fileString + " : this audio file data is not recognized/supported; it may need to be reencoded");
		} catch (IOException e) {
			System.out.println("Problem loading audio " + fileString + " : an IOException has occured; check the file name and path!");
		} catch (Exception e) {
			System.out.println("Unknown problem loading audio from " + fileString );
		}

		return null;
	}
    


	/**
	 * Constructor for the controller
	 */
	public SpampedeController() {
        
		// Loading audio using the helper function loadClip
		audioSpam = loadClip("media/spam.wav");
		audioCrunch = loadClip("media/crunch.wav");

		// Initialize the view and start the game 
		view = new SpampedeView(this, null,  Preferences.GAMEBOARDWIDTH, 600);
        startNewGame(); // Set up the game internals!
    }

	/**
	 * Processes buttons and menu items.
	 */
	public void actionPerformed(ActionEvent evt) {
		String actionCommand = evt.getActionCommand();
		switch (actionCommand) {
			case "New Game":
				startNewGame();
				go();
				break;
			case "Pause":
				pause();
				break;	
			case "Start":
				go();
				break;
		}
		requestFocus(); // makes sure this applet keeps keyboard focus
	}

	/**
	 * Reacts to characters typed by the user.
	 * 
	 * <p>
	 * SpampedeCibtrikker registers as an "observer" for key presses
	 * on the keyboard. So, whenever the user presses a key, Java automatically
	 * calls this keyPressed method and passes it a KeyEvent describing the specific
	 * key press.
	 * </p>
	 */
	public void keyPressed(KeyEvent evt) {
		switch (evt.getKeyChar()) { // get the char of the pressed key
			case REVERSE:
				model.reverseSnake();
				break;
			/* HW10 Part 4: Direction Keys */

			case AI_MODE:
				model.setMode_AI();
				break;
			case PLAY_SPAM_NOISE:
				playSound_spam();
				break;
		}
	}

	public void keyReleased(KeyEvent evt) {
		// Not used
	}

	@Override
	public void keyTyped(KeyEvent evt) {
		// Not used
	}

	/**
	 * Called to run this applet.
	 */
	@Override
	public void run() {
		// calls the "model.cycle()" method every so often (every sleepTime milliseconds)
		while (running) {
			try {
				if (thread != null) {
					Thread.sleep(Preferences.SLEEP_TIME);
					synchronized (this) {
						while (threadSuspended) {
							wait(); // sleeps until notify() wakes it up
						}
					}
				}
			} catch (InterruptedException e) {
				;
			}

			model.cycle(); // this represents 1 update cycle for the environment
		}
		thread = null;
	}

	/**
	 * Called when the "Start" button is pressed.
	 */
	public synchronized void go() {
		if (thread == null) {
			thread = new Thread(this);
			running = true;
			thread.start();
			threadSuspended = false;
		} else {
			threadSuspended = false;
		}
		notify(); // wakes up the call to wait(), above
	}

	/**
	 * Called when the "Pause" button is pressed.
	 */
	void pause() {
		if (thread != null) threadSuspended = true;
	}

	/** Starts a new game. */
	public void startNewGame() {
		model = new SpampedeModel(this, view);
		model.placeSnakeAtStartLocation();
		model.setStartDirection();

		view.updateModel(model);

		/**
		 * Hack because pictures have a delay in loading, and we do not redraw the
		 * screen again until the game actually starts, which means we would not see the
		 * image until the game does start. Wait a fraction of a second (200 ms), by
		 * which time the picture should have been fetched from disk, and redraw.
		 */
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}

		view.updateGraphics();
		playSound(audioSpam);
	}

	/** Declares the game over. */
	public void gameOver() {
		if (thread != null) threadSuspended = true;
		model.setGameOver(); // tell the model that the game is over
	}

	/* ------ */
	/* Sounds */
	/* ------ */

	/** Plays crunch noise. */
	public void playSound_spamEaten() {
		playSound("media/crunch.wav");
	}

	/** Plays spam noise. */
	public void playSound_spam() {
	 	playSound("media/spam.wav");
	}

	public void playSound(AudioInputStream sound) {
		if (sound != null) {
			try {
				Clip clip = AudioSystem.getClip();
				clip.open(sound);
				clip.start();
			} catch (Exception e) {
				System.out.println("Problem playing sound "+sound);
			}
		}
	}

	public void playSound(String filename) {
		AudioInputStream sound = null;
		File f = new File(filename).getAbsoluteFile();
		try {
			sound =  AudioSystem.getAudioInputStream(f);
		} catch (Exception e) {
			System.out.println("Problem loading sound "+filename);
		}
		if (sound != null) {
			try {
				Clip clip = AudioSystem.getClip();
				clip.open(sound);
				clip.start();
			} catch (Exception e) {
				System.out.println("Problem playing sound "+filename);
			}
		}
	}

	/* ---------------------- */
	/* Testing Infrastructure */
	/* ---------------------- */

	public static SpampedeController getTestGame(TestGame gameNum) {
		SpampedeController brain = new SpampedeController();
		brain.model = new SpampedeModel(gameNum);
		return brain;
	}

	public String testing_toStringParent() {
		return model.toStringParents();
	}

	public BoardCell testing_getNextCellInDir() {
		return model.getNextCellInDir();
	}

	public String testing_toStringSpampedeModel() {
		return model.toString();
	}

	/* ---------------------- */
	/* Main */
	/* ---------------------- */

	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SpampedeController();
            }
        });
    }

}
