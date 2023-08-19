package model;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;
import model.bins.Bin;
import model.bins.FoodScrapBin;
import model.bins.GarbageBin;
import model.bins.PaperBin;
import model.bins.RecyclableContainersBin;
import model.wasteItems.BananaPeel;
import model.wasteItems.GlassBottle;
import model.wasteItems.Letter;
import model.wasteItems.Magazine;
import model.wasteItems.MilkBox;
import model.wasteItems.Newspaper;
import model.wasteItems.PlasticBag;
import model.wasteItems.WasteItem;
import ui.WasteSortingGame;
import ui.GameOverFrame;

// This class represents the main game logic
public class WSGame extends Observable {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    // X coordinates for bins
    public static final int firstX = 100;
    public static final int secondX = 300;
    public static final int thirdX = 500;
    public static final int fourthX = 700;

    // Constants for event notifications
    public static final String CORRECTLY_SORTED = "CORRECTLY SORTED";
    public static final String MISPLACED = "WASTE MISPLACED";
    public static final String GameStarts = "GAME STARTS NOW!";

    private List<Bin> bins;
    private FoodScrapBin foodScrapBin;
    private GarbageBin garbageBin;
    private PaperBin paperBin;
    private RecyclableContainersBin recyclableBin;
    private int count;
    private boolean isGameOver;
    private int correctlySorted;
    private int incorrectlySorted;
    private WasteItem itemOnScreen;

    // Random number generator
    public static final Random RND = new Random();
    public static final int smallSize = 10;

    // Constructor
    public WSGame() {
        initializeItems();
        reset();
    }

    // Set difficulty level based on action event
    public static void setDifficultyLevel(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Medium":
                WasteItem.setMedSpeed();
                break;
            case "Difficult":
                WasteItem.setHighSpeed();
                break;
            case "Easy":
                WasteItem.setLowSpeed();
                break;
            default:
                throw new Error("wrong difficulty level");
        }
    }

    // Getters for correct and incorrect items
    public int getCorrectItems() {
        return this.correctlySorted;
    }

    public int getIncorrectItems() {
        return this.incorrectlySorted;
    }

    // Initialize the game items and bins
    private void initializeItems() {
        this.count = 0;
        this.itemOnScreen = getNext();
        this.foodScrapBin = new FoodScrapBin();
        this.garbageBin = new GarbageBin();
        this.paperBin = new PaperBin();
        this.recyclableBin = new RecyclableContainersBin();
        this.bins = new ArrayList<>();
        this.bins.add(this.foodScrapBin);
        this.bins.add(this.garbageBin);
        this.bins.add(this.paperBin);
        this.bins.add(this.recyclableBin);
    }

    // Generate a specific waste item based on an index
    public WasteItem generateItem(int i) {
        // ...
    }

    // Reset the game to its initial state
    private void reset() {
        this.isGameOver = false;
        this.count = 0;
        this.correctlySorted = 0;
        this.incorrectlySorted = 0;
        setChanged();
        notifyObservers(GameStarts);
    }

    // Update the game state
    public void update(WasteSortingGame wsFrame) {
        moveItem();
        checkGameOver(wsFrame);
    }

    // Handle key press events
    public void keyPressed(int keyCode) {
        // ...
    }

    // Speed up the falling waste item
    private void speedUpDy() {
        this.itemOnScreen.speedUp();
    }

    // Move the waste item
    private void moveItem() {
        // ...
    }

    // Check if a waste item falls beyond the screen
    public boolean checkFalls() {
        return (this.itemOnScreen.getY() >= 600 - Bin.getSizeY());
    }

    // Check if a waste item is correctly sorted
    public boolean correctlySorted() {
        // ...
    }

    // Generate a new waste item that falls
    public void newItemFalls() {
        // ...
    }

    // Make a waste item fall
    private void itemFalls(WasteItem item) {
        this.itemOnScreen = item;
    }

    // Get the next waste item to fall
    private WasteItem getNext() {
        // ...
    }

    // Check if the game is over
    public void checkGameOver(WasteSortingGame wsFrame) {
        // ...
    }

    // Check if the game is over
    public boolean isOver() {
        return this.isGameOver;
    }

    // Render the game elements
    public void render(Graphics g) {
        if (!this.isGameOver)
            this.itemOnScreen.render(g);
        for (Bin bin : this.bins)
            bin.render(g);
    }
}
