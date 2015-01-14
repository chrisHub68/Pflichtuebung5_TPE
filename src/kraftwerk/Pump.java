package kraftwerk;
 
 
public class Pump implements Runnable {
 
        // Pumpleistung in Liter pro Sekunde
        private int performance;
        private CoolingCircuit circuit;
        private int waterpumped = 0;
        private int cooeficent;
        private RiverExchanger riExchange;
        private ReactorExchanger reExchange;
        private MainControl mc;
 
        public Pump(int performance, CoolingCircuit coolingcircuit, int cooeficent,RiverExchanger riExchange,ReactorExchanger reExchange,MainControl mc) {
                this.performance = performance;
                this.circuit = coolingcircuit;
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
                                       
                                        waterpumped+=performance;
 
                                        if (waterpumped >= 100) {
                                                circuit.rotate();
                                                exchange();
                                                waterpumped -= 100;
                                        }
                                        
                                        MainControl.LOCK.wait((long)(1000 / cooeficent));
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
       
        private synchronized void exchange(){
                riExchange.exchange();
                reExchange.exchange();
                mc.printTemperature();
        }
 
}
