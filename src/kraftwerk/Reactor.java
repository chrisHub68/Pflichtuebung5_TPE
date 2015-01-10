package kraftwerk;

public class Reactor extends HasTemperature implements Runnable {



	public Reactor(int temp , int cooeficent) {
		super(temp);
	}



	
	
	
	@Override
	public void run() {
		{
			/*
			synchronized (MainControl.LOCK) {

				try {

					for (int i = 0; i < performance; i++) {
						getTemperature()++;
					}

					MainControl.LOCK.wait(1000 / cooeficent);

					if (waterpumped >= 100) {
						a.rotate();
						exchange();
						waterpumped -= 100;
					}
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}

			}
		}
		
		*/
		}
	}
	
}






