package kraftwerk;
/**
 * Die Klasse River implementiert den Fluss Rhein mit seiner Temperatur
 *
 */
public class River extends HasTemperature {

	private MainControl mc;


	public River(int temp,MainControl mc) {
		super(temp);
		this.mc = mc;
		// TODO Auto-generated constructor stub
	}
	
	
	//Fluss hat immer die Temperature 10
	@Override
    public int getTemperature(){
        return 10;
    }
    
	
	// wenn die TEmperatur ge�ndert wird wird diese an die Leitwarte weitergeleitet;
	@Override
    public void setTemperature(int temp){
       mc.onRiverTempChange(temp);
    }

}
