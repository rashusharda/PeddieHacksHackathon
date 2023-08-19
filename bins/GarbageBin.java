package model.bins;

import java.awt.Color;

// This class represents the Garbage Bin
public class GarbageBin extends Bin {

    private static final Color COLOR = new Color(23, 23, 23);
    private static final String IMAGE_PATH = "src/data/images/bins/garbage_bin.png";

    // Constructor
    public GarbageBin() {
        super("Garbage Bin", 700); // Initialize the bin with the name and x-coordinate
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
