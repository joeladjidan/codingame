package org.joeladjidan.codingame;

import java.util.Arrays;

/**
 * Programme Echo minimal en Java 17.
 * Usage : java org.joeladjidan.codingame.Echo arg1 arg2 ...
 * Affiche les arguments séparés par des espaces sur une seule ligne.
 */
public class Echo {

    public static void main(String[] args) {
        args = new String[] {"Hello", "world!"};
        // Joindre les arguments par des espaces et imprimer (si aucun argument, imprime une ligne vide)
        System.out.println(String.join("\n", args));
    }
}

