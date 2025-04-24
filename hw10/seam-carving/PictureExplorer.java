package com.gradescope.photoeditor;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Displays a picture and allows exploration of the picture by displaying
 *      the x, y, red, green, and blue values of the pixel at the cursor when
 *      a mouse button is clicked or a mouse button is pressed and held while
 *      moving the cursor. The x and y values of a pixel can also be entered
 *      to see the color at that pixel.
 *
 * @author Keith McDermott (gte047w@cc.gatech.edu) and
 *      Barb Ericson (ericson@cc.gatech.edu)
 *      (Copyright Georgia Institute of Technology 2004)
 * @author Modified by Colleen Lewis (lewis@cs.hmc.edu),
 *      Jonathan Kotker (jo_ko_berkeley@berkeley.edu),
 *      Kaushik Iyer (kiyer@berkeley.edu), George Wang (georgewang@berkeley.edu),
 *      and David Zeng (davidzeng@berkeley.edu).

 */
public class PictureExplorer implements MouseMotionListener, ActionListener, MouseListener
{

        // Current x- and y-index.
        private int xIndex = 0;
        private int yIndex = 0;

        // Main GUI variables.
        private JFrame pictureFrame;
        private JScrollPane scrollPane;

        // Information bar variables.
        private JLabel xLabel;
        private JLabel yLabel;
        private JButton xPrevButton;
        private JButton yPrevButton;
        private JButton xNextButton;
        private JButton yNextButton;
        private JTextField xValue;
        private JTextField yValue;
        private JLabel rLabel;
        private JLabel rValue;
        private JLabel gLabel;
        private JLabel gValue;
        private JLabel bLabel;
        private JLabel bValue;
        private JLabel colorLabel;
        private JPanel colorPanel;

        // Menu components.
        private JMenuBar menuBar;

        // File menu.
        private JMenu fileMenu;
        private JMenuItem openMenuItem;
        private JMenuItem resetMenuItem;
        private JMenuItem saveMenuItem;
        private JMenuItem saveAsMenuItem;
        private JMenuItem exitMenuItem;

        // Strings used in file menu items.
        private static final String STR_FILE = "File";
        private static final String STR_OPEN = "Open...";
        private static final String STR_RESET = "Reset Picture";
        private static final String STR_SAVE = "Save";
        private static final String STR_SAVEAS = "Save As...";
        private static final String STR_EXIT = "Exit";

        // Zoom menu.
        private JMenu zoomMenu;
        private JMenuItem twentyFiveMenuItem;
        private JMenuItem fiftyMenuItem;
        private JMenuItem seventyFiveMenuItem;
        private JMenuItem hundredMenuItem;
        private JMenuItem hundredFiftyMenuItem;
        private JMenuItem twoHundredMenuItem;
        private JMenuItem fiveHundredMenuItem;
        private JMenuItem fiveThousandMenuItem;

        // Strings used in zoom menu items.
        private static final String STR_ZOOM = "Zoom";
        private static final String STR_25PERC = "25%";
        private static final String STR_50PERC = "50%";
        private static final String STR_75PERC = "75%";
        private static final String STR_100PERC = "100%";
        private static final String STR_150PERC = "150%";
        private static final String STR_200PERC = "200%";
        private static final String STR_500PERC = "500%";
        private static final String STR_5000PERC = "5000%";

        // Picture effects menu.
        private JMenu pictureEffectsMenu;
        private JMenuItem chromakeyMenuItem;
        private JMenuItem blurMenuItem;
        private JMenuItem showEdgesMenuItem;
        private JMenuItem paintBucketMenuItem;

        private static final String STR_PICTURE_EFFECTS = "Picture Effects";
        private static final String STR_CHROMAKEY = "Chromakey on Current Point";
        private static final String STR_BLUR = "Blur Image";
        private static final String STR_SHOW_EDGES = "Show Edges";
        private static final String STR_PAINT_BUCKET = "Paint Bucket on Current Point";

        // Picture rotate menu
        private JMenu rotateflipMenu;
        private JMenuItem flipHorzMenuItem;
        private JMenuItem flipVertMenuItem;
        private JMenuItem flipForwardMenuItem;
        private JMenuItem flipBackwardMenuItem;
        private JMenuItem rotateMenuItem;

        private static final String STR_ROTATE_MENU = "Rotate/Flip";
        private static final String STR_ROTATE_RIGHT = "Rotate Image Right";
        private static final String STR_FLIP_HORIZONTAL = "Flip Horizontally";
        private static final String STR_FLIP_VERTICAL = "Flip Vertically";
        private static final String STR_FLIP_FORWARD = "Flip on Forward Slash";
        private static final String STR_FLIP_BACKWARD = "Flip on Backward Slash";

        // Picture color change menu
        private JMenu changeColorMenu;
        private JMenuItem grayscaleMenuItem;
        private JMenuItem negateMenuItem;
        private JMenuItem lightenMenuItem;
        private JMenuItem darkenMenuItem;
        private JMenuItem addRedMenuItem;
        private JMenuItem addGreenMenuItem;
        private JMenuItem addBlueMenuItem;

        private static final String STR_COLOR_CHANGE = "Change Colors";
        private static final String STR_GRAYSCALE = "Grayscale";
        private static final String STR_NEGATE   = "Photonegative";
        private static final String STR_LIGHTEN  = "Lighten";
        private static final String STR_DARKEN   = "Darken";
        private static final String STR_ADD_RED          = "Add Red";
        private static final String STR_ADD_GREEN = "Add Green";
        private static final String STR_ADD_BLUE         = "Add Blue";

        // Picture seam carving menu
        private JMenu seamCarvingMenu;
        private JMenuItem luminosityMenuItem;
        private JMenuItem energyMenuItem;
        private JMenuItem showSeamMenuItem;
        private JMenuItem carveMenuItem;
        private JMenuItem carveManyMenuItem;

