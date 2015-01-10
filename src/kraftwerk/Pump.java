package kraftwerk;

import sun.applet.Main;

public class Pump implements Runnable {

	// Pumpleistung in Liter pro Sekunde
	private int performance = 0;
	private CoolingCircuit a;
	private int waterpumped = 0;
	private int cooeficent = 0;
	RiverExchanger riExchange;
	ReactorExchanger reExchange;
	MainControl mc;

	public Pump(int performance, CoolingCircuit coolingcircuit, int cooeficent,RiverExchanger riExchange,ReactorExchanger reExchange,MainControl mc) {
		this.performance = performance;
		this.a = coolingcircuit;
		this.cooeficent = cooeficent;
		this.riExchange=riExchange;
		this.reExchange=reExchange;
		this.mc=mc;
	}

	@Override
	public void run() {

		while (!Thread.currentThread().isInterrupted()) {

			synchronized (MainControl.LOCK) {

				try {

					for (int i = 0; i < performance; i++) {
						waterpumped++;
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

	}

	public int getPerformance() {
		return this.performance;
	}

	public void setPerformance(int performance) {
		this.performance = performance;
	}
	
	private void exchange(){
		riExchange.exchange();
		reExchange.exchange();
		mc.printTemperature();
	}

}
