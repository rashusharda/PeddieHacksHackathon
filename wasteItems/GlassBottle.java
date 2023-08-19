package model.wasteItems;

// This class represents a Glass Bottle waste item
public class GlassBottle extends WasteItem {

    // Unique code for the Glass Bottle waste item
    private static final int code = 3;

    // String indicating the bin that the Glass Bottle belongs to
    public static final String belongsTo = "Recyclable Containers Bin";

    // Path to the image file of the Glass Bottle
    // Icons made by Freepik from www.flaticon.com
    private static final String IMAGE_PATH = "src/data/images/waste_items/thin-bottle-of-water.png";

    // Constructor to create a Glass Bottle waste item
    public GlassBottle(int x) {
        super(x); // Initialize the waste item with the x-coordinate
        belongedBin = belongsTo; // Set the bin that the waste item belongs to
        codeNum = code; // Set the code number
        this.name = "Glass bottle"; // Set the name of the waste item
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
