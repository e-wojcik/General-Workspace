
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * GetFortune.java
 *
 * Simple client program to prompt for a string to search for in a list of
 * fortunes, and then a response is served, and the newly-served fortune is
 * displayed in the console. Program only works as expected if SimpleServer.java
 * is up and running beforehand.
 *
 * @author Eric Wojcik
 * @version 19 March 2017
 *
 */
public class GetFortune {

    public static void main(String[] args) {
        Socket sckt;
        String host = "ThinkPad";
        Scanner scan;
        PrintWriter out;

        try {
            // System.out.print(". ");
            sckt = new Socket(host, 4444);
            scan = new Scanner(sckt.getInputStream());
            out = new PrintWriter(sckt.getOutputStream(), true);
            // System.out.println("Please enter the number of fortunes to be
            // served: ");
            System.out.println("Enter a string (or not) to specify a fortune: ");
            String strFortunes = new Scanner(System.in).nextLine();
            out.println(strFortunes);

            while (scan.hasNext()) {
                System.out.println(scan.nextLine());
            }
            // System.out.println("There is a server on port " + 4444 + " of " +
            // host);
            sckt.close();
            out.close();

        } catch (UnknownHostException e) {
            System.err.println("UnknownHostException(LookForPorts): " + e);
        } catch (IOException e) {
            // must not be a server on this port - do nothing
        }

        System.out.println("Done!");
    }
}
