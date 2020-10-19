/* 
 *  Name: Dan Di Clemente
 *  Course: Enterprise Java
 *  Assignment: Assignment 2
 *  Date: October 16, 2020
 */

package ca.sheridancollege.diclemed.repositories;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

import ca.sheridancollege.diclemed.beans.Destination;
import lombok.Data;

@Component
@Data
public class DestinationListImpl implements DestinationList {

	List<Destination> destinationList = new CopyOnWriteArrayList<Destination>();

	@Override
	public void addDestination(Destination destination) {
		destinationList.add(destination);
	}

	@Override
	public List<Destination> searchDestination(String year) {
		
		// Create list to store destinations
		List<Destination> match = new CopyOnWriteArrayList<Destination>();
		
		// If the year is left blank...
		if (!(year.matches("\\d+"))) {
			// return the full destination list
			return destinationList;
		} else {
			// add all destinations that have the same year to new list
			for (Destination i : destinationList) {
				if (i.getYear() == Integer.parseInt(year)) {
					match.add(i);
				}
			}
			// return new list
			return match;
		}
	}

	@Override
	public List<Destination> getDestinationList() {
		return destinationList;
	}
}
