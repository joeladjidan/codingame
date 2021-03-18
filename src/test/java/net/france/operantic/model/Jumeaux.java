package net.france.operantic.model;

public class Jumeaux {
	
  /**
	 * 
	 * @author operantic
	 * @param a
	 * @param b
	 * 
	 * Le jumeau (twin) d'un mot est un mot écrit avec exactement les mêmes lettres (indépendamment de la casse), 
	 * mais pas nécessairement dans le même ordre.
     * Par exemple Marion est le jumeau de Romain.
     * La méthode isTwin(a, b) retourne true si b est le jumeau de a ou false si ce n'est pas le cas. 
     * a et b sont deux chaînes de caractères non null.
     * Écrivez le corps de la méthode isTwin(a, b) .
	 * @return boolean  true or false
	 */
	public static boolean isTwin(String a, String b) {
		
	    if(a != null && a != "" && b != null && b != "" ) {
		   if(a.length() == b.length()){
			  String aLower = a.toLowerCase();
			  String bLower = b.toLowerCase();
			
			char[] co = String.valueOf(aLower).toCharArray();
			char[] bo = String.valueOf(bLower).toCharArray();
				for(int i = 0; i < co.length; i++){
					if(co[i] != bo[i]){
						return false;
					}
		        }
		       return true;
		    }
	    }
		return false;
	}
}

