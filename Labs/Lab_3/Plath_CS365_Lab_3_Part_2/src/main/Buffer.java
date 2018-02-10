/*
 * Copyright (C) 2018 AndreJPlath.com to Present.
 * Last Modified 02/09/2018 5:22:28 PM. All rights reserved. 
 *
 * @author Andre J Plath
 * @version 1.0 02/09/2018
 */

package main;

/**
 * 
 *
 */
public interface Buffer<E>
{

	// producers call this method
	public void insert(E item);

	// consumers call this method
	public E remove();

}
