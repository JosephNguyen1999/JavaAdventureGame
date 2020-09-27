/*
 * Player.java
 * Author:  Joseph Nguyen 
 * Submission Date:  4/1/2020
 *
 * Purpose: This is the player class and has all the methods related to the player object.
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing 
 * or posting of source code for this assignment is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.  
 */


public class Player {

	private int x;
	private int y;
	private Lamp lamp;
	private Key key;

	//getter and setter for x
	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	//getter and setter for y
	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	//getter and setter for lamp
	public Lamp getLamp() {
		return this.lamp;
	}

	public void setLamp(Lamp lamp) {
		this.lamp = lamp;
	}

	//getter and setter for key
	public Key getKey() {
		return this.key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

}
