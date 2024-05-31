import javax.swing.*;
import java.awt. *;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColorPaletteSwingApp extends JFrame implements ActionListener, ItemListener {
    JButton[][] colorButtons;
    JRadioButton foregroundRadioButton, backgroundRadioButton;
    JTextArea textArea;
    Color selectedColor;
    boolean isForeground;

    public ColorPaletteSwingApp() {
        setTitle("Color Palette Swing Application");
        setLayout(new BorderLayout());

        // Create a panel for the color palette
        JPanel palettePanel = new JPanel(new GridLayout(3, 3)); // 3x3 color palette
        colorButtons = new JButton[3][3];
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.LIGHT_GRAY};

        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                colorButtons[i][j] = new JButton();
                colorButtons[i][j].setBackground(colors[index]);
                colorButtons[i][j].addActionListener(this);
                palettePanel.add(colorButtons[i][j]);
                index++;
            }
        }
        add(palettePanel, BorderLayout.NORTH);

        // Create radio buttons for foreground and background selection
        JPanel radioPanel = new JPanel(new FlowLayout());
        ButtonGroup group = new ButtonGroup();
        foregroundRadioButton = new JRadioButton("Foreground", true);
        backgroundRadioButton = new JRadioButton("Background");
        foregroundRadioButton.addItemListener(this);
        backgroundRadioButton.addItemListener(this);
        group.add(foregroundRadioButton);
        group.add(backgroundRadioButton);
        radioPanel.add(foregroundRadioButton);
        radioPanel.add(backgroundRadioButton);
        add(radioPanel, BorderLayout.CENTER);

        // Create a text area
        textArea = new JTextArea("Sample Text", 5, 40);
        add(new JScrollPane(textArea), BorderLayout.SOUTH);

        // Initialize selected color and selection type
        selectedColor = Color.BLACK;
        isForeground = true;

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the color from the button pressed
        JButton source = (JButton) e.getSource();
        selectedColor = source.getBackground();

        // Apply the selected color to either foreground or background
        if (isForeground) {
            textArea.setForeground(selectedColor);
        } else {
            textArea.setBackground(selectedColor);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // Determine if we are setting foreground or background
        JRadioButton source = (JRadioButton) e.getSource();
        if (source == foregroundRadioButton) {
            isForeground = true;
        } else if (source == backgroundRadioButton) {
            isForeground = false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorPaletteSwingApp::new);
    }
}
