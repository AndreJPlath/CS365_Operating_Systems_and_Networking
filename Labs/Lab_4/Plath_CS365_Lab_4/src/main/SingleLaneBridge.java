/*
 * Copyright (C) 2018 AndreJPlath.com to Present.
 * Last Modified 02/25/2018 3:18:15 PM. All rights reserved. 
 *
 * @author Andre J Plath
 * @version 1.0 02/25/2018
 */

package main;

import java.util.concurrent.TimeUnit;

/**
 * This is the driving class for the implementation of 
 * CS365 Operating Systems and Networking Lab 4 Part 1.
 *
 */
public class SingleLaneBridge
{

	public static void main(String[] args) 
	{
		Bridge bridge = new Bridge();

		Thread threadNorthbound = new Thread(new Runnable() 
		{
			public void run() 
			{
				while(true)
				{
					Farmer farmer = new Farmer(bridge);
					Thread thread = new Thread(farmer);
					farmer.setName("North Farmer : " + thread.getId());
					thread.start();
					try
                    {
                        TimeUnit.SECONDS.sleep((long)(Math.random()*10));
                    }
                    catch(InterruptedException iex)
                    {
                        iex.printStackTrace();
                    }
				}
			}
		});

		Thread threadSouthbound = new Thread( new Runnable() 
		{

			public void run() 
			{
				while(true)
				{
					Farmer farmer = new Farmer(bridge);
					Thread thread = new Thread(farmer);
					farmer.setName("South Farmer : " + thread.getId());
					thread.start();
					try
                    {
                        TimeUnit.SECONDS.sleep((long)(Math.random()*10));
                    }
                    catch(InterruptedException iex)
                    {
                        iex.printStackTrace();
                    }
				}
			}
		});

		threadNorthbound.start();
		threadSouthbound.start();
	}
}



