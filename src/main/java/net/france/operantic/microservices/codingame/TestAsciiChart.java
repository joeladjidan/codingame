package net.france.operantic.microservices.codingame;

/**
     * 
     * 
	 * In stations and airports you often see this type of screen. 
	 * Have you ever asked yourself how it might be possible to simulate this display on a good old terminal? 
	 * We have: with ASCII art!
	 * 
	 */
	public class TestAsciiChart {
		private static final char[] ALPHABET = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
			    'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 
			    'V', 'W', 'X', 'Y', 'Z'
		};
		
		/**
		* @return the char that is represented by s
		*/
		static char scanChar(String s) {
			if (s == null) {
				return '?';
		}
			
		for (int i = 0 ; i < ALPHABET.length ; i++) {
		    if(s.equals(scanChar(String.valueOf(ALPHABET[i])))) {
		     		return ALPHABET[i];
		   	 }
		   }
		   return '?';
		}

		public void main(String[] args) {
			scanChar("JOEL") ;
		}
	}