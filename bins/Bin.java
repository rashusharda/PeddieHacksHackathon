package model.bins;

import model.WSGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

// This abstract class represents a bin for waste items
public abstract class Bin {

    // Constants for size and coordinates
    protected static final int SIZE_X = 100;
    protected static final int SIZE_Y = 90;
    protected int x;
    protected int y;
    protected Color color;
    protected String imagePath;

    protected String name;
    protected Image i;
    private int lineHeight;

    // Constructor
    public Bin(String name, int x) {
        this.name = name;
        this.x = x;
        this.y = WSGame.HEIGHT - SIZE_Y / 2;

        // Load bin image
        try {
            i = ImageIO.read(new File(getPath())).getScaledInstance(SIZE_X, SIZE_Y, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("fail to read image of bins");
        }
    }

    // Get the path to the bin image
    protected abstract String getPath();

    // Render the bin and its name
    public void render(Graphics g) {
        Color savedCol = g.getColor();
        g.setColor(color);
        lineHeight = g.getFontMetrics().getHeight();
        drawString(g, name, x - SIZE_X / 2, y);
        g.drawImage(i, x - SIZE_X / 2, y - SIZE_Y, null);
        g.setColor(savedCol);
    }

    // Draw a string with line breaks
    private void drawString(Graphics g, String str, int x, int y) {
        g.setColor(color.WHITE);
        g.setFont(new Font("Arial Black", Font.BOLD, 14));
        for (String line : name.split("\n"))
            g.drawString(line, x, y += lineHeight);
    }
}
