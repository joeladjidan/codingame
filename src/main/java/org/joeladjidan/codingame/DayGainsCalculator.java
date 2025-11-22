package org.joeladjidan.codingame;

import java.util.ArrayDeque;
import java.util.Queue;

public final class DayGainsCalculator {

    private DayGainsCalculator() { /* utilitaire */ }

    /**
     * Calcule les gains de la journée.
     * @param nbSeats nombre de places disponibles
     * @param payingGuests tableau où payingGuests[id] est ce que le visiteur id paiera
     * @param guestMovements séquence d'événements (première occurrence = arrivée, deuxième = départ, etc.)
     * @return total des paiements perçus (long)
     */
    public static long computeDayGains(int nbSeats, int[] payingGuests, int[] guestMovements) {
        if (nbSeats <= 0 || payingGuests == null || guestMovements == null) return 0L;

        int nGuests = payingGuests.length;
        // états : 0 = absent, 1 = assis, 2 = en attente
        byte[] state = new byte[nGuests];
        boolean[] paid = new boolean[nGuests];
        Queue<Integer> waiting = new ArrayDeque<>();
        long total = 0L;
        int occupied = 0;

        for (int id : guestMovements) {
            if (id < 0 || id >= nGuests) {
                // ignoré si id invalide
                continue;
            }

            if (state[id] == 0) {
                // arrivée
                if (occupied < nbSeats) {
                    // assoir immédiatement
                    state[id] = 1;
                    occupied++;
                    if (!paid[id]) {
                        total += payingGuests[id];
                        paid[id] = true;
                    }
                } else {
                    // entrer en attente
                    state[id] = 2;
                    waiting.add(id);
                }
            } else {
                // départ (si assis ou en attente)
                if (state[id] == 1) {
                    // libérer une place
                    state[id] = 0;
                    occupied--;
                    // essayer de prendre la prochaine personne en attente
                    while (occupied < nbSeats && !waiting.isEmpty()) {
                        int next = waiting.poll();
                        // cette personne peut avoir quitté entre-temps
                        if (next < 0 || next >= nGuests) continue;
                        if (state[next] != 2) continue; // n'est plus en attente
                        state[next] = 1;
                        occupied++;
                        if (!paid[next]) {
                            total += payingGuests[next];
                            paid[next] = true;
                        }
                        // on occupe une place libérée
                        break;
                    }
                } else if (state[id] == 2) {
                    // il quitte la file d'attente sans payer
                    state[id] = 0;
                    // restera éventuellement dans la file mais sera ignoré lors du poll
                }
            }
        }

        return total;
    }

    public static void main(String[] args) {
        // Cas 1
        int[] paying1 = {10, 20, 30};
        int[] moves1 = {0, 1, 2, 0, 1, 2};
        long result1 = computeDayGains(2, paying1, moves1);
        System.out.println("Cas 1 attendu=60, obtenu=" + result1);

        // Cas 2
        int[] paying2 = {5, 25, 15};
        int[] moves2 = {1, 2, 1, 2};
        long result2 = computeDayGains(1, paying2, moves2);
        System.out.println("Cas 2 attendu=40, obtenu=" + result2);

        // Cas 3 : même visiteur plusieurs fois (ne paye qu'une fois)
        int[] paying3 = {10};
        int[] moves3 = {0, 0, 0, 0};
        long result3 = computeDayGains(1, paying3, moves3);
        System.out.println("Cas 3 attendu=10, obtenu=" + result3);

        // Cas 4 : identifiants invalides sont ignorés
        int[] paying4 = {8, 12};
        int[] moves4 = {0, 99, 1, 0, 1};
        long result4 = computeDayGains(1, paying4, moves4);
        System.out.println("Cas 4 attendu=20, obtenu=" + result4);
    }
}