        private static final String STR_SEAM_CARVING = "Seam Carving";
        private static final String STR_LUMINOSITY  = "Luminosity";
        private static final String STR_ENERGY      = "Energy";
        private static final String STR_SHOW_SEAM    = "Show Seam";
        private static final String STR_CARVE       = "Carve";
        private static final String STR_CARVE_MANY   = "Carve Many";


        // Strings used in the ImageDisplay and in the pixel navigation system.
        private static final String imageDisplayTooltip = "Click a mouse button " +
        "on a pixel to see the pixel information";
        private static final String STR_CLICK_DESC = "Click to go to the ";
        private static final String xNextTooltip = STR_CLICK_DESC + "next x value";
        private static final String xPrevTooltip = STR_CLICK_DESC
                        + "previous x value";
        private static final String yNextTooltip = STR_CLICK_DESC + "next y value";
        private static final String yPrevTooltip = STR_CLICK_DESC
                        + "previous y value";
        private static final String redLabel = "R: ";
        private static final String greenLabel = "G: ";
        private static final String blueLabel = "B: ";
        private static final String cannotShowText = "N/A";

        /** The Picture being explored. */
        private Picture picture;
        private String fileName;

        /** The ImageDisplay. */
        private ImageDisplay imageDisplay;

        /** The zoom factor (amount to zoom). */
        private double zoomFactor;

        /** The number system to use.
         *      0 means starting at 0, 1 means starting at 1. */
        private int numberBase = 0;

        /**
         * Public constructor.
         *
         * @param picture The Picture to explore.
         */
        public PictureExplorer(Picture picture) {
                this.picture = picture;
                this.fileName = picture.getFileName();
                this.zoomFactor = 1;
                
                // Seed future dialog boxes
                FileChooser.LAST_FILE = this.fileName;

                // Create the window and set things up.
                this.createWindow();
        }

        /**
         * Changes the number system to start at base one.
         */
        public void changeToBaseOne() {
                this.numberBase = 1;
        }

        /**
         * Sets the title of the frame.
         *
         * @param title The title to use.
         */
        public void setTitle(String title) {
                this.pictureFrame.setTitle(title);
        }

        /**
         * Creates and initializes the picture frame.
         */
        private void createAndInitPictureFrame() {
                this.pictureFrame = new JFrame(); // Create the JFrame.
                this.pictureFrame.setResizable(true);  // Allow the user to resize it.
                this.pictureFrame.getContentPane().
                setLayout(new BorderLayout()); // Use border layout.
                this.pictureFrame.setDefaultCloseOperation
                (JFrame.DISPOSE_ON_CLOSE); // When closed, stop.
                this.pictureFrame.setTitle(picture.getTitle());
                PictureExplorerFocusTraversalPolicy newPolicy =
                        new PictureExplorerFocusTraversalPolicy();
                this.pictureFrame.setFocusTraversalPolicy(newPolicy);
        }

        /**
         * Creates the menu bar, menus, and menu items.
         */
        private void setUpMenuBar() {
                // Create menu bar.
                this.menuBar = new JMenuBar();

                // Create each sub-menu in the menu bar
                this.setUpMenuBar_FileMenu();
                this.setUpMenuBar_ZoomMenu();
                this.setUpMenuBar_PictureEffectsMenu();
                this.setUpMenuBar_FlipMenu();
                this.setUpMenuBar_ColorChangeMenu();
                this.setUpMenuBar_SeamCarvingMenu();

                // Set the menu bar to this menu.
                this.pictureFrame.setJMenuBar(menuBar);
        }

        /**
         * Creates the File Menu
         */
        private void setUpMenuBar_FileMenu(){
                // Add the file menu.
                this.fileMenu = new JMenu(STR_FILE);
                this.openMenuItem = new JMenuItem(STR_OPEN);
                this.resetMenuItem = new JMenuItem(STR_RESET);
                this.saveMenuItem = new JMenuItem(STR_SAVE);
                this.saveAsMenuItem = new JMenuItem(STR_SAVEAS);
                this.exitMenuItem = new JMenuItem(STR_EXIT);

                // Add the action listeners for the file menu.
                this.openMenuItem.addActionListener(this);
                this.resetMenuItem.addActionListener(this);
                this.saveMenuItem.addActionListener(this);
                this.saveAsMenuItem.addActionListener(this);
                this.exitMenuItem.addActionListener(this);

                // Add the menu items to the file menu.
                this.fileMenu.add(openMenuItem);
                this.fileMenu.add(resetMenuItem);
                this.fileMenu.addSeparator();
                this.fileMenu.add(saveMenuItem);
                this.fileMenu.add(saveAsMenuItem);
                this.fileMenu.addSeparator();
                this.fileMenu.add(exitMenuItem);
                this.menuBar.add(fileMenu);
        }

