package org.joeladjidan.codingame;

import java.math.BigDecimal;
import java.util.Objects;

public class Calculator {

    /**
     * Additionne des nombres décimaux exacts passés sous forme de chaînes,
     * et retourne le résultat sous forme de chaîne décimale exacte (sans notation scientifique).
     *
     * Exemple : sum("99.35", "1.10") -> "100.45"
     */
    public static String sum(String... numbers) {
        BigDecimal total = sumAsBigDecimal(numbers);
        // toPlainString évite la notation scientifique (ex: "1E+3")
        return total.stripTrailingZeros().toPlainString();
    }

    /**
     * Variante qui retourne un BigDecimal (utile si l'appelant veut poursuivre des calculs exacts).
     */
    public static BigDecimal sumAsBigDecimal(String... numbers) {
        Objects.requireNonNull(numbers, "numbers ne doit pas être null");
        BigDecimal total = BigDecimal.ZERO;
        for (String s : numbers) {
            Objects.requireNonNull(s, "Un élément de numbers est null");
            // IMPORTANT : utiliser le constructeur String pour une précision exacte
            BigDecimal term = new BigDecimal(s);
            total = total.add(term);
        }
        return total;
    }

    /**
     * Démo autonome.
     */
    public static void main(String[] args) {
        System.out.println("Exemples :");
        System.out.println("sum(\"99.35\", \"1.10\") = " + sum("99.35", "1.10") + " (attendu: 100.45)");
        System.out.println("sum(\"0.1\", \"0.2\")    = " + sum("0.1", "0.2") + " (attendu: 0.3)");
        System.out.println("sum(\"1\", \"2\", \"3\") = " + sum("1", "2", "3") + " (attendu: 6)");

        // Bonus : utilisation de la version BigDecimal
        BigDecimal exact = sumAsBigDecimal("123456789.01", "0.99");
        System.out.println("sumAsBigDecimal(...)    = " + exact.toPlainString() + " (exact)");
    }
}
