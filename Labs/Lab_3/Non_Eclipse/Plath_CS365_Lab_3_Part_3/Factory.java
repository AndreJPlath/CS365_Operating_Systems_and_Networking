/*
 * Copyright (C) 2018 AndreJPlath.com to Present.
 * Last Modified 02/09/2018 5:20:39 PM. All rights reserved. 
 *
 * @author Andre J Plath
 * @version 1.0 CS365_Lab_3_Part_3, 02/09/2018
 */



import java.util.Date;

/**
 * The Factory class that is needed to implementing
 * CS365 Lab 3. Code was given.
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
               
               // start the threads
	           producer.start();
	           consumer.start();
	 } 
}
