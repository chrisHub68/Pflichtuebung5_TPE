package kraftwerk;

public class ReactorTemp extends HasTemperature {

	private MainControl mc;


	public ReactorTemp(int temp,MainControl mc) {
		super(temp);
		this.mc = mc;
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
    public int getTemperature(){
        return 10;
    }
    
	
	// wenn die TEmperatur ge�ndert wird wird diese an die Leitwarte weitergeleitet;
	@Override
    public void setTemperature(int temp){
       mc.onReactorTempChange(temp);
    }
}
