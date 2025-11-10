package org.joeladjidan.codingame;

import java.util.*;
import java.util.stream.Collectors;

public class CustomSorter {

    /**
     * Trie une liste de "pseudo-objets" (Map<String, Number>) selon la clé criteria en ordre décroissant.
     * @param table   liste de maps représentant des objets {clé -> valeur numérique}
     * @param criteria clé numérique à utiliser pour le tri (ex: "id")
     * @return une nouvelle liste triée (la liste d'origine n'est pas modifiée)
     * @throws IllegalArgumentException si la clé n'existe pas ou si la valeur n'est pas numérique
     */
    public static List<Map<String, Number>> customSort(List<Map<String, Number>> table, String criteria) {
        if (table == null) {
            return List.of();
        }
        if (criteria == null || criteria.isBlank()) {
            throw new IllegalArgumentException("Le paramètre 'criteria' ne doit pas être vide.");
        }

        // Copie défensive pour ne pas muter l'entrée
        List<Map<String, Number>> copy = new ArrayList<>(table);

        // Vérifications minimales et tri
        for (Map<String, Number> obj : copy) {
            if (!obj.containsKey(criteria)) {
                throw new IllegalArgumentException(
                        "Clé '" + criteria + "' absente dans au moins un élément : " + obj);
            }
            Number n = obj.get(criteria);
            if (n == null) {
                throw new IllegalArgumentException(
                        "Valeur nulle pour la clé '" + criteria + "' dans : " + obj);
            }
        }

        copy.sort((m1, m2) -> {
            Number n1 = m1.get(criteria);
            Number n2 = m2.get(criteria);
            // Tri décroissant
            return Double.compare(n2.doubleValue(), n1.doubleValue());
        });

        return copy;
    }

    /** Affichage type JSON compact pour la variante Map */
    public static void display(List<Map<String, Number>> table) {
        String out = table.stream()
                .map(m -> m.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .map(e -> e.getKey() + ": " + e.getValue())
                        .collect(Collectors.joining(", ", "{", "}")))
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(out);
    }

    // Démonstration
    public static void main(String[] args) {
        List<Map<String, Number>> a = List.of(
                Map.of("id", 2),
                Map.of("id", 3),
                Map.of("id", 1)
        );

        List<Map<String, Number>> sorted = customSort(a, "id");
        display(sorted); // attendu: [{id: 3}, {id: 2}, {id: 1}] (ordre des clés stable, format compact)
    }
}
