package es.uam.eps.ads.p5.Main;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import es.uam.eps.ads.p5.Classes.Agent;
import es.uam.eps.ads.p5.Classes.Cell;
import es.uam.eps.ads.p5.Classes.Simulator;

public class MainAgentSimulator {
	
	public static void main(String[] args) {
		Simulator s = new Simulator(10,10);
		Agent random = new Agent("random");
		Agent outer = new Agent("outer");
		
		random.addBehaviour( agent -> { // se ejecuta siempre, movemos el agente a una casilla aleatoria vecina
										List<Cell> neighbours = agent.cell().neighbours();
										Cell destination = neighbours.get(new Random().nextInt(neighbours.size()));
										agent.moveTo(destination);
										return true;
									});
		
		outer.addBehaviour( agent ->  agent.cell().getAgents().size()>5, // Lo ejecutamos si hay más de 5 agentes
																		  // en la celda actual
							agent -> { // nos movemos a la celda destino con menos agentes
										List<Cell> neighbours = agent.cell().neighbours();
										Integer minAgents = neighbours.stream().
															mapToInt( c -> c.getAgents().size() ).
															min( ).
															getAsInt();
										List<Cell> destinations = neighbours.stream().
																	filter( c -> c.getAgents().size() == minAgents ).
																	collect(Collectors.toList());
										Cell destination = destinations.get(new Random().nextInt(destinations.size()));
										agent.moveTo(destination);
										return true;
									});
		
		s.create(random, 100, 5, 5); // Crear 100 agentes random
		s.create(outer, 100, 7, 7); // Crear 100 agentes "outer"
		s.run(60); // Ejecutar 60 pasos de simulacion

	}
	
}
