import java.io.*;
import java.net.*;
import java.util.*;


public class CalculatorClient
{
	public static void main(String[] args) 
	{
		try{
            Scanner user = new Scanner(System.in);
            
			/* make connection to server socket */
			Socket sock = new Socket("localhost", 6013);

			System.out.println("Client Connection Established.....(quit to end)");
            
            DataInputStream dataInputStream = new DataInputStream(sock.getInputStream()); // Get the input
            DataOutputStream dataOutputStream = new DataOutputStream(sock.getOutputStream()); // Get the output
            
			while(true)
            {
                System.out.print("Please enter an equation the following form: ");
                System.out.println("'operand operator operand'");
                
                String input = user.nextLine();
                if (input.equals("quit"))
                    break;
                
                dataOutputStream.writeUTF(input); // Sends data to equation server
                
                String answer = dataInputStream.readUTF();
                System.out.println("The equation equals: " + answer);
                
			}
		}
		catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
}
