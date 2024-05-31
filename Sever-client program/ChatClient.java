import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        Scanner scanner = new Scanner(System.in);
        try {
            // Create a datagram socket
            socket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] sendData;
            byte[] receiveData = new byte[1024];

            while (true) {
                // Get input from the user
                System.out.print("You: ");
                String message = scanner.nextLine();

                // Convert the string into a datagram packet
                sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);

                // Send the datagram packet to the server
                socket.send(sendPacket);

                // Check if user wants to exit
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting chat.");
                    break;
                }

                // Receive response from the server
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                // Convert the response data to string and display it
                String responseMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server: " + responseMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
            scanner.close();
        }
    }
}
