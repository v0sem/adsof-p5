package es.uam.eps.ads.p5.Main;

import java.util.List;
import java.util.Random;

import es.uam.eps.ads.p5.Classes.AgentWithState;
import es.uam.eps.ads.p5.Classes.Cell;
import es.uam.eps.ads.p5.Classes.Simulator;

public class MainAgentWithStateSimulator {

	public static void main(String[] args) {
		AgentWithState outer = new AgentWithState("outer", "idle", "active"); // dos estados: idle y active
		
		outer.state("idle").toState("active", agent -> agent.cell().getAgents().size()>5);
		outer.state("active").toState("idle", agent -> agent.cell().getAgents().size()<=5);
		
		outer.state("active").addBehaviour(
											agent -> {
												List<Cell> neighbours = agent.cell().neighbours();
												Cell destination = neighbours.get(new Random().nextInt(neighbours.size()));
												agent.moveTo(destination);
												return true;
											});
		
		Simulator sim = new Simulator(10, 10);

		sim.create(outer, 10, 4, 4);
		
		sim.run(5);
	}
}
