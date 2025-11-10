package org.joeladjidan.codingame;

import java.util.Arrays;

/**
 * Démonstration Java (Java 17) de la fonction JavaScript `convertToIntegers()`.
 *
 * En JavaScript la solution correcte est par exemple :
 *   function convertToIntegers(arr) {
 *     return arr.map(s => parseInt(s, 10));
 *   }
 * ou plus concis : arr.map(Number)
 *
 * Ici, la méthode Java équivalente utilise les streams et `Integer.parseInt`.
 */
public class ConvertToIntegers {

    /**
     * Convertit un tableau de chaînes en tableau d'entiers en parsant chaque élément.
     * Comportement : lève NumberFormatException si une chaîne n'est pas un entier valide.
     *
     * @param strings tableau de chaînes représentant des entiers (non-null)
     * @return tableau d'entiers parsés
     */
    public static int[] convertToIntegers(String[] strings) {
        // Utilise Arrays.stream(..).mapToInt(Integer::parseInt) comme l'équivalent Java de Array.map en JS
        return Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void main(String[] args) {
        String[] input = {"4", "7", "12"};

        int[] result = convertToIntegers(input);

        System.out.println("Input = " + Arrays.toString(input));
        System.out.println("Output = " + Arrays.toString(result));

        // Quelques tests supplémentaires
        String[] empty = new String[] {};
        System.out.println("Empty -> " + Arrays.toString(convertToIntegers(empty)));

        String[] negatives = new String[] {"-1", "0", "100"};
        System.out.println("Negatives -> " + Arrays.toString(convertToIntegers(negatives)));
    }
}

