package org.joeladjidan.codingame;


import java.util.Arrays;
import java.util.Locale;

public final class TwinChecker {

    private TwinChecker() { /* utilitaire */ }

    /**
     * Retourne true si a et b contiennent exactement les mêmes lettres
     * (insensible à la casse, ordre indifférent). Retourne false si
     * l'une des chaînes est null ou si les longueurs diffèrent.
     */
    public static boolean isTwin(String a, String b) {
        if (a == null || b == null) return false;
        String sa = a.toLowerCase(Locale.ROOT);
        String sb = b.toLowerCase(Locale.ROOT);
        if (sa.length() != sb.length()) return false;
        char[] ca = sa.toCharArray();
        char[] cb = sb.toCharArray();
        Arrays.sort(ca);
        Arrays.sort(cb);
        return Arrays.equals(ca, cb);
    }


    public static void main(String[] args) {
        Object[][] cases = new Object[][] {
                {"Marion", "Romain", true},
                {"Test", "tset", true},
                {"Hello", "Olelh", true},
                {"abc", "ab", false},
                {null, "a", false},
                {"AaBb", "bbaA", true},
                {"abc", "abd", false}
        };

        int failures = 0;
        for (int i = 0; i < cases.length; i++) {
            String a = (String) cases[i][0];
            String b = (String) cases[i][1];
            boolean expected = (Boolean) cases[i][2];
            boolean actual = TwinChecker.isTwin(a, b);
            System.out.printf("Test %d: isTwin(%s, %s) -> %s (attendu: %s)%n",
                    i + 1, show(a), show(b), actual, expected);
            if (actual != expected) {
                failures++;
            }
        }

        if (failures == 0) {
            System.out.println("Tous les tests sont passés.");
        } else {
            System.out.printf("%d test(s) ont échoué.%n", failures);
        }

        System.exit(failures);
    }

    private static String show(String s) {
        return s == null ? "null" : "\"" + s + "\"";
    }

}
