
  package net.france.operantic.microservices;
  
  import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.france.operantic.microservices.utils.Constante;
import net.france.operantic.model.Booleans;
import net.france.operantic.model.Calculator;
import net.france.operantic.model.Combinaison;
import net.france.operantic.model.Danseur;
import net.france.operantic.model.Factoriel;
import net.france.operantic.model.Jumeaux;
import net.france.operantic.model.Magic;
import net.france.operantic.model.Permutation;
import net.france.operantic.model.Functions;
  
  @RunWith(SpringRunner.class)
  @SpringBootTest 
   class ApplicationTests {
	  
	Booleans booleans = new  Booleans();
	Calculator calculator;

    @BeforeAll
    static void start() {
        System.out.println("inside @BeforeAll");
    }

    @BeforeEach
    void init() {
        System.out.println("inside @BeforeEach");
        booleans = new Booleans();
        calculator = new Calculator();
    }

    @Test
    void testExpressionBoolean() {
        System.out.println("inside testExpressionBoolean");
        assertTrue(booleans.a(Constante.a, Constante.b));
    }
    
    @Test
    void additionTest() {
        System.out.println("inside additionTest");
        assertAll(
            () -> assertEquals(2, Calculator.addition(1,1), "Doesn't add two positive numbers properly"),
            () -> assertEquals(0, Calculator.addition(-1,1), "Doesn't add a negative and a positive number properly"),
            () -> assertNotNull(calculator, "The calc variable should be initialized")
        );
    }
    
    @Test
    void sommeArrayTest() {
        System.out.println("inside sommeArrayTest");
        assertAll(
            () -> assertEquals(6, Calculator.sommeArray(Constante.tab, 1, 2), "Doesn't add two positive numbers properly"),
            () -> assertEquals(0, Calculator.sommeArray(Constante.tab, 10, 8), "Doesn't add a negative and a positive number properly"),
            () -> assertNotNull(calculator, "The calc variable should be initialized")
        );
    }

    @Test
    void divisionTest() {
        System.out.println("inside divisionTest");
        assertThrows(ArithmeticException.class, () -> calculator.division(2,0));
    }
    
    
    @Test
    void totalPriceTest() {
        System.out.println("inside totalPriceTest");
        assertEquals(48, Calculator.totalPrice(Constante.tab, Constante.a), "Erreur detecté dans le calcul total des prix de promotions");
    }
    
    @Test
    void combinaisonTest() {
       System.out.println("inside @combinaisonTest");	
       assertAll(
            () -> assertEquals(6, Combinaison.count(4) , "Erreur detecté dans le calcul total des prix de promotions")
        );
    }
    
    @Test
    void danseurTest() {
       System.out.println("inside @danseurTest");	
       assertAll(
            () -> assertEquals(-4, Danseur.getPositionAt(3), "Erreur detecté dans le calcul total des prix de promotions"),
            () -> assertEquals(-5, Danseur.getPositionAt(100000), "Erreur detecté dans le calcul total des prix de promotions"),
            () -> assertEquals(1, Danseur.getPositionAt(2147483647), "Erreur detecté dans le calcul total des prix de promotions")
        );
    }
    
    @Test
    void factorielTest() {
       System.out.println("inside @factorielTest");	
       assertAll(
            () -> assertEquals(24, Factoriel.factorialUsingStreams(4) , "Erreur detecté dans le calcul total des prix de promotions"),
            () -> assertEquals(24, Factoriel.factorialUsingForLoop(4), "Erreur detecté dans le calcul total des prix de promotions"),
            () -> assertEquals(24, Factoriel.fact(4), "Erreur detecté dans le calcul total des prix de promotions")
        );
    }
    
    @Test
    void jumeauxTest() {
    	 System.out.println("inside @jumeauxTest");	
    	 assertTrue(Jumeaux.isTwin("joel", "joel") , "Erreur detecté dans le calcul total des prix de promotions");
    }
    
    @Test
    void magicTest() {
    	 System.out.println("inside @magicTest");	
    	 assertAll(
	            () -> assertEquals(0, Magic.magicStones(Constante.array) , "Erreur detecté dans le calcul total des prix de promotions")
	        );
    }
    
    @Test
    void permutationTest() {
       System.out.println("inside @permutationTest");	
       assertAll(
            () -> assertEquals(0, Permutation.trouvePetitEtGrand(Constante.tab) , "Erreur detecté dans le calcul total des prix de promotions")
        );
    }
    
    @Test
    void functionsTest() {
       System.out.println("inside @functionsTest");	
       assertAll(
	          //  () -> assertEquals("ddddd", Functions.get(67,34) , "Erreur detecté dans le calcul total des prix de promotions"),
	          //  () -> assertTrue(Functions.check("JOEL") , "Erreur detecté dans le calcul total des prix de promotions"),
    		   () -> assertEquals(5, Functions.findNetworkEndpoint(5, Constante.tab , Constante.tab ) , "Erreur detecté dans le calcul total des prix de promotions"),
    		   () -> assertEquals(1, Functions.closestToZero(Constante.tab) , "Erreur detecté dans le calcul total des prix de promotions"),
    		   () -> assertEquals(894, Functions.stringToIntegerArray(Constante.str) , "Erreur detecté dans le calcul total des prix de promotions"),
    		   () -> assertEquals(23, Functions.sumRange(Constante.tab) , "Erreur detecté dans le calcul total des prix de promotions"),
    		   () -> assertEquals(48, Functions.findSumUsingStream(Constante.tab) , "Erreur detecté dans le calcul total des prix de promotions"),
    		   () -> assertEquals(6.0, Functions.findAverageUsingStream(Constante.tab) , "Erreur detecté dans le calcul total des prix de promotions"),
    		   () -> assertEquals(55, Functions.findSumIntervalNumber(1,10), "Erreur detecté dans le calcul total des prix de promotions")
	   );
    }

    @AfterEach
    void afterEach() {
        System.out.println("inside @AfterEach");
    }

    @AfterAll
    static void close() {
        System.out.println("inside @AfterAll");
    }
	  
}