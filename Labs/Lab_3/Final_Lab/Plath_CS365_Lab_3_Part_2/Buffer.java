/*
 * Copyright (C) 2018 AndreJPlath.com to Present.
 * Last Modified 02/09/2018 5:22:28 PM. All rights reserved. 
 *
 * @author Andre J Plath
 * @version 1.0 CS365_Lab_3_Part_2, 02/09/2018
 */



/**
 * The Buffer class that is needed to implementing
 * CS365 Lab 3. Code was reused from online source.
 *
 */
public interface Buffer<E>
{

	// producers call this method
	public void insert(E item);

	// consumers call this method
	public E remove();

}
