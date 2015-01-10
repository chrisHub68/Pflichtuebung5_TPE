package kraftwerk;

public class ReactorExchanger {

	CoolingCircuit circuit;
	Reactor reactor;
	MainControl mc;
	
	public  ReactorExchanger(CoolingCircuit circuit,Reactor reactor,MainControl mc){
		
		this.circuit=circuit;
		this.reactor=reactor;
		this.mc=mc;
	}
	
	
	public void exchange(){
		
		int result =  (circuit.getWaterelement(circuit.getPointerA()).getTemperature() + reactor.getTemperature()) /2;
		reactor.setTemperature(result);
		circuit.getWaterelement(circuit.getPointerB()).setTemperature(result);
		mc.onReactorTempChange(result);
	}
}
