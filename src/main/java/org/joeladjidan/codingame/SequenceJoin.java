package org.joeladjidan.codingame;

import java.util.BitSet;

/**
 * Calcule le point de jonction de deux suites définies par :
 * next(n) = n + sumDigits(n)
 *
 * Les suites sont strictement croissantes, ainsi on peut avancer la plus petite
 * des deux valeurs jusqu'à ce qu'elles deviennent égales (point de jonction).
 *
 * Contraintes : 0 < s1,s2 < 20000000 et le point de jonction < 20000000.
 */
public class SequenceJoin {

    /**
     * Calcule la somme des chiffres de n (n >= 0)
     */
    private static int sumDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    /**
     * Calcule next(n) = n + sumDigits(n)
     */
    private static int next(int n) {
        return n + sumDigits(n);
    }

    /**
     * Renvoie le point de jonction des deux suites commençant en s1 et s2.
     * Implémentation : marque la trajectoire de s1 dans une BitSet
     * puis parcourt la trajectoire de s2 pour trouver la première valeur marquée.
     *
     * Retourne -1 si les paramètres sont invalides ou si aucune jonction n'est trouvée
     * sous la limite (20_000_000).
     *
     * @param s1 point de départ 1 (strictement positif)
     * @param s2 point de départ 2 (strictement positif)
     * @return le point de jonction (entier) ou -1 si non trouvé / entrée invalide
     */
    public static int computeJoinPoint(int s1, int s2) {
        final int LIMIT = 20_000_000;
        if (s1 <= 0 || s2 <= 0) {
            return -1;
        }
        if (s1 >= LIMIT || s2 >= LIMIT) {
            return -1;
        }

        BitSet visited = new BitSet(LIMIT);
        int v = s1;
        // Mark trajectory of s1
        while (v < LIMIT && !visited.get(v)) {
            visited.set(v);
            v = next(v);
        }

        // Traverse trajectory of s2 and find first marked value
        v = s2;
        while (v < LIMIT) {
            if (visited.get(v)) return v;
            v = next(v);
        }

        return -1;
    }

    public static void main(String[] args) {
        // Exemples fournis
        int s1 = 471;
        int s2 = 480;
        int join = computeJoinPoint(s1, s2);
        if (join >= 0) {
            System.out.printf("computeJoinPoint(%d, %d) = %d\n", s1, s2, join); // attendu 519
        } else {
            System.out.printf("computeJoinPoint(%d, %d) = -1 (no join or invalid input)\n", s1, s2);
        }

        // Quelques paires supplémentaires
        int[][] tests = new int[][] {
            {34, 41},
            {1, 1},
            {2, 3},
            {119, 120}
        };
        for (int[] t : tests) {
            int a = t[0], b = t[1];
            int res = computeJoinPoint(a, b);
            if (res >= 0) {
                System.out.printf("computeJoinPoint(%d, %d) = %d\n", a, b, res);
            } else {
                System.out.printf("computeJoinPoint(%d, %d) = -1 (no join or invalid input)\n", a, b);
            }
        }
    }
}
