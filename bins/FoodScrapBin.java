package model.bins;

import java.awt.Color;

// This class represents the Food Scrap Bin
public class FoodScrapBin extends Bin {

    private static final Color COLOR = new Color(16, 188, 83);
    private static final String IMAGE_PATH = "src/data/images/bins/food_scrap_bin_green.png";

    // Constructor
    public FoodScrapBin() {
        super("Food Scrap \nBin", 100); // Initialize the bin with the name and x-coordinate
        color = COLOR; // Set the color of the bin

        // Load the bin image
        imagePath = IMAGE_PATH;
    }

    // Get the path to the bin image
    @Override
    protected String getPath() {
        return IMAGE_PATH;
    }

    // The render method is inherited from the Bin class and does not need to be overridden
    // It will render the bin image along with its name
}
