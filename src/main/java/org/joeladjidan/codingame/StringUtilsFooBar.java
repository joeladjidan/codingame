package org.joeladjidan.codingame;

public class StringUtilsFooBar {

    /**
     * Concatène toutes les chaînes du tableau en une seule.
     * Hypothèse : strings contient au moins un élément.
     *
     * @param strings tableau de chaînes
     * @return la chaîne concaténée
     */
    public static String concat(String[] strings) {
        if (strings == null || strings.length == 0) {
            throw new IllegalArgumentException("Le tableau ne doit pas être vide.");
        }

        // Utilisation de StringBuilder pour éviter les concaténations coûteuses
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }

    /**
     * Méthode main pour tester concat.
     */
    public static void main(String[] args) {
        // Cas de test intégrés
        String[] test1 = {"f", "o", "o", "bar"};
        String[] test2 = {"hello", " ", "world"};
        String[] test3 = {"Java17"};
        String[] test4 = {"", "abc", "", "xyz"};

        System.out.println("Test 1 : " + concat(test1) + " (attendu foobar)");
        System.out.println("Test 2 : " + concat(test2) + " (attendu hello world)");
        System.out.println("Test 3 : " + concat(test3) + " (attendu Java17)");
        System.out.println("Test 4 : " + concat(test4) + " (attendu abcxyz)");
    }
}