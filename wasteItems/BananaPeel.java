package model.wasteItems;

// This class represents a Banana Peel waste item
public class BananaPeel extends WasteItem {

    // String indicating the bin that the Banana Peel belongs to
    public static final String belongsTo = "Food Scrap Bin";

    // Unique code for the Banana Peel waste item
    private static final int code = 2;

    // Path to the image file of the Banana Peel
    private static final String IMAGE_PATH = "src/data/images/waste_items/banana_peel.png";

    // Constructor to create a Banana Peel waste item
    public BananaPeel(int x) {
        super(x); // Initialize the waste item with the x-coordinate
        this.belongedBin = "Food Scrap Bin"; // Set the bin that the waste item belongs to
        this.codeNum = 2; // Set the code number
        this.name = "Banana peel"; // Set the name of the waste item
        this.imagePath = "src/data/images/waste_items/banana_peel.png"; // Set the image path
    }

    // Get the path to the waste item image
    @Override
    protected String getPath() {
        return "src/data/images/waste_items/banana_peel.png";
    }
}
