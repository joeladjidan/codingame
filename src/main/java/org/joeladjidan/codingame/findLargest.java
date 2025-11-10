package org.joeladjidan.codingame;

import java.util.Arrays;

public class findLargest {

    /**
     * Retourne le plus grand nombre dans le tableau.
     * Hypothèse : numbers contient au moins un élément.
     *
     * @param numbers tableau d'entiers
     * @return le plus grand entier trouvé
     */

    public static int findLargest(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Le tableau ne doit pas être vide.");
        }
        return Arrays.stream(numbers).max().getAsInt();
     }

    /**
     * Méthode main pour tester findLargest.
     */
    public static void main(String[] args) {
        // Cas de test intégrés
        int[] test1 = {1, 2, 3, 4, 5};
        int[] test2 = {-10, -20, -3, -4};
        int[] test3 = {42};
        int[] test4 = {100, 200, 50, 999, 0};

        System.out.println("Test 1 : " + findLargest(test1) + " (attendu 5)");
        System.out.println("Test 2 : " + findLargest(test2) + " (attendu -3)");
        System.out.println("Test 3 : " + findLargest(test3) + " (attendu 42)");
        System.out.println("Test 4 : " + findLargest(test4) + " (attendu 999)");
    }
}
