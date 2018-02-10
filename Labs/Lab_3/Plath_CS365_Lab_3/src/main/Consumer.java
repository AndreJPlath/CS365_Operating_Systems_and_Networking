/*
 * Copyright (C) 2018 AndreJPlath.com to Present.
 * Last Modified 02/09/2018 11:15:01 AM. All rights reserved. 
 *
 * @author Andre J Plath
 * @version 1.0 CS_365_Lab_3 02/09/2018
 */

package main;

import java.util.Date;

/**
 * The Consumer class that is needed to implementing
 * CS365 Lab 3. Code was given.
 *
 */
public class Consumer implements java.lang.Runnable
{
	private Channel<Date> queue;

	public Consumer(Channel<Date> queue) 
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
			// consume an item from the buffer
			message = queue.receive();

			if (message != null)
				System.out.println("Consumer consumed " + message);
		} 
	}

}
