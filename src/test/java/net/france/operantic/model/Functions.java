package net.france.operantic.model;

import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import net.france.operantic.microservices.utils.Constante;

public class Functions {
	/**
	 * 
	 * @author operantic
	 * 
	 * Implémentez la méthode findSumIntervalNumber(numbers) qui retourne la somme des entier 
	 * d'un intervalle compris entre les nombre en parametre
     * 
     * @param start
     * @param end
	 * @return the largest number of the given array
	 * 
	 */
	public static int findSumIntervalNumber(int start, int end) {
		// Intervalle Strictement ouvert
	//	int sum = IntStream.range(1, 10).sum();//returns 45
		// Intervalle Strictement fermé
		int sum = IntStream.rangeClosed(start, end).sum(); //returns 55
		System.out.println("SOMME DE NOMBRE : "+sum);
		return sum;
	}
	
	  /**
		* 
		* @author operantic
		* 
		* La méthode sumRange devrait retourner la somme des entiers compris entre 10 et 100 inclusifs contenus dans le tableau passé en paramètre.
		* Corrigez la méthode sumRange.
		* Note : le paramètre ints n'est jamais null.
		* 
		*/
		public static int sumRange(int[] ints) {
		  int sum = 0;
		  if(ints != null ) {
			  for (int i = 1; i < ints.length; i++) {
				  int n = ints[i];
					if (n >= 10 && n <= 100) 
						sum += n;
			  }
		  }
		  return sum;
		}
		
		public static int findSumUsingStream(int[]array) {
		    return Arrays.stream(array).sum();
		}
		
	    public static double findAverageUsingStream(int[]array) {
	       return Arrays.stream(array).average().orElse(Double.NaN);
	    }
	
	/**
	 * 
	 * La fonction JavaScript qui vous est présentée contient un bug. Votre objectif est de le trouver et de le corriger.
	 * Vous devez implémenter la fonction StringToIntegerArray() qui prend en paramètre un tableau de strings.
	 * Chacune de ces strings représente un entier. La fonction doit donc les parser et retourner la liste de ces entiers.
	 * Par exemple, convertToIntegers(["4", "7", "12"]) doit retourner [4, 7, 12].
	 * Remarque: Pour avoir le score maximum, vous devez continuez à utiliser la fonction Array.map.
	 * @return 
	 *
	 */
	 public static int stringToIntegerArray(String [] str)  {
	    int size = str.length;
	    int [] arr = new int [size];
	    for(int i=0; i<size; i++) {
	       arr[i] = Integer.parseInt(str[i]);
	    }
	    System.out.println("Element Table : "+Arrays.toString(arr));
	    Arrays.stream(arr).max().getAsInt();
	    System.out.println("Maximum : "+Arrays.stream(arr).max().getAsInt());
	    return  Arrays.stream(arr).max().getAsInt();
     }
	
	/**
	 * In stations and airports you often see this type of screen. Have you ever asked yourself how 
	 * it might be possible to simulate this display on a good old terminal? We have: with ASCII art!
	 * Cet exercice consiste à identifier une chaine de caractères composée de parenthèses () et de crochets []. 
	 * Une chaine de ce type est considérée comme correcte : si c'est une chaine vide ou null si la chaine A est correcte, 
	 * (A) et [A] sont correctes si les chaines A et B sont correctes, la concaténation AB est également correcte Données : 
	 * La chaine contient au plus 10 000 caractères.
	 * 
     * Exemples : [()] est correcte, (()[]) est correcte, ([)] n'est pas correcte, (( n'est pas correcte.
     * Implémentez la méthode check(String str) qui devra retourner true si la chaine passée en paramètre est correcte, 
     * sinon elle retournera false.
	 *
	 * Checks that the given string is correct.
	 */
	public static boolean check(String str) {
		Deque<String> pile = new ArrayDeque<>();
		
		char[] tableau = String.valueOf(str).toCharArray();
		List<String> lStrings = new ArrayList<>();
		
		for (char c : tableau) {
			lStrings.add(Character.toString(c));
		}
	
	    for (String element : lStrings) {
		   if(element.equals("(") || element.equals("[")){
			   pile.add(element);
		   }else{
			  String correspondant = pile.getLast();
			  pile.removeLast();
			if(correspondant.equals("(") && element.equals(")")) {
			  continue;
			}else if(correspondant.equals("[") && element.equals("]")){
			  continue;
			}else{
			  return false;
			}
		  }
	   }

	   if(pile.size()>0){
	      return false;
	   }
	   
       return true;
   }
	
	
	/**
	 * 
	 * Implémentez get(int l, int c) en découvrant un modèle de construction générique à partir de l'illustration ci-dessous.
	 * Données : 0 ≤ c ≤ l ≤ 10000
	 * 
	 * Important :
	 * Essayez de privilégier un faible usage de la mémoire RAM, 
	 * 64 bits peuvent ne pas suffire pour stocker certains résultats ! 
	 * Privilégiez ensuite le temps d'exécution si c'est possible.
	 * 
	 * 
	 * Exemples :
	 * get(4, 2) devrait retourner la chaîne 6
	 * get(5, 0) devrait retourner la chaîne 1
	 * get(67, 34) devrait retourner la chaîne 14226520737620288370
	 * 
	 * @return the number in the (l, c) cell
	 */
	public static String get(int l, int c) {
		  return String.valueOf(getFactoriel(l) / (getFactoriel(c)*getFactoriel(l-c)));
	}
	
