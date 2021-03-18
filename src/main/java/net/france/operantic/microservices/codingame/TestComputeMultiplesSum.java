package net.france.operantic.microservices.codingame;

import java.io.PrintStream;
import java.util.Scanner;

public class TestComputeMultiplesSum {
	/**
	 * 
	 * @author operantic
	 * 
	 * La méthode computeMultiplesSum(n) doit renvoyer la somme de tous les multiples positifs de 3 ou 5 ou 7 strictement inférieurs à n.
	 * Par exemple, pour n=11, on obtient 3,5,6,7,9,10 en tant que multiples et la somme de ces multiples vaut 40.
	 * 
	 * Implémentez computeMultiplesSum(n).
	 * Contraintes: 0 ≤ n < 1000
	 * 
	 */
	
	/* Ignore and do not change the code below */
	// #region main
	@SuppressWarnings("resource")
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		PrintStream outStream = System.out;
		System.setOut(System.err);
		int res = computeMultiplesSum(n);
		System.setOut(outStream);
		System.out.println("Le resultat est : "+res);
	}
	// #endregion
	
	public static int computeMultiplesSum(int n) {
		int somme = 0;
		System.out.println("------------ ");
		while(n >= 3)
		{
			System.out.println("------------ "+somme);
			n--;
			boolean a = n%3 == 0;
			boolean b = n%5 == 0;
			boolean c = n%7 == 0;
			if(a || b || c) {
				somme +=n;
			}
		}
	   return somme;
	}
}
