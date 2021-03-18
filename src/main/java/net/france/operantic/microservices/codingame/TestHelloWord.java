package net.france.operantic.microservices.codingame;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestHelloWord {
	/**
	 * 
	 * @author operantic
	 *
	 * console> java Echo Hello you !
     *
     * Écrivez le programme Echo pour afficher .
     * 
	 * Hello 
	 * you 
	 * !
     * console>
     * 
	 */
	
	public static void main(String[] args) 
    {
		String strings = "Hello you !";
		echo(strings) ;
    }
	
	public static void echo(String str) {
		 List<String> list = Stream.of(str.split(" "))
		            .collect(Collectors.toCollection(ArrayList::new));
	      Consumer<String> lambdaExpression = x -> System.out.println(x);
	      list.forEach(lambdaExpression);
	}
}
