/*
 * Copyright (C) 2018 AndreJPlath.com to Present.
 * Last Modified 02/09/2018 3:05:31 PM. All rights reserved. 
 *
 * @author Andre J Plath
 * @version 1.0 CS_365_Lab_3 02/09/2018
 */

package main;


/**
 * The Channel interface for implementing
 * CS365 Lab 3.
 *
 */
public interface Channel<E>
{
	/**
	 * Send a message to the channel.
	 * It is possible that this method may or may not block.
	 */
	public void send(E message);
	/**
	 * Receive a message from the channel.
	 * It is possible that this method may or may not block.
	 */
	public E receive();
}
