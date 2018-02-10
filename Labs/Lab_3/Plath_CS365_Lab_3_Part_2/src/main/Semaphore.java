/*
 * Copyright (C) 2018 AndreJPlath.com to Present.
 * Last Modified 02/09/2018 5:22:53 PM. All rights reserved. 
 *
 * @author Andre J Plath
 * @version 1.0 02/09/2018
 */

package main;


/**
 * 
 *
 */
public final class Semaphore
{
	private int value;

	public Semaphore() 
	{
		value = 0;
	}

	public Semaphore(int v) {
		value = v;
	}

	public synchronized void acquire() {
		while (value <= 0) {
			try {
				wait();
			}
			catch (InterruptedException e) { }
		}

		value --;
	}

	public synchronized void release() {
		++value;

		notify();
	}
}
