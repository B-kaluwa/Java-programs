import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoaderUsingBufferedImage {

    public static void main(String[] args) {
        try {
            // Specify the path to the image file
            String imagePath = "/Users/KALUWA/Pictures/[WallpapersMania]_vol87-002.jpg";

            // Load the image using ImageIO and BufferedImage
            BufferedImage image = ImageIO.read(new File(imagePath));

            // Check if the image is successfully loaded
            if (image != null) {
                System.out.println("Image loaded successfully.");

                // Perform operations with the loaded image if needed
                // For example, display the width and height of the image
                int width = image.getWidth();
                int height = image.getHeight();
                System.out.println("Image width: " + width);
                System.out.println("Image height: " + height);

                // You can also display the image using a GUI library or framework
                // (Swing, JavaFX, etc.) based on your application requirements.
            } else {
                System.out.println("Failed to load the image.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
