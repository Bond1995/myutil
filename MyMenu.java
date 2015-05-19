/**
 * Classe che rappresenta un prototipo di menu per l'interazione con l'utente
 * 
 * @author Gruppo B
 *
 */
public class MyMenu {
	
	private String titolo;
	private String voci[];
	
	/**
	 * Costruttore della classe MyMenu che assegna all'oggetto un titolo e delle voci
	 * @param titolo Il titolo del menu
	 * @param voci Le voci del menu
	 */
	public MyMenu (String titolo, String voci []){
		this.titolo = titolo;
		this.voci = voci;
	}
	
	/**
	 * Gestisce la scelta di un'opzione del menu da prate dell'utente
	 * @return L'indice della scelta dell'utente
	 */
	public int scegliVoce(){
		
		stampaMenu();
		return (MyUtil.leggiInt(1, voci.length) - 1);
		
	}
	
	/**
	 * Stampa a video il menu con le relative opzioni
	 */
	public void stampaMenu (){
		
		System.out.println(titolo);
		for(int i = 0; i < voci.length; i++) 
			System.out.println((i+1) + "\t" + voci[i] + "\n" );
		
	}

}
