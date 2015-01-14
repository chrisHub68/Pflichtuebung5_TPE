package kraftwerk;
/**
 * RiverExchanger ist der Wärmetauscher für den Rhein.
 * @author h.ahmetovic
 *
 */
public class RiverExchanger {

	CoolingCircuit circuit;
	River river;
	
	public RiverExchanger(CoolingCircuit circuit ,River river){
		this.circuit = circuit;
		this.river =river;
		
	}
	/**
	 * Wärmtetausch Methode für den Fluss
	 */
	public void exchange(){
		
		int result =  (circuit.getWaterelement(circuit.getPointerB()).getTemperature() + river.getTemperature()) /2;
		river.setTemperature(result);
		circuit.getWaterelement(circuit.getPointerB()).setTemperature(result);
		
	}
}
