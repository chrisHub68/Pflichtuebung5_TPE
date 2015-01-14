package kraftwerk;
/**
 * RiverExchanger ist der Wärmetauscher für den Rhein.
 *
 */
public class RiverExchanger {

	private CoolingCircuit circuit;
	private River river;
	
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
