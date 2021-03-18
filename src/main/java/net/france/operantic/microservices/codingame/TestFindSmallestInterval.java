package net.france.operantic.microservices.codingame;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class TestFindSmallestInterval {
	/**
	 * 
	 * @author operantic
	 * 
	 * Implémentez la méthode findSmallestInterval(numbers) qui retourne 
	 * le plus petit intervalle positif entre deux éléments du tableau numbers.
	 * Par exemple, si on considère le tableau [1 6 4 8 2] , 
	 * le plus petit intervalle est 1 (différence entre 2 et 1)
	 * Contraintes:
     * numbers contient au moins deux éléments et au maximum 100 000 éléments. 
     * La solution qui privilégie la vitesse d'exécution pour les tableaux de grande taille obtiendra le plus de points. 
     * La différence entre deux éléments ne dépassera jamais la capacité d'un entier pour votre langage.
     * 
     * @param numbers 
	 * @return the largest number of the given array
	 * 
	 */
	
	public static int findSmallestInterval(int[] numbers) {
		// Write your code here
		// To debug: System.err.println("Debug messages...");
		Arrays.sort(numbers);
		int max = numbers[1] - numbers[0];
		for(int i = 0; i < numbers.length-1; i++){
		int diff = numbers[i+1] - numbers[i];
			if(diff < max) 
				max = diff;
			}
		   return max;
		}
		
		/* Ignore and do not change the code below */
		// #region main
		@SuppressWarnings("resource")
		public static void main(String args[]) {
			Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
		  numbers[i] = in.nextInt();
		}
		
		PrintStream outStream = System.out;
		 System.setOut(System.err);
			int res = findSmallestInterval(numbers);
			System.setOut(outStream);
			System.out.println(res);
		}
}
