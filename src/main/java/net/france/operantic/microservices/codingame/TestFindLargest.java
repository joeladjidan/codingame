package net.france.operantic.microservices.codingame;

import java.util.Arrays;

import net.france.operantic.microservices.utils.Constante;

public class TestFindLargest {
	/**
	 * 
	 * @author operantic
	 * 
	 * Du désordre le plus grand gagne
	 * Implémentez la méthode Algorithm.findLargest(int[] numbers) afin qu'elle retourne le plus grand nombre dans numbers.
     * Note : Le tableau contient toujours au moins un nombre.
	 * @return the largest number of the given array
	 * 
	 */
	
	public static void main(String[] args) 
    {
		findLargest(Constante.tab) ;
		System.out.println("Le resultat est : "+findLargest(Constante.tab));
    }
	
	public static int findLargest(int[] numbers) {
	// Your code goes here
	 return Arrays.stream(numbers).max().getAsInt();
	}
}
