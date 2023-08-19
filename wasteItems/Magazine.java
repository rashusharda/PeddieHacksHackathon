package model.wasteItems;

// This class represents a Magazine waste item
public class Magazine extends WasteItem {

    // Unique code for the Magazine waste item
    private static final int code = 6;

    // String indicating the bin that the Magazine belongs to
    public static final String belongsTo = "Paper Bin";

    // Path to the image file of the Magazine
    private static final String IMAGE_PATH = "src/data/images/waste_items/magazine.png";

    // Constructor to create a Magazine waste item
    public Magazine(int x) {
        super(x); // Initialize the waste item with the x-coordinate
        belongedBin = belongsTo; // Set the bin that the waste item belongs to
        codeNum = code; // Set the code number
        this.name = "Magazine"; // Set the name of the waste item
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
