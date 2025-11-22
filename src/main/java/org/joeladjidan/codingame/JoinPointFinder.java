package org.joeladjidan.codingame;


public final class JoinPointFinder {

    private static final int LIMIT = 20_000_000;

    private JoinPointFinder() { /* utilitaire */ }

    /**
     * Retourne le point de jonction des deux suites définies par
     * next(n) = n + sumDigits(n), en partant de s1 et s2.
     * Préconditions : 0 < s1,s2 < LIMIT, le point de jonction < LIMIT.
     */
    public static int computeJoinPoint(int s1, int s2) {
        if (s1 <= 0 || s2 <= 0) {
            throw new IllegalArgumentException("s1 et s2 doivent être > 0");
        }

        boolean[] seen = new boolean[LIMIT + 1];

        int a = s1;
        while (a <= LIMIT) {
            seen[a] = true;
            a = next(a);
        }

        int b = s2;
        while (b <= LIMIT) {
            if (seen[b]) return b;
            b = next(b);
        }

        // Selon l'énoncé cela ne doit pas arriver ; retour d'erreur si jamais.
        throw new IllegalStateException("Point de jonction non trouvé dans les limites");
    }

    private static int next(int n) {
        return n + sumDigits(n);
    }

    private static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
