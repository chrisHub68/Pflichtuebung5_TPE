package kraftwerk;

public class RiverExchanger {

	CoolingCircuit circuit;
	River river;
	
	public RiverExchanger(CoolingCircuit circuit ,River river){
		this.circuit = circuit;
		this.river =river;
		
	}
	
	public void exchange(){
		
		int result =  (circuit.getWaterelement(circuit.getPointerB()).getTemperature() + river.getTemperature()) /2;
		river.setTemperature(result);
		circuit.getWaterelement(circuit.getPointerB()).setTemperature(result);
		
	}
}
