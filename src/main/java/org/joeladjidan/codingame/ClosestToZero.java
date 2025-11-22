package org.joeladjidan.codingame;

/**
 * Utilitaire pour trouver l'entier le plus proche de zéro dans un tableau.
 */
public final class ClosestToZero {

    private ClosestToZero() { /* utilitaire */ }

    /**
     * Retourne l'entier du tableau `ints` le plus proche de zéro.
     * Si deux entiers sont à égale distance de zéro, le positif est préféré.
     * Retourne 0 si `ints` est null ou vide.
     */
    public static int closestToZero(int[] ints) {
        if (ints == null || ints.length == 0) return 0;

        int best = ints[0];
        for (int i = 1; i < ints.length; i++) {
            int v = ints[i];
            int absV = Math.abs(v);
            int absBest = Math.abs(best);
            if (absV < absBest) {
                best = v;
            } else if (absV == absBest && v > best) {
                // en cas d'égalité de distance à zéro, choisir le positif
                best = v;
            }
        }
        return best;
    }
}
