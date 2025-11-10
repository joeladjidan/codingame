package org.joeladjidan.codingame;

import java.util.*;

/**
 * Simulation des gains journaliers d'un buffet "pay-what-you-want" dans un casino.
 *
 * Enoncé :
 * Pour attirer les touristes, un Casino de Las Vegas propose un buffet à volonté où chacun paye ce qu'il
 * souhaite payer. Sachant que vous connaissez ce que chaque touriste est prêt à payer, on vous demande de
 * calculer les gains du restaurant pour la journée.
 *
 * Règles principales :
 * - Au début de la journée le restaurant est vide. Il y a seulement `nbSeats` places.
 * - La première apparition d'un identifiant dans `guestMovements` est une arrivée, la seconde apparition est
 *   son départ, et ainsi de suite (une arrivée est toujours suivie d'un départ pour chaque visite).
 * - Lorsqu'un touriste arrive :
 *     * s'il y a une place libre, il est placé, il mange et paye (au plus une seule fois dans la journée),
 *     * sinon il attend dans une file FIFO jusqu'à être placé ou jusqu'à son départ (s'il part avant d'être
 *       placé, il ne paie pas).
 * - Un touriste peut venir plusieurs fois dans la journée, mais il ne paiera jamais plus d'une fois au total.
 *
 * Contrat de la méthode computeDayGains :
 * - Entrées :
 *     - nbSeats : nombre de sièges disponibles (int, attendu >= 0). Si nbSeats <= 0, les gains sont 0.
 *     - payingGuests : tableau int où payingGuests[id] est le montant que le touriste `id` paiera s'il mange.
 *       Le tableau définit les identifiants valides : 0 <= id < payingGuests.length.
 *     - guestMovements : tableau d'entiers représentant l'ordre chronologique des arrivées et départs. La
 *       première apparition d'un id correspond à une arrivée, la deuxième à un départ, etc.
 * - Sortie :
 *     - Somme totale (long) payée pendant la journée.
 *
 * Hypothèses & comportements :
 * - Si un id hors bornes (id < 0 ou id >= payingGuests.length) apparaît, il est traité comme visiteur mais ne
 *   contribue pas aux gains (protection pour éviter IndexOutOfBounds).
 * - La file d'attente est FIFO et ne contient pas de duplicata d'un même visiteur à un instant donné (si un
 *   visiteur tente de s'ajouter alors qu'il est déjà en attente, le comportement attendu est de l'ajouter une
 *   seule fois — l'implémentation actuelle n'empêche pas explicitement les duplicatas, mais l'énoncé n'en
 *   parle pas ; la simulation assume des mouvements cohérents).
 * - Complexité : O(M + N) en moyenne, où M = guestMovements.length et N = payingGuests.length (pour l'initialisation
 *   du tableau hasPaid). L'utilisation d'un HashSet garantit des opérations d'insertion/suppression en O(1) en moyenne.
 *
 * Exemple rapide :
 * nbSeats = 2
 * payingGuests = [25, 30, 15, 10]
 * guestMovements = [0,1,2,0,3,1,2,3]
 * => Gains = 25 + 30 + 15 + 10 = 80 (selon l'ordre d'assise et d'attente décrit dans l'exemple)
 */
public class DayGains {
    /**
     * Calcule les gains de la journée.
     *
     * Règles de simulation:
     * - La première apparition d'un identifiant dans guestMovements est une arrivée, la suivante est un départ, etc.
     * - Si un touriste arrive et qu'il y a une place libre, il est placé tout de suite et paye (au maximum une fois par journée).
     * - Si aucun siège n'est disponible, il attend dans une file d'attente (FIFO) jusqu'à être placé ou jusqu'à son départ.
     * - Au départ d'un touriste assis, la première personne en attente (s'il y en a) est placée.
     *
     * @param nbSeats nombre de sièges disponibles
     * @param payingGuests tableau où payingGuests[id] donne ce que l'id est prêt à payer
     * @param guestMovements ordre des arrivées/départs (alternance arrivée/départ par visite)
     * @return la somme totale payée pendant la journée
     */
    public static long computeDayGains(int nbSeats, int[] payingGuests, int[] guestMovements) {
        if (nbSeats <= 0 || payingGuests == null || guestMovements == null) return 0L;

        Set<Integer> seated = new HashSet<>(); // visiteurs actuellement assis
        Deque<Integer> waiting = new ArrayDeque<>(); // file d'attente FIFO
        boolean[] hasPaid = new boolean[payingGuests.length];
        long total = 0L;

        for (int id : guestMovements) {
            // Départ s'il est déjà assis ou en attente ; sinon c'est une arrivée
            if (seated.contains(id)) {
                // départ d'un touriste assis
                seated.remove(id);
                // si quelqu'un attend, on le place
                if (!waiting.isEmpty()) {
                    int next = waiting.poll();
                    seated.add(next);
                    if (next >= 0 && next < payingGuests.length && !hasPaid[next]) {
                        total += payingGuests[next];
                        hasPaid[next] = true;
                    }
                }
            } else if (waiting.contains(id)) {
                // départ d'un touriste qui était en attente -> il s'en va sans payer
                // il faut retirer de la file d'attente (ArrayDeque#remove(Object))
                waiting.remove(id);
            } else {
                // arrivée
                if (seated.size() < nbSeats) {
                    seated.add(id);
                    if (id >= 0 && id < payingGuests.length && !hasPaid[id]) {
                        total += payingGuests[id];
                        hasPaid[id] = true;
                    }
                } else {
                    // pas de place, il attend
                    waiting.add(id);
                }
            }
        }

        return total;
    }

    // Exemple de programme autonome pour démontrer et tester la méthode
    public static void main(String[] args) {
        // Exemple simple
        int nbSeats = 2;
        // payingGuests[id] = montant que le visiteur id paiera
        int[] payingGuests = new int[] {25, 30, 15, 10};
        // guestMovements: chaque id apparaît en alternance arrivée/départ (un visiteur peut revenir plusieurs fois)
        int[] guestMovements = new int[] {
            0, 1, 2, // arrivées: 0,1,2 -> 0 et 1 seront assis, 2 attend
            0, // départ de 0 -> met 2 à table
            3, // arrivée 3 -> si sièges pleins, il attend (ici sièges: 1 et 2)
            1, // départ 1 -> 3 est placé
            2, // départ 2
            3  // départ 3
        };

        long gains = computeDayGains(nbSeats, payingGuests, guestMovements);
        System.out.println("Gains de la journée (exemple) = $" + gains);

        // Vous pouvez remplacer l'exemple par d'autres scénarios pour tester.
    }
}
