package kraftwerk;

public class Pump implements Runnable {

	
	//Pumpleistung in Liter pro Sekunde
	private int performance = 0;
	private CoolingCircuit a; 
	
	public Pump(int performance, CoolingCircuit coolingcircuit){
		this.performance=performance;
		this.a = coolingcircuit;
	}
	
	@Override
	public void run() {
		a.rotate();
	}

	
	public int getPerformance(){
		return this.performance;
	}
	
	
	public void setPerformance(int performance){
		this.performance = performance;
	}
	
	
}
