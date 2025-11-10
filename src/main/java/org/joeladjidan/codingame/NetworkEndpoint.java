package org.joeladjidan.codingame;

import java.util.*;

/**
 * Résolution du "nœud terminal" dans un réseau simple.
 * Chaque nœud a au plus un successeur (lien unidirectionnel).
 *
 * Règles :
 * - Si l'on atteint un nœud sans successeur, c'est le terminal.
 * - Si l'on détecte qu'on va refermer une boucle (le prochain nœud a déjà été visité),
 *   on retourne le dernier nœud visité avant la répétition.
 *
 * Compatible Java 17.
 */
public class NetworkEndpoint {

    /**
     * Trouve l'id du dernier nœud atteint en partant de startNodeId et en suivant les liens.
     *
     * @param startNodeId id de départ
     * @param fromIds     tableau des sources des arcs
     * @param toIds       tableau des destinations des arcs (toIds[i] est la destination de fromIds[i])
     * @return l'id du nœud terminal (ou le dernier nœud avant de clore une boucle)
     * @throws IllegalArgumentException si les entrées sont invalides
     */
    public static int findNetworkEndpoint(int startNodeId, int[] fromIds, int[] toIds) {
        validateInputs(fromIds, toIds);

        // Construire la table "successeur unique" -> next[node] = successeur
        Map<Integer, Integer> next = buildNextMap(fromIds, toIds);

        // Ensemble des nœuds déjà vus pour détecter la fermeture de boucle
        Set<Integer> visited = new HashSet<>();

        int current = startNodeId;

        while (true) {
            Integer succ = next.get(current);
            // Pas de successeur : terminal
            if (succ == null) {
                return current;
            }
            // Si le prochain saut referme une boucle, retourner "current"
            if (visited.contains(succ)) {
                return current;
            }
            // Marquer le nœud courant comme visité et avancer
            visited.add(current);
            current = succ;
        }
    }

    /**
     * Construit la table d'adjacence "un seul successeur par nœud".
     */
    private static Map<Integer, Integer> buildNextMap(int[] fromIds, int[] toIds) {
        Map<Integer, Integer> next = new HashMap<>(Math.max(16, fromIds.length * 2));

        for (int i = 0; i < fromIds.length; i++) {
            int u = fromIds[i];
            int v = toIds[i];

            // La contrainte dit "pas d'auto-lien direct"
            if (u == v) {
                throw new IllegalArgumentException("Un nœud ne peut pas être lié directement à lui-même: " + u);
            }

            Integer existing = next.put(u, v);
            if (existing != null && existing != v) {
                // Défensif : si des données invalides donnent deux successeurs à u
                throw new IllegalArgumentException(
                        "Le nœud " + u + " a plusieurs successeurs (" + existing + " et " + v + ").");
            }
        }
        return next;
    }

    /**
     * Vérifie la validité des tableaux d'entrée.
     */
    private static void validateInputs(int[] fromIds, int[] toIds) {
        if (fromIds == null || toIds == null) {
            throw new IllegalArgumentException("fromIds et toIds ne doivent pas être null.");
        }
        if (fromIds.length != toIds.length) {
            throw new IllegalArgumentException("fromIds et toIds doivent avoir la même longueur.");
        }
        int m = fromIds.length;
        if (m <= 0 || m >= 10000) {
            throw new IllegalArgumentException("Le nombre de liens doit vérifier 0 < m < 10000. m = " + m);
        }
    }

    /**
     * Démo autonome.
     * Exécute quelques cas de test et affiche les résultats attendus/obtenus.
     */
    public static void main(String[] args) {
        // Exemple 1 : chaîne simple menant à 5
        int[] from1 = {1, 2, 3, 4};
        int[] to1   = {2, 3, 4, 5};

        System.out.println("Exemple 1 (chaîne simple vers 5) :");
        System.out.println(" start=2  -> " + findNetworkEndpoint(2, from1, to1) + " (attendu: 5)");
        System.out.println(" start=1  -> " + findNetworkEndpoint(1, from1, to1) + " (attendu: 5)");
        System.out.println(" start=5  -> " + findNetworkEndpoint(5, from1, to1) + " (attendu: 5)");
        System.out.println();

        // Exemple 2 : boucle 2 -> 3 -> 2, avec une entrée depuis 1
        int[] from2 = {1, 2, 3};
        int[] to2   = {2, 3, 2};

        System.out.println("Exemple 2 (boucle 2<->3, entrée depuis 1) :");
        System.out.println(" start=1  -> " + findNetworkEndpoint(1, from2, to2) + " (attendu: 3)");
        System.out.println(" start=2  -> " + findNetworkEndpoint(2, from2, to2) + " (attendu: 2)");
        System.out.println(" start=3  -> " + findNetworkEndpoint(3, from2, to2) + " (attendu: 3)");
        System.out.println();

        // Exemple 3 : plusieurs branches, certaines finissent, d'autres bouclent
        int[] from3 = {10, 11, 12, 20, 21, 22};
        int[] to3   = {11, 12, 13, 21, 22, 20}; // 10->11->12->13 (terminal), 20->21->22->20 (boucle)
        System.out.println("Exemple 3 (mélange terminal & boucle) :");
        System.out.println(" start=10 -> " + findNetworkEndpoint(10, from3, to3) + " (attendu: 13)");
        System.out.println(" start=20 -> " + findNetworkEndpoint(20, from3, to3) + " (attendu: 22)");
        System.out.println(" start=22 -> " + findNetworkEndpoint(22, from3, to3) + " (attendu: 21)");
        System.out.println();

        // Exemple 4 : start n'est connecté à rien (terminal immédiat)
        int[] from4 = {100, 200};
        int[] to4   = {101, 201};
        System.out.println("Exemple 4 (start isolé) :");
        System.out.println(" start=999 -> " + findNetworkEndpoint(999, from4, to4) + " (attendu: 999)");
    }
}