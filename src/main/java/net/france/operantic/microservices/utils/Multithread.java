package net.france.operantic.microservices.utils;

import net.france.operantic.microservices.codingame.TestCounterIncrement;

//classe principale
public class Multithread {
 public static void main(String[] args) {
     TestCounterIncrement cpt = new TestCounterIncrement();
     Thread obj1 = new Thread(new Multithreading(cpt));
     Thread obj2 = new Thread(new Multithreading(cpt));
     obj1.start();
     obj2.start();

     // attendre la fin des threads
     try {
         obj1.join();
         obj1.join();
     } catch (Exception e) {
    	 
     }
 }
}
