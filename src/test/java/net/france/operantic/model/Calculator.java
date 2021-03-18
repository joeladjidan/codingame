package net.france.operantic.model;

import java.util.Arrays;

public class Calculator {
    /**
	 * 
	 * @author operantic
	 * 
	 * C'est bientôt les soldes d'été !
	 * Vous travaillez pour un magasin qui souhaite offrir une réduction de discount% 
	 * sur le produit le plus cher acheté par un client donné pendant la période des soldes.
	 * Le responsable du magasin vous demande de développer la méthode calculateTotalPrice().
	 *
	 * Cette méthode :
	 * 
	 * prend en paramètres la liste de prix des produits achetés par le client et le pourcentage de réduction discount. 
	 * retourne le prix de vente total (arrondi à l'entier inférieur si le total ne tombe pas rond).
	 * 
	 * Contraintes:
	 * 0 ≤ discount ≤ 100 
	 * 0 < prix d'un produit < 100000 
	 * 0 < nombre de produits < 100
	 * 
	 */
	public static int totalPrice(int[] prices, int discount) {
		Arrays.sort(prices);
		prices[prices.length-1] -= (prices[prices.length-1]*discount)/100;
		double somme = 0;
		  for(int price : prices){
			 somme+=price;
		  }
		  return (int)somme;
	}
	
   /**
	* 
	* Écrivez le corps de la méthode calc(array, n1, n2).
    * array est un tableau d'entiers.
    * Les paramètres n1 et n2 sont des entiers définis par la relation 0 <= n1 <= n2 < array.length.
    * La méthode calc doit retourner la somme des entiers de array dont l'index appartient à l'intervalle [n1; n2].
	* 
	* @return the sum of integers whose index is between n1 and n2
	*/
	// Java 7
	public static int sommeArray(int[] array, int n1, int n2) {
	  int somme = 0;
	  for(int i = n1; i <= n2; i++){
	     somme+=array[i];
	  }
	  return somme;
	}

    public static float addition(float a, float b) {
        return a + b;
    }

    public int division(int a, int b) {
        return a/b;
    }
}

