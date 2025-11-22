package org.joeladjidan.codingame;

public final class PiApproximator {

    private PiApproximator() { /* utilitaire */ }

    /**
     * Approxime π en utilisant la méthode du quarter-circle.
     * @param pts tableau de points, chaque point est un tableau [x, y] avec 0 <= x,y <= 1
     * @return estimation de π (4 * fraction de points à l'intérieur du quart de disque).
     *         Retourne 0.0 si pts est null ou vide.
     */
    public static double approx(double[][] pts) {
        if (pts == null || pts.length == 0) return 0.0;

        int inside = 0;
        int total = 0;
        for (double[] p : pts) {
            if (p == null || p.length < 2) continue;
            double x = p[0];
            double y = p[1];
            // on compte uniquement les points fournis (on suppose 0<=x,y<=1 d'après l'énoncé)
            total++;
            if (x * x + y * y <= 1.0) inside++;
        }
        if (total == 0) return 0.0;
        return 4.0 * ((double) inside / (double) total);
    }

    public static void main(String[] args) {
        // petit exemple déterministe
        double[][] pts = {
            {0.0, 0.0}, {1.0, 0.0}, {0.0, 1.0}, {0.5, 0.5},
            {0.7, 0.2}, {0.9, 0.9}, {0.3, 0.4}, {0.2, 0.9}
        };
        System.out.println("Estimation de π = " + approx(pts));
    }
}
