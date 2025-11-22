package org.joeladjidan.codingame;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Fournit une méthode pour reconnaître un caractère ASCII (A..Z) à partir
 * de sa représentation graphique produite par AsciiArt.printChar(char).
 */
public final class AsciiArtScanner {

    private AsciiArtScanner() { /* utilitaire */ }

    /**
     * Retourne le caractère (A..Z) correspondant à la représentation graphique s,
     * ou '?' si aucune correspondance.
     *
     * La méthode normalise les chaînes (suppression des espaces de fin de ligne
     * et suppression des lignes vides en tête/queue) avant comparaison.
     */
    public static char scanChar(String s) {
        if (s == null) return '?';
        String target = normalize(s);

        for (char c = 'A'; c <= 'Z'; c++) {
            String rendered = capturePrintChar(c);
            if (rendered == null) continue;
            if (normalize(rendered).equals(target)) {
                return c;
            }
        }
        return '?';
    }

    private static String capturePrintChar(char c) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos, true, StandardCharsets.UTF_8);
        try {
            System.setOut(ps);
            // Appel à la méthode existante qui affiche le caractère.
            // Elle est supposée être : AsciiArt.printChar(char)
            printChar(c);
        } catch (Throwable t) {
            // En cas d'erreur lors de l'appel, on ignore ce caractère.
            return null;
        } finally {
            // restaurer la sortie standard
            System.setOut(originalOut);
            try { ps.close(); } catch (Exception ignored) {}
        }
        return new String(baos.toByteArray(), StandardCharsets.UTF_8);
    }

    private static String normalize(String s) {
        // Uniformiser retours chariot
        String[] lines = s.replace("\r\n", "\n").replace('\r', '\n').split("\n", -1);
        int start = 0, end = lines.length - 1;
        // enlever espaces de fin de chaque ligne
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].replaceAll("\\s+$", "");
        }
        // supprimer lignes vides en tête
        while (start <= end && lines[start].isEmpty()) start++;
        // supprimer lignes vides en queue
        while (end >= start && lines[end].isEmpty()) end--;
        if (start > end) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(lines[i]);
            if (i < end) sb.append('\n');
        }
        return sb.toString();
    }

    /**
     * Affiche la représentation ASCII du caractère c (A..Z).
     * Ici implémentation minimale : imprime le caractère sur une seule ligne.
     */
    public static void printChar(char c) {
        if (c < 'A' || c > 'Z') {
            // ne rien afficher pour les caractères hors A..Z
            return;
        }
        System.out.println(c);
    }

    public static void main(String[] args) {
        char[] samples = {'A', 'B', 'Z'};
        System.out.println("Exemples de scanChar :");
        for (char c : samples) {
            String repr = capturePrintChar(c);
            System.out.println("Représentation pour " + c + " :");
            System.out.println(repr);
            System.out.println("Detecté : " + scanChar(repr));
            System.out.println("----");
        }

        // motif inconnu
        String unknown = "###\n# #\n###";
        System.out.println("Motif inconnu -> " + scanChar(unknown));
    }
}
