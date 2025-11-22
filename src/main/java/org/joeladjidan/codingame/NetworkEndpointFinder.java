package org.joeladjidan.codingame;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Utilitaire pour trouver le nœud terminal d'un réseau simple.
 */
public final class NetworkEndpointFinder {

    private NetworkEndpointFinder() { /* utilitaire */ }

    /**
     * Parcourt le réseau à partir de startNodeId et retourne :
     * - l'id du dernier nœud avant d'entrer dans une boucle (si une boucle est rencontrée),
     * - ou l'id du nœud terminal (s'il n'a pas d'arc sortant).
     *
     * @param startNodeId id du nœud de départ
     * @param fromIds tableau des origines des arcs
     * @param toIds tableau des destinations des arcs (même longueur que fromIds)
     * @return id du nœud terminal selon la règle décrite
     * @throws IllegalArgumentException si fromIds et toIds sont de longueurs différentes
     */
    public static int findNetworkEndpoint(int startNodeId, int[] fromIds, int[] toIds) {
        if (fromIds == null || toIds == null) {
            throw new IllegalArgumentException("fromIds et toIds ne doivent pas être null");
        }
        if (fromIds.length != toIds.length) {
            throw new IllegalArgumentException("fromIds et toIds doivent avoir la même longueur");
        }

        // Construire la map from -> to (chaque nœud a au plus une sortie)
        Map<Integer, Integer> nextMap = new HashMap<>();
        for (int i = 0; i < fromIds.length; i++) {
            nextMap.put(fromIds[i], toIds[i]);
        }

        Set<Integer> visited = new HashSet<>();
        int current = startNodeId;

        while (true) {
            Integer next = nextMap.get(current);
            if (next == null) {
                // pas d'arc sortant : current est terminal
                return current;
            }
            if (visited.contains(next)) {
                // on s'apprête à entrer dans une boucle : retourner le dernier nœud traversé (current)
                return current;
            }
            // marquer current puis avancer
            visited.add(current);
            current = next;
        }
    }
}
