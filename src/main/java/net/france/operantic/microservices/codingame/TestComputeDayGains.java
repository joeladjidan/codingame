package net.france.operantic.microservices.codingame;
	import java.util.*;
	import java.io.*;
	/**
	 * 
	 * @author operantic
	 * 
	 * Pour attirer les touristes, un Casino de Las Vegas propose un buffet à volonté où chacun paye ce qu'il souhaite payer.
	 * Sachant que vous connaissez ce que chaque touriste est prêt à payer, on vous demande de calculer les gains du restaurant pour la journée :
	 * En début de journée le restaurant est vide. Un touriste arrive, est placé, mange, paye et s'en va. Il y a seulement nbSeats places disponibles. 
	 * Un touriste peut manger et payer seulement s'il peut être placé. 
	 * Si un touriste arrive au restaurant alors qu'il n'y a plus de places disponibles : 
	 * soit il attend son tour jusqu'à ce qu'une place se libère soit il attend un moment et part avant qu'une place se libère 
	 * Un touriste peut venir plusieurs fois dans la journée, dans ce cas il ne paye au maximum qu'une seule fois.
	 * Implémentez la méthode computeDayGains(nbSeats, payingGuests, guestMovements) qui renvoie les gains de la journée :
	 * Le tableau payingGuests contient ce que chaque touriste est prêt à payer. 
	 * Par exemple si payingGuests[5] vaut 25, cela veut dire que le touriste avec l'idenfiant 5 est prêt à payer 25$ pour le buffet. 
	 * Le tableau guestMovements donne l'ordre des arrivées et départs des touristes. 
	 * La première fois que vous trouvez un identifiant dans le tableau, il s'agit d'une arrivée. 
	 * La deuxième fois, il s'agit d'un départ. Un arrivée est toujours suivie d'un départ dans la journée.
	 * 
	 */
	public class TestComputeDayGains {
	/* Ignore and do not change the code below */
		// #region main
		public static void main(String args[])
		{
			Scanner in = new Scanner(System.in);
			int nbSeats = in.nextInt();
			int nbGuests = in.nextInt();
			int nbMovements = in.nextInt();
			
			System.out.println("Resultat de la somme "+nbSeats);
			
			int[] payingGuests = new int[nbGuests];
			
			for (int i = 0; i < nbGuests; i++) {
			   payingGuests[i] = in.nextInt();
			}
			
			int[] guestMovements = new int[nbMovements];
			for (int i = 0; i < nbMovements; i++) {
			   guestMovements[i] = in.nextInt();
			}
			
			PrintStream outStream = System.out;
			System.setOut(System.err);
			int res = computeDayGains(nbSeats, payingGuests, guestMovements);
			System.setOut(outStream);
			System.out.println(res);
		}
	    // #endregion
		
		public static int computeDayGains(int nbSeats, int[] payingGuests, int[] guestMovements) {
			// To debug: System.err.println("Debug messages...");
			List<Integer> tablePresence = new ArrayList<Integer>();
			List<Integer> tableMangeur = new ArrayList<Integer>();
			Integer totalPaid = 0;
			for(int i =0; i <guestMovements.length; i++){
			if(tablePresence.size() == nbSeats){
				continue;
			}
			int element = tablePresence.indexOf(guestMovements[i]);
				if(element > -1){
					tablePresence.remove(element);
				}else{
					tablePresence.add(guestMovements[i]);
					int indexMangeur = tablePresence.indexOf(guestMovements[i]);
					if(indexMangeur == -1){
					   tableMangeur.add(guestMovements[i]);
					   totalPaid += payingGuests[guestMovements[i]];
					}
				}
			}
			return totalPaid;
		}
}