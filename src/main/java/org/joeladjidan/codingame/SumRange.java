package org.joeladjidan.codingame;

import java.util.stream.IntStream;

/**
 * Classe utilitaire fournissant la méthode sumRange et un main de démonstration.
 *
 * La méthode sumRange retourne la somme des entiers compris entre 10 et 100 inclusifs
 * contenus dans le tableau passé en paramètre. Le paramètre `ints` n'est jamais null.
 */
public class SumRange {

    /**
     * Retourne la somme des valeurs du tableau `ints` qui sont entre 10 et 100 inclus.
     * Délègue à RangeSummer.sumRange(ints) pour une implémentation lisible basée sur streams.
     *
     * @param ints tableau d'entiers (non null)
     * @return somme des entiers v tels que 10 <= v <= 100
     */
    public static int sumRange(int[] ints) {
        // IntStream.of est lisible et évite la boucle explicite ; la logique de filtrage
        // est concise et expressive.
        return IntStream.of(ints)
                .filter(v -> v >= 10 && v <= 100)
                .sum();
    }

    /**
     * Programme autonome pour démontrer et tester sumRange.
     * Affiche quelques cas de test et leurs résultats attendus.
     */
    public static void main(String[] args) {
        int[] a1 = {1, 5, 9}; // aucun élément dans l'intervalle => 0
        int[] a2 = {10, 50, 100}; // tous dans l'intervalle => 160
        int[] a3 = {-10, 10, 11, 101, 100, 200}; // somme = 10 + 11 + 100 = 121
        int[] a4 = {}; // tableau vide => 0
        int[] a5 = {10, 10, 100, 100}; // duplicatas => 220

        System.out.println("sumRange(a1) = " + sumRange(a1) + " (attendu 0)");
        System.out.println("sumRange(a2) = " + sumRange(a2) + " (attendu 160)");
        System.out.println("sumRange(a3) = " + sumRange(a3) + " (attendu 121)");
        System.out.println("sumRange(a4) = " + sumRange(a4) + " (attendu 0)");
        System.out.println("sumRange(a5) = " + sumRange(a5) + " (attendu 220)");
    }
}
