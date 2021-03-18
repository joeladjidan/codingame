package net.france.operantic.microservices.codingame;

public class TestCounterIncrement {
	/**
	 * 
	 * @author operantic
	 * 
	 * Synchronisation d'un compteur
	 * Transformez la méthode Counter.increment() pour qu'elle supporte l'accès concurrentiel de plusieurs threads.
	 * @return int 
	 */
	private static int count = 0;
		
	/**
	* Increments count in a thread-safe manner.
	*/
	public synchronized int increment() {
        try {
        	 count += count;
        	 System.out.println("i = " + count);
        } catch (Exception e) {
            System.out.println("Thread  interrompu.");
        }
		return count;
    }
}
