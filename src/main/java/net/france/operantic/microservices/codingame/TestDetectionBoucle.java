package net.france.operantic.microservices.codingame;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestDetectionBoucle {
   /**
	* 
	* @author operantic
	* 
	* Implémentez la méthode findNetworkEndpoint(startNodeId, fromIds, toIds) qui 
	* retourne l'id du dernier noeud du réseau trouvé en partant du noeud startNodeId et en suivant les liens du réseau.
    * Dans l'exemple ci-dessus, le noeud terminal en partant du noeud n°2 (ou de n'importe quel noeud) est le noeud n°5.
	* fromIds et toIds sont deux tableaux de la même longueur qui décrivent les liens unidirectionnels du réseau ( fromIds[i] est lié à toIds[i]).
    * Dans le cas où vous rencontrez une boucle lors du parcours du réseau, 
    * la méthode doit renvoyer l'id du dernier noeud traversé avant de clore la boucle.
    * Constraintes:
    * 0 < nombre de liens < 10000 Un noeud ne peut pas être directement lié à lui-même.
	* 
	* @return the number that is closest to zero
	*/
	
	 public static int findNetworkEndpoint(int startNodeId, int[] fromIds, int[] toIds) {
			 List<Integer> listFromId = new ArrayList<Integer>();
			 List<Integer> listToId = new ArrayList<Integer>();
			 
			 for(int fro : fromIds){
			     listFromId.add(fro);
			 }
			 
			 
			 for(int fro : toIds){
			     listToId.add(fro);
			 }
			 
			 for(Integer elementToId : listToId){
			     if(listFromId.indexOf(elementToId) == -1) 
			        return elementToId;
			 }
		 
		     int indexStarTnode = listToId.indexOf(startNodeId);
		 
		     return listFromId.get(indexStarTnode);
		 }

		 
		 /* Ignore and do not change the code below */
		 // #region main
		 public static void main(String args[]) {
			 Scanner in = new Scanner(System.in);
			 
			 int startNodeId = in.nextInt();
			 int n = in.nextInt();
			 int[] fromIds = new int[n];
			 
			 for (int i = 0; i < n; i++) {
			    fromIds[i] = in.nextInt();
			 }
			 
			 int[] toIds = new int[n];
			 for (int i = 0; i < n; i++) {
			    toIds[i] = in.nextInt();
			 }
			 
			 PrintStream outStream = System.out;
			 System.setOut(System.err);
			 int endPointId = findNetworkEndpoint(startNodeId, fromIds, toIds);
			 System.setOut(outStream);
			 System.out.println(endPointId);
		 }
		 // #endregion
}