package org.joeladjidan.codingame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MagicStones {

    /**
     * Calcule le nombre minimal de pierres après fusions successives.
     * Deux pierres de niveau n fusionnent en une pierre de niveau n+1.
     * <p>
     * Hypothèses :
     * - stones non vide
     * - 0 < niveau < 10000
     * <p>
     * Temps : O(n log n)
     * Mémoire : O(n) si la liste passée est immuable (copie), O(1) si elle est modifiable.
     */
    public static int magic(List<Integer> stones) {
        if (stones == null || stones.isEmpty()) {
            throw new IllegalArgumentException("La liste 'stones' doit contenir au moins un élément.");
        }

        // Validation (facultative si déjà garantie par l’appelant)
        for (int v : stones) {
            if (v <= 0 || v >= 10000) {
                throw new IllegalArgumentException("Chaque niveau doit vérifier 0 < n < 10000. Reçu: " + v);
            }
        }

        // Copier dans une liste modifiable si l'entrée est potentiellement immuable (List.of, Arrays.asList sur array fixe, etc.)
        stones = new ArrayList<>(stones);

        // Tri en place
        Collections.sort(stones);

        long result = 0L;
        long carryPairs = 0L;
        int i = 0;
        final int n = stones.size();

        while (i < n) {
            int L = stones.get(i);
            int j = i + 1;
            while (j < n && stones.get(j).intValue() == L) j++;
            int countAtL = j - i;

            long total = carryPairs + countAtL;
            result += (total & 1L);    // reste (0/1) au niveau L
            carryPairs = total >>> 1;  // paires -> L+1

            int nextLevel = (j < n) ? stones.get(j) : Integer.MAX_VALUE;
            long gaps = (nextLevel == Integer.MAX_VALUE) ? Long.MAX_VALUE : (long) nextLevel - (long) L - 1L;

            // Propager au travers des niveaux absents
            while (carryPairs != 0 && gaps-- > 0) {
                result += (carryPairs & 1L);
                carryPairs >>>= 1;
            }

            i = j;
        }

        // Propagation finale après le dernier niveau
        while (carryPairs != 0) {
            result += (carryPairs & 1L);
            carryPairs >>>= 1;
        }

        return (int) result;
    }

    /**
     * Main de test :
     * - Si vous lancez sans args : exécute des cas de test intégrés.
     * - Si vous lancez avec l'argument "stdin" : lit depuis l'entrée standard.
     * <p>
     * Mode stdin attendu :
     * n
     * v1 v2 v3 ... vn
     * <p>
     * Exemple :
     * 7
     * 1 3 3 7 7 7 7
     */
    public static void main(String[] args) {
        if (args.length > 0 && "stdin".equalsIgnoreCase(args[0])) {
            // Lecture depuis la console
            try (Scanner sc = new Scanner(System.in)) {
                int n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("0");
                    return;
                }
                List<Integer> stones = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    stones.add(sc.nextInt());
                }
                int answer = magic(stones);
                System.out.println(answer);
            }
            return;
        }

        // --- Tests intégrés (hardcodés) ---
        System.out.println("== Tests intégrés ==");
        System.out.println("magic([1])                   -> " + magic(List.of(1)) + " (attendu 1)");
        System.out.println("magic([1,1])                 -> " + magic(List.of(1, 1)) + " (attendu 1)");
        System.out.println("magic([1,1,1])               -> " + magic(List.of(1, 1, 1)) + " (attendu 2)");
        System.out.println("magic([1,1,1,1])             -> " + magic(List.of(1, 1, 1, 1)) + " (attendu 1)");
        System.out.println("magic([2,2,2,2])             -> " + magic(List.of(2, 2, 2, 2)) + " (attendu 1)");
        System.out.println("magic([2,2,2,2,2])           -> " + magic(List.of(2, 2, 2, 2, 2)) + " (attendu 2)");
        System.out.println("magic([3,3,3])               -> " + magic(List.of(3, 3, 3)) + " (attendu 2)");
        System.out.println("magic([9999,9999])           -> " + magic(List.of(9_999, 9_999)) + " (attendu 1)");
        System.out.println("magic([1,3,3,7,7,7,7])       -> " + magic(List.of(1, 3, 3, 7, 7, 7, 7)) + " (attendu 3)");

        // Exemple si vous souhaitez passer une liste modifiable (sans copie) :
        List<Integer> mutable = new ArrayList<>(List.of(5, 5, 5, 5, 5, 6, 6));
        System.out.println("magic([5,5,5,5,5,6,6])       -> " + magic(mutable) + " (attendu 2)");
    }
}