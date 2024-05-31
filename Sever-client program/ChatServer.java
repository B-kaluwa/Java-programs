import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        Scanner scanner = new Scanner(System.in);
        try {
            // Create a datagram socket on port 9876
            socket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            while (true) {
                // Receive datagram packet from client
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                // Convert the received data to string
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());

                // Display the received message
                System.out.println("Client: " + message);

                // Check if client wants to exit
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Client has exited the chat.");
                    break;
                }

                // Prompt the server user to enter a response
                System.out.print("You: ");
                String responseMessage = scanner.nextLine();

                // Prepare the response message
                sendData = responseMessage.getBytes();

                // Get client's IP address and port from the received packet
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Send the response datagram packet to the client
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);
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
