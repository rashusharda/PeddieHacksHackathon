package model.bins;

import java.awt.Color;

// This class represents the Recyclable Containers Bin
public class RecyclableContainersBin extends Bin {

    // Color of the Recyclable Containers Bin
    private static final Color COLOR = new Color(184, 184, 184);

    // Path to the image file of the Recyclable Containers Bin
    private static final String IMAGE_PATH = "src/data/images/bins/container_bin_grey.png";

    // Constructor to create a Recyclable Containers Bin
    public RecyclableContainersBin() {
        super("Recyclable \nContainers Bin", 300); // Initialize the bin with the name and x-coordinate
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
