/*
 * Adventure.java
 * Author:  Joseph Nguyen 
 * Submission Date:  4/1/2020
 *
 * Purpose: The purpose of this program is to run the main method of a game so the user can actually play.
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


import java.util.Scanner;

public class Adventure {

	public static void main(String[] args) {

		//objects
		Player player = new Player();
		Map map = new Map();
		Lamp theLamp = player.getLamp();
		Key theKey = player.getKey();
		Room playersRoom = map.getRoom(player.getX(), player.getY());


		//scanner and variables declaration
		Scanner keyboard = new Scanner(System.in);
		int deadOrTreasure = 0;
		int counter = 0;
		String command;
		String description = playersRoom.getDescription();

		///prints the start of the game
		System.out.println("Welcome to UGA Adventures: Episode I\n" + 
				"The Adventure of the Cave of Redundancy Adventure\n" + 
				"By: Joseph Nguyen\n\n" + description);

		//start loop and set a requirement and under it are all the cases for commands
		while (deadOrTreasure == 0) {


			int x = player.getX();
			int y = player.getY();
			command = keyboard.nextLine();

			//here are all the commands for the game
			if (command.equalsIgnoreCase("get lamp")) {
				Lamp theRoomLamp = playersRoom.getLamp();
				if (theRoomLamp == null) {
					System.out.println("No lamp present");
				}
				else {
					playersRoom.clearLamp();
					player.setLamp(theRoomLamp);
					theLamp = player.getLamp();
					System.out.println("OK");
				}
			}
			else if (command.equalsIgnoreCase("light lamp")) {
				if (theLamp == null) {
					System.out.println("You don't have a lamp to light");
				}
				else {
					theLamp.setIsLit(true);
					System.out.println("OK");
				}
			}
			else if (command.equalsIgnoreCase("get key")) {
				Key theRoomKey = playersRoom.getKey();
				if (theRoomKey == null) {
					System.out.println("No key present");
				}
				else {
					playersRoom.clearKey();
					player.setKey(theRoomKey);
					theKey = player.getKey();
					System.out.println("OK");
				}
			}
			else if (command.equalsIgnoreCase("open chest")) {
				Chest theChest = playersRoom.getChest();
				if (theChest == null) {
					System.out.println("No chest present");
				}
				else if (theChest.isLocked() == true) {
					System.out.println("The chest is locked");
				}
				else {
					String theChestContents = theChest.getContents();
					System.out.println(theChestContents);
					deadOrTreasure = 1;
				}
			}
			else if (command.equalsIgnoreCase("unlock chest")) {
				Chest theChest = playersRoom.getChest();
				if (theChest == null) {
					System.out.println("No chest present");
				}
				else if (player.getKey() == null) {
					System.out.println("Need a key to do any unlocking!");
				}
				else {
					theKey.use(theChest);
					System.out.println("OK");
				}
			}
			else if (command.equalsIgnoreCase("look")) {
				if (playersRoom.isDark() == true && (theLamp == null || theLamp.getIsLit() == false)) {
					System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
				}
				else {
					System.out.println(description);
					if (!(playersRoom.getLamp() == null)){
						System.out.println("There is an old oil lamp that was made long ago here.");
					}
					if (!(playersRoom.getKey() == null)){
						System.out.println("You see the outline of a key on a dusty shelf that's covered in dust.");
					}
					if (!(playersRoom.getChest() == null)){
						System.out.println("There is a large, wooden, massive, oaken chest here with the word “CHEST” carved into it.");
					}
					System.out.print("Exits are: ");
					if (playersRoom.canGoNorth() == true) {
						System.out.println("north");
					}
					if (playersRoom.canGoEast() == true) {
						System.out.println("east");
					}
					if (playersRoom.canGoSouth() == true) {
						System.out.println("south");
					}
					if (playersRoom.canGoWest() == true) {
						System.out.println("west");
					}
				}

			}
			else if (command.equalsIgnoreCase("north")) {
				if (playersRoom.canGoNorth() == true) {
					player.setX(x - 1);
					playersRoom = map.getRoom(player.getX(), player.getY());
					description = playersRoom.getDescription();
					if (counter == 1 && (theLamp == null || theLamp.getIsLit() == false)) { 
						System.out.println("You have stumbled into a passing grue, and have been eaten");
						deadOrTreasure = 1;
						System.exit(0);
					}
					if (playersRoom.isDark() == true && (theLamp == null || theLamp.getIsLit() == false)) {
						description = "It is pitch black, you can't see anything. You may be eaten by a grue!";
						counter++;
					}
					System.out.println(description);
					description = playersRoom.getDescription();
				}
				else {
					System.out.println("Can't go that way");
				}
			}
			else if (command.equalsIgnoreCase("south")) {
				if (playersRoom.canGoSouth() == true) {
					player.setX(x + 1);
					playersRoom = map.getRoom(player.getX(), player.getY());
					description = playersRoom.getDescription();
					if (counter == 1 && (theLamp == null || theLamp.getIsLit() == false)) { 
						System.out.println("You have stumbled into a passing grue, and have been eaten");
						deadOrTreasure = 1;
						System.exit(0);
					}
					if (playersRoom.isDark() == true && (theLamp == null || theLamp.getIsLit() == false)) {
						description = "It is pitch black, you can't see anything. You may be eaten by a grue!";
						counter++;
					}
					System.out.println(description);
					description = playersRoom.getDescription();
				}
				else {
					System.out.println("Can't go that way");
				}
			}
			else if (command.equalsIgnoreCase("east")) {
				if (playersRoom.canGoEast() == true) {
					player.setY(y + 1);
					playersRoom = map.getRoom(player.getX(), player.getY());
					description = playersRoom.getDescription();
					if (counter == 1 && (theLamp == null || theLamp.getIsLit() == false)) { 
						System.out.println("You have stumbled into a passing grue, and have been eaten");
						deadOrTreasure = 1;
						System.exit(0);
					}
					if (playersRoom.isDark() == true && (theLamp == null || theLamp.getIsLit() == false)) {
						description = "It is pitch black, you can't see anything. You may be eaten by a grue!";
						counter++;
					}
					System.out.println(description);
					description = playersRoom.getDescription();
				}
				else {
					System.out.println("Can't go that way");
				}
			}
			else if (command.equalsIgnoreCase("west")) {
				if (playersRoom.canGoWest() == true) {
					player.setY(y - 1);
					playersRoom = map.getRoom(player.getX(), player.getY());
					description = playersRoom.getDescription();
					if (counter == 1 && (theLamp == null || theLamp.getIsLit() == false)) { 
						System.out.println("You have stumbled into a passing grue, and have been eaten");
						deadOrTreasure = 1;
						System.exit(0);
					}
					if (playersRoom.isDark() == true && (theLamp == null || theLamp.getIsLit() == false)) {
						description = "It is pitch black, you can't see anything. You may be eaten by a grue!";
						counter++;
					}
					System.out.println(description);
					description = playersRoom.getDescription();
				}
				else {
					System.out.println("Can't go that way");
				}
			}
			else {
				System.out.println("I'm sorry I don't know how to do that.");
			}


		}

		System.exit(0);
		keyboard.close();
	}

}
