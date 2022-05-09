/*
Bank  Balance:  Design  a  distributed  application  which  consist  of  a  client  server communication  using  TCP,  UDP  &  RMI  techniques in Java.  Multiple  clients  can simultaneously connect to the server and multiple clients submits account number and server generates random number and returns as balanceamount.
43227 Murtuza Husain Q 10 Cl-IX Assignment 1a
*/

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.lang.Math;   

public class Server {
  public static void main(String[] args) throws IOException {
        final int PORT = 4040;
        ServerSocket serverSocket = new ServerSocket(PORT);
        
        System.out.println("Server started...");
        System.out.println("Wating for clients...");
        
        while (true) {
            Socket clientSocket = serverSocket.accept();
            Thread t = new Thread() {
                public void run() {
                    try (
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        Scanner in = new Scanner(clientSocket.getInputStream());
                    ) {
                        while (in.hasNextLine()) {
                            String input = in.nextLine();
                            if (input.equalsIgnoreCase("exit")) {
                                break;
                            }
                            System.out.println("Received Account Number from CLient " + input);
                            
                            double feet = Double.valueOf(input);
                            double metre = 0.3048*feet ;
                            double balance = Math.random();
                            out.println(balance*10000);
                        }
                    } catch (IOException e) { }
                }
            };
            t.start();
        }
    }   
}
