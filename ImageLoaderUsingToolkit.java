import java.awt.Image;
import java.awt.Toolkit;

public class ImageLoaderUsingToolkit {

    public static void main(String[] args) {
        // Specify the path to the image file
        String imagePath = "/Users/KALUWA/Pictures/[WallpapersMania]_vol87-002.jpg";

        // Get the default toolkit
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // Load the image using Toolkit
        Image image = toolkit.getImage(imagePath);

        // Perform operations with the loaded image if needed
        // For example, display the image in a component
    }
}
