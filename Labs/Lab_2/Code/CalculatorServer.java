import java.io.*;
import java.net.*;
import java.util.*;


public class CalculatorServer
{
	public static void main(String[] args)
	{
		try 
        {
            System.out.println("Server is running....");
            ServerSocket sock = new ServerSocket(6013);
            Socket client = sock.accept();
            
            DataInputStream dataInputStream = new DataInputStream(client.getInputStream()); // Get the input
            DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream()); // Get the output
			
			/* now listen for connections */
			while(true)
			{
                String input = dataInputStream.readUTF(); // wait for input
                
                if(input.equals("quit"))
                    break;
                
                System.out.println("Equation was received as :-" + input);
                int result;
                
                StringTokenizer stringTokenizer = new StringTokenizer(input); // Using StringTokenizer to break the equation into operand & operation
                
                int operand1 = Integer.parseInt(stringTokenizer.nextToken());
                String operation = stringTokenizer.nextToken();
                int operand2 = Integer.parseInt(stringTokenizer.nextToken());
                
                
                if (operation.equals("+")) // perform the required operation.
                {
                    result = operand1 + operand2;
                }
                
                else if (operation.equals("-"))
                {
                    result = operand1 - operand2;
                }
                else if (operation.equals("*"))
                {
                    result = operand1 * operand2;
                }
                else
                {
                    result = operand1 / operand2;
                }
                System.out.println("Sending the result...");
                dataOutputStream.writeUTF(Integer.toString(result)); // send the result back to the client
			}
		}
		catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
}
