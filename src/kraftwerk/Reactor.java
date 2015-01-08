package kraftwerk;

public class Reactor implements Runnable,HasTemperature {

	//Temperatur des Reaktors in Grad Celsius
	public int temperature;
	
	
	
	@Override
	public void run() {
		temperature =10;
	
		while(true){
			
		}
	}



	@Override
	public void changeTemp(int temperature) {
		this.temperature = temperature;
		
	}



	@Override
	public int getTemp(int temperature) {
		return this.temperature;
	}
	

}


