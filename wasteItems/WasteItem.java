package model.wasteItems;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.bins.Bin;

// This is an abstract class representing a Waste Item
public abstract class WasteItem {

    private static int dy;

    // Constants for different speed levels
    private static final int normalSpeed = 1;
    private static final int mediumSpeed = 2;
    private static final int fastSpeed = 3;

    // Default speed for waste items
    private static int defaultSpeed = 1;

    private static final int dropSpeed = 30;

    protected String name;

    protected int x;
    protected int y;

    protected int SIZE_X = 60;
    protected int SIZE_Y = 60;

    protected String belongedBin;
    protected int codeNum;

    protected Image i;
    protected String imagePath;

    // Constructor to create a Waste Item
    public WasteItem(int x) {
        this.x = x;
        this.y = 0;
        dy = defaultSpeed;

        try {
            // Load the waste item image
            this.i = ImageIO.read(new File(getPath())).getScaledInstance(this.SIZE_X, this.SIZE_Y, 1);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("fail to read image of bins");
        }
    }

    // Methods to set different speed levels
    public static void setLowSpeed() {
        defaultSpeed = 1;
    }

    public static void setHighSpeed() {
        defaultSpeed = 3;
    }

    public static void setMedSpeed() {
        defaultSpeed = 2;
    }

    // Abstract method to get the path to the waste item image
    protected abstract String getPath();

    public int getCode() {
        return this.codeNum;
    }

    // Move the waste item downward
    public void move() {
        if (this.y + dy >= 600 - Bin.getSizeY()) {
            this.y = 600 - Bin.getSizeY();
        } else {
            this.y += dy;
        }
    }

    // Move the waste item to the left
    public void moveLeft() {
        switch (this.x) {
            case 500:
                this.x = 300;
                return;
            case 700:
                this.x = 500;
                return;
        }
        this.x = 100;
    }

    // Move the waste item to the right
    public void moveRight() {
        switch (this.x) {
            case 100:
                this.x = 300;
                return;
            case 300:
                this.x = 500;
                return;
        }
        this.x = 700;
    }

    // Speed up the downward movement of the waste item
    public void speedUp() {
        dy = dropSpeed;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public String getBelongedBin() {
        return this.belongedBin;
    }

    // Render the waste item on the screen
    public void render(Graphics g) {
        Color savedCol = g.getColor();
        g.drawImage(this.i, this.x - this.SIZE_X / 2, this.y, null);
        g.setColor(Color.WHITE);
        g.drawString(this.name, this.x - this.SIZE_X / 2, this.y + this.SIZE_Y);
        g.setColor(savedCol);
    }
}
