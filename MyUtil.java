import java.util.Random;
import java.util.Scanner;

/**
 * Classe personale di utilità generale
 * 
 * @author Gruppo B
 *
 */
public class MyUtil {

	public static Scanner in = creaLettore();
	public static Random random = new Random();
	public static final String ERRORE_NUMERICO = "Attenzione: inserire un valore numerico!";
	public static final String ERRORE_COMPRESO_INT = "Attenzione: inserire un valore numerico compreso tra %d e %d!\n";
	public static final String ERRORE_STRINGA_VUOTA = "Attenzione: inserire una stringa non vuota!\n";
	public static final String SI_O_NO = " (S/N)";
	public static final String ERRORE_SI_O_NO = "Attenzione: inserire S o N!";
	
	/**
	 * Metodo per creare un lettore da tastiera che interrompe la scansione al termine di una riga
	 * 
	 * @return Un oggetto Scanner per la lettura da tastiera
	 */
	public static Scanner creaLettore() {
		
		Scanner in = new Scanner(System.in);
		
		in.useDelimiter(System.getProperty("line.separator"));
		
		return in;
		
	}
	
	/**
	 * Metodo per generare un intero casuale compreso o uguale ai valori inseriti
	 * @param min Il valore minimo tra cui estrarre il numero
	 * @param max Il valore massimo tra cui estrarre il numero
	 * @return Un intero casuale compreso tra i valori inseriti
	 */
	public static int randomInt(int min, int max) {
		
		int n = random.nextInt(max - min + 1);
		n += min;
		
		return n;
		
	}
	
	/**
	 * Metodo per leggere un numero double da tastiera
	 * 
	 * @return Il numero double letto
	 */
	public static double leggiDouble() {
		
		double letto = 0;
		boolean finito = false;
		
		do {
			
			if (in.hasNextDouble()) {
				
				letto = in.nextDouble();
				finito = true;
				
			} else {
				
				System.out.println(ERRORE_NUMERICO);
				String eliminato = in.next();
				
			}
			
		} while (!finito);
		
		return letto;
		
	}
	
	/**
	 * Metodo per leggere un numero double da tastiera compreso o uguale ai valori inseriti
	 * @param min Il valore minimo del double letto
	 * @param max Il valore massimo del double letto
	 * @return Il numero double letto compreso tra i valori inseriti
	 */
	public static double leggiDouble(double min, double max) {
		
		final String ERRORE = "Attenzione: inserire un valore numerico compreso tra %.1f e %.1f!\n";
		double letto = 0;
		boolean finito = false;
		
		do {
			
			letto = leggiDouble();
			
			if (letto >= min && letto <= max) finito = true;
			else System.out.printf(ERRORE, min, max);
			
		} while (!finito);
		
		return letto;
		
	}
	
	/**
	 * Metodo per leggere un numero intero da tastiera
	 * 
	 * @return Il numero int letto
	 */
	public static int leggiInt() {
		
		int letto = 0;
		boolean finito = false;
		
		do {
			
			if (in.hasNextInt()) {
				
				letto = in.nextInt();
				finito = true;
				
			} else {
				
				System.out.println(ERRORE_NUMERICO);
				String eliminato = in.next();
				
			}
			
		} while (!finito);
		
		return letto;
		
	}

	/**
	 * Metodo per leggere un numero intero da tastiera compreso o uguale ai valori inseriti
	 * @param min Il valore minimo dell'intero letto
	 * @param max Il valore massimo dell'intero letto
	 * @return Il numero int letto compreso tra i valori inseriti
	 */
	public static int leggiInt(int min, int max) {

		int letto = 0;
		boolean finito = false;

		do {

			letto = leggiInt();

			if (letto >= min && letto <= max) finito = true;
			else System.out.printf(ERRORE_COMPRESO_INT, min, max);

		} while (!finito);

		return letto;

	}
	
	/**
	 * Metodo per leggere da tastiera una stringa non vuota fino all'immissione dell'a-capo.
	 * @return La stringa non vuota letta.
	 */
	public static String leggiStringaConSpazi() {
		
		boolean finito = false;
		String letta = null;
		
		do {
			
			letta = in.next();
			letta.trim();
			if (letta.length() > 0) finito = true;
			else System.out.println(ERRORE_STRINGA_VUOTA);
			
		} while (!finito);
		
		return letta;
		
	}
	
	/**
	 * Metodo per consentire all'utente di scegliere se compiere o meno un'azione
	 * @param messaggio Il messaggio da stampare a video contente la richiesta all'utente
	 * @return true se l'utente conferma la scelta, false altrimenti
	 */
	 public static boolean yesOrNo(String messaggio) {
		 
		  System.out.println(messaggio + SI_O_NO);
		  
		  do{
			  
			  String scelta = in.next();
			  switch (scelta) {
			  
			  case "S": case "s":
				  return false;
				  
			  case "N": case "n":
				  return true;
				  
			  default: System.out.println(ERRORE_SI_O_NO);
			
			  }
			  
		  } while (true);
		  
	 }
	 
}
