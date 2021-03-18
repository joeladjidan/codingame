package net.france.operantic.microservices.codingame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.france.operantic.microservices.utils.Constante;
import net.france.operantic.microservices.utils.Function;

public class TestApplication {
	private static final Logger logger = LogManager.getLogger(TestApplication.class);
	
    public static void main(String[] args) 
    {
    	logger.debug("Hello from Log4j 2 - num : {}", Constante.tab);
    	Function.isFoo(null);
    //	Function.webnet(Constante.tableau);
    	Function.minArrayJava8(Constante.tab);
    	Function.maxArrayJava8(Constante.tab);
    	Function.numberPair(Constante.number);
    	Function.numberInPair(Constante.number);
    	Function.sum(Constante.a, Constante.b);
    	Function.concat(Constante.table);
    	Function.getEvenNumbers(8, 3);
    	Function.trieCroissantDecroissant(Constante.tab);
    	Function.compterMinisculeJava8(Constante.majiscule);
    	Function.compterMajusculesJava8(Constante.majiscule);
    	Function.stringContainsElement(Constante.VALUE1, Constante.strings);
    	Function.permute(Constante.VALUE2, 0, Constante.VALUE2.length() - 1);
    	Function.recopierListeJava8(Constante.listSource, Constante.listDestinataire);
    }
    
   
    
    
    
}
