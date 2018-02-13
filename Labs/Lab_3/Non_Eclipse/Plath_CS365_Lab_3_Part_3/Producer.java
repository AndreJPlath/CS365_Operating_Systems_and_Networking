/*
 * Copyright (C) 2018 AndreJPlath.com to Present.
 * Last Modified 02/09/2018 5:16:46 PM. All rights reserved. 
 *
 * @author Andre J Plath
 * @version 1.0 CS365_Lab_3_Part_3, 02/09/2018
 */



import java.util.Date;

/**
 * The Producer class that is needed to implementing
 * CS365 Lab 3. Code was given.
 */
public class Producer implements Runnable 
{
	private Buffer<Date> buffer;

	public Producer(Buffer<Date> buffer) 
	{ 
		this.buffer = buffer;
	}
	
	public void run() 
	{
		Date message;
		while (true) 
		{
			// nap for awhile 
			SleepUtilities.nap();
			// produce an item & enter it into the buffer
			message = new Date();
			System.out.println("Producer produced " + message);
			buffer.insert(message);
		} 
	}
}
