/*
 * Copyright (C) 2018 AndreJPlath.com to Present.
 * Last Modified 02/09/2018 5:19:14 PM. All rights reserved. 
 *
 * @author Andre J Plath
 * @version 1.0 CS365_Lab_3_Part_2, 02/09/2018
 */



import java.util.Date;

/**
 * The Consumer class that is needed to implementing
 * CS365 Lab 3. Code was given.
 *
 */
public class Consumer implements Runnable
{
	private Buffer<Date> buffer;

	public Consumer(Buffer<Date> buffer) 
	{ 
		this.buffer = buffer;
	}

	public void run() 
	{
		Date message;
		
		while (true) 
		{
			// nap for awhile 
			System.out.println("Consumer napping");
			SleepUtilities.nap();
			// consume an item from the buffer
			System.out.println("Consumer wants to consume.");
			
			message = (Date)buffer.remove();
		} 
	}

}
