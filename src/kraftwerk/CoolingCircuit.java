/**
 * Klasse CoolingCircuit implementiert die Funktionsweise eines Kühlkreislaufs in einem Kernkraftwerk
 */

package kraftwerk;

public class CoolingCircuit {

	// Es gibt insgesamt 12 Wasserelemente im Wasserkreislauf
	private Waterelement[] watercircle = new Waterelement[12];
	private int pointerA;
	private int pointerB;
	
	
	
	//Konstruktor
	public CoolingCircuit(int temperature){
		this.pointerA = 0;
		this.pointerB = 6;
		fill(temperature);
	}
	
	
	/**
	 * erzeuge 12 Wasserelemente
	 * @param temperature
	 */
	private void fill(int temperature){
		for (int i = 0; i < watercircle.length; i++) {
			watercircle[i] = new Waterelement(temperature);
		}
	}
	
	/**
	 * Funktion um die Rotation der WasserElemente im Wasserkeislauf zu steuern
	 */
	public void rotate(){
		 if(this.pointerA == 11){
			 this.pointerA = 0;
		 }else{
			 pointerA++;
		 }
			 
		 if(this.pointerB == 11){
			 this.pointerB = 0;
		 }else{
			 pointerB++;
		 }
	}

	public int getPointerA(){
		return this.pointerA;
	}
	
	
	
	public int getPointerB(){
		return this.pointerB;
	}
	
	public Waterelement getWaterelement(int position){
		return this.watercircle[position];
	}
}
