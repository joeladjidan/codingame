package org.joeladjidan.codingame;

public class ComputeMultiplesSum {

    /**
     * Version O(1) via inclusion–exclusion et somme arithmétique des multiples.
     * Contraintes: 0 ≤ n < 1000
     */
    public static int computeMultiplesSumO1(int n) {
        if (n <= 0) return 0;

        long s3   = sumOfMultiplesBelow(n, 3);
        long s5   = sumOfMultiplesBelow(n, 5);
        long s7   = sumOfMultiplesBelow(n, 7);

        long s15  = sumOfMultiplesBelow(n, lcm(3, 5));
        long s21  = sumOfMultiplesBelow(n, lcm(3, 7));
        long s35  = sumOfMultiplesBelow(n, lcm(5, 7));

        long s105 = sumOfMultiplesBelow(n, lcm(3, lcm(5, 7)));

        long result = s3 + s5 + s7 - s15 - s21 - s35 + s105;

        return (int) result; // sûr pour n < 1000
    }

    /**
     * Somme des multiples positifs de k strictement inférieurs à n :
     * k * (1 + 2 + ... + m) avec m = floor((n-1)/k) -> k * m * (m+1) / 2
     */
    private static long sumOfMultiplesBelow(int n, int k) {
        if (k <= 0) return 0;
        int m = (n - 1) / k; // nombre de multiples strictement < n
        return (long) k * m * (m + 1L) / 2L;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }

    private static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    /**
     * Version simple O(n) : somme des i (1 <= i < n) tels que i % 3 == 0 || i % 5 == 0 || i % 7 == 0.
     */
    public static int computeMultiplesSum(int n) {
        if (n <= 0) return 0;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    // --- Main de test ---
    public static void main(String[] args) {
        // Exemples et quelques cas
        System.out.println("n=11 -> O(n): " + computeMultiplesSum(11)   + ", O(1): " + computeMultiplesSumO1(11)   + " (attendu 40)");
        System.out.println("n=1  -> O(n): " + computeMultiplesSum(1)    + ", O(1): " + computeMultiplesSumO1(1)    + " (attendu 0)");
        System.out.println("n=20 -> O(n): " + computeMultiplesSum(20)   + ", O(1): " + computeMultiplesSumO1(20)   + " (attendu 119)");
        System.out.println("n=0  -> O(n): " + computeMultiplesSum(0)    + ", O(1): " + computeMultiplesSumO1(0)    + " (attendu 0)");
        System.out.println("n=999-> O(n): " + computeMultiplesSum(999)  + ", O(1): " + computeMultiplesSumO1(999));
    }
}

