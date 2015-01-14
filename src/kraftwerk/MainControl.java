package kraftwerk;
 
public class MainControl {
 
        private final static int REACTOR_CRITICALTEMP = 2878;
        private static final int REACTOR_START_TEMP = 10;
        private static final int REACTOR_HEAT_COEFFICIENT =1000;
        private static final int PUMP_SPEED = 100;
        private static final int PUMP_COEFFICENT = 1;
        private static final int WATER_START_TEMP = 10;
        
        
        
        public static final Object LOCK = new Object();
 
        private int riverTemp = WATER_START_TEMP;
        private int reactorTemp = REACTOR_START_TEMP;
        
        private Thread reactorT;
        private Thread pump;
        public void start() {
 
                Reactor reactor = new Reactor(REACTOR_START_TEMP,
                                REACTOR_HEAT_COEFFICIENT, this);
                River river = new River(WATER_START_TEMP, this);
                CoolingCircuit A = new CoolingCircuit(WATER_START_TEMP);
                RiverExchanger riExchange = new RiverExchanger(A, river);
                ReactorExchanger reExchange = new ReactorExchanger(A, reactor, this);
                pump = new Thread(new Pump(PUMP_SPEED, A, PUMP_COEFFICENT,
                                riExchange, reExchange, this));
                reactorT = new Thread(reactor);
 
                pump.start();
                reactorT.start();
 
                try {
 
                        Thread.sleep(20000);
                } catch (InterruptedException e) {
                        e.printStackTrace();
 
                }
                
                endProgramm( pump, reactorT);
 
            
 
        }
 
        //Ausgabe der Temperaturen
        public void printTemperature() {
 
                System.out.println("Temperatur Reaktor :" + reactorTemp
                                + ", Temperatur Rueckfluss in Rhein: " + riverTemp);
        }
 
        public void onRiverTempChange(int temp) {
                this.riverTemp = temp;
        }
 
        public void onReactorTempChange(int temp) {
                this.reactorTemp = temp;
                if(this.reactorTemp > REACTOR_CRITICALTEMP){
                System.out.println("Der Reaktor hat seine Kritische Temperatur"
                				+ " erreicht und wird nun heruntergefahren!");
                endProgramm(pump, reactorT);
                }
                //printTemperature();
        }
        
        public void endProgramm(Thread pump,Thread reactor){
        	
        	   pump.interrupt();
               reactor.interrupt();

               System.exit(0);
        }
        
 
}