        /**
         * Creates the Zoom Menu
         */
        private void setUpMenuBar_ZoomMenu(){
                // Add the zoom menu.
                this.zoomMenu = new JMenu(STR_ZOOM);
                this.twentyFiveMenuItem = new JMenuItem(STR_25PERC);
                this.fiftyMenuItem = new JMenuItem(STR_50PERC);
                this.seventyFiveMenuItem = new JMenuItem(STR_75PERC);
                this.hundredMenuItem = new JMenuItem(STR_100PERC);
                this.hundredMenuItem.setEnabled(false);
                this.hundredFiftyMenuItem = new JMenuItem(STR_150PERC);
                this.twoHundredMenuItem = new JMenuItem(STR_200PERC);
                this.fiveHundredMenuItem = new JMenuItem(STR_500PERC);
                this.fiveThousandMenuItem = new JMenuItem(STR_5000PERC);

                // Add the action listeners for the zoom menu.
                this.twentyFiveMenuItem.addActionListener(this);
                this.fiftyMenuItem.addActionListener(this);
                this.seventyFiveMenuItem.addActionListener(this);
                this.hundredMenuItem.addActionListener(this);
                this.hundredFiftyMenuItem.addActionListener(this);
                this.twoHundredMenuItem.addActionListener(this);
                this.fiveHundredMenuItem.addActionListener(this);
                this.fiveThousandMenuItem.addActionListener(this);

                // Add the menu items to the zoom menu.
                this.zoomMenu.add(twentyFiveMenuItem);
                this.zoomMenu.add(fiftyMenuItem);
                this.zoomMenu.add(seventyFiveMenuItem);
                this.zoomMenu.add(hundredMenuItem);
                this.zoomMenu.add(hundredFiftyMenuItem);
                this.zoomMenu.add(twoHundredMenuItem);
                this.zoomMenu.add(fiveHundredMenuItem);
                this.zoomMenu.add(fiveThousandMenuItem);
                this.menuBar.add(zoomMenu);

        }
        /**
         * Creates the Picture Effects Menu
         */
        private void setUpMenuBar_PictureEffectsMenu(){
                // Add the picture effects menu.
                this.pictureEffectsMenu          = new JMenu(STR_PICTURE_EFFECTS);
                this.chromakeyMenuItem   = new JMenuItem(STR_CHROMAKEY);
                this.blurMenuItem                = new JMenuItem(STR_BLUR);
                this.showEdgesMenuItem   = new JMenuItem(STR_SHOW_EDGES);
                this.paintBucketMenuItem  = new JMenuItem(STR_PAINT_BUCKET);

                // Add the action listeners for the picture effects menu.
                this.chromakeyMenuItem.addActionListener(this);
                this.blurMenuItem.addActionListener(this);
                this.showEdgesMenuItem.addActionListener(this);
                this.paintBucketMenuItem.addActionListener(this);

                this.pictureEffectsMenu.add(chromakeyMenuItem);
                this.pictureEffectsMenu.add(blurMenuItem);
                this.pictureEffectsMenu.add(showEdgesMenuItem);
                this.pictureEffectsMenu.add(paintBucketMenuItem);
                this.menuBar.add(pictureEffectsMenu);
        }
        /**
         * Creates the Flip Menu
         */
        private void setUpMenuBar_FlipMenu(){
                // Add the rotate flip menu.
                this.rotateflipMenu              = new JMenu(STR_ROTATE_MENU);
                this.rotateMenuItem              = new JMenuItem(STR_ROTATE_RIGHT);
                this.flipHorzMenuItem    = new JMenuItem(STR_FLIP_HORIZONTAL);
                this.flipVertMenuItem    = new JMenuItem(STR_FLIP_VERTICAL);
                this.flipForwardMenuItem  = new JMenuItem(STR_FLIP_FORWARD);
                this.flipBackwardMenuItem = new JMenuItem(STR_FLIP_BACKWARD);

                // Add the action listeners for the rotate/flip effects menu.
                this.rotateMenuItem.addActionListener(this);
                this.flipHorzMenuItem.addActionListener(this);
                this.flipVertMenuItem.addActionListener(this);
                this.flipForwardMenuItem.addActionListener(this);
                this.flipBackwardMenuItem.addActionListener(this);

                this.rotateflipMenu.add(rotateMenuItem);
                this.rotateflipMenu.add(flipHorzMenuItem);
                this.rotateflipMenu.add(flipVertMenuItem);
                this.rotateflipMenu.add(flipForwardMenuItem);
                this.rotateflipMenu.add(flipBackwardMenuItem);
                this.menuBar.add(rotateflipMenu);

        }
        /**
         * Creates the Color Change Menu
         */
        private void setUpMenuBar_ColorChangeMenu(){
                // Add the color change menu
                this.changeColorMenu     = new JMenu(STR_COLOR_CHANGE);
                this.grayscaleMenuItem   = new JMenuItem(STR_GRAYSCALE);
                this.grayscaleMenuItem.setAccelerator(KeyStroke.getKeyStroke('0'));
                this.negateMenuItem              = new JMenuItem(STR_NEGATE);
                this.negateMenuItem.setAccelerator(KeyStroke.getKeyStroke('n'));
                this.lightenMenuItem     = new JMenuItem(STR_LIGHTEN);
                this.lightenMenuItem.setAccelerator(KeyStroke.getKeyStroke('+'));
                this.darkenMenuItem              = new JMenuItem(STR_DARKEN);
                this.darkenMenuItem.setAccelerator(KeyStroke.getKeyStroke('-'));
                this.addRedMenuItem              = new JMenuItem(STR_ADD_RED);
                this.addRedMenuItem.setAccelerator(KeyStroke.getKeyStroke('r'));
                this.addGreenMenuItem    = new JMenuItem(STR_ADD_GREEN);
                this.addGreenMenuItem.setAccelerator(KeyStroke.getKeyStroke('g'));
                this.addBlueMenuItem     = new JMenuItem(STR_ADD_BLUE);
                this.addBlueMenuItem.setAccelerator(KeyStroke.getKeyStroke('n'));

                // Add the action listeners for the color change menu.
                this.grayscaleMenuItem.addActionListener(this);
                this.negateMenuItem.addActionListener(this);
                this.lightenMenuItem.addActionListener(this);
                this.darkenMenuItem.addActionListener(this);
                this.addRedMenuItem.addActionListener(this);
                this.addGreenMenuItem.addActionListener(this);
                this.addBlueMenuItem.addActionListener(this);

                this.changeColorMenu.add(grayscaleMenuItem);
                this.changeColorMenu.add(negateMenuItem);
                this.changeColorMenu.add(lightenMenuItem);
                this.changeColorMenu.add(darkenMenuItem);
                this.changeColorMenu.add(addRedMenuItem);
                this.changeColorMenu.add(addGreenMenuItem);
                this.changeColorMenu.add(addBlueMenuItem);
                this.menuBar.add(changeColorMenu);

        }

