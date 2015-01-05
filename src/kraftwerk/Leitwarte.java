package kraftwerk;

public class Leitwarte {
	
	private final static int CRITICALTEMP = 2878;
	
	
	
    public void start(){
    	
    Kuehlkreislauf A = new Kuehlkreislauf();
    Thread pumpe = new Thread(new Pumpe());
    Thread reaktor = new Thread(new Reaktor());
    }

    
	
	//Ausgabe der Temperaturen
	private void printTemperature(int tr , int tf){
		
		System.out.println("Temperatur Reaktor :" +tr+ ", Temperatur Rückfluss in Rhein: " +tf);
	}
}
