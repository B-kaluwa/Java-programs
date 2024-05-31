import java.io. *;
import java.net.Socket;

public class PROGRAM5 {
    public static void main (String [] args) {
        // HTTP
        try {
            Socket httpSocket = new Socket("example.com", 80); // Connect to the HTTP server
            PrintWriter httpOut = new PrintWriter(new OutputStreamWriter(httpSocket.getOutputStream()));
            httpOut.println("GET / HTTP/1.1"); // Send HTTP GET request
            httpOut.println("Host: example.com");
            httpOut.println(); // End of HTTP request
            httpOut.flush();
            BufferedReader httpIn = new BufferedReader(new InputStreamReader(httpSocket.getInputStream()));
            String httpLine;
            while ((httpLine = httpIn.readLine())!= null) {
                System.out.println("HTTP: " + httpLine); // Print HTTP response
            }
            httpSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // FTP
        try {
            Socket ftpSocket = new Socket("ftp.example.com", 21); // Connect to the FTP server
            BufferedReader ftpIn = new BufferedReader(new InputStreamReader(ftpSocket.getInputStream()));
            PrintWriter ftpOut = new PrintWriter(new OutputStreamWriter(ftpSocket.getOutputStream()));
            // Login
            ftpOut.println("USER username");
            ftpOut.println("PASS password");
            ftpOut.flush();
            // Retrieve file
            ftpOut.println("RETR filename");
            ftpOut.flush();

            // Read file content
            BufferedReader ftpFileReader = new BufferedReader(new InputStreamReader(ftpSocket.getInputStream()));
            String ftpLine;
            while ((ftpLine = ftpFileReader.readLine()) != null) {
                System.out.println("FTP: " + ftpLine);
            }
            ftpSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // SMTP
        try {
            Socket smtpSocket = new Socket("mail.example.com", 25); // Connect to the SMTP server
            BufferedReader smtpIn = new BufferedReader(new InputStreamReader(smtpSocket.getInputStream()));
            PrintWriter smtpOut = new PrintWriter(new OutputStreamWriter(smtpSocket.getOutputStream()));
            // Send email
            smtpOut.println("HELO example.com");
            smtpOut.println("MAIL FROM: sender@example.com");
            smtpOut.println("RCPT TO: recipient@example.com");
            smtpOut.println("DATA");
            smtpOut.println("Subject: Test Email");
            smtpOut.println("This is a test email.");
            smtpOut.println(".");
            smtpOut.flush();
            String smtpResponse;
            while ((smtpResponse = smtpIn.readLine()) != null) {
                System.out.println("SMTP: " + smtpResponse); // Print SMTP response
                if (smtpResponse.startsWith("250 ")) {
                    break; // End of message
                }
            }
            smtpSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // POP3
        try {
            Socket pop3Socket = new Socket("pop.example.com", 110); // Connect to the POP3 server
            BufferedReader pop3In = new BufferedReader(new InputStreamReader(pop3Socket.getInputStream()));
            PrintWriter pop3Out = new PrintWriter(new OutputStreamWriter(pop3Socket.getOutputStream()));
            // Login
            pop3Out.println("USER username");
            pop3Out.println("PASS password");
            pop3Out.flush();
            // Retrieve emails
            pop3Out.println("RETR 1");
            pop3Out.flush();
            // Read email content
            BufferedReader pop3EmailReader = new BufferedReader(new InputStreamReader(pop3Socket.getInputStream()));
            String pop3Line;
            while ((pop3Line = pop3EmailReader.readLine()) != null) {
                System.out.println("POP3: " + pop3Line);
            }
            pop3Socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


