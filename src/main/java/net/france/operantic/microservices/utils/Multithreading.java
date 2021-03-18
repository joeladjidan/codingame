package net.france.operantic.microservices.utils;

import net.france.operantic.microservices.codingame.TestCounterIncrement;

class Multithreading implements Runnable {
	TestCounterIncrement cpt;
 
    public Multithreading(TestCounterIncrement cpt) {
        this.cpt = cpt;
    }
 
    public void run() {
        synchronized (cpt) {
            cpt.increment();
        }
        System.out.println("Bye bye " + Thread.currentThread().getName());
    }
}