package net.france.operantic.model;

import java.util.stream.LongStream;

public class Factoriel {
	
	/**
	 * Donnée un entier non négatif n , 
	 * factorielle est le produit de tous les entiers positifs inférieurs ou égaux à n .
	 * 
	 * @param args
	 */
	// java 8
	public static long factorialUsingStreams(int n) {
	    return LongStream.rangeClosed(1, n)
	        .reduce(1, (long x, long y) -> x * y);
	}
	  
	// java 7
	public static long factorialUsingForLoop(int n) {
	    long fact = 1;
	    for (int i = 2; i <= n; i++) {
	        fact = fact * i;
	    }
	    return fact;
	}
	
	public static int fact(int n){
	  if ((n == 0) || (n == 1))
	     return 1;  
	  else 
	     return (n * fact(n-1));  
	} 
	
	/*
	 * function factorielle(n){ if ((n === 0) || (n === 1)) return 1; else return (n
	 * * factorielle(n - 1)); }
	 */
}
