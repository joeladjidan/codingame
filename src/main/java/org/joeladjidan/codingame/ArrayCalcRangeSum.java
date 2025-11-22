package org.joeladjidan.codingame;

/**
 * Utilitaire simple fournissant la méthode calc(array,n1,n2) :
 * Retourne la somme des éléments du tableau entre les indices n1 et n2 (inclus).
 * Préconditions : 0 <= n1 <= n2 < array.length
 */
public final class ArrayCalcRangeSum {

    private ArrayCalcRangeSum() { /* non instanciable */ }

    /**
     * Calcule la somme des éléments array[n1]..array[n2] inclus.
     * @param array tableau d'entiers (non null)
     * @param n1 indice de début (inclus)
     * @param n2 indice de fin (inclus)
     * @return somme des éléments entre n1 et n2 inclus
     * @throws IllegalArgumentException si array est null ou si les indices sont hors bornes
     */
    public static int calc(int[] array, int n1, int n2) {
        if (array == null) {
            throw new IllegalArgumentException("array ne doit pas être null");
        }
        if (n1 < 0 || n2 < n1 || n2 >= array.length) {
            throw new IllegalArgumentException("Bornes invalides : 0 <= n1 <= n2 < array.length (reçu n1=" + n1 + ", n2=" + n2 + ", length=" + array.length + ")");
        }
        int sum = 0;
        for (int i = n1; i <= n2; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        // Quelques démonstrations simples
        int[] a1 = {1, 2, 3, 4, 5};
        System.out.println("calc({1,2,3,4,5}, 1, 3) = " + calc(a1, 1, 3) + " (attendu 9)");

        int[] a2 = {42};
        System.out.println("calc({42}, 0, 0) = " + calc(a2, 0, 0) + " (attendu 42)");

        int[] a3 = {5, -2, 7, -4};
        System.out.println("calc({5,-2,7,-4}, 1, 3) = " + calc(a3, 1, 3) + " (attendu 1)");

        // Exemple d'utilisation avec arguments : si on passe une liste d'entiers suivie de n1 n2
        if (args.length >= 3) {
            try {
                int last = args.length - 1;
                int n2 = Integer.parseInt(args[last]);
                int n1 = Integer.parseInt(args[last - 1]);
                int len = args.length - 2;
                int[] arr = new int[len];
                for (int i = 0; i < len; i++) arr[i] = Integer.parseInt(args[i]);
                System.out.println("calc(args array, " + n1 + ", " + n2 + ") = " + calc(arr, n1, n2));
            } catch (NumberFormatException ex) {
                System.err.println("Arguments invalides : fournir des entiers");
            } catch (IllegalArgumentException ex) {
                System.err.println("Erreur : " + ex.getMessage());
            }
        }
    }
}

