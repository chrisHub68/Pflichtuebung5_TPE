package kraftwerk;

public class Reactor extends HasTemperature implements Runnable {

	int cooeficent =0;
	MainControl mc;

	public Reactor(int temp , int cooeficent ,MainControl mc) {
		super(temp);
		this.cooeficent =cooeficent;
		this.mc=mc;
	}



	
	
	
	@Override
	public void run() {
		{
			
			while (!Thread.currentThread().isInterrupted()) {
			synchronized (MainControl.LOCK) {

				try {
						this.setTemperature(getTemperature()+1);
					

					MainControl.LOCK.wait(1000 / cooeficent);
				
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}

			}
		}
		}
		
		
		}
    
	}
	







