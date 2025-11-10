package org.joeladjidan.codingame;

import java.util.Arrays;

public class FindSmallestInterval {

    /**
     * Retourne la plus petite différence (>= 0) entre deux éléments du tableau,
     * sans modifier le tableau d'entrée.
     *
     * Hypothèses :
     *  - numbers contient au moins deux éléments
     *  - taille maximale : 100 000 éléments
     *  - la différence tient dans un int
     *
     * @param numbers tableau d'entiers (non null, length >= 2)
     * @return la plus petite différence entre deux éléments
     */
    public static int findSmallestIntervalImmutable(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            throw new IllegalArgumentException("Le tableau doit contenir au moins deux éléments.");
        }

        // Copier pour préserver l'immuabilité de l'entrée
        int[] copy = Arrays.copyOf(numbers, numbers.length);

        // Tri en place de la copie (l'entrée d'origine n'est pas affectée)
        Arrays.sort(copy);

        // Parcours des différences adjacentes
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < copy.length; i++) {
            int diff = copy[i] - copy[i - 1]; // non négatif car trié
            if (diff < minDiff) {
                minDiff = diff;
                if (minDiff == 0) return 0; // meilleur possible
            }
        }
        return minDiff;
    }

    // --- Démonstration ---
    public static void main(String[] args) {
        int[] input1 = {1, 6, 4, 8, 2};
        int[] input2 = {3, 3, 3};
        int[] input3 = {-10, -3, 5, 9};
        int[] input4 = {100000, 100001};
        int[] input5 = {7, 2, 10, 15, 12, 11};

        System.out.println(findSmallestIntervalImmutable(input1) + " (attendu 1)");
        System.out.println(findSmallestIntervalImmutable(input2) + " (attendu 0)");
        System.out.println(findSmallestIntervalImmutable(input3) + " (attendu 4)");
        System.out.println(findSmallestIntervalImmutable(input4) + " (attendu 1)");
        System.out.println(findSmallestIntervalImmutable(input5) + " (attendu 1)");

        // Vérification que l'entrée n'est pas modifiée
        System.out.println("Entrée conservée: " + Arrays.toString(input1)); // doit rester [1, 6, 4, 8, 2]
    }
}