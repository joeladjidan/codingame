package org.joeladjidan.codingame;

import java.util.stream.IntStream;

public class AStreamFun {

    /**
     * Retourne true si :
     * - i == 1 ou j == 1
     * - OU si i + j == 1
     *
     * Version Stream API (fun).
     */
    public static boolean a(int i, int j) {
        // anyMatch pour "au moins un vaut 1"
        boolean hasOne = IntStream.of(i, j).anyMatch(x -> x == 1);
        // sum() pour "la somme vaut 1"
        boolean sumIsOne = IntStream.of(i, j).sum() == 1;
        return hasOne || sumIsOne;
    }

    // --- Démo ---
    public static void main(String[] args) {
        System.out.println("A.a(1, 5) -> " + a(1, 5) + " (attendu true)");
        System.out.println("A.a(2, 3) -> " + a(2, 3) + " (attendu false)");
        System.out.println("A.a(-3, 4) -> " + a(-3, 4) + " (attendu true)");
        System.out.println("A.a(0, 1) -> " + a(0, 1) + " (attendu true)");
        System.out.println("A.a(0, 0) -> " + a(0, 0) + " (attendu false)");
    }
}
