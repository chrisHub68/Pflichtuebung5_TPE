package kraftwerk;

public class Waterelement implements HasTemperature{
	
	private int temperature;

	
	public Waterelement(int temperature){
		this.temperature = temperature;
	}
	
	@Override
	public void changeTemp(int temperature) {
		this.temperature = temperature;
	
		
	}

	@Override
	public int getTemp(int a) {
		return this.temperature;
	}

	
}
