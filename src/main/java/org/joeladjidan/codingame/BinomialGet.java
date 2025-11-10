package org.joeladjidan.codingame;

import java.math.BigInteger;
import java.util.Scanner;

public class BinomialGet {

    /**
     * Retourne C(l, c) sous forme de chaîne (peut avoir des milliers de chiffres).
     * Contraintes : 0 ≤ c ≤ l ≤ 10000
     * Utilise une seule BigInteger et la formule multiplicative pour minimiser la mémoire.
     */
    public static String get(int l, int c) {
        if (c < 0 || l < 0 || c > l) {
            throw new IllegalArgumentException("Contraintes violées : 0 ≤ c ≤ l, reçus l=" + l + ", c=" + c);
        }
        if (c == 0 || c == l) {
            return "1";
        }

        int k = Math.min(c, l - c); // symétrie C(l, c) = C(l, l-c) pour réduire les étapes
        BigInteger res = BigInteger.ONE;

        for (int i = 1; i <= k; i++) {
            // res = res * (l - k + i) / i ; la division est exacte à chaque étape
            int factor = l - k + i;
            res = res.multiply(BigInteger.valueOf(factor))
                    .divide(BigInteger.valueOf(i));
        }

        return res.toString();
    }

    /**
     * Main de test :
     * - Sans argument : exécute des tests intégrés (exemples de l'énoncé).
     * - Avec l'argument "stdin" : lit l et c depuis l'entrée standard et affiche get(l, c).
     */
    public static void main(String[] args) {
        if (args.length > 0 && "stdin".equalsIgnoreCase(args[0])) {
            try (Scanner sc = new Scanner(System.in)) {
                int l = sc.nextInt();
                int c = sc.nextInt();
                System.out.println(get(l, c));
            }
            return;
        }

        // Tests intégrés (rapides)
        System.out.println("get(4, 2)  = " + get(4, 2) + " (attendu 6)");
        System.out.println("get(5, 0)  = " + get(5, 0) + " (attendu 1)");
        System.out.println("get(67,34) = " + get(67, 34) + " (attendu 14226520737620288370)");

        // Quelques vérifications complémentaires
        System.out.println("get(1, 1)  = " + get(1, 1) + " (attendu 1)");
        System.out.println("get(10, 3) = " + get(10, 3) + " (attendu 120)");
        System.out.println("get(100, 50) longueur = " + get(100, 50).length() + " chiffres");
    }
}