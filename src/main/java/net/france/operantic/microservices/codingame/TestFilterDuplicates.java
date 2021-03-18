package net.france.operantic.microservices.codingame;

import java.util.*;
import java.io.*;

public class TestFilterDuplicates {
	/**
	 * 
	 * @author operantic
	 *
	 * Implémenter la méthode filterDuplicates(data) qui prend un tableau data en entrée et 
	 * retourne un tableau contenant les valeurs de data sans les doublons de valeurs.
	 * L'ordre initial des valeurs doit être conservé.
	 * Exemple: [7 3 6 4 3 3 4 9] => [7 3 6 4 9]
	 * Constraintes:
	 * data n'est jamais null
	 *
	 */
	
	public static int[] filterDuplicates(int[] data) {
		// Write your code here
		// To debug: System.err.println("Debug messages...");
		return Arrays.stream(data).distinct().toArray();
	}
		
	/* Ignore and do not change the code below */
	// #region main
	public static void main(String args[]) {
	@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int[] data = new int[n];
		for (int i = 0; i < n; i++) {
		   data[i] = in.nextInt();
		}
		PrintStream outStream = System.out;
		System.setOut(System.err);
	    int[] filtered = filterDuplicates(data);
		System.setOut(outStream);
		for (int i = 0; i < filtered.length; i++) {
		    System.out.println(filtered[i]);
		}
	}
	// #endregion
	}
