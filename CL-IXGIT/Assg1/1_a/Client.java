

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) throws IOException {
        final String HOST = "127.0.0.1";
        final int PORT = 4040;
        
        System.out.println("Client started.");
        
        try (
            Socket socket = new Socket(HOST, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner in = new Scanner(socket.getInputStream());
            Scanner s = new Scanner(System.in);
        ) {
            while (true) {
                System.out.print("Enter Account Number: ");
                String input = s.nextLine();
                out.println(input);
                if (input.equalsIgnoreCase("exit")) break;
                System.out.println("Echoed from server: ");
                System.out.println("Balance: " + in.nextLine());
            }
        }
    }
 
}
