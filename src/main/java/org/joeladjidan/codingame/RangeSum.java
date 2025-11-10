package org.joeladjidan.codingame;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class RangeSum {

    /**
     * Variante 1 : retourne un OptionalInt.
     * - Présent si au moins une valeur appartient à [10, 100]
     * - Vide sinon
     */
    public static OptionalInt sumRangeOptionalInt(int[] ints) {
        // IntStream -> OptionalInt évite l'autoboxing
        // On filtre, puis on réduit en somme. Si rien ne passe le filtre, l'OptionalInt est vide.
        return Arrays.stream(ints)
                .filter(v -> v >= 10 && v <= 100)
                .reduce(Integer::sum);
    }

    /**
     * Variante 2 : retourne un Optional<Integer>.
     * - Identique à la variante 1, mais renvoie un Optional<Integer> si vous devez rester en types objet.
     */
    public static Optional<Integer> sumRangeOptional(int[] ints) {
        // Même logique, mais on convertit l'OptionalInt en Optional<Integer>
        OptionalInt opt = sumRangeOptionalInt(ints);
        return opt.isPresent() ? Optional.of(opt.getAsInt()) : Optional.empty();
    }

    // --- Démonstration ---
    public static void main(String[] args) {
        int[] a = {1, 6, 10, 50, 101, 100}; // éléments éligibles : 10, 50, 100 -> somme 160
        int[] b = {5, 9, 101, 200};         // aucun élément dans [10, 100]

        // OptionalInt
        OptionalInt r1 = sumRangeOptionalInt(a);
        OptionalInt r2 = sumRangeOptionalInt(b);

        System.out.println("OptionalInt a : " + (r1.isPresent() ? r1.getAsInt() : "vide") + " (attendu 160)");
        System.out.println("OptionalInt b : " + (r2.isPresent() ? r2.getAsInt() : "vide") + " (attendu vide)");

        // Optional<Integer>
        Optional<Integer> r3 = sumRangeOptional(a);
        Optional<Integer> r4 = sumRangeOptional(b);

        System.out.println("Optional<Integer> a : " + r3.orElse(null) + " (attendu 160)");
        System.out.println("Optional<Integer> b : " + (r4.isPresent() ? r4.get() : "vide") + " (attendu vide)");

        // Exemples d'usage idiomatique
        int valeurParDefaut = r2.orElse(0);
        System.out.println("Valeur par défaut si vide : " + valeurParDefaut + " (attendu 0)");

        // Lever une exception si vide
        try {
            int mustExist = r2.orElseThrow(() -> new IllegalStateException("Aucune valeur dans [10,100]"));
            System.out.println(mustExist); // ne s'exécutera pas ici
        } catch (IllegalStateException ex) {
            System.out.println("Exception attendue : " + ex.getMessage());
        }
    }
}