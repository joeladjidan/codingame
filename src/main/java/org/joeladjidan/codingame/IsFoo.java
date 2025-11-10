package org.joeladjidan.codingame;

/**
 * Classe autonome pour démontrer et tester A.isFoo(String).
 */
public class IsFoo {

    /**
     * Retourne true si et seulement si param est exactement la chaîne "foo".
     * Cette méthode est null-safe (retourne false si param == null).
     *
     * @param param chaîne à tester (peut être null)
     * @return true si param.equals("foo"), false sinon
     */
    public static boolean isFoo(String param) {
        return "foo".equals(param);
    }

    public static void main(String[] args) {
        String[] tests = {null, "", "foo", "Foo", " foo ", "foobar", "foo"};

        for (String t : tests) {
            System.out.printf("isFoo(%s) = %b%n", t, isFoo(t));
        }
    }
}

