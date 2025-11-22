package org.joeladjidan.codingame;


public final class PairCounter {

    private PairCounter() { /* utilitaire */ }

    /**
     * Retourne le nombre de paires distinctes (ordre indifférent) parmi n joueurs.
     * Complexité : O(1).
     * Précondition : n >= 2 (renvoie 0 sinon).
     */
    public static long count(int n) {
        if (n < 2) return 0L;
        return (long) n * (n - 1) / 2;
    }

}
