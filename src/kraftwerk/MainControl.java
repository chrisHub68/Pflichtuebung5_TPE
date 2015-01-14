package kraftwerk;

/**
 * Klasse MainControl implementiert eine Leitwarte, die zur Steuerung des
 * Kraftwerks dient.
 *
 */
public class MainControl {

	// maximal mögliche Temperatur des Reaktors
	private final static int REACTOR_CRITICALTEMP = 2878;
	// Reaktortemperatur im Ruhestand
	private static final int REACTOR_START_TEMP = 10;
	// Erhitzungskoeffizient des Reaktors
	private static final int REACTOR_HEAT_COEFFICIENT = 1000;
	// Pumpleistung in Litern der Pumpe pro Pumpbewegung
	private static final int PUMP_SPEED = 100;
	// Pumpbewegungen pro Sekunde(17 = 17Pumpbewegungen in einer sek)
	private static final int PUMP_COEFFICENT = 1;
	// Temperatur des Rheins
	private static final int WATER_START_TEMP = 10;
	
	

	// Tokenobjekt für threadsicheren Ablauf im Programm
	public static final Object LOCK = new Object();

	private int riverTemp = WATER_START_TEMP;
	private int reactorTemp = REACTOR_START_TEMP;

	private Thread reactorT;
	private Thread pump;

	public void start() {

		/*
		 * Objekterzeugungen der Elemente im Kraftwerk
		 */
		Reactor reactor = new Reactor(REACTOR_START_TEMP,
				REACTOR_HEAT_COEFFICIENT, this);
		River river = new River(WATER_START_TEMP, this);
		CoolingCircuit A = new CoolingCircuit(WATER_START_TEMP);
		RiverExchanger riExchange = new RiverExchanger(A, river);
		ReactorExchanger reExchange = new ReactorExchanger(A, reactor, this);
		/*
		 * Erstelle Threads für Pumpe und Reaktor und mache diese damit 
		 * lauffähig
		 */
		pump = new Thread(new Pump(PUMP_SPEED, A, PUMP_COEFFICENT, riExchange,
				reExchange, this));
		reactorT = new Thread(reactor);
		
		//Kontrolle
		if(this.reactorTemp > REACTOR_CRITICALTEMP){
			System.out.println("Der Reaktor hat seine Kritische Temperatur"
					+ " erreicht und wird nun heruntergefahren!");
			endProgramm(pump, reactorT);
		}
		
		
		/*
		 * Threads starten
		 */
		pump.start();
		reactorT.start();

		try {
			// Warte 20 Sekunden bis MainThread weiter macht
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();

		}

		
		endProgramm(pump, reactorT);

	}

	// Ausgabe der Temperaturen
	public void printTemperature() {

		System.out.println("Temperatur Reaktor :" + reactorTemp
				+ ", Temperatur Rueckfluss in Rhein: " + riverTemp);
	}

	public void onRiverTempChange(int temp) {
		this.riverTemp = temp;
	}

	/**
	 * Registriert jede Temperaturänderung des Reaktors.
	 * gibt evtl. Überhitzung aus
	 * @param temp
	 */
	public void onReactorTempChange(int temp) {
		this.reactorTemp = temp;
		if (this.reactorTemp > REACTOR_CRITICALTEMP) {
			System.out.println("Der Reaktor hat seine Kritische Temperatur"
					+ " erreicht und wird nun heruntergefahren!");
			endProgramm(pump, reactorT);
		}
		// printTemperature();
	}

	/**
	 * Fährt den Reaktor runter
	 * @param pump
	 * @param reactor
	 */
	public void endProgramm(Thread pump, Thread reactor) {

		pump.interrupt();
		reactor.interrupt();
		System.out.println("\nPumpe wurde heruntergefahren");
		System.out.println("Reaktor wurde heruntergefahren");
		System.exit(0);
	}

}