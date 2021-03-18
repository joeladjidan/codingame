package net.france.operantic.microservices.codingame;
import java.util.Arrays;
import java.util.stream.IntStream;

import net.france.operantic.microservices.utils.Constante;

/**
 * 
 * @author operantic
 *
 * La fonction JavaScript qui vous est présentée contient un bug. Votre objectif est de le trouver et de le corriger.
 * Vous devez implémenter la fonction StringToIntegerArray() qui prend en paramètre un tableau de strings.
 * Chacune de ces strings représente un entier. La fonction doit donc les parser et retourner la liste de ces entiers.
 * Par exemple, convertToIntegers(["4", "7", "12"]) doit retourner [4, 7, 12].
 * Remarque: Pour avoir le score maximum, vous devez continuez à utiliser la fonction Array.map.
 *
 */

public class TestStringToIntegerArray {
	
	   public static void main(String args[]) 
	   {
	      String [] str = {"123", "345", "437", "894"};
	      int size = str.length;
	      int [] arr = new int [size];
	      for(int i=0; i<size; i++) {
	         arr[i] = Integer.parseInt(str[i]);
	      }
	      System.out.println("Element Table : "+Arrays.toString(arr));
	      Arrays.stream(arr).max().getAsInt();
	      System.out.println("Maximum : "+Arrays.stream(arr).max().getAsInt());
     }
	   
	   
	   
	    // JavaScript code below
		// This function doesn't work as expected.
		// Find the error and fix it.
	//   const arrStr = ["1", "3", "5", "9"];
	 //  const nuevo = arrStr.map((i) => Number(i));
	 //  console.log(nuevo);
	   // [1,3,5,9];
}