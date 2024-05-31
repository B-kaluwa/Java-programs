import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ImageLoaderUsingFileInputStream {

    public static void main(String[] args) {
        try {
            // Specify the path to the image file
            String imagePath = "/Users/KALUWA/Pictures/[WallpapersMania]_vol87-002.jpg";

            // Create a FileInputStream for the image file
            FileInputStream fileInputStream = new FileInputStream(new File(imagePath));

            // Determine the size of the image
            int fileSize = (int) new File(imagePath).length();
            byte[] imageData = new byte[fileSize];

            // Read the image data into a byte array
            fileInputStream.read(imageData);

            // Now, the image data is available in the imageData byte array
            // You can process or use this data as needed

            // Close the FileInputStream
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

