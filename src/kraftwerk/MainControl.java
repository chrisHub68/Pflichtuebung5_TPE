package kraftwerk;

public class MainControl {
	
	private final static int CRITICALTEMP = 2878;
	
	
	
    public void start(){
    	
    CoolingCircuit A = new CoolingCircuit();
    Thread pumpe = new Thread(new Pump());
    Thread reaktor = new Thread(new Reactor());
    }

    
	
	//Ausgabe der Temperaturen
	private void printTemperature(int tr , int tf){
		
		System.out.println("Temperatur Reaktor :" +tr+ ", Temperatur Rückfluss in Rhein: " +tf);
	}
}
