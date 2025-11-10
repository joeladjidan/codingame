package org.joeladjidan.codingame;

public class NextDifferentDigits {

    /**
     * Retourne le plus petit entier strictement supérieur à n
     * n'utilisant aucun chiffre présent dans n. Sinon -1.
     * n est un entier strictement positif < 2^31.
     */
    public static int next(int n) {
        if (n <= 0 || n == Integer.MAX_VALUE) return -1;

        // 1) Construire le bitmask des chiffres interdits à partir de n
        // bit i == 1 <=> le chiffre i apparaît dans n
        int forbiddenMask = 0;
        for (int x = n; x > 0; x /= 10) {
            forbiddenMask |= 1 << (x % 10);
        }

        // 2) Chiffres autorisés = complément sur 10 bits (0..9)
        int allowedMask = (~forbiddenMask) & 0x3FF; // 0b11_1111_1111
        if (allowedMask == 0) return -1;            // aucun chiffre autorisé
        // 3) Obtenir le plus petit autorisé (minAllowed) et le plus petit autorisé non nul (minNonZero)
        int minAllowed = lowestSetBitIndex(allowedMask);
        int allowedNonZeroMask = allowedMask & ~1;  // retire le bit du 0
        if (allowedNonZeroMask == 0) return -1;     // pas de tête possible
        int minNonZero = lowestSetBitIndex(allowedNonZeroMask);

        // 4) Longueur décimale de n et premier chiffre (sans String)
        int len = decimalLength(n);
        int pow10 = POW10[len - 1];
        int firstDigit = n / pow10;

        // 5) Essai: même longueur -> tête = plus petit autorisé > firstDigit (et != 0)
        int candidateFirst = smallestAllowedGreaterThan(firstDigit, allowedNonZeroMask);
        if (candidateFirst != -1) {
            long candidate = candidateFirst;
            for (int i = 1; i < len; i++) {
                candidate = candidate * 10 + minAllowed;
                if (candidate > Integer.MAX_VALUE) return -1;
            }
            if (candidate > n) return (int) candidate;
        }

        // 6) Essai: longueur + 1 -> tête = minNonZero, puis len fois minAllowed
        long candidate = minNonZero;
        for (int i = 0; i < len; i++) {
            candidate = candidate * 10 + minAllowed;
            if (candidate > Integer.MAX_VALUE) return -1;
        }
        return (candidate > n && candidate <= Integer.MAX_VALUE) ? (int) candidate : -1;
    }

    // --- Utilitaires performants ---

    // index (0..9) du bit à 1 le plus faible (mask != 0)
    private static int lowestSetBitIndex(int mask) {
        return Integer.numberOfTrailingZeros(mask);
    }

    // plus petit chiffre autorisé strictement > d dans allowedMask, sinon -1
    private static int smallestAllowedGreaterThan(int d, int allowedMask) {
        for (int val = Math.min(9, d + 1); val <= 9; val++) {
            if (((allowedMask >>> val) & 1) != 0) return val;
        }
        return -1;
    }

    // longueur décimale d'un int > 0 sans conversion
    private static int decimalLength(int n) {
        if (n >= 1_000_000_000) return 10;
        if (n >= 100_000_000) return 9;
        if (n >= 10_000_000) return 8;
        if (n >= 1_000_000) return 7;
        if (n >= 100_000) return 6;
        if (n >= 10_000) return 5;
        if (n >= 1_000) return 4;
        if (n >= 100) return 3;
        if (n >= 10) return 2;
        return 1;
    }

    // 10^k pré-calculés (0 <= k <= 9)
    private static final int[] POW10 = {
            1, 10, 100, 1_000, 10_000,
            100_000, 1_000_000, 10_000_000, 100_000_000, 1_000_000_000
    };

    // --- Démo rapide ---
    public static void main(String[] args) {
        System.out.println(next(654321));      // 700000
        System.out.println(next(98));          // 100
        System.out.println(next(109));         // 222
        System.out.println(next(10));          // 22
        System.out.println(next(987654321));   // -1 (seul 0 autorisé -> tête impossible)
        System.out.println(next(129));         // 300
    }
}
