import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIExample {

    public static void main(String[] args) {
        // Create a JFrame (window)
        JFrame frame = new JFrame("GUI Example");
        frame.setSize(300, 200); // Set the size of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the program when the frame is closed

        // Create a JLabel
        JLabel label = new JLabel("Welcome to GUI Example!");
        frame.add(label); // Add the label to the frame

        // Create a JButton
        JButton button = new JButton("Click Me!");
        frame.add(button); // Add the button to the frame

        // Add ActionListener to the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Button Clicked!");
            }
        });

        // Set layout manager to null (absolute positioning)
        frame.setLayout(null);

        // Set the position and size of the label and button
        label.setBounds(20, 20, 200, 30);
        button.setBounds(20, 60, 100, 30);

        // Make the frame visible
        frame.setVisible(true);
    }
}
