package model.wasteItems;

// This class represents a Newspaper waste item
public class Newspaper extends WasteItem {

    // Path to the image file of the Newspaper
    private static final String IMAGE_PATH = "src/data/images/waste_items/newspaper.png";

    // String indicating the bin that the Newspaper belongs to
    public static final String belongsTo = "Paper Bin";

    // Unique code for the Newspaper waste item
    private static final int code = 7;

    // Constructor to create a Newspaper waste item
    public Newspaper(int x) {
        super(x); // Initialize the waste item with the x-coordinate
        belongedBin = belongsTo; // Set the bin that the waste item belongs to
        codeNum = code; // Set the code number
        this.name = "Newspaper"; // Set the name of the waste item
        imagePath = IMAGE_PATH; // Set the image path
    }

    // Get the path to the waste item image
    @Override
    protected String getPath() {
        return IMAGE_PATH;
    }

    // The render method is inherited from the WasteItem class and does not need to be overridden
    // It will render the waste item image along with its name
}
