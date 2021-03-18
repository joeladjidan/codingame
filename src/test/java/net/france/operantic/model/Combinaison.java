package net.france.operantic.model;

public class Combinaison {
	/**
	 * 
	 * @author operantic
	 * 
	 * Vous organisez un tournoi d’échecs dans lequel les joueurs s'affronteront en duel.
	 * Pour former les duels on procède ainsi : d'abord on tire au hasard un joueur, 
	 * ensuite on tire au hasard son opposant parmi les joueurs restants. Cette paire forme un des duels du tournoi. 
	 * On procède de la même manière pour former toutes les paires.
	 * Dans cet exercice, on souhaiterait connaître le nombre de paires qu'il est possible d'obtenir 
	 * sachant que l'ordre des opposants dans une paire n'a pas d'importance.
	 * Par exemple, avec 4 joueurs nommés A, B, C et D, il est possible d'obtenir 6 paires différentes : 
	 * AB, AC, AD, BC, BD, CD.
	 * Implémentez count pour retourner le nombre de paires possibles. 
	 * Le paramètre n correspond au nombre de joueurs.
	 * Essayez d'optimiser votre solution pour que, dans l'idéal, la durée de traitement soit la même quel que soit n.
	 * 
	 * Données : 2 <= n <= 10000
	 * 
	 * @return boolean int
	 */
	 
	/** Counts the number of pairs for n players. */
	public static int count(int n) {
		return (n>= 2 && n<=1000)  ? ((n*n)-(n*1))/2 : 0;
		
	}
}

