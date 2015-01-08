package kraftwerk;

public class CoolingCircuit {

	
	private Waterelement[] watercircle = new Waterelement[12];
	int pointerA;
	int pointerB;
	
	
	
	//Konstruktor
	public CoolingCircuit(int temperature){
		this.pointerA = 0;
		this.pointerB = 6;
		fill(temperature);
	}
	
	
	
	private void fill(int temperature){
		for (int i = 0; i < watercircle.length; i++) {
			watercircle[i] = new Waterelement(temperature);
		}
	}
	
	

	
}
