package net.france.operantic.microservices.codingame;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestPointDeJointure {
   /**
	* 
	* @author operantic
	* 
	* On considére la suite de nombres dans laquelle un nombre est suivi du même nombre plus la somme de ces chiffres.
	* Par exemple 34 est suivi de 41 (41 = 34 + (3 + 4)). 41 est lui-même suivi de 46 (46 = 41 + (4 + 1)).
	* Deux séquences avec des points de départ différents peuvent finir par se rejoindre. 
	* Par exemple la séquence qui commence à 471 et la séquence qui commence à 480 partagent le nombre 519 ( le point de jointure). 
	* Bien évidemment après le point de jointure, les séquences sont identiques.
	* 
	* Un example de deux séquences se rejoignant en 519.
	* Implémentez la méthode int computeJoinPoint(int s1, int s2) qui prend 
	* les points de départ de deux séquences et renvoie le point de jointure de ces deux séquences.

    * Contraintes:

    * Les deux séquences se rejoignent toujours 0 < s1, s2 < 20000000 0 < joint point < 20000000
	* 
	* @return the number that is closest to zero
	*/
	
	/* Ignore and do not change the code below */
	// #region main
	public static void main(String args[]) {
	   Scanner in = new Scanner(System.in);
	   
	   int s1 = in.nextInt();
	   int s2 = in.nextInt();
	   
	   PrintStream outStream = System.out;
	   System.setOut(System.err);
	   
	   int res = computeJoinPoint(s1, s2);
	   
	   System.setOut(outStream);
	   System.out.println(res);
	}
	
	
	private static int computeJoinPoint(int s1, int s2){
		List<Integer> listJointPoint = new ArrayList<Integer>();
		while(true)
		{
			if(listJointPoint.indexOf(s1) == -1){
				listJointPoint.add(s1);
				s1 = calculateNextNumber(s1);
			}else
				return s1;
			
			if(listJointPoint.indexOf(s2) == -1){
				listJointPoint.add(s2);
				s2 = calculateNextNumber(s2);
			}else
				return s2;
			}
		}
		
		private static int calculateNextNumber(int s){
		   char chaineNumber[] = String.valueOf(s).toCharArray();
		   Integer nextNumber = s;
			for (char c : chaineNumber) {
			   nextNumber+=Integer.parseInt(String.valueOf(c));
			}
		    return nextNumber;
		}
		
		// #endregion
}