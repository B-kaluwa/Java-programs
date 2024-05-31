import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class ScaledImagePanel extends JPanel {

    private BufferedImage originalImage;
    private BufferedImage scaledImage;

    public ScaledImagePanel(String imagePath) {
        try {
            // Load the original image
            originalImage = ImageIO.read(new File(imagePath));

            // Scale the image while maintaining aspect ratio
            int scaledWidth = 300;  // Replace with your desired width
            int scaledHeight = calculateScaledHeight(originalImage, scaledWidth);

            scaledImage = scaleImage(originalImage, scaledWidth, scaledHeight);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (scaledImage != null) {
            // Draw the scaled image on the JPanel
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(scaledImage, 0, 0, this);
        } else {
            System.err.println("Image not loaded.");
        }
    }

    private int calculateScaledHeight(BufferedImage image, int scaledWidth) {
        double aspectRatio = (double) image.getHeight() / image.getWidth();
        return (int) (scaledWidth * aspectRatio);
    }

    private BufferedImage scaleImage(BufferedImage originalImage, int newWidth, int newHeight) {
        BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
        Graphics2D g2d = scaledImage.createGraphics();

        // Use AffineTransform to scale the image
        AffineTransform transform = new AffineTransform();
        transform.scale((double) newWidth / originalImage.getWidth(), (double) newHeight / originalImage.getHeight());

        g2d.drawImage(originalImage, transform, this);
        g2d.dispose();

        return scaledImage;
    }
}

public class ImageScalingWithAffineTransform {

    public static void main(String[] args) {
        // Replace this path with the actual path to your image file
        String imagePath = "C:/Users/KALUWA/Pictures/[WallpapersMania]_vol87-002.jpg";

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Image Scaling with AffineTransform");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            ScaledImagePanel imagePanel = new ScaledImagePanel(imagePath);
            frame.getContentPane().add(imagePanel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}

//ScaledImagePanel is a custom JPanel that loads an original image, calculates the scaled height to maintain the aspect ratio, and scales the image using the scaleImage method.
//calculateScaledHeight method is used to calculate the scaled height based on the original image's aspect ratio.
//scaleImage method uses AffineTransform to perform the actual scaling of the image.
