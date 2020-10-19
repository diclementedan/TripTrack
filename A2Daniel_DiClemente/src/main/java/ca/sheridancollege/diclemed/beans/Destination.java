/* 
 *  Name: Dan Di Clemente
 *  Course: Enterprise Java
 *  Assignment: Assignment 2
 *  Date: October 16, 2020
 */

package ca.sheridancollege.diclemed.beans;

import java.io.Serializable;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Destination implements Serializable{

	private String name;
	private Long duration;
	private String guests; // who they went with
	private int year;
	private String comments;
}