        /**
         * Creates the Seam Carving Menu
         */
        private void setUpMenuBar_SeamCarvingMenu(){
                // Add the seam carving menu
                this.seamCarvingMenu     = new JMenu(STR_SEAM_CARVING);
                this.luminosityMenuItem          = new JMenuItem(STR_LUMINOSITY);
                this.luminosityMenuItem.setAccelerator(KeyStroke.getKeyStroke('l'));
                this.energyMenuItem              = new JMenuItem(STR_ENERGY);
                this.energyMenuItem.setAccelerator(KeyStroke.getKeyStroke('e'));
                this.showSeamMenuItem    = new JMenuItem(STR_SHOW_SEAM);
                this.showSeamMenuItem.setAccelerator(KeyStroke.getKeyStroke('s'));
                this.carveMenuItem               = new JMenuItem(STR_CARVE);
                this.carveMenuItem.setAccelerator(KeyStroke.getKeyStroke('c'));
                this.carveManyMenuItem   = new JMenuItem(STR_CARVE_MANY);
                this.carveManyMenuItem.setAccelerator(KeyStroke.getKeyStroke('m'));


                // Add the action listeners for the seam carving menu.
                this.luminosityMenuItem.addActionListener(this);
                this.energyMenuItem.addActionListener(this);
                this.showSeamMenuItem.addActionListener(this);
                this.carveMenuItem.addActionListener(this);
                this.carveManyMenuItem.addActionListener(this);

                this.seamCarvingMenu.add(luminosityMenuItem);
                this.seamCarvingMenu.add(energyMenuItem);
                this.seamCarvingMenu.add(showSeamMenuItem);
                this.seamCarvingMenu.add(carveMenuItem);
                this.seamCarvingMenu.add(carveManyMenuItem);
                this.menuBar.add(seamCarvingMenu);
        }
        /**
         * Creates and initializes the scrolling image.
         */
        private void createAndInitScrollingImage() {
                if (this.scrollPane != null) {
                        this.pictureFrame.getContentPane().remove(this.scrollPane);
                }

                this.scrollPane = new JScrollPane();

                BufferedImage bimg = this.picture.getBufferedImage();
                this.imageDisplay = new ImageDisplay(bimg);
                this.imageDisplay.addMouseMotionListener(this);
                this.imageDisplay.addMouseListener(this);
                this.imageDisplay.setToolTipText(imageDisplayTooltip);
                this.scrollPane.setViewportView(imageDisplay);

                this.pictureFrame.getContentPane().add(this.scrollPane, BorderLayout.CENTER);
                this.pictureFrame.validate();
                
                // Put the keyboard focus back on the picture.
                //   (which the above pictureFrame manipulation seems to lose.)
                this.scrollPane.requestFocusInWindow();
        }

        /**
         * Creates the JFrame and sets everything up.
         */
        private void createWindow() {
                // Create the picture frame and initializes it.
                this.createAndInitPictureFrame();

                // Set up the menu bar.
                this.setUpMenuBar();

                // Create the information panel.
                this.createInfoPanel();

                // Create the scrollpane for the picture.
                this.createAndInitScrollingImage();

                // Show the picture in the frame at the size it needs to be.
                this.pictureFrame.pack();
                this.pictureFrame.setVisible(true);
        }

