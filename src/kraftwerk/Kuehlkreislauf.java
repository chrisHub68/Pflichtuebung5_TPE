package kraftwerk;

public class Kuehlkreislauf {

	
	private int[] watercircle = new int[12];
	int pointerA;
	int pointerB;
	
	//Konstruktor
	public Kuehlkreislauf(){
		this.pointerA = 0;
		this.pointerB = 6;
		fill();
	}
	
	
	
	private void fill(){
		for (int i = 0; i < watercircle.length; i++) {
			watercircle[i]=10;
		}
	}
	
	

	
}
