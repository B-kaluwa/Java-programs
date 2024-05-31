import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageDisplayExample {

    public static void main(String[] args) {
        // Specify the path to the image file
        String imagePath = "/Users/KALUWA/Pictures/[WallpapersMania]_vol87-002.jpg";

        // Load the image using ImageIO
        BufferedImage image = loadImage(imagePath);

        // Check if the image is successfully loaded
        if (image != null) {
            // Display the image in a JFrame using a JLabel
            displayImage(image);
        } else {
            System.out.println("Failed to load the image.");
        }
    }

    private static BufferedImage loadImage(String imagePath) {
        try {
            return ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void displayImage(BufferedImage image) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Image Display Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            JLabel label = new JLabel(new ImageIcon(image));
            frame.getContentPane().add(label, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}