        /**
         * Sets up the next and previous buttons for the pixel location
         * information.
         */
        private void setUpNextAndPreviousButtons() {
                // Create the image icons for the buttons.
                Icon prevIcon = new ImageIcon(
                                PictureExplorer.class.getResource("_leftArrow.gif"),
                "previous index");
                Icon nextIcon = new ImageIcon(
                                PictureExplorer.class.getResource("_rightArrow.gif"),
                "next index");

                // Create the arrow buttons.
                this.xPrevButton = new JButton(prevIcon);
                this.xNextButton = new JButton(nextIcon);
                this.yPrevButton = new JButton(prevIcon);
                this.yNextButton = new JButton(nextIcon);

                // Set the tool tip text.
                this.xNextButton.setToolTipText(xNextTooltip);
                this.xPrevButton.setToolTipText(xPrevTooltip);
                this.yNextButton.setToolTipText(yNextTooltip);
                this.yPrevButton.setToolTipText(yPrevTooltip);

                // Set the sizes of the buttons.
                int prevWidth = prevIcon.getIconWidth() + 2;
                int nextWidth = nextIcon.getIconWidth() + 2;
                int prevHeight = prevIcon.getIconHeight() + 2;
                int nextHeight = nextIcon.getIconHeight() + 2;
                Dimension prevDimension = new Dimension(prevWidth,prevHeight);
                Dimension nextDimension = new Dimension(nextWidth, nextHeight);
                this.xPrevButton.setPreferredSize(prevDimension);
                this.yPrevButton.setPreferredSize(prevDimension);
                this.xNextButton.setPreferredSize(nextDimension);
                this.yNextButton.setPreferredSize(nextDimension);

                // Handle previous x-button press.
                this.xPrevButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                xIndex--;
                                if (xIndex < 0)
                                        xIndex = 0;
                                displayPixelInformation(xIndex, yIndex);
                        }
                });

                // Handle previous y button press.
                yPrevButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                yIndex--;
                                if (yIndex < 0)
                                        yIndex = 0;
                                displayPixelInformation(xIndex, yIndex);
                        }
                });

                // Handle next x button press.
                xNextButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                xIndex++;
                                if (xIndex >= picture.getWidth())
                                        xIndex = picture.getWidth() - 1;
                                displayPixelInformation(xIndex, yIndex);
                        }
                });

                // Handle next y button press.
                yNextButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                yIndex++;
                                if (yIndex >= picture.getHeight())
                                        yIndex = picture.getHeight() - 1;
                                displayPixelInformation(xIndex, yIndex);
                        }
                });
        }

        /**
         * Creates the pixel location panel.
         *
         * @param labelFont The font for the labels.
         *
         * @return The location panel.
         */
        public JPanel createLocationPanel(Font labelFont) {

                // Create a location panel.
                JPanel locationPanel = new JPanel();
                locationPanel.setLayout(new FlowLayout());
                Box hBox = Box.createHorizontalBox();

                // Create the labels.
                this.xLabel = new JLabel("X:");
                this.yLabel = new JLabel("Y:");

                // Create the text fields.
                this.xValue = new JTextField(Integer.toString(xIndex + numberBase), 6);
                this.xValue.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                displayPixelInformation(xValue.getText(), yValue.getText());
                        }
                });
                this.yValue = new JTextField(Integer.toString(yIndex + numberBase), 6);
                this.yValue.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                displayPixelInformation(xValue.getText(), yValue.getText());
                        }
                });

                // Set up the next and previous buttons.
                this.setUpNextAndPreviousButtons();

                // Set up the font for the labels.
                this.xLabel.setFont(labelFont);
                this.yLabel.setFont(labelFont);
                this.xValue.setFont(labelFont);
                this.yValue.setFont(labelFont);

                // Add the items to the vertical box and the box to the panel.
                hBox.add(Box.createHorizontalGlue());
                hBox.add(xLabel);
                hBox.add(xPrevButton);
                hBox.add(xValue);
                hBox.add(xNextButton);
                hBox.add(Box.createHorizontalStrut(10));
                hBox.add(yLabel);
                hBox.add(yPrevButton);
                hBox.add(yValue);
                hBox.add(yNextButton);
                locationPanel.add(hBox);
                hBox.add(Box.createHorizontalGlue());

                return locationPanel;
        }

        /**
         * Creates the color information panel.
         *
         * @param labelFont The font to use for labels.
         *
         * @return the color information panel.
         */
        private JPanel createColorInfoPanel(Font labelFont) {
                // Create a color information panel.
                JPanel colorInfoPanel = new JPanel();
                colorInfoPanel.setLayout(new FlowLayout());

                // Get the pixel at the current x and y.
                Pixel pixel = picture.getPixel(xIndex, yIndex);

                // Create the labels.
                this.rLabel = new JLabel(redLabel);
                this.rValue = new JLabel(Integer.toString(pixel.getRed()));
                this.gLabel = new JLabel(greenLabel);
                this.gValue = new JLabel(Integer.toString(pixel.getGreen()));
                this.bLabel = new JLabel(blueLabel);
                this.bValue = new JLabel(Integer.toString(pixel.getBlue()));

                // Create the sample color panel and label.
                this.colorLabel = new JLabel("Color at location: ");
                this.colorPanel = new JPanel();
                this.colorPanel.setBorder(new LineBorder(Color.black, 1));

                // Set the color sample to the pixel color.
                this.colorPanel.setBackground(pixel.getColor());

                // Set the font.
                this.rLabel.setFont(labelFont);
                this.rValue.setFont(labelFont);
                this.gLabel.setFont(labelFont);
                this.gValue.setFont(labelFont);
                this.bLabel.setFont(labelFont);
                this.bValue.setFont(labelFont);
                this.colorLabel.setFont(labelFont);
                this.colorPanel.setPreferredSize(new Dimension(25, 25));

                // Add items to the color information panel.
                colorInfoPanel.add(rLabel);
                colorInfoPanel.add(rValue);
                colorInfoPanel.add(gLabel);
                colorInfoPanel.add(gValue);
                colorInfoPanel.add(bLabel);
                colorInfoPanel.add(bValue);
                colorInfoPanel.add(colorLabel);
                colorInfoPanel.add(colorPanel);

                return colorInfoPanel;
        }

        /**
         * Creates the north JPanel with all the pixel location
         * and color information.
         */
        private void createInfoPanel() {
                // Create the info panel and set the layout.
                JPanel infoPanel = new JPanel();
                infoPanel.setLayout(new BorderLayout());

                // Create the font.
                Font largerFont = new Font(infoPanel.getFont().getName(),
                                infoPanel.getFont().getStyle(), 14);

                // Create the pixel location panel.
                JPanel locationPanel = createLocationPanel(largerFont);

                // Create the color information panel.
                JPanel colorInfoPanel = createColorInfoPanel(largerFont);

                // Add the panels to the info panel.
                infoPanel.add(BorderLayout.NORTH, locationPanel);
                infoPanel.add(BorderLayout.SOUTH, colorInfoPanel);

                // Add the info panel.
                pictureFrame.getContentPane().add(BorderLayout.NORTH, infoPanel);
        }

        /**
         * Checks that the current position is in the viewing area and if
         *      not, scroll to center the current position, if possible.
         */
        public void checkScroll() {
                // Get the x and y position in pixels.
                int xPos = (int) (xIndex * zoomFactor);
                int yPos = (int) (yIndex * zoomFactor);

                // Only do this if the image is larger than normal.
                if (zoomFactor > 1) {

                        // Get the rectangle that defines the current view.
                        JViewport viewport = scrollPane.getViewport();
                        Rectangle rect = viewport.getViewRect();
                        int rectWidth = (int) rect.getWidth();
                        int rectHeight = (int) rect.getHeight();

                        // Get the maximum possible x and y index.
                        int maxIndexX = (int) (picture.getWidth() * zoomFactor)
                        - rectWidth - 1;
                        int maxIndexY = (int) (picture.getHeight() * zoomFactor)
                        - rectHeight - 1;

                        /* Calculate how to position the current position in the
                         * middle of the viewing area. */
                        int viewX = xPos - (int) (rectWidth / 2);
                        int viewY = yPos - (int) (rectHeight / 2);

                        // Reposition the viewX and viewY if outside allowed values.
                        if (viewX < 0) {
                                viewX = 0;
                        }
                        else if (viewX > maxIndexX) {
                                viewX = maxIndexX;
                        }
                        if (viewY < 0) {
                                viewY = 0;
                        }
                        else if (viewY > maxIndexY) {
                                viewY = maxIndexY;
                        }

                        // Move the viewport upper left point.
                        viewport.scrollRectToVisible(new Rectangle(viewX,
                                        viewY, rectWidth, rectHeight));
                }
        }

        /**
         * Zooms in on the picture by scaling the image.
         * Caution: It is extremely memory intensive.
         *
         * @param factor The amount to zoom by.
         */
        public void zoom(double factor) {
                // Save the current zoom factor.
                this.zoomFactor = factor;

                // Calculate the new width and height and get an image that size.
                int width = (int)(this.picture.getWidth() * this.zoomFactor);
                int height = (int)(this.picture.getHeight() * this.zoomFactor);
                BufferedImage bimg = this.picture.getBufferedImage();

                // Set the scroll image icon to the new image.
                this.imageDisplay.setImage(bimg.getScaledInstance(width, height,
                                Image.SCALE_DEFAULT));
                this.imageDisplay.setCurrentX((int) (this.xIndex * this.zoomFactor));
                this.imageDisplay.setCurrentY((int) (this.yIndex * this.zoomFactor));
                this.imageDisplay.revalidate();
                checkScroll();  // Check if need to reposition scroll.
        }

        /**
         * Repaints the image on the scrollpane.
         */
        public void repaint() {
                this.pictureFrame.repaint();
        }

        ///////////////////////////// Event Listeners /////////////////////////////

        /**
         * Called when the mouse is dragged (button held down and moved).
         *
         * @param e the mouse event
         */
        public void mouseDragged(MouseEvent e) {
                this.displayPixelInformation(e);
        }

        /**
         * Checks if the given x and y coordinates
         *      are in the picture.
         *
         * @param x The horizontal coordinate.
         * @param y The vertical coordinate.
         *
         * @return True, if the horizontal and vertical coordinates provided
         *      are in the picture; false, otherwise.
         */
        private boolean isLocationInPicture(int x, int y) {
                boolean result = false; // Default is false.
                if (x >= 0 && x < picture.getWidth() &&
                                y >= 0 && y < picture.getHeight()) {
                        result = true;
                }
                return result;
        }

        /**
         * Displays the pixel information from the x and y
         *      coordinates provided.
         *
         * @param xString The x value as a String from the user.
         * @param yString The y value as a String from the user.
         */
        public void displayPixelInformation(String xString, String yString) {
                int x = -1;
                int y = -1;
                try {
                        x = Integer.parseInt(xString);
                        x = x - numberBase;
                        y = Integer.parseInt(yString);
                        y = y - numberBase;
                } catch (Exception ex) {
                }

                if (x >= 0 && y >= 0) {
                        displayPixelInformation(x,y);
                }
        }

        /**
         * Display pixel information for the x and y
         *      coordinates provided.
         *
         * @param pictureX The x value in the picture.
         * @param pictureY the y value in the picture.
         */
        private void displayPixelInformation(int pictureX, int pictureY) {
                // Check that this x and y is in range.
                if (isLocationInPicture(pictureX, pictureY))
                {
                        // Save the current x and y index.
                        this.xIndex = pictureX;
                        this.yIndex = pictureY;

                        // Get the pixel at the x and y provided.
                        Pixel pixel = this.picture.getPixel(this.xIndex, this.yIndex);

                        // Set the values based on the pixel.
                        this.xValue.setText(Integer.toString(this.xIndex + this.numberBase));
                        this.yValue.setText(Integer.toString(this.yIndex + this.numberBase));

                        int redValue = pixel.getRed();
                        int greenValue = pixel.getGreen();
                        int blueValue = pixel.getBlue();
                        this.rValue.setText(Integer.toString(redValue));
                        this.gValue.setText(Integer.toString(greenValue));
                        this.bValue.setText(Integer.toString(blueValue));
                        this.colorPanel.setBackground(
                                        new Color(redValue, greenValue, blueValue));
                        if (this.scrollPane != null) {
                        	         this.scrollPane.requestFocusInWindow();
                        }

                } else {
                        this.clearInformation();
                }

                // Notify the image display of the current x and y.
                this.imageDisplay.setCurrentX((int) (this.xIndex * this.zoomFactor));
                this.imageDisplay.setCurrentY((int) (this.yIndex * this.zoomFactor));
        }

        /**
         * Displays pixel information based on a mouse event.
         *
         * @param e The mouse event.
         */
        private void displayPixelInformation(MouseEvent e) {
                // Get the cursor x- and y-coordinate.
                int cursorX = e.getX();
                int cursorY = e.getY();

                // Get the x and y in original (not scaled) image.
                int pictureX = (int) (cursorX / this.zoomFactor + this.numberBase);
                int pictureY = (int) (cursorY / this.zoomFactor + this.numberBase);

                // Display the information for this x and y.
                this.displayPixelInformation(pictureX, pictureY);
        }

        /**
         * Clears the labels and current color and resets the current index to -1.
         */
        private void clearInformation() {
                this.xValue.setText(cannotShowText);
                this.yValue.setText(cannotShowText);
                this.rValue.setText(cannotShowText);
                this.gValue.setText(cannotShowText);
                this.bValue.setText(cannotShowText);
                this.colorPanel.setBackground(Color.black);
                this.xIndex = -1;
                this.yIndex = -1;
        }

        /**
         * Called when the mouse is moved with no buttons down.
         *
         * @param e The mouse event.
         */
        public void mouseMoved(MouseEvent e) {}

        /**
         * Called when the mouse is clicked.
         *
         * @param e The mouse event.
         */
        public void mouseClicked(MouseEvent e) {
                this.displayPixelInformation(e);
        }

        /**
         * Called when the mouse button is pushed down.
         *
         * @param e The mouse event.
         */
        public void mousePressed(MouseEvent e) {
                this.displayPixelInformation(e);
        }

        /**
         * Called when the mouse button is released.
         *
         * @param e The mouse event.
         */
        public void mouseReleased(MouseEvent e) { }

        /**
         * Called when the component is entered (mouse moves over it).
         *
         * @param e The mouse event.
         */
        public void mouseEntered(MouseEvent e) {
        }

        /**
         * Called when the mouse moves over the component.
         *
         * @param e The mouse event
         */
        public void mouseExited(MouseEvent e) { }

        /**
         * Enables all zoom menu commands.
         */
        private void enableZoomItems() {
                this.twentyFiveMenuItem.setEnabled(true);
                this.fiftyMenuItem.setEnabled(true);
                this.seventyFiveMenuItem.setEnabled(true);
                this.hundredMenuItem.setEnabled(true);
                this.hundredFiftyMenuItem.setEnabled(true);
                this.twoHundredMenuItem.setEnabled(true);
                this.fiveHundredMenuItem.setEnabled(true);
                this.fiveThousandMenuItem.setEnabled(true);
        }


        /**
         * Controls the menu bar.
         *
         * @param a the ActionEvent
         */
        public void actionPerformed(ActionEvent a) {
                // Actions reset the zoom (so update the zoom menu)
                this.enableZoomItems();
                this.hundredMenuItem.setEnabled(false);

                if (a.getActionCommand().equals(STR_OPEN)) {
                        this.fileName = FileChooser.pickAFile(FileChooser.OPEN);

                        if (this.fileName != null) {
                                try {
                                        this.picture.loadOrFail(this.fileName);
                                        this.pictureFrame.setTitle(this.picture.getTitle());
                                        this.createAndInitScrollingImage();
                                } catch (IOException e) {
                                        JOptionPane.showMessageDialog(pictureFrame,
                                                    "Could not open file: " + this.fileName,
                                                    "Open Error",
                                                    JOptionPane.ERROR_MESSAGE);
                                }
                        }
                }
                if (a.getActionCommand().equals(STR_RESET)) {
                        //System.out.println("RESET");
                        if (this.fileName != null) {
                                //System.out.println("non null");
                                try {
                                        this.picture.loadOrFail(this.fileName);
                                        this.createAndInitScrollingImage();
                                } catch (IOException e) {
                                        JOptionPane.showMessageDialog(pictureFrame,
                                                    "Could not open file: " + this.fileName,
                                                    "Open Error",
                                                    JOptionPane.ERROR_MESSAGE);
                                }
                        } else {
                                System.out.println("There was no filename associated with this Picture.");
                        }
                }
                if (a.getActionCommand().equals(STR_SAVE)) {
                        this.saveFile();
                }

                if (a.getActionCommand().equals(STR_SAVEAS)) {
                        String fileName = FileChooser.pickAFile(FileChooser.SAVE);

                        if (fileName != null) {
                                try {
                                        String extension = this.picture.getExtension();

                                        // User may have provided a file extension.
                                        int posDot = fileName.indexOf('.');
                                        if (posDot >= 0)
                                                extension = fileName.substring(posDot + 1);
                                        else
                                                fileName = fileName + "." + extension;

                                        File file = new File(fileName);

                                        ImageIO.write(this.picture.getBufferedImage(),
                                                        this.picture.getExtension(), file);
                                        
                                        this.fileName = fileName;
                                } catch (IOException e) {
                                        JOptionPane.showMessageDialog(this.pictureFrame,
                                                    "Could not save file. If you have added an " +
                                                    "image extension (such as JPG or BMP), please" +
                                                    "ensure that the extension is a vaild one.",
                                                    "Save Error",
                                                    JOptionPane.ERROR_MESSAGE);
                                }
                        }
                }

                if (a.getActionCommand().equals(STR_EXIT)) {
                        System.exit(0);
                }

                if (a.getActionCommand().equals(STR_25PERC)) {
                        zoom(.25);
                        enableZoomItems();
                        twentyFiveMenuItem.setEnabled(false);
                }

                if (a.getActionCommand().equals(STR_50PERC)) {
                        zoom(.50);
                        enableZoomItems();
                        fiftyMenuItem.setEnabled(false);
                }

                if (a.getActionCommand().equals(STR_75PERC)) {
                        zoom(.75);
                        enableZoomItems();
                        seventyFiveMenuItem.setEnabled(false);
                }

                if (a.getActionCommand().equals(STR_100PERC)) {
                        zoom(1.0);
                        enableZoomItems();
                        hundredMenuItem.setEnabled(false);
                }

                if (a.getActionCommand().equals(STR_150PERC)) {
                        zoom(1.5);
                        enableZoomItems();
                        hundredFiftyMenuItem.setEnabled(false);
                }

                if (a.getActionCommand().equals(STR_200PERC)) {
                        zoom(2.0);
                        enableZoomItems();
                        twoHundredMenuItem.setEnabled(false);
                }

                if (a.getActionCommand().equals(STR_500PERC)) {
                        zoom(5.0);
                        enableZoomItems();
                        fiveHundredMenuItem.setEnabled(false);
                }
                if (a.getActionCommand().equals(STR_5000PERC)) {
                        zoom(50.0);
                        enableZoomItems();
                        fiveThousandMenuItem.setEnabled(false);
                }

                if (a.getActionCommand().equals(STR_GRAYSCALE)) {
                        picture = new Picture(picture.grayscale());
                        createAndInitScrollingImage();
                }
                if (a.getActionCommand().equals(STR_NEGATE)) {
                        picture = new Picture(picture.negate());
                        createAndInitScrollingImage();
                }
                if (a.getActionCommand().equals(STR_CHROMAKEY)) {
                        int threshold =  getParameterValue("the color threshold", 1, 100);
                        picture = new Picture(picture.chromaKey(xIndex, yIndex, new Picture(FileChooser.pickAFile(FileChooser.OPEN)), threshold));
                        createAndInitScrollingImage();
                }
                if (a.getActionCommand().equals(STR_ROTATE_RIGHT)) {
                        picture = new Picture(picture.rotateRight());
                        createAndInitScrollingImage();
                }
                if (a.getActionCommand().equals(STR_BLUR)) {
                        int blurThreshold =  getParameterValue("the blur threshold", 1, 5);
                        picture = new Picture(picture.blur(blurThreshold));
                        createAndInitScrollingImage();
                }
                if (a.getActionCommand().equals(STR_SHOW_EDGES)) {
                        int threshold =  getParameterValue("the edge threshold", 1, 100);
                        picture = new Picture(picture.showEdges(threshold));
                        createAndInitScrollingImage();
                }
                if (a.getActionCommand().equals(STR_FLIP_HORIZONTAL)) {
                        picture = picture.flip(Picture.HORIZONTAL);
                        createAndInitScrollingImage();
                }
                if (a.getActionCommand().equals(STR_FLIP_VERTICAL)) {
                        picture = picture.flip(Picture.VERTICAL);
                        createAndInitScrollingImage();
                }
                if (a.getActionCommand().equals(STR_FLIP_FORWARD)) {
                        picture = picture.flip(Picture.FORWARD_DIAGONAL);
                        // repaint();
                        createAndInitScrollingImage();
                }
                if (a.getActionCommand().equals(STR_FLIP_BACKWARD)) {
                        picture = picture.flip(Picture.BACKWARD_DIAGONAL);
                        // repaint();
                        createAndInitScrollingImage();
                }
                if (a.getActionCommand().equals(STR_PAINT_BUCKET)) {
                        int threshold =  getParameterValue("the color threshold", 1, 100);
                        picture = new Picture(picture.paintBucket(xIndex, yIndex, threshold, new Color(0, 0, 255)));
                        createAndInitScrollingImage();
                }
                if (a.getActionCommand().equals(STR_LIGHTEN)) {
                        int value =  getParameterValue("the amount to increase all colors ", 1, 255);
                        picture = new Picture(picture.lighten(value));
                        createAndInitScrollingImage();
                }
                if (a.getActionCommand().equals(STR_DARKEN)) {
                        int value =  getParameterValue("the amount to decrease all colors ", 1, 255);
                        picture = new Picture(picture.darken(value));
                        createAndInitScrollingImage();
                }
                if (a.getActionCommand().equals(STR_ADD_RED)) {
                        int value =  getParameterValue("the amount to increase red", 1, 255);
                        picture = new Picture(picture.addRed(value));
                        createAndInitScrollingImage();
                }
                if (a.getActionCommand().equals(STR_ADD_GREEN)) {
                        int value =  getParameterValue("the amount to increase green", 1, 255);
                        picture = new Picture(picture.addGreen(value));
                        createAndInitScrollingImage();
                }
                if (a.getActionCommand().equals(STR_ADD_BLUE)) {
                        int value =  getParameterValue("the amount to increase blue", 1, 255);
                        picture = new Picture(picture.addBlue(value));
                        createAndInitScrollingImage();
                }
                if (a.getActionCommand().equals(STR_LUMINOSITY)) {
                		   picture.luminosity().show();
                        // picture = picture.luminosity();
                        createAndInitScrollingImage();
                }
                if (a.getActionCommand().equals(STR_ENERGY)) {
                        picture.energy().show();
                        // picture = picture.energy();
                        createAndInitScrollingImage();
                }
                if (a.getActionCommand().equals(STR_SHOW_SEAM)) {
                        picture.showSeam().show();
                        // picture = picture.showSeam();
                        createAndInitScrollingImage();
                }
                if (a.getActionCommand().equals(STR_CARVE)) {
                        picture = picture.carve();
                        createAndInitScrollingImage();
                }
                if (a.getActionCommand().equals(STR_CARVE_MANY)) {
                        int value =  getParameterValue("the number of seams to carve", 1, picture.getWidth());
                        picture = new Picture(picture.carveMany(value));
                        createAndInitScrollingImage();
                }

        }

        /**
         * Saves the file corresponding to the current picture.
         */
        private void saveFile() {
                File file = new File(this.fileName);

                try {
                        ImageIO.write(this.picture.getBufferedImage(),
                                        this.picture.getExtension(), file);
                } catch (IOException e) {
                        JOptionPane.showMessageDialog(this.pictureFrame,
                                    "Could not save file.",
                                    "Save Error",
                                    JOptionPane.WARNING_MESSAGE);
                }

        }

        /**
         * Handle input to functions
         */
        public int getParameterValue(String parameterName, int min, int max) {
                String inputValue = JOptionPane
                                .showInputDialog("Please input a value for " + parameterName
                                                + " in the range of " + min + " to " + max);
                try {
                        // the String to int conversion happens here
                        int i = Integer.parseInt(inputValue.trim());
                        if (i > max) {
                                JOptionPane.showMessageDialog(null, "Your input " + inputValue
                                                + " for " + parameterName
                                                + " was too large. The maximum value " + max
                                                + " will be used.", "Invalid Input",
                                                JOptionPane.ERROR_MESSAGE);
                                return max;
                        } else if (i < min) {
                                JOptionPane.showMessageDialog(null, "Your input " + inputValue
                                                + " for " + parameterName
                                                + " was too small. The minimum value " + min
                                                + " will be used.", "Invalid Input",
                                                JOptionPane.ERROR_MESSAGE);
                                return min;
                        } else {
                                // they provide input in a valid range.
                                return i;
                        }
                } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Your input " + inputValue
                                        + " for " + parameterName
                                        + " was invalid. The minimum value " + min
                                        + " will be used.", "Invalid Input",
                                        JOptionPane.ERROR_MESSAGE);
                        return min;
                }

        }
        /**
         * Class for establishing the focus for the textfields.
         */
        private class PictureExplorerFocusTraversalPolicy
        extends FocusTraversalPolicy {

                /**
                 * Gets the next component for focus.
                 */
                public Component getComponentAfter(Container focusCycleRoot,
                                Component aComponent) {
                        if (aComponent.equals(xValue))
                                return yValue;
                        else
                                return xValue;
                }


                /**
                 * Gets the previous component for focus.
                 */
                public Component getComponentBefore(Container focusCycleRoot,
                                Component aComponent) {
                        if (aComponent.equals(xValue))
                                return yValue;
                        else
                                return xValue;
                }

                public Component getDefaultComponent(Container focusCycleRoot) {
                        return xValue;
                }

                public Component getLastComponent(Container focusCycleRoot) {
                        return yValue;
                }

                public Component getFirstComponent(Container focusCycleRoot) {
                        return xValue;
                }
        }

} // End of PictureExplorer class.
