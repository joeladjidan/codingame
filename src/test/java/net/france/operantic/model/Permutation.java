package net.france.operantic.model;

import java.util.Arrays;
public class Permutation {

   /**
	* 
	* @author operantic
	* 
	* Fonction qui permet de trouver le plus petit et le plus grand élément d'un tableau.
	* On vous donne un tableau d'entiers contenant 1 à n mais l'un des nombres de 1 à n 
	* dans le tableau est manquant. 
	* Vous devez fournir une solution optimale pour trouver le numéro manquant. 
	* Le numéro ne peut pas être répété dans l'arche.
	* 
	* @return the number that is closest to zero
	*/
	public static int trouvePetitEtGrand( int[] tab) {
     Arrays.sort(tab); 
     System.out.printf("tab[] : %s", Arrays.toString(tab)); 
     
      if(tab != null) {
     	 for(int i=0; i<tab.length ; i++) {
     		
     	 }
      }
	  return 0;
	}
 }