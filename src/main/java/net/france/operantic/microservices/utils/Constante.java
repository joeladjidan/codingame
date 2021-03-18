package net.france.operantic.microservices.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Constante {
	
  public static final String directory = System.getProperty("user.home");
  public static final String  fileName = "/Example/sample.txt";
  public static final String  absolutePath = directory + File.separator + fileName;
	
	
  public static final int a = 1;
  public static final int b = 2;
  public static final String VALUE1 = "cha";
  public static final String VALUE2 = "ABC";
  public static final int tab [] = {7,5,6,1,4,2,11,12};
  public static final String [] str = {"123", "345", "437", "894"};
  public static final Integer tableau []  = {1,4,3,7,5,11,15};
  public static final String table []  = {"f", "o", "o", "bar"};
  public static final String majiscule =  "Ceci est Un Test"; 
  public static final List<Integer> array = new ArrayList<Integer>();
  public static final List<Integer> arrayPair = new ArrayList<Integer>();
  public static final List<Integer> arrayImp = new ArrayList<Integer>();
  public static final List<Integer> number = Arrays.asList(1, 2, 7, 4, 5, 9, 14, 16, 19, 20);
  public static final List<String> strings = Arrays.asList("girafe", "chameau", "chat", "poisson", "cachalot");
  public static final List<String> listDestinataire = new ArrayList<String>();
  public static final List<String> listSource = new ArrayList<String>(Arrays.asList("Edwige","Joel","Martial","Franck"));
  
}
