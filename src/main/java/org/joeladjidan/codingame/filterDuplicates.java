package org.joeladjidan.codingame;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Arrays;

public class filterDuplicates {

    /**
     * Retourne un tableau sans doublons, en conservant l'ordre initial.
     *
     * @param data tableau d'entiers (non null)
     * @return tableau filtré sans doublons
     */
    public static int[] filterDuplicates(int[] data) {
        if (data.length == 0) {
            return new int[0];
        }

        Set<Integer> seen = new LinkedHashSet<>();
        for (int value : data) {
            seen.add(value);
        }

        // Convertir le Set en tableau d'int
        int[] result = new int[seen.size()];
        int i = 0;
        for (int val : seen) {
            result[i++] = val;
        }
        return result;
    }

    /**
     * Méthode main pour tester filterDuplicates.
     */
    public static void main(String[] args) {
        int[] test1 = {7, 3, 6, 4, 3, 3, 4, 9};
        int[] test2 = {1, 1, 1, 1};
        int[] test3 = {5, 6, 7};
        int[] test4 = {};

        System.out.println("Test 1 : " + Arrays.toString(filterDuplicates(test1)) + " (attendu [7, 3, 6, 4, 9])");
        System.out.println("Test 2 : " + Arrays.toString(filterDuplicates(test2)) + " (attendu [1])");
        System.out.println("Test 3 : " + Arrays.toString(filterDuplicates(test3)) + " (attendu [5, 6, 7])");
        System.out.println("Test 4 : " + Arrays.toString(filterDuplicates(test4)) + " (attendu [])");
    }
}
