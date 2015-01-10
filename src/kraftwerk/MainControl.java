package kraftwerk;

public class MainControl {
	
	private final static int REACTOR_CRITICALTEMP = 2878;
	private static final int REACTOR_START_TEMP = 0; 
    private static final int REACTOR_HEAT_COEFFICIENT = 42;
    private static final int PUMP_SPEED = 1;
    private static final int PUMP_COEFFICENT = 1;
    private static final int WATER_START_TEMP = 10; 
    private static final int WATER_CYCLE_SIZE = 12; 
    private static final int RIVER_START_TEMP = 10;
    public static final Object LOCK = new Object();
	
    private int riverTemp = WATER_START_TEMP;
    private int reactorTemp = REACTOR_START_TEMP;
    		
    public void start(){
    
    ReactorTemp reactortemp = new ReactorTemp(REACTOR_START_TEMP, this);
    River river = new River(WATER_START_TEMP,this);
    CoolingCircuit A = new CoolingCircuit(WATER_START_TEMP);
    RiverExchanger riExchange = new RiverExchanger(A ,river);
    ReactorExchanger reExchange = new ReactorExchanger(A,reactortemp);
    Thread pump = new Thread(new Pump(PUMP_SPEED,A,PUMP_COEFFICENT,riExchange,reExchange,this));
    Thread reactor = new Thread(new Reactor(REACTOR_START_TEMP,REACTOR_HEAT_COEFFICIENT));
    
    pump.start();
    reactor.start();
    
  
    
   
    
    }

    
    
	
	//Ausgabe der Temperaturen
	public void printTemperature(){
		
		System.out.println("Temperatur Reaktor :" +reactorTemp+ ", Temperatur Rueckfluss in Rhein: " + riverTemp);
	}




	public void onRiverTempChange(int temp) {
		this.riverTemp=temp;
	}
	
	
	
	public void onReactorTempChange(int temp){
		this.reactorTemp =temp;
	}
}



