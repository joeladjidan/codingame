package net.france.operantic.microservices.codingame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.france.operantic.microservices.utils.Constante;

public class TestAbstraction {
	
	private static final Logger logger = LogManager.getLogger(TestAbstraction.class);
   /**
	* 
	* @author operantic
	* 
	* Essayez d'améliorer le code affiché dans l'éditeur de réponses tout en conservant le comportement actuel du programme.
	* @return the sum of integers whose index is between n1 and n2
	* 
	*/
	
	abstract class Animal {
		String name;
		
		 String getName() {
		 return name;
	   }
    }
	
	class Dog extends Animal {
		/**
		 * Creates a new dog with the given name.
		 */
		  Dog(String name) {
		  this.name = name;
		}
	
		  String getName() {
		  return name;
		}
	}
	
    class Cat extends Animal {
	   /**
		* Creates a new cat with the given name.
		*/
		Cat(String name) {
		  this.name = name;
		}
		
		  String getName() {
		  return name;
		}
	}
    
    static class Application {
    	/**
    	* @return the name of the given animal
    	*/
    	static String getAnimalName(Animal a) {
	    	String name = null;
	    	if (a instanceof Dog) {
	    	  name = a.getName();
	    	} else if (a instanceof Cat) {
	    	  name = a.getName();
	    	}
	    	return name;
	    }
   }

	public void main(String[] args) {
	{
	    logger.debug("Hello from Log4j 2 - num : {}", Constante.tab);
	}
   }
    
    
}