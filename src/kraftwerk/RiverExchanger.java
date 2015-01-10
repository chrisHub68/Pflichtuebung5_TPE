package kraftwerk;

public class RiverExchanger {

	CoolingCircuit circuit;
	River river;
	
	public RiverExchanger(CoolingCircuit circuit ,River river){
		this.circuit = circuit;
		this.river =river;
		
	}
	
	public void exchange(){
		
		int resolution =  (circuit.getPointerB() + river.getTemperature()) /2;
	}
}
