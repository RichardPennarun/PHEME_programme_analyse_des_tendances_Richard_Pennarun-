package com.hemebiotech.analytics;

/**
 *  Executable main function using 2 methods defined in class AnalyticsCounter
 */

public class Main {
	
	public static void main(String args[]) {
		
		// Instantciation de la classe
		AnalyticsCounter a = new AnalyticsCounter();
		// Appel aux méthodes
		a.readSymptoms();
		a.writeSymptoms();
		
	}
}
