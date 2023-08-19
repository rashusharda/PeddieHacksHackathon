package ui;

import model.WSGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

// This class represents the instruction panel where players can choose difficulty levels.
public class InstructionFrame extends JFrame {

    private JButton startButton; // Button to start the game
    Collection<JButton> buttons; // Collection to hold difficulty level buttons

    public static final String gameStarts = "Start the Game!"; // Button text for starting the game
    private JPanel instPanel; // Panel for the instruction content
    private Dimension dm = new Dimension(300, 240); // Dimension for panel size

    // Constructor
    public InstructionFrame() {
        super();
        setBackground(new Color(184, 184, 184)); // Set background color
        setSize(dm); // Set the size of the frame
        centreOnScreen(); // Center the frame on the screen
        setVisible(true); // Make the frame visible

        startButton = new JButton(gameStarts); // Create the start button
        instPanel = new JPanel(); // Panel to hold the instruction content
        instPanel.setLayout(new BoxLayout(instPanel, BoxLayout.Y_AXIS)); // Set panel layout

        startButton.setActionCommand(gameStarts); // Set action command for the start button
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align the start button
        startButton.addActionListener(e -> {
            dispose(); // Close the instruction frame
            new WasteSortingGame(); // Start the game by opening the main game window
        });

        String instructions = "Please choose from a difficulty level: ";
        String welcome = "Welcome to the Waste Sorting Game!";
        String inst1 = "Use <- or -> key to control the position";
        String inst2 = "Use down arrow or space key to speed up waste falling";

        // Add instruction labels and content to the instruction panel
        addALabel(welcome, instPanel);
        addALabel(inst1, instPanel);
        addALabel(inst2, instPanel);
        addALabel(instructions, instPanel);
        createButtons(); // Create difficulty level buttons
        instPanel.add(startButton); // Add the start button to the panel
        add(instPanel, BorderLayout.CENTER); // Add the instruction panel to the frame
        pack(); // Pack the components
    }

    // Create difficulty level buttons
    private void createButtons() {
        String[] levels = {"Easy", "Medium", "Difficult"};
        buttons = new ArrayList<>();

        // Create buttons for each difficulty level
        for (String str : levels) {
            JButton btn = new JButton(str);
            buttons.add(btn);
            btn.setActionCommand(str);
            btn.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align the buttons
            btn.addActionListener(e -> {
                btn.setSelected(true);
                unselectRest(btn); // Deselect other buttons
                WSGame.setDifficultyLevel(e); // Set the game difficulty level
            });

            instPanel.add(btn); // Add the button to the instruction panel
        }
    }

    // Add a label to a container with centered alignment
    private void addALabel(String text, Container container) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align the label
        container.add(label); // Add the label to the container
    }

    // Center the frame on the screen
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize(); // Get screen dimensions
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2); // Calculate center position
    }

    // Deselect other buttons when a button is selected
    private void unselectRest(JButton btn) {
        for (JButton b : buttons) {
            if (!b.equals(btn)) {
                b.setSelected(false);
            }
        }
    }
}
