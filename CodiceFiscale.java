/**
 * Classe che offre metodi di utilità per la gestione
 * dei codici fiscali
 * 
 * @author Gruppo B
 *
 */

public class CodiceFiscale {
	
	private final static int LENGTH = 16;
	private final static int [] SEPARATORI = {5, 7, 8, 10, 11, 14};
	
	//Stringhe costanti utilizzate per gli errori
	private final static String ERRORE_LUNGHEZZA = "Attenzione! Il codice fiscale inserito non possiede 16 caratteri!";
	private final static String ERRORE_CARATTERI = "Attenzione! Nella posizione #%d deve essere presente un carattere alfabetico!\n";
	private final static String ERRORE_CIFRE = "Attenzione! Nella posizione #%d deve essere presente una cifra!\n";	
			                                             
	/**
	 * Controlla che un codice fiscale sia valido
	 * 
	 * Regole utilizzate:
	 * 6 caratteri [A-Z]
	 * 2 caratteri [0-9]
	 * 1 caratteri [A-Z]
	 * 2 caratteri [0-9]
	 * 1 caratteri [A-Z]
	 * 3 caratteri [0-9]
	 * 1 caratteri [A-Z]
	 * 
	 * @param codiceFiscale il codice fiscale da verificare
	 *        
	 * @throws IllegalArgumentException Se viene trovato un carattere errato nel codice nell'eccezione viene specificata la posizione del carattere sbagliato
	 *         
	 * @return true se il codice è corretto, false se il codice è errato
	 */
	public static boolean valido(String codiceFiscale) {
		
		codiceFiscale = codiceFiscale.trim().toUpperCase();
		
		if(codiceFiscale.length() != LENGTH) {
			
			System.out.println(ERRORE_LUNGHEZZA);
			return false;
	
		}
		
		int j = 0;
		boolean lettere = true;
		
		for (int i = 0; i < codiceFiscale.length(); i++) {
			
			if (i > SEPARATORI[j]) {
				
				j++;
				lettere = !lettere;
				
			}
			
			if (lettere)
				if(!(codiceFiscale.charAt(i) >= 'A' && codiceFiscale.charAt(i) <= 'Z')) {
					
					System.out.printf(ERRORE_CARATTERI, i);
					return false;
					
				}
			
			else 
				if(!(codiceFiscale.charAt(i) >= '0' && codiceFiscale.charAt(i) <= '9')) {
					
					System.out.printf(ERRORE_CIFRE, i);
					return false;
					
				}
			
		}
		
		return true;
		
	}
	
	/**
	 * Gestisce l'acquisizione del codice fiscale
	 * e lo ritorna in uan stringa
	 * 
	 * @param msgLetturaCodiceFiscale Il messaggio da stampare a video per l'aquisizione del codice fiscale
	 *        
	 * @return Il codice fiscale acquisito
	 */
	public static String leggiCodiceFiscale(String messaggio) {
		
		boolean finito = false;
		String codiceFiscale = null;		

		do {
			
			codiceFiscale = MyUtil.leggiStringaConSpazi(messaggio);
			finito = valido(codiceFiscale);
		
		} while (!finito);
		
		return codiceFiscale;
		
	}	

}
