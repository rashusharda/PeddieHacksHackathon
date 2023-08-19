package model.wasteItems;

// This class represents a Letter waste item
public class Letter extends WasteItem {

    // String indicating the bin that the Letter belongs to
    public static final String belongsTo = "Paper Bin";

    // Unique code for the Letter waste item
    private static final int code = 1;

    // Path to the image file of the Letter
    private static final String IMAGE_PATH = "src/data/images/waste_items/letter.png";

    // Constructor to create a Letter waste item
    public Letter(int x) {
        super(x); // Initialize the waste item with the x-coordinate
        belongedBin = belongsTo; // Set the bin that the waste item belongs to
        codeNum = code; // Set the code number
        this.name = "Letter"; // Set the name of the waste item
        imagePath = IMAGE_PATH; // Set the image path
    }

    // Get the path to the waste item image
    @Override
    protected String getPath() {
        return "src/data/images/waste_items/letter.png";
    }

    // The render method is inherited from the WasteItem class and does not need to be overridden
    // It will render the waste item image along with its name
}
