package org.joeladjidan.codingame;


import java.util.List;

public class CalculateTotalPrice {

    /**
     * Calcule le prix total à payer en appliquant la réduction 'discount' sur l'article le plus cher.
     * Le total retourné est arrondi à l'entier inférieur.
     *
     * @param prices   tableau des prix des produits (longueur >= 1, chaque prix dans (0, 100000))
     * @param discount pourcentage de réduction (0..100)
     * @return total à payer (arrondi à l'entier inférieur)
     */
    public static long calculateTotalPrice(int[] prices, int discount) {
        validateInputs(prices, discount);

        long sum = 0L;
        int max = 0;
        for (int p : prices) {
            sum += p;
            if (p > max) max = p;
        }

        // Prix du produit le plus cher après remise, arrondi à l'entier inférieur
        // On fait tout en arithmétique entière pour éviter les erreurs de virgule.
        int reducedMax = (max * (100 - discount)) / 100;

        // Total = (somme des autres) + (max remisé)
        long total = (sum - max) + reducedMax;
        return total; // déjà un entier, conforme à l'arrondi par défaut (vers le bas)
    }

    /**
     * Variante pratique acceptant une liste (wrapping léger).
     */
    public static long calculateTotalPrice(List<Integer> prices, int discount) {
        if (prices == null || prices.isEmpty()) {
            throw new IllegalArgumentException("La liste de prix doit contenir au moins un élément.");
        }
        int[] arr = new int[prices.size()];
        for (int i = 0; i < prices.size(); i++) {
            arr[i] = prices.get(i);
        }
        return calculateTotalPrice(arr, discount);
    }

    // --- Validation des entrées ---
    private static void validateInputs(int[] prices, int discount) {
        if (prices == null || prices.length == 0 || prices.length >= 100) {
            throw new IllegalArgumentException("Le nombre de produits doit être dans (0, 100).");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("discount doit être dans [0, 100].");
        }
        for (int p : prices) {
            if (p <= 0 || p >= 100000) {
                throw new IllegalArgumentException("Chaque prix doit vérifier 0 < prix < 100000. Reçu: " + p);
            }
        }
    }

    // --- Démonstration ---
    public static void main(String[] args) {
        // Exemples simples
        System.out.println(calculateTotalPrice(new int[]{100, 200, 50}, 10) + " (attendu 325)");
        // Détail: plus cher = 200 -> 200 * 0.9 = 180 ; total = 100 + 50 + 180 = 330 ? Oups !
        // Correction du détail ci-dessus : 100 + 50 + 180 = 330 (attendu 330). Mise à jour :
        System.out.println("Correction: " + calculateTotalPrice(new int[]{100, 200, 50}, 10) + " (attendu 330)");

        System.out.println(calculateTotalPrice(new int[]{11}, 0) + " (attendu 11)");
        System.out.println(calculateTotalPrice(new int[]{11}, 100) + " (attendu 0)");
        System.out.println(calculateTotalPrice(new int[]{3, 5, 7}, 50) + " (attendu 3 + 5 + floor(7*0.5)=3 -> 11)");
        System.out.println(calculateTotalPrice(new int[]{3, 5, 7}, 50));

        // Vérification arrondi à l'entier inférieur
        // Exemple: max = 99, discount = 33% -> 99*67/100 = 6633/100 = 66 (floor)
        System.out.println(calculateTotalPrice(new int[]{10, 99}, 33) + " (attendu 10 + 66 = 76)");

        // Version List<Integer>
        System.out.println(calculateTotalPrice(java.util.List.of(1000, 99999), 1) + " (attendu 1000 + floor(99999*0.99)=1000+98999=99999)");
    }
}
