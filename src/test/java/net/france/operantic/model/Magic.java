package net.france.operantic.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Magic {
	
	/**
	 * 
	 * @author operantic
	 * 
	 * Vous transportez un certain nombre de pierres ayant chacune un niveau n (entier, 0 < n < 10000).
	 * Deux pierres d'un même niveau n peuvent être fusionnées pour créer une pierre de niveau n + 1.
	 * La méthode magic retourne le nombre minimum de pierres pouvant être atteint par fusions successives.
	 * Dans cet exemple, le nombre minimum de pierres est 1.
     * Écrivez le corps de la méthode magic(stones). 
     * stones est une liste d'entiers qui contient au moins un élément.
	 * 
	 */
	public static int magicStones(List<Integer> stones) 
	{
		List<Integer> table = new ArrayList<Integer>();
		Collections.sort(stones);
		int i = 0;
		boolean arret = true;
		while (arret) {
		arret = false;
		while (i < stones.size()-1) {
			if(stones.get(i) == stones.get(i+1)){
				table.add(stones.get(i)+1);
				i +=2;
				arret = true;
			}else{
				table.add(stones.get(i));
				i +=1;
			}
		}
		if(table.size()>0){
			stones = table;
			table.clear();
		}
	}
	return stones.size();
   }
}

