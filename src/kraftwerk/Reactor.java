package kraftwerk;
/**
 * Implementierung eines Reaktors in einem Kernkraftwerk
 *
 */
public class Reactor extends HasTemperature implements Runnable {

	private int cooeficent =0;
	private MainControl mc;

	public Reactor(int temp , int cooeficent ,MainControl mc) {
		super(temp);
		this.cooeficent =cooeficent;
		this.mc=mc;
	}


	@Override
	public void run() {
		
			
			while (!Thread.currentThread().isInterrupted()) {
				
			synchronized (MainControl.LOCK) {

				try {
						this.setTemperature(getTemperature()+1);
						mc.onReactorTempChange(getTemperature());

					MainControl.LOCK.wait((long) (1000 / cooeficent));
				
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}

			}
		}
		
		
		
		}
    
	}
	







