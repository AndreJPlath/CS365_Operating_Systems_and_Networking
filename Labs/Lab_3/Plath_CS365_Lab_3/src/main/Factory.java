/*
 * Copyright (C) 2018 AndreJPlath.com to Present.
 * Last Modified 02/09/2018 3:25:19 PM. All rights reserved. 
 *
 * @author Andre J Plath
 * @version 1.0 02/09/2018
 */

package main;

import java.util.Date;

/**
 * The Factory class that is needed to implementing
 * CS365 Lab 3. Code was given.
 */
public class Factory
{

	public static void main(String args[]) 
    {
        // create the message queue
        Channel<Date> queue = new MessageQueue<Date>();
         
        // Create the producer and consumer threads and pass
        // each thread a reference to the MessageQueue object.
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
         
        // start the threads
        producer.start();
        consumer.start();
    }
}
