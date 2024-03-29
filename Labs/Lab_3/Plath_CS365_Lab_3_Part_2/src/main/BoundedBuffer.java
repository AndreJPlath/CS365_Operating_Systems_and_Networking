/*
 * Copyright (C) 2018 AndreJPlath.com to Present.
 * Last Modified 02/09/2018 5:10:48 PM. All rights reserved. 
 *
 * @author Andre J Plath
 * @version 1.0 CS365_Lab_3_Part_2, 02/09/2018
 */

package main;

/**
 * 
 *
 */
public class BoundedBuffer<E> implements Buffer<E>
{
	private static final int BUFFER_SIZE = 5; 
	private E[] buffer;
	private int in, out;
	private Semaphore mutex;
	private Semaphore empty;
	private Semaphore full;
	
	public BoundedBuffer() 
	{
		// buffer is initially empty
		in = 0;
		out = 0;
		mutex = new Semaphore(1);
		empty = new Semaphore(BUFFER_SIZE); full = new Semaphore(0);
		buffer = (E[]) new Object[BUFFER_SIZE];
	}

	public void insert(E item) 
	{ 
		// Figure 6.10
		empty.acquire();
		mutex.acquire();

		// add an item to the buffer 
		buffer[in] = item;
		in = (in + 1) % BUFFER_SIZE;
		mutex.release();
		full.release();
	}
	
	public E remove() 
	{ 
		// Figure 6.11
		E item;
		full.acquire();
		mutex.acquire();
		
		//remove an item from the buffer 
		item = buffer[out];
		out = (out + 1) % BUFFER_SIZE;
		mutex.release();
		empty.release();
		
		return item;
	}
}
