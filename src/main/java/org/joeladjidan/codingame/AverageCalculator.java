package org.joeladjidan.codingame;

import java.util.*;
import java.util.stream.*;
import java.text.*;

public class AverageCalculator {

    /**
     * Petit record Java 17 pour regrouper des statistiques utiles.
     */
    public record Stats(double sum, long count, double average) {}

    /**
     * Calcule la moyenne d'un tableau de double.
     * Retourne 0 si le tableau est vide (ou null).
     */
    public static double average(double[] table) {
        if (table == null || table.length == 0) return 0.0;
        // OptionalDouble évite les divisions par zéro et les tableaux vides
        return Arrays.stream(table).average().orElse(0.0);
    }

    /**
     * Variante qui renvoie aussi la somme et le nombre d'éléments sous forme d'un record Java 17.
     */
    public static Stats stats(double[] table) {
        if (table == null || table.length == 0) return new Stats(0.0, 0L, 0.0);
        double sum = Arrays.stream(table).sum();
        long count = table.length;
        double avg = sum / count; // sûr car count > 0 ici
        return new Stats(sum, count, avg);
    }

    /**
     * Parse une ligne contenant des nombres séparés par espaces et/ou virgules.
     * - Accepte les formats FR ("12,5") et US ("12.5")
     * - Ignore les entrées vides
     */
    public static double[] parseNumbers(String line) {
        if (line == null || line.isBlank()) return new double[0];

        // Normalisation simple : on remplace la virgule par un point pour Double.parseDouble
        // On autorise séparateurs: espace, virgule, point-virgule
        String normalized = line.replace(',', '.');

        String[] tokens = normalized.trim().split("[\\s;,]+");
        return Arrays.stream(tokens)
                .filter(s -> !s.isBlank())
                .mapToDouble(Double::parseDouble)
                .toArray();
    }

    /**
     * Formate un double de manière lisible en évitant la notation scientifique,
     * avec un nombre raisonnable de décimales.
     */
    public static String formatDouble(double value) {
        // NumberFormat est pratique pour affichage, sans perdre en précision d'usage
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        nf.setGroupingUsed(false);
        if (nf instanceof DecimalFormat df) {
            df.setMaximumFractionDigits(12); // Ajuste selon le besoin
            df.setMinimumFractionDigits(0);
        }
        return nf.format(value);
    }

    public static void main(String[] args) {
        // Text block (Java 15+, donc OK Java 17)
        String banner = """
                =========================================
                  Calcul de moyenne — Version Java 17
                =========================================
                Entrez des nombres séparés par espaces, virgules ou points-virgules.
                Exemples :
                  10 20 30
                  10,5 20,25 30
                  1.2, 3.4; 5
                Tapez une ligne vide pour terminer.
                """;
        System.out.println(banner);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Votre liste de nombres : ");
                var line = scanner.nextLine();
                if (line == null || line.isBlank()) {
                    System.out.println("Fin. Merci !");
                    break;
                }

                try {
                    var values = parseNumbers(line);
                    var s = stats(values);

                    // Affichage formaté
                    System.out.println("""
                            ---- Résultats ----
                            Nombres saisis : %s
                            Somme          : %s
                            Compte         : %d
                            Moyenne        : %s
                            -------------------
                            """.formatted(
                            Arrays.toString(values),
                            formatDouble(s.sum()),
                            s.count(),
                            formatDouble(s.average())
                    ));
                } catch (NumberFormatException nfe) {
                    System.out.println("⚠️  Entrée invalide. Veuillez ne saisir que des nombres.");
                }
            }
        }
    }
}
