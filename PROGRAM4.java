import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
public class PROGRAM4 {

    public static void main(String[]args){
        try{
            //(a)set the url of another server
            String serverURL = "http://google.com";

            //(b) Download the homepage of the server
            String pageContent = downloadHomePage(serverURL);

            //(c)Display the contents of home page with date, content type, and Expiration date
            displayPageInfo(serverURL, pageContent);

            //(d)Last modified and length of the home page
            displayPageDetails(serverURL);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private static String downloadHomePage(String serverURL) throws IOException {
        URL url = new URL(serverURL);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");


        int responseCode = connection.getResponseCode();
        if (responseCode==HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine=in.readLine()) !=null){
                content.append(inputLine);
            }
            in.close();
            return content.toString();
        }else{
            throw new IOException("Failed to download homepage.Response code:" + responseCode);
        }
    }

    private static void displayPageInfo(String serverURL, String pageContent){
        try {
            URL url = new URL(serverURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();


            System.out.println("Server URL: " + serverURL);
            System.out.println("Date: " + new Date());
            System.out.println("Content Type : " + HttpURLConnection.guessContentTypeFromStream(connection.getInputStream()));
            System.out.println("Content: \n" + pageContent);
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    private static void displayPageDetails(String serverURL)
        throws IOException{
        URL url = new URL(serverURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("HEAD");

        System.out.println("Last modified: " + new Date(connection.getLastModified()));
        System.out.println("Content Length: " + connection.getContentLength());
    }
}
