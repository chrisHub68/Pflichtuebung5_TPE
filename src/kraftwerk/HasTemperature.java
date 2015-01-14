/**
 * Klasse HasTemperature dient dazu allen Elementen die mit Temperaturen arbeiten eine Temperatur erben zu lassen
 */

package kraftwerk;

public abstract class HasTemperature {
    
	// Temperatur eines Elementes im Kernkraftwerk
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