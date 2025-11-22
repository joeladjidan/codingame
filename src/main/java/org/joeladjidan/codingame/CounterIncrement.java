package org.joeladjidan.codingame;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Compteur thread-safe simple pour démonstration.
 */
public final class CounterIncrement {

    private static final AtomicInteger COUNT = new AtomicInteger();

    private CounterIncrement() { /* non instanciable */ }

    /**
     * Incrémente le compteur et renvoie la nouvelle valeur.
     */
    public static int incrementAndGet() {
        return COUNT.incrementAndGet();
    }

    /** Valeur courante. */
    public static int get() {
        return COUNT.get();
    }

    /** Réinitialise le compteur (utile pour les tests). */
    public static void reset() {
        COUNT.set(0);
    }

    public static void main(String[] args) throws InterruptedException {
        reset();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                int v = incrementAndGet(); // utiliser la valeur retournée
                // utilisation factice pour éviter l'optimisation du compilateur
                if (v == Integer.MIN_VALUE) System.out.println();
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(task);
        pool.execute(task);
        pool.shutdown();
        if (!pool.awaitTermination(5, TimeUnit.SECONDS)) {
            pool.shutdownNow();
            System.err.println("Timeout: tâches arrêtées de force");
        }

        System.out.println("Counter final value = " + get() + " (attendu 2000)");
    }
}
