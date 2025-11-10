package org.joeladjidan.codingame;

/**
 * Fournit la fonction a(i, j) qui retourne true si au moins un des arguments vaut 1
 * ou si leur somme vaut 1.
 */
public class AFunction {

    /**
     * Retourne true si i == 1 ou j == 1 ou i + j == 1.
     *
     * @param i premier entier
     * @param j second entier
     * @return true si au moins un argument vaut 1 ou si leur somme vaut 1
     */
    public static boolean a(int i, int j) {
        return i == 1 || j == 1 || (i + j) == 1;
    }

    /**
     * Main autonome pour démontrer la fonction avec plusieurs exemples.
     */
    public static void main(String[] args) {
        int[][] tests = new int[][] {
            {1, 5},  // true (i == 1)
            {2, 3},  // false
            {-3, 4}, // true (sum == 1)
            {0, 1},  // true (j == 1)
            {0, 0},  // false
            {-1, 2}  // true (sum == 1)
        };

        for (int[] t : tests) {
            int x = t[0];
            int y = t[1];
            System.out.printf("a(%d, %d) => %b%n", x, y, a(x, y));
        }
    }
}

