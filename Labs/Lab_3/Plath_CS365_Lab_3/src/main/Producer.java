/*
 * Copyright (C) 2018 AndreJPlath.com to Present.
 * Last Modified 02/09/2018 3:19:58 PM. All rights reserved. 
 *
 * @author Andre J Plath
 * @version 1.0 CS_365_Lab_3 02/09/2018
 */

package main;

import java.util.Date;

/**
 * The Producer class that is needed to implementing
 * CS365 Lab 3. Code was given.
 */
public class Producer implements java.lang.Runnable
{
	private Channel<Date> queue;

	public Producer(Channel<Date> queue) 
	{ 
		this.queue = queue;
	}

	public void run() 
	{
		Date message;

		while (true) 
		{
			// nap for awhile 
			SleepUtilities.nap();
			// produce an item and enter it into the buffer
			message = new Date();
			System.out.println("Producer produced " + message);
			queue.send(message);
		} 
	}

}
