package es.uam.eps.ads.p5.Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import es.uam.eps.ads.p5.Interfaces.IAgent;
import es.uam.eps.ads.p5.Interfaces.IAgentState;
import es.uam.eps.ads.p5.Interfaces.IAgentWithState;

public class AgentWithState extends Agent implements IAgentWithState {

	private IAgentState state;
	
	private List<IAgentState> states;
	
	private List<String> names;
	
	public AgentWithState(String type, String ...states) {
		super(type);
		this.states = new ArrayList<>();
		this.names = new ArrayList<>();
		
		for(String s : states) {
			this.states.add(new AgentState(this, s));
			this.names.add(s);
		}
		
		this.states.get(0);
	}

	@Override
	public IAgentState state(String name) {
		for(IAgentState as : states) {
			if(as.name().equals(name)) {
				state = as;
				return as;	
			}
		}
		
		return null;
	}

	@Override
	public IAgentWithState addBehaviour(String state, Predicate<IAgent> trigger, Function<IAgent, Boolean> behaviour) {
		state(state).addBehaviour(trigger, behaviour);
		return this;
	}

	@Override
	public IAgentWithState addBehaviour(String state, Function<IAgent, Boolean> behaviour) {
		state(state).addBehaviour(behaviour);
		return this;
	}
	
	public IAgent copy() {
		String[] names = {};
		names = this.names.toArray(names);
		
		AgentWithState newAgent = new AgentWithState(type, names);
		
		try {
			newAgent.position = (Cell) this.position.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		newAgent.state = state;
		newAgent.states = newAgent.states;
		newAgent.fun = this.fun;
		newAgent.trigg = this.trigg;
		
		return newAgent;
	}
	
	public void exec() {
		state.changeState();
		
		state.exec();
	}

}
