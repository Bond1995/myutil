import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Classe MyTime che contiene metodi per facilitare
 * la gestione degli orari e delle date attraverso
 * LocalTime e LocalDate
 * 
 * @author Gruppo B
 *
 */
public class MyTime {
	
	// Stringa costante utilizzata per formattare una
	// LocalDate
	private static final String FORMATO_DATA_ITA = "%02d/%02d/%2d";
	
	// Stringhe costanti per la lettura di un orario
	private final static String ERRORE_FORMATO_ORARIO = "Attenzione! L'orario inserito non rispetta il formato specificato!";	
	private final static String ERRORE_ORARIO_IMPOSSIBILE = "Attenzione! L'orario inserito non è un orario possbile!";	
	private final static String ERRORE_CAST_ORARIO = "Attenzione! Si è verificato un errore. Impossbile acquisire l'orario";
	
	// Stringhe costanti per la lettura di una data
	private final static String FORMATO_DATA = "([0-9][0-9])/([0-9][0-9])/([0-9][0-9][0-9][0-9])";
	private final static String ERRORE_FORMATO_DATA = "Attenzione! La data inserita non rispetta il formato specificato!";	
	private final static String ERRORE_DATA_IMPOSSIBILE = "Attenzione! La data inserito non è un data possbile!";	
	private final static String ERRORE_CAST_DATA = "Attenzione! Si è verificato un errore. Impossbile acquisire la data";

	/**
	 * Ritorna una stringa contenente la data
	 * foramattata nel formato italiano relativo alle date
	 * 
	 * @param data
	 *        la data da formattare
	 *        
	 * @return la data formattata
	 */	
	public static String formattaData(LocalDate data) {
		
		if (data == null)
			return null;
		
		// Si lavora sulla data acquisita come
		// parametro per renderla
		// compatibile alla notazione italiana
		// delle date
		
		// Divido al data in tre stringhe contenti i numeri
		String dataNascitaDivisa[] = data.toString().split("-");
		// "Rovescio" la data la dispongo nel 
		// formato scelto rendendo le stringhe
		// degli interi per facilitarne la
		// formattazione
		String dataNascita = String.format(FORMATO_DATA_ITA, Integer.parseInt(dataNascitaDivisa[2]), 
						                   Integer.parseInt(dataNascitaDivisa[1]), 
						                   Integer.parseInt(dataNascitaDivisa[0]));
		
		return dataNascita;
	}
	
	/**
	 * Gestisce l'acquisizione di un orario
	 * e lo ritorna
	 * 
	 * @param msgLetturaOrario
	 *        il messaggio da stampare a video per 
	 *        l'aquisizione dell'orario
	 * @param formato
	 *        il formato dell'orario da leggere
	 *        
	 * @return l'orario acquisito
	 */
    public static LocalTime leggiOrario(String msgLetturaOrario, String formato) {
    	// Variabile utilizzata per la condizione di uscita dal ciclo
    	// per l'inserimento dell'orario
		boolean flag = false;
		String orarioStr;
		int ore = 0, minuti = 0;

		do {
			// Reimposto la condizione del ciclo in modo che 
			// se tutto andrà a buon fine si uscirà
			flag = false;
			
			// Leggo l'orario stampando la stringa ricevuta
			// come parametro
			orarioStr = MyUtil.leggiStringaConSpazi(msgLetturaOrario);
			// Diviso l'orario in due stringhe contenenti
			// rispettivamente le ore e i minuti
			String orarioDiviso[] = orarioStr.split(":");

			// Se l'orario non è del formato richiesto allora
			// imposto la condizione del ciclo a
			// true in modo che venga data la possibilità
			// all'utente di inserirne un altro
			if (!orarioStr.matches(formato)) {
				System.out.println(ERRORE_FORMATO_ORARIO);
				flag = true;
			} else {

				try {
					ore = Integer.parseInt(orarioDiviso[0]);
					minuti = Integer.parseInt(orarioDiviso[1]);
				} catch (NumberFormatException e) {
					// Se c'è un errore nel cast allora
					// imposto la condizione del ciclo a
					// true in modo che venga data la possibilità
					// all'utente di inserirne un altro
					System.out.println(ERRORE_CAST_ORARIO);
					flag = true;
				}

				// Se l'orario inserito si tratta
				// di un un orario impossibile allora
				// imposto la condizione del ciclo a
				// true in modo che venga data la possibilità
				// all'utente di inserirne un altro
				try {
					LocalTime.of(ore, minuti);
				} catch (DateTimeException e) {
					System.out.println(ERRORE_ORARIO_IMPOSSIBILE);
					flag = true;
				}
			}
			
		} while (flag);
		
		return LocalTime.of(ore, minuti);
    }	
    
    /**
	 * Gestisce l'acquisizione di una data 
	 * e la ritorna
	 * 
	 * @param msgLetturaData
	 *        il messaggio da stampare a video per 
	 *        l'aquisizione della data
	 *        
	 * @return la data acquisita
	 */
	public static LocalDate leggiData(String msgLetturaData) {
		// Variabile utilizzata per la condizione di uscita dal ciclo
    	// per l'inserimento della data
		boolean flag = false;
		String dataStr;
		int giorno = 0, mese = 0, anno = 0;

		do {
			// Reimposto la condizione del ciclo in modo che 
			// se tutto andrà a buon fine si uscirà
			flag = false;
			
			// Leggo la data stampando la stringa ricevuta
			// come parametro
			dataStr = MyUtil.leggiStringaConSpazi(msgLetturaData);

			// Diviso la data in tre stringhe contenenti
			// rispettivamente il girono, il mese e l'anno
			String orarioDiviso[] = dataStr.split("/");

			// Se la data non è del formato richiesto allora
			// imposto la condizione del ciclo a
			// true in modo che venga data la possibilità
			// all'utente di inserirne un'altra
			if (!dataStr.matches(FORMATO_DATA)) {
				System.out.println(ERRORE_FORMATO_DATA);
				flag = true;
			} else {

				try {
					giorno = Integer.parseInt(orarioDiviso[0]);
					mese = Integer.parseInt(orarioDiviso[1]);
					anno = Integer.parseInt(orarioDiviso[2]);
				} catch (NumberFormatException e) {
					// Se c'è un errore nel cast allora
					// imposto la condizione del ciclo a
					// true in modo che venga data la possibilità
					// all'utente di inserirne un'altra
					System.out.println(ERRORE_CAST_DATA);
					flag = true;
				}

				// Se la data inserita si tratta
				// di un una data impossibile allora
				// imposto la condizione del ciclo a
				// true in modo che venga data la possibilità
				// all'utente di inserirne un'altra
				try {
					LocalDate.of(anno, mese, giorno);
				} catch (DateTimeException e) {
					System.out.println(ERRORE_DATA_IMPOSSIBILE);
					flag = true;
				}
			}
			
		} while (flag);
		
		return LocalDate.of(anno, mese, giorno);
		
	}
	
}
