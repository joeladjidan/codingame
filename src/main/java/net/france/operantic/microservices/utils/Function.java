package net.france.operantic.microservices.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Function {

	 public static void stringContainsElement(String caractere , List<String> listString) {
		 System.out.println("\nBEGIN LISTER LES NOMBRES CONTENANT LE CARACTERE "+caractere);
	    	listString = Arrays.asList("girafe", "chameau", "chat", "poisson", "cachalot");
	    	listString.stream()
	                  // filtrage
	                   .filter(x -> x.contains(caractere))
	                  // mapping : reformatage des chaînes de caractères
	                   .map(x -> x.substring(0, 1).toUpperCase() + x.substring(1))
	                  // tri par ordre alphabétique
	                   .sorted()
	                   .forEach( System.out::println );
	    }
	 
	  
	  /**@trieCroissantDecroissant 
	   * tri dans l'ordre croissant puis decroissant les element du tableau
	   *  
	   * @param miniscule contient la liste des nombre à recopier 
	   * @param listDestinataire contient la liste vide qui recevra le resultat du tri
	   *
	   **/
	   public static void trieCroissantDecroissant(int array[])
	   {
		    System.out.println("\nBEGIN TRIE DE NOMBRE CROISSANT");
		    // créer un tableau qui contient des objets Integer
		    Integer[] integerArray = new Integer[array.length];
		    // afficher tous les entiers avant le tri
		    // copier tous les valeurs dans un tableau de type Integer
		    for (int i=0; i < array.length; i++) {
		       System.out.println("nombre: " + array[i]);
		       //instancier un nouveau Integer
		       integerArray[i] = new Integer(array[i]);
		    }
		  
		     // trier le tableau
		    Arrays.sort(integerArray); // Ordre croissant
		    //   Arrays.sort(integerArray, Collections.reverseOrder()); // Ordre decroissant
	
		    // lafficher tous les entiers après le tri
		    System.out.println("Tableau trié\n");
		    for (int entier : integerArray) {
		       System.out.println("nombre: " + entier);
		    }
	  }
	   
	  public static void maxArrayJava8 (int[] tab) {
		  System.out.println("\nBEGIN MAXIMUM D'UN TABLEAU");
		  OptionalInt max = IntStream.of(tab).max();
		  System.out.println("maximun: " + max.getAsInt());
	   }
	   
	   /** 
		 * 
		 * Determiner le minimum dans un tableau d'entier
		 * @param miniscule contient la liste des nombre à recopier 
		 * @param listDestinataire contient la liste vide qui recevra le resultat du tri
		 * 
		 **/
		public static void minArrayJava8 (int[] tab) {
		  System.out.println("\nBEGIN MINIMUM D'UN TABLEAU");
	       OptionalInt min = IntStream.of(tab).min();
	       System.out.println("minimun: " + min.getAsInt());
		}
		
		/** 
		 * 
		 * Compter les lettres en majiscule dans une chaine de caractere
		 * @param miniscule contient la liste des nombre à recopier 
		 * @param listDestinataire contient la liste vide qui recevra le resultat du tri
		 * 
		 **/
		public static void compterMajusculesJava8(String majiscule) {
			System.out.println("\nBEGIN NOMBRE MAJISCULE");
		    long compteur = majiscule.chars().filter(Character::isUpperCase).count();
		    System.out.println("minimun: " + compteur);
		}
		
		/** 
		 * 
		 * Compter les lettres en miniscules dans une chaine de caractere
		 * @param miniscule contient la liste des nombre à recopier 
		 * @param listDestinataire contient la liste vide qui recevra le resultat du tri
		 * 
		 **/
		public static void compterMinisculeJava8(String miniscule) {
			System.out.println("\nBEGIN NOMBRE MINISCULE");
			long compteur = miniscule.chars().filter(Character::isLowerCase).count();
		    System.out.println("minimun: " + compteur);
		}
		
		/** 
		 * 
		 * Fonction recopier une les elements d'une liste en java 8
		 * @param listSource contient la liste des nombre à recopier 
		 * @param listDestinataire contient la liste vide qui recevra le resultat du tri
		 * 
		 **/
		public static void recopierListeJava8(List<String> listSource , List<String> listDestinataire) 
		{
		   System.out.println("\nBEGIN RECOPIER UNE LISTE DANS UNE AUTRE");
		   listDestinataire = Optional.ofNullable(listSource)
			   .filter(s->s.contains("Edwige"))
			   .map(List::stream).orElseGet(Stream::empty)
			   .skip(2) // Ignorer les "2" premiers éléments du flux
			   .collect(Collectors.toList() );
		   listDestinataire.forEach(System.out::println);
		   System.out.println("\nBEGIN PERMUTTER LES VALEURS ");
		}
		
		/** 
		 * 
		 * Fonction parcourir une list d'entier et récuperer 
		 * les nombres pairs dans la limite et des sauts
		 * 
		 * @param offset un entier qui definit les elements à ignoré
		 * @param limit un entier qui definir la limite 
		 * 
		 **/
		public static List<Integer> getEvenNumbers(int offset, int limit) {
		    return Stream.iterate(0, i -> i + 1)
		        .filter(i -> i % 2 == 0)
		        .skip(offset) // Ignorer les "2" premiers éléments du flux
		        .limit(limit) // taille maximum de la liste
		        .collect(Collectors.toList());
		        
		     //   list.stream().map(x -> x + 1).forEach(System.out::println);
		}

	    /** 
	     * permutation function 
	     * @param str string to calculate permutation for 
	     * @param l starting index 
	     * @param r end index 
	     */
	    public static void permute(String str, int l, int r) 
	    { 
	        if (l == r) {
	        	System.out.println(str);
	        }
	        else 
	            { 
	            for (int i = l; i <= r; i++) { 
	                str = swap(str, l, i); 
	                permute(str, l + 1, r); 
	                str = swap(str, l, i); 
	            } 
	        } 
	    } 
		  
	    /** 
	     * Swap Characters at position 
	     * @param a string value 
	     * @param i position 1 
	     * @param j position 2 
	     * @return swapped string 
	     */
	    public static String swap(String a, int i, int j) 
	    { 
	        char temp; 
	        char[] charArray = a.toCharArray(); 
	        temp = charArray[i]; 
	        charArray[i] = charArray[j]; 
	        charArray[j] = temp; 
	        return String.valueOf(charArray); 
	    } 
		    
	    /** 
	     * Swap Characters at position 
	     * @param a string value 
	     * @param i position 1 
	     * @param j position 2 
	     * @return swapped string 
	     */
	    public static void numberPair(List<Integer> list)
	    {
	    	System.out.println("\nBEGIN DETERMINER LES NOMBRES PAIR ");
	        list.stream() // Ccreating Stream from collection source
	        .filter(i -> i%2 == 0) // Intermediate Operation
	        .sorted()
	        .forEach(System.out::println); // Terminal Operation
	    }
		    
	    /** 
	     * 
	     * ranger les nombres dans l'ordre pair 
	     * 
	     * @param List<Integer> list contient les nombres
	     * @return  
	     */
	    public static void numberInPair(List<Integer> list)
	    {
	    	System.out.println("\nBEGIN DETERMINER LES NOMBRES IMPAIR ");
	        list.stream() // Ccreating Stream from collection source
	        .filter(i -> i%2 == 1) // Intermediate Operation
	        .sorted()
	        .forEach(System.out::println); // Terminal Operation
	    }
		    
	    /** 
	     * Tester la valeur de la variable
	     * 
	     * A.isFoo(String param) devrait retourner  si  est égal à la chaine , 
	     * sinon elle devrait true param "foo" retourner . false
         * Implémentez A.isFoo(String param)
	     * 
	     * @param String param 
	     * @return boolean
	     */
	     public static boolean isFoo(String param ) 
	     {    
	    	 System.out.println("BEGIN TESTER LA VALEUR DE LA VARIABLE");
	    	 if(param == null) 
	    		 return false;  
	    	 if( param.equals("foo"))
	    	 {     
	    		 return true;    
	    	 }else{      
	    		 return false;    
	         } 
	    } 
    	     
	    public static boolean sum(int i, int j) 
	    {
	    	 int sum = i + j;
	    	 if( i == 1 || j == 5 || sum == 1)
	    	 {
	    		 System.out.println("\nBEGIN CALCULER LA SOMME  "+sum);
	    		 return true; 
	    	 }else{
	    		 return false;
	    	 }
	     }
	    
		/** 
		 * Fonction recopier une les elements d'une liste en java 8
		 * @param listSource contient la liste des nombre à recopier 
		 * @param listDestinataire contient la liste vide qui recevra le resultat du tri
		 * @return 
		 * 
		 **/
		public static String webnet(Integer[] tab) 
		{
		   System.out.println("\nBEGIN RECOPIER UNE LISTE DANS UNE AUTRE");
		   List<Integer> list = Arrays.asList(tab);
		   StringBuilder str = new StringBuilder();
		   list.forEach(str::append);
		   System.out.println(""+  str);
		   for(int i : list) {
			  if(i%2 == 0) 
			    list.add(Integer.valueOf(i));
		   }
		   return str.toString() ;
		}
		
		/**  
		 * Concatenates the given array of strings
		 * 
		 * @return
		 */
		public static String concat(String[] strings) {
			StringBuilder str = new StringBuilder();
			for(int i = 0; i < strings.length; i++){
				str = str.append(strings[i]);
			}
			 System.out.println("\nBEGIN CONCATENATION DE CHAINE \n"+str.toString());
			return str.toString();
		}
		
	    
	//    La fonction JavaScript qui vous est présentée contient un bug. Votre objectif est de le trouver et de le corriger.
	//    Vous devez implémenter la fonction convertToIntegers() qui prend en paramètre un tableau de strings. Chacune de ces strings représente un entier. La fonction doit donc les parser et retourner la liste de ces entiers. 
	//     Par exemple, convertToIntegers(["4", "7", "12"]) doit retourner [4, 7, 12].
	//    Remarque: Pour avoir le score maximum, vous devez continuez à utiliser la fonction Array.map. 
	    
    	    
    	    
    	    
    	     
    	     
    	     
}