	public static Integer getFactoriel(int nobre){
		if(nobre == 0) 
			return 1;
		else{
		    return nobre * getFactoriel(nobre-1);
	  }
	}
	
	 /**
		* 
		* @author operantic
		* 
		* Implémentez la méthode findNetworkEndpoint(startNodeId, fromIds, toIds) qui 
		* retourne l'id du dernier noeud du réseau trouvé en partant du noeud startNodeId et en suivant les liens du réseau.
	    * Dans l'exemple ci-dessus, le noeud terminal en partant du noeud n°2 (ou de n'importe quel noeud) est le noeud n°5.
		* fromIds et toIds sont deux tableaux de la même longueur qui décrivent les liens unidirectionnels du réseau ( fromIds[i] est lié à toIds[i]).
	    * Dans le cas où vous rencontrez une boucle lors du parcours du réseau, 
	    * la méthode doit renvoyer l'id du dernier noeud traversé avant de clore la boucle.
	    * Constraintes:
	    * 0 < nombre de liens < 10000 Un noeud ne peut pas être directement lié à lui-même.
		* 
		* @return the number that is closest to zero
		*/
		
		 public static int findNetworkEndpoint(int startNodeId, int[] fromIds, int[] toIds) {
			 List<Integer> listFromId = new ArrayList<Integer>();
			 List<Integer> listToId = new ArrayList<Integer>();
			 
			 for(int fro : fromIds){
			     listFromId.add(fro);
			 }
			 
			 
			 for(int fro : toIds){
			     listToId.add(fro);
			 }
			 
			 for(Integer elementToId : listToId){
			     if(listFromId.indexOf(elementToId) == -1) 
			        return elementToId;
			 }
		 
		     int indexStarTnode = listToId.indexOf(startNodeId);
		 
		     return listFromId.get(indexStarTnode);
		 }

		 
		 /* Ignore and do not change the code below */
		 // #region main
		 public static void main(String args[]) {
			 Scanner in = new Scanner(System.in);
			 
			 int startNodeId = in.nextInt();
			 int n = in.nextInt();
			 int[] fromIds = new int[n];
			 
			 for (int i = 0; i < n; i++) {
			    fromIds[i] = in.nextInt();
			 }
			 
			 int[] toIds = new int[n];
			 for (int i = 0; i < n; i++) {
			    toIds[i] = in.nextInt();
			 }
			 
			 PrintStream outStream = System.out;
			 System.setOut(System.err);
			 int endPointId = findNetworkEndpoint(startNodeId, fromIds, toIds);
			 System.setOut(outStream);
			 System.out.println(endPointId);
		 }
		 
		 public static int closestToZero(int[] ints) {
			  if(ints == null || ints.length == 0) 
				  return 0;
			  
			  int T;
			  int min = ints[0];
			  
			  Arrays.sort(ints);
			   for(int i =0; i < ints.length; i++)
			   {
				T = ints[i];
				  if(Math.abs(T)< Math.abs(min) || (T == -min && T > 0)){
				     min = T;
				  }
			   }
			   System.out.println("Resultat du minimum "+min);
			   return min;
			}
			 
			 void bsrt(int a[], int n)
			 {
			   for (int i = 0; i < n-1; i++)
				 for (int j = n-1; j > i; j--)
					 if (a[j-1] > a[j])
					 {
						 int tmp = a[j-1];
						 a[j-1] = a[j];
						 a[j] = tmp;
					 }
			 }
}

