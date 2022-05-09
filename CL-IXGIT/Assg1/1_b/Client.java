/*
Bank  Balance:  Design  a  distributed  application  which  consist  of  a  client  server communication  using  TCP,  UDP  &  RMI  techniques in Java.  Multiple  clients  can simultaneously connect to the server and multiple clients submits account number and server generates random number and returns as balanceamount.
43227 Murtuza Husain Q 10 Cl-IX Assignment 1b
*/
import java.rmi.*;
import java.util.*;
public class Client {
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Enter Account Number:  ");
         double input = sc.nextDouble();
			
				ConvertInterface obj
					= (ConvertInterface)Naming.lookup("CONVERT");
				double n;
				n = obj.convert(input);
				System.out.println("Balance: " + n);
			
			}
		}
	}

