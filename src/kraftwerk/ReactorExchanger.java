package kraftwerk;
/**
 * Wärmetauscher ReactorExchanger für den Reaktor.
 *
 */
public class ReactorExchanger {

	private CoolingCircuit circuit;
	private Reactor reactor;
	private MainControl mc;
	
	public  ReactorExchanger(CoolingCircuit circuit,Reactor reactor,MainControl mc){
		
		this.circuit=circuit;
		this.reactor=reactor;
		this.mc=mc;
	}
	
	/**
	 * Wärmtetausch Methode für den Reaktor
	 */
	public void exchange(){
		
		int result =  (circuit.getWaterelement(circuit.getPointerA()).getTemperature() + reactor.getTemperature()) /2;
		reactor.setTemperature(result);
		circuit.getWaterelement(circuit.getPointerA()).setTemperature(result);
		mc.onReactorTempChange(result);
	}
}
