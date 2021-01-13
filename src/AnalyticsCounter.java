package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

/**
 * Public class AnalyticsCounter provides the core of the app in 2 methods. 
 * First one reads the symptoms from a file symptoms.txt and saves them using a map.
 * The other write a sorted list with number of occurrencies from the map to result.out
 * The main function is assigned to an other class (main.java).
 */

public class AnalyticsCounter {
	
	
	// treemap initialization, will recieve symptom as a key and number of occurrencies as its value
	TreeMap <String, Integer> symptomsOccurrences = new TreeMap <String, Integer>();
	
	// Read symptoms method returning a treemap : symptom as key and number of occurrences as value
	public void readSymptoms() {
		
		// ReadSymptomDataFromFile class instantiation
		ReadSymptomDataFromFile symptomsList = new ReadSymptomDataFromFile ("symptoms.txt");
		
		// Récupération de la liste des symptomes sous forme d'un ArayList grâce à la méthode GetSymptoms
		ArrayList<String> list = (ArrayList<String>) symptomsList.GetSymptoms();
		
		// Lecture de chaque ligne, le symptôme est encapsulé dans la variable symptom
		for(String symptom: list) {
			// Variable de comptage d'occurrences par symptome, 1 par défaut
			int count = 1;	
			// Vérification de la présence du symptome dans la map par l'existence de sa valeur
			if (symptomsOccurrences.get(symptom) != null) {
				// si c'est le cas, incrémentation du nombre d'occurrences (valeur) et assignation à count
				count = symptomsOccurrences.get(symptom) + 1; 
			}
			// Écriture dans la map du symptome (symptom) et du nombre d'occurrences (count)
			symptomsOccurrences.put(symptom, count);
		}
	}
	
	
	
	// Write symptoms to file result.out method returning an alphabetic list of symptoms, one by line and with number of occurrencies aside
	public void writeSymptoms() {
		
		// Initialisation de la fonction Filewriter
		FileWriter writer;
		// Mise en place d'une récupération des erreurs
		try {
			// Création du fichier result.out
			writer = new FileWriter ("result.out");
			// Écriture d'une ligne titre
			writer.write("Liste alpha des symptomes et nombre d'occurrences : \n");
	        // Récupération du contenu de la map par une liste de ses clés
			Set<String> keys = symptomsOccurrences.keySet();        
			// Lecture de chaque ligne, le symptôme est encapsulé dans la variable key
			for(String key: keys){
				// Écriture du symptome (key) suivi d'une virgule et du nombre d'occurrences à l'aide d'un get sur la map
        			writer.write(key + ", " + symptomsOccurrences.get(key) + "\n");
        			// Affichage du résultat dans la console
        			System.out.println(key + ", " + symptomsOccurrences.get(key));
			}
			// Fermeture du writer
			writer.close();
		// Récupération des erreurs
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
