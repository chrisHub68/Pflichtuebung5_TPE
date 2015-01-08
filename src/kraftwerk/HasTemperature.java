package kraftwerk;

public abstract class HasTemperature {
    
    private volatile int temperature;
    
    public HasTemperature(int temp){
        temperature = temp;
    }
    
    public int getTemperature(){
        return temperature;
    }
    
    public void setTemperature(int temp){
        this.temperature = temp;
    }

}