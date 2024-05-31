import java.io.File;

public class directory_info {
    public static void main(String[] args) {
        // Prompt the user for a directory path
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        // Create a File object for the entered directory
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Directory Information:");
            System.out.println("Directory Name: " + directory.getName());
            System.out.println("Absolute Path: " + directory.getAbsolutePath());
            System.out.println("Total Space: " + directory.getTotalSpace() + " bytes");
            System.out.println("Free Space: " + directory.getFreeSpace() + " bytes");

            // List the contents of the directory (files and subdirectories)
            File[] contents = directory.listFiles();
            if (contents != null) {
                System.out.println("Contents of the Directory:");
                for (File item : contents) {
                    if (item.isDirectory()) {
                        System.out.println("Directory: " + item.getName());
                    } else {
                        System.out.println("File: " + item.getName());
                    }
                }
            }
        } else {
            System.out.println("The specified directory does not exist or is not a directory.");
        }
    }
}


