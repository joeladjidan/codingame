package org.joeladjidan.codingame;

/**
 * Version clarifiée des classes Animal/Dog/Cat et de l'application.
 * Comportement conservé : getAnimalName retourne le nom seulement si l'animal
 * est un Dog ou un Cat ; sinon retourne null.
 */
public final class AnimalApp {

    private AnimalApp() { /* utilitaire */ }

    public static abstract class Animal {
        private final String name;

        protected Animal(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static final class Dog extends Animal {
        /** Crée un chien avec le nom donné. */
        public Dog(String name) {
            super(name);
        }
    }

    public static final class Cat extends Animal {
        /** Crée un chat avec le nom donné. */
        public Cat(String name) {
            super(name);
        }
    }

    /**
     * Retourne le nom de l'animal si c'est un Dog ou un Cat ; retourne null sinon.
     */
    public static String getAnimalName(Animal a) {
        if (a == null) return null;
        if (a instanceof Dog || a instanceof Cat) {
            return a.getName();
        }
        return null;
    }

    // Démo
    public static void main(String[] args) {
        Animal dog = new Dog("Rex");
        Animal cat = new Cat("Mia");
        Animal other = new Animal("Anon") { /* anonymous other */ };

        System.out.println("dog -> " + getAnimalName(dog));   // Rex
        System.out.println("cat -> " + getAnimalName(cat));   // Mia
        System.out.println("other -> " + getAnimalName(other)); // null
    }
}

