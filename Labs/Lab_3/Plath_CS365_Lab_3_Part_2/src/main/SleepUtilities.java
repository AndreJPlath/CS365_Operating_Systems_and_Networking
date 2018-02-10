/*
 * Copyright (C) 2018 AndreJPlath.com to Present.
 * Last Modified 02/09/2018 5:25:48 PM. All rights reserved. 
 *
 * @author Andre J Plath
 * @version 1.0 02/09/2018
 */

package main;


/**
 * 
 *
 */
public class SleepUtilities
{
private static final int NAP_TIME = 5;
	
	/**
	 * Nap between zero and NAP_TIME seconds.
	 */
	public static void nap() 
	{
		nap(NAP_TIME);
	}

	/**
	 * Nap between zero and duration seconds.
	 */
	public static void nap(int duration) 
	{
		int sleeptime = (int) (duration * Math.random() );

		try 
		{ 
			Thread.sleep(sleeptime*1000); 
		}
		catch (InterruptedException e) 
		{

		}
	}
}
