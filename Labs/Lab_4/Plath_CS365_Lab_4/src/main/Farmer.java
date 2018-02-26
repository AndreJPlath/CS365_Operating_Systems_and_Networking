/*
 * Copyright (C) 2018 AndreJPlath.com to Present.
 * Last Modified 02/25/2018 11:29:19 AM. All rights reserved. 
 *
 * @author Andre J Plath
 * @version 1.0 02/25/2018
 */

package main;


/**
 * Farmer class for CS365 Operating Systems and Networking Lab 4 Part 1
 *
 */
public class Farmer implements Runnable
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
