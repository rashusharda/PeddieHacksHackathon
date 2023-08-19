package model.bins;

import java.awt.Color;

// This class represents the Paper Bin
public class PaperBin extends Bin {

    // Color of the Paper Bin
    private static final Color COLOR = new Color(46, 81, 175);

    // Path to the image file of the Paper Bin
    private static final String IMAGE_PATH = "src/data/images/bins/paper_bin_blue.png";

    // Constructor to create a Paper Bin
    public PaperBin() {
        super("Paper Bin", 500); // Initialize the bin with the name and x-coordinate
        this.color = COLOR; // Set the color of the bin

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
