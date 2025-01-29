package studio2;

import java.util.Scanner;

public class Ruin {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Start amount?");
		double startAmount = in.nextDouble();
		System.out.println("Win chance?");
		double winChance = in.nextDouble();
		System.out.println("Win limit?");
		double winLimit = in.nextDouble();
		System.out.println("How many days?");
		double totalSimulations = in.nextDouble();
		
		double moneyLeft = startAmount;
		int currentDay = 0;
		int numOfPlays = 0;
		double ruinRate = 0;
		
		for(double i = totalSimulations; i > 0; i--) {
			moneyLeft = startAmount;
			numOfPlays = 0;
			currentDay++;
			while(moneyLeft>0 && moneyLeft < winLimit) {
				double result = Math.random();
				if(result<=winChance) {
					moneyLeft++;
					numOfPlays++;
				}
				else {
					moneyLeft--;
					numOfPlays++;
				
			}
			}
			System.out.println("Current day: "+ currentDay);
			System.out.println("Number of plays: " + numOfPlays);		
			if(moneyLeft>0) {
				System.out.println("You won!!!");
			}
			else {
				System.out.println("You lost :(");
				ruinRate++;
				}
			
		}
		
		double a = (1-winChance)/winChance;
		double expectedRuin = 0;
		if(winChance == 0.5) {
			expectedRuin = 1-(startAmount/winLimit);
		}
		else {
			expectedRuin = (Math.pow(a, startAmount) - Math.pow(a, winLimit))/(1-Math.pow(a, winLimit));
		}
		
		double finalRuinRate = ruinRate/totalSimulations;
		System.out.println("Expected ruin rate: " + expectedRuin + "");
		System.out.println("Ruin rate: " + finalRuinRate + "");
		//
		
		

	}
}
