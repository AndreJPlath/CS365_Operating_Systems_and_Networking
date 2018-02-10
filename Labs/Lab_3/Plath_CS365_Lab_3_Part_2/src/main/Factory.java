/*
 * Copyright (C) 2018 AndreJPlath.com to Present.
 * Last Modified 02/09/2018 5:20:39 PM. All rights reserved. 
 *
 * @author Andre J Plath
 * @version 1.0 02/09/2018
 */

package main;

import java.util.Date;

/**
 * 
 *
 */
public class Factory
{
	
	 public static void main(String args[]) 
	 {
	           Buffer<Date> buffer = new BoundedBuffer<Date>();
	           
	           // Create the producer and consumer threads
	           Thread producer = new Thread(new Producer(buffer));
	           Thread consumer = new Thread(new Consumer(buffer));
	           producer.start();
	           consumer.start();
	 } 
}
