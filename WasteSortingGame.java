package ui;

import model.WSGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// This class represents the main game window.
public class WasteSortingGame extends JFrame {
    private WSGame game; // The game logic
    private GamePanel gamePanel; // Panel for rendering the game
    private static final int INTERVAL = 5; // Timer interval for game updates
    private Timer timer; // Timer for game updates
    private ScorePanel scorePanel; // Panel for displaying the player's score

    // Constructor
    public WasteSortingGame() {
        super("Waste Sorting Game"); // Set the window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application on window close
        game = new WSGame(); // Create the game logic instance
        gamePanel = new GamePanel(game); // Create the game rendering panel
        scorePanel = new ScorePanel(game); // Create the score panel
        add(gamePanel); // Add the game rendering panel
        add(scorePanel, BorderLayout.NORTH); // Add the score panel at the top
        pack(); // Pack the components
        addKeyListener(new KeyHandler()); // Add key listener for game controls
        centreOnScreen(); // Center the frame on the screen
        setVisible(true); // Make the frame visible
        addTimer(); // Set up and start the game timer
        timer.start();
        game.addObserver(scorePanel); // Add the score panel as an observer to the game logic
    }

    // Center the frame on the screen
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize(); // Get screen dimensions
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2); // Calculate center position
    }

    // A key handler to respond to key events
    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            game.keyPressed(e.getKeyCode()); // Pass the key code to the game logic
        }
    }

    // Set up the game timer
    private void addTimer() {
        timer = new Timer(INTERVAL, ae -> {
            game.update(this); // Update the game logic
            gamePanel.repaint(); // Repaint the game panel
        });
    }

    // Stop the game timer
    public void stopTimer() {
        timer.stop();
    }

    // Entry point for the application
    public static void main(String[] args) {
        new InstructionFrame(); // Start the game by opening the instruction frame
    }
}
