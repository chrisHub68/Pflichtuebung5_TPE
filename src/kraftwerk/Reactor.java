package kraftwerk;

public class Reactor extends HasTemperature implements Runnable {

	public Reactor(int temp) {
		super(temp);
	}



	//Temperatur des Reaktors in Grad Celsius
	private int temperature;
	
	
	
	@Override
	public void run() {
		temperature =10;
		while(true){
			
		}
	}
	
}






