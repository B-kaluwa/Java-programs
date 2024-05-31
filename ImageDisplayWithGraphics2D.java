import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class ImagePanel extends JPanel {

    private BufferedImage image;

    public ImagePanel(String imagePath) {
        try {
            // Load the image using ImageIO
            this.image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            // Draw the image on the JPanel using Graphics2D
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(image, 0, 0, this);
        } else {
            System.err.println("Image not loaded.");
        }
    }
}

public class ImageDisplayWithGraphics2D {

    public static void main(String[] args) {
        // Replace this path with the actual path to your image file
        String imagePath = "/Users/KALUWA/Pictures/[WallpapersMania]_vol87-002.jpg";

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Image Display with Graphics2D");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            // Create an instance of ImagePanel with the image path
            ImagePanel imagePanel = new ImagePanel(imagePath);

            // Add the ImagePanel to the JFrame
            frame.getContentPane().add(imagePanel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}

