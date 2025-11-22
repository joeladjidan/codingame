// java
package org.joeladjidan.codingame;

/**
 * Calcul de la position du danseur à l'étape n.
 */
public final class Algorithm {

    private Algorithm() { /* utilitaire */ }

    /**
     * Retourne la position du danseur à l'étape n (0 <= n <= 2147483647).
     * La suite des déplacements a période 6 ; on utilise les sommes précomputées.
     */
    public static int getPositionAt(int n) {
        if (n <= 0) return 0;
        // index = n % 6 -> valeurs pré-calculées des positions cumulées
        // n%6 : 0 -> 0, 1 -> 1, 2 -> -1, 3 -> -4, 4 -> -5, 5 -> -3
        final int[] prefix = {0, 1, -1, -4, -5, -3};
        return prefix[n % 6];
    }

    public static void main(String[] args) {
        int[] tests = {0, 1, 2, 3, 4, 5, 6, 100000, Integer.MAX_VALUE};
        System.out.println("Exemples de positions :");
        for (int n : tests) {
            System.out.printf("n = %d -> position = %d%n", n, getPositionAt(n));
        }

        // Vérification rapide de la périodicité (somme sur une période de 6 = 0)
        int sumPeriod = 0;
        for (int i = 1; i <= 6; i++) sumPeriod += getPositionAt(i) - getPositionAt(i - 1);
        System.out.println("Somme des déplacements sur une période de 6 = " + sumPeriod);
    }
}