package model.wasteItems;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

// This class represents a Plastic Bag waste item
public class PlasticBag extends WasteItem {

    // Unique code for the Plastic Bag waste item
    private static final int code = 4;
    
    // String indicating the bin that the Plastic Bag belongs to
    public static final String belongsTo = "Garbage Bin";

    // Path to the image file of the Plastic Bag
    // Icons made by Good Ware from www.flaticon.com
    private static final String IMAGE_PATH = "src/data/images/waste_items/plastic_bag.png";

    // Constructor to create a Plastic Bag waste item
    public PlasticBag(int x) {
        super(x); // Initialize the waste item with the x-coordinate
        belongedBin = belongsTo; // Set the bin that the waste item belongs to
        codeNum = code; // Set the code number
        this.name = "Plastic Bag"; // Set the name of the waste item
        imagePath = IMAGE_PATH; // Set the image path
        
        try {
            // Load the waste item image
            i = ImageIO.read(new File(imagePath)).getScaledInstance(SIZE_X, SIZE_Y, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            System.out.println("Fail to read image of items");
            e.printStackTrace();
        }
    }

    // Get the path to the waste item image
    @Override
    protected String getPath() {
        return IMAGE_PATH;
    }

    // The render method is inherited from the WasteItem class and does not need to be overridden
    // It will render the waste item image along with its name
}
