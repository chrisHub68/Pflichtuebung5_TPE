package kraftwerk;
/**
 * RiverExchanger ist der W�rmetauscher f�r den Rhein.
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
	 * W�rmtetausch Methode f�r den Fluss
	 */
	public void exchange(){
		
		int result =  (circuit.getWaterelement(circuit.getPointerB()).getTemperature() + river.getTemperature()) /2;
		river.setTemperature(result);
		circuit.getWaterelement(circuit.getPointerB()).setTemperature(result);
		
	}
}
