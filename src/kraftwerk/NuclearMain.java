package kraftwerk;
/**
 * Main Klasse NuclearMain wird benötigt um das ReaktorProgramm zu starten
 *
 */
public class NuclearMain {

	
	
	public static void main(String[] args) {
		//Starte die Leitwarte
		MainControl mc = new MainControl();
		System.out.println("Start");
		mc.start();
		
		
	}

}
