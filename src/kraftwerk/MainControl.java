package kraftwerk;

public class MainControl {
	
	private final static int REACTOR_CRITICALTEMP = 2878;
	private static final int REACTOR_START_TEMP = 0; 
    private static final int REACTOR_HEAT_COEFFICIENT = 42;
    private static final int PUMP_SPEED = 1;
    private static final int WATER_START_TEMP = 10; 
    private static final int WATER_CYCLE_SIZE = 12; 
    private static final int REACTOR_POS = 0; 
    private static final int RIVER_POS = 5;
    private static final int RIVER_START_TEMP = 10;
    public static final Object LOCK = new Object();
	
    
    public void start(){
    	
    CoolingCircuit A = new CoolingCircuit(10);
    Thread pump = new Thread(new Pump());
    Thread reactor = new Thread(new Reactor(REACTOR_START_TEMP));
    pump.start();
    reactor.start();
    
    reactor.sleep(1000);
    
    //ToDo
    
    }

    
	
	//Ausgabe der Temperaturen
	private void printTemperature(int tr , int tf){
		
		System.out.println("Temperatur Reaktor :" +tr+ ", Temperatur Rückfluss in Rhein: " +tf);
	}
}



// wartezeit 1000/pump
//