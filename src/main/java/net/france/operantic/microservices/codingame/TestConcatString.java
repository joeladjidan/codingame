package net.france.operantic.microservices.codingame;

import net.france.operantic.microservices.utils.Constante;

public class TestConcatString {
	/**
	 * 
	 * @author operantic
	 *
	 * StringUtils.concat(String[] strings) sert à joindre des chaînes de caractères bout à bout.
	 * Par exemple, à partir d'un tableau contenant "f", "o", "o", "bar", concat devrait retourner "foobar".
	 * Données : strings contient toujours au moins un élément.
	 * Implémentez StringUtils.concat(String[] strings).
	 *
	 * Concatenates the given array of strings.
	 */
	
	public static void main(String[] args) 
    {
		concat(Constante.table) ;
		System.out.println("Le resultat est : "+concat(Constante.table));
    }
	
	public static String concat(String[] strings) {
		StringBuilder  bf = new StringBuilder ();
		for(String b : strings){
		  bf.append(b);
		}
	    return bf.toString();
	}
}
