/*
 * Copyright (C) 2018 AndreJPlath.com to Present.
 * Last Modified 02/25/2018 3:18:15 PM. All rights reserved. 
 * Code Reused from Oracle'
 *
 * @author Andre J Plath
 * CS365 Lab 4 Part 1, 02/25/2018
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.Semaphore;

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
    
/**
 * Farmer class for CS365 Operating Systems and Networking Lab 4 Part 1
 *
 */
class Farmer implements Runnable
{
	private String name; // name of farmer
	private Bridge bridge;


	public Farmer (Bridge bridge)
	{
		this.bridge = bridge;
	}


	public void run()
	{
		bridge.crossBridge(this);
	}


	/**
	 * Method to get name of farmer
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}


	/**
	 * Method to set name of farmer
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
}
    
/**
 * Bridge class for CS365 Operating Systems and Networking Lab 4 Part 1
 *
 */
class Bridge
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



