package ui;

import model.WSGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

// This class represents the panel where the game is rendered.
public class GamePanel extends JPanel {
    // Constants for game over messages
    private static final String OVER = "Game Over!";
    private static final String REPLAY = "R to replay";

    // Image source for the background
    private static final String imagePath = "src/data/images/background.jpg";

    private WSGame game; // The game logic
    private Image bgImg; // Background image

    // Constructor
    public GamePanel(WSGame g) {
        setPreferredSize(new Dimension(WSGame.WIDTH, WSGame.HEIGHT)); // Set the panel size
        this.game = g; // Set the game logic
        try {
            bgImg = ImageIO.read(new File(imagePath)).getScaledInstance(WSGame.WIDTH, WSGame.HEIGHT, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            System.out.print("fail to load background image");
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bgImg, 0, 0, null); // Draw the background image
        renderGame(g); // Draw the game elements

        if (game.isOver()) {
            gameOver(g); // Display game over message
        }
    }

    // Draw the "game over" message and replay instructions
    private void gameOver(Graphics g) {
        Color saved = g.getColor(); // Save the current color
        g.setColor(new Color(0, 0, 0)); // Set color for text
        g.setFont(new Font("Arial", Font.BOLD, 20)); // Set font for text
        FontMetrics fm = g.getFontMetrics(); // Get font metrics for text positioning
        centreString(OVER, g, fm, WSGame.HEIGHT / 2); // Display "Game Over!" centered
        centreString(REPLAY, g, fm, WSGame.HEIGHT / 2 + 40); // Display "R to replay" centered below
        g.setColor(saved); // Restore the original color
    }

    // Draw the game elements
    private void renderGame(Graphics g) {
        game.render(g); // Call the game's render method to draw game elements
    }

    // Center a string on the screen
    private void centreString(String str, Graphics g, FontMetrics fm, int yPos) {
        int width = fm.stringWidth(str); // Get the width of the string
        g.drawString(str, (WSGame.WIDTH - width) / 2, yPos); // Draw the string centered horizontally
    }
}
