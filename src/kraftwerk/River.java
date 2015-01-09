package kraftwerk;

public class River extends HasTemperature {

	public River(int temp) {
		super(temp);
		// TODO Auto-generated constructor stub
	}
	
	
	//Fluss hat immer die Temperature 10
	@Override
    public int getTemperature(){
        return 10;
    }
    
	
	// wenn die TEmperatur geändert wird wird diese an die Leitwarte weitergeleitet;
	@Override
    public void setTemperature(int temp){
       //todo
    }

}
