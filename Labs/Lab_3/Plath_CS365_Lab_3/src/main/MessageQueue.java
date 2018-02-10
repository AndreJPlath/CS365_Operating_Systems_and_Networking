/*
 * Copyright (C) 2018 AndreJPlath.com to Present.
 * Last Modified 02/09/2018 3:12:48 PM. All rights reserved. 
 *
 * @author Andre J Plath
 * @version 1.0 CS_365_Lab_3 02/09/2018
 */

package main;

import java.util.Vector;

/**
 * The MessageQueue class that is needed to implementing
 * CS365 Lab 3.
 *
 */
public class MessageQueue<E> implements Channel<E> 
{
	private Vector<E> queue;
	
	public MessageQueue() 
	{
		queue = new Vector<E>();
	}
	
	public void send(E item) 
	{
		queue.addElement(item);	// add to tail (end)
	}
	public E receive() 
	{
		if ( queue.size() == 0 )
			return null;
		else		// remove from head (front)
			return queue.remove( 0 );
	}
}
