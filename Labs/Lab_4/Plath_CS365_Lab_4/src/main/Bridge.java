/*
 * Copyright (C) 2018 AndreJPlath.com to Present.
 * Last Modified 02/25/2018 11:31:20 AM. All rights reserved. 
 *
 * @author Andre J Plath
 * CS365 Lab 4,  02/25/2018
 */

package main;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


/**
 * Bridge class for CS365 Operating Systems and Networking Lab 4 Part 1
 *
 */
public class Bridge
{
	private Semaphore semaphore;

	/**
	 * Constructor for bridge class
	 */
	public Bridge()
	{
		semaphore = new Semaphore(1);
	}


	/**
	 * Method for crossing the bridge and identifying which farmer has crossed.
	 * @param farmer
	 */
	public void crossBridge(Farmer farmer) 
	{
		try
		{
			System.out.printf("Farmer " + farmer.getName() + " is trying to entering the bridge.\n");
			semaphore.acquire();
			System.out.printf("Farmer " + farmer.getName() + " is crossing the bridge.\n");
			long duration = (long)(Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.printf("Farmer " + farmer.getName() + " has exited the bridge.\n");
			semaphore.release();
		}
	}
}
