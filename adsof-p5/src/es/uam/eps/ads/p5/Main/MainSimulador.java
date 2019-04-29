package es.uam.eps.ads.p5.Main;

import es.uam.eps.ads.p5.Interfaces.IBasicAgent;
import es.uam.eps.ads.p5.Classes.BasicAgent;
import es.uam.eps.ads.p5.Classes.BasicSimulator;

public class MainSimulador {
	
	public static void main(String[] args) {
		BasicSimulator s = new BasicSimulator(10,10);
		IBasicAgent random = new BasicAgent("random");
		IBasicAgent outer = new BasicAgent("outer");
		
		s.create(random, 10, 5, 5);
		s.create(outer, 10, 7, 7);
		s.run(2);
	}
}
