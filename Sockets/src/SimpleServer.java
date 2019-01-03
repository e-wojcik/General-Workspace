
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * SimpleServer.java
 *
 * Accepts socket connections on port 4444. A prerequisite string is entered by
 * the user/client and ENTER is pressed; a reply with a single message in the
 * form of a fortune is displayed and then the socket is closed.
 *
 * @author Eric Wojcik
 * @version 20 March 2017
 */
public class SimpleServer {

    public static void main(String[] args) {
        ServerSocket server;
        Socket conn;
        FortuneTeller teller = new FortuneTeller();
        Scanner scn;

        try {
            System.out.println("Server started...");
            for (int i = 0; i < 4; i++) {
                server = new ServerSocket(4444);
                conn = server.accept();
                // pw.println("This is Eric Wojciks's server...Welcome!!");
                try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(conn.getOutputStream()), true)) {
                    // pw.println("This is Eric Wojciks's server...Welcome!!");
                    scn = new Scanner(conn.getInputStream());
                    String strFortunes = scn.nextLine();

                    if (strFortunes.isEmpty()) {
                        pw.println(teller.getFortune());
                    } else {
                        pw.println(teller.getFortune(strFortunes));
                    }

                    // int numFortunes = scn.nextInt();
                    //
                    // for (int j = 0; j < numFortunes; j++){
                    // pw.println(teller.getFortune());
                    // }
                    conn.close();
                    server.close();
                }
            }
            System.out.println("...Server shut down");
        } catch (IOException e) {
            System.err.println("IOException(SimpleServer): " + e);
        }
    }
}
