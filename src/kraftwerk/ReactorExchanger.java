package kraftwerk;

public class ReactorExchanger {

	CoolingCircuit circuit;
	ReactorTemp reTemp;
	
	public  ReactorExchanger(CoolingCircuit circuit,ReactorTemp reTemp){
		
		this.circuit=circuit;
		this.reTemp=reTemp;
	}
	
	
	public void exchange(){
		
		int result =  (circuit.getWaterelement(circuit.getPointerA()).getTemperature() + reTemp.getTemperature()) /2;
		reTemp.setTemperature(result);
		circuit.getWaterelement(circuit.getPointerB()).setTemperature(result);
		
	}
}
