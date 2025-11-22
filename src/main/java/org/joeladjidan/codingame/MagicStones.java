package org.joeladjidan.codingame;

import java.util.*;

/**
 * Main de test :
 * - Si vous lancez sans args : exécute des cas de test intégrés.
 * - Si vous lancez avec l'argument "stdin" : lit depuis l'entrée standard.
 *
 * Mode stdin attendu :
 * n
 * v1 v2 v3 ... vn
 *
 * Exemple :
 * 7
 * 1 3 3 7 7 7 7
 */
public class MagicStones {

    /**
     * Calcule le nombre final de pierres restantes suivant les règles du problème.
     *
     * Approche :
     * - Compter la fréquence de chaque niveau dans un TreeMap (tri croissant).
     * - Itérer sur les niveaux, en gardant un "carry" (paires qui se transforment
     *   en une pierre du niveau suivant). Entre deux niveaux distants, on
     *   propage le carry sur les niveaux vides (en extrayant les bits de carry),
     *   ce qui produit des pierres isolées quand le carry est impair.
     * - Enfin, on consomme les bits restants du carry.
     *
     * Complexité : O(n log m) pour construire la map (n = nombre d'entrées,
     * m = nombre de niveaux distincts) et O(m + log carry) pour l'itération.
     */
    public static int magic(List<Integer> stones) {
        Objects.requireNonNull(stones, "stones ne doit pas être null");
        if (stones.isEmpty()) {
            throw new IllegalArgumentException("La liste 'stones' doit contenir au moins un élément.");
        }

        // Compter les occurrences par niveau (triées)
        var counts = new TreeMap<Integer, Long>();
        for (var s : stones) {
            counts.merge(s, 1L, Long::sum);
        }

        long result = 0L;
        long carry = 0L;
        Integer prevLevel = null;

        for (var entry : counts.entrySet()) {
            int level = entry.getKey();
            long count = entry.getValue();

            if (prevLevel != null) {
                int gap = level - prevLevel - 1;
                // Propager le carry sur les niveaux vides entre prevLevel et level
                while (gap > 0 && carry > 0) {
                    result += carry & 1L; // bit de poids faible du carry => pierre isolée
                    carry >>= 1; // on remonte d'un niveau
                    gap--;
                }
            }

            // Fusionner les pierres présentes au niveau courant avec le carry
            long total = carry + count;
            result += total & 1L;
            carry = total >>> 1; // paires deviennent carry pour le niveau suivant

            prevLevel = level;
        }

        // Propagation finale du carry jusqu'à extinction
        while (carry > 0) {
            result += carry & 1L;
            carry >>= 1;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        if (args.length > 0 && "stdin".equalsIgnoreCase(args[0])) {
            try (var sc = new java.util.Scanner(System.in)) {
                int n = sc.nextInt();
                var stones = new ArrayList<Integer>(n);
                for (int i = 0; i < n; i++) stones.add(sc.nextInt());
                System.out.println(magic(stones));
            }
            return;
        }

        System.out.println("== Tests intégrés ==");
        System.out.println("magic([1]) -> " + magic(List.of(1)) + " (attendu 1)");
        System.out.println("magic([1,1]) -> " + magic(List.of(1, 1)) + " (attendu 1)");
        System.out.println("magic([1,1,1]) -> " + magic(List.of(1, 1, 1)) + " (attendu 2)");
        System.out.println("magic([1,1,1,1]) -> " + magic(List.of(1, 1, 1, 1)) + " (attendu 1)");
        System.out.println("magic([2,2,2,2]) -> " + magic(List.of(2, 2, 2, 2)) + " (attendu 1)");
        System.out.println("magic([2,2,2,2,2]) -> " + magic(List.of(2, 2, 2, 2, 2)) + " (attendu 2)");
        System.out.println("magic([3,3,3]) -> " + magic(List.of(3, 3, 3)) + " (attendu 2)");
        System.out.println("magic([9999,9999]) -> " + magic(List.of(9_999, 9_999)) + " (attendu 1)");
        System.out.println("magic([1,3,3,7,7,7,7]) -> " + magic(List.of(1, 3, 3, 7, 7, 7, 7)) + " (attendu 3)");
        System.out.println("magic([5,5,5,5,5,6,6]) -> " + magic(new ArrayList<>(List.of(5, 5, 5, 5, 5, 6, 6))) + " (attendu 2)");
    }
}