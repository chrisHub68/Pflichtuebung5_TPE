package kraftwerk;

public class Pump implements Runnable {

	
	//Pumpleistung in Liter pro Sekunde
	private int performance = 0;
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
	public int getPerformance(){
		return this.performance;
	}
	
	
	public void setPerformance(int performance){
		this.performance = performance;
	}
	
	
}
