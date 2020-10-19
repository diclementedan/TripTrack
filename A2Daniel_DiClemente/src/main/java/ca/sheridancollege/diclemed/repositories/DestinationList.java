/* 
 *  Name: Dan Di Clemente
 *  Course: Enterprise Java
 *  Assignment: Assignment 2
 *  Date: October 16, 2020
 */

package ca.sheridancollege.diclemed.repositories;

import java.util.List;

import ca.sheridancollege.diclemed.beans.Destination;

public interface DestinationList {

	public void addDestination(Destination destination);
	public List<Destination> searchDestination(String year);
	public List<Destination> getDestinationList();
}
