package es.uam.eps.ads.p5.Classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;

import es.uam.eps.ads.p5.Interfaces.IAgent;
import es.uam.eps.ads.p5.Interfaces.IAgentState;
import es.uam.eps.ads.p5.Interfaces.IAgentWithState;

public class AgentState implements IAgentState {

	private String name;
	
	private IAgentWithState owner;
	
	private Function<IAgent, Boolean> fun;
	
	private Predicate<IAgent> trigg;
	
	private Map<String, Predicate<IAgent>> changes;
	
	public AgentState(IAgentWithState owner, String name) {
		this.owner = owner;
		this.name = name;
		this.changes = new HashMap<>();
	}
	
	@Override
	public String name() {
		return name;
	}

	@Override
	public void toState(String target, Predicate<IAgent> trigger) {
		changes.put(target, trigger);
	}

	@Override
	public IAgentState changeState() {
		for(Entry<String, Predicate<IAgent>> pred : changes.entrySet()) {
			if(pred != null) {
				if(pred.getValue().test(owner))
					return owner.state(pred.getKey());
			}
		}
		return null;
	}

	@Override
	public IAgentWithState addBehaviour(Predicate<IAgent> trigger, Function<IAgent, Boolean> behaviour) {
		if(trigger == null || behaviour == null)
			return null;
		
		this.trigg = trigger;
		this.fun = behaviour;
		
		return owner;
	}

	@Override
	public IAgentWithState addBehaviour(Function<IAgent, Boolean> behaviour) {
		if(behaviour == null)
			return null;
		
		this.fun = behaviour;
		
		return owner;
	}

	@Override
	public void exec() {
		
		if(fun == null)
			return;
		
		if(trigg == null) {
			this.fun.apply(owner);
			return;
		}
		if(trigg.test(owner))
			this.fun.apply(owner);
	}

	@Override
	public void setOwner(IAgentWithState aws) {
		// TODO Auto-generated method stub

	}

	@Override
	public IAgentState copy() {
		AgentState newAgent = new AgentState(owner, name);

		newAgent.fun = this.fun;
		newAgent.trigg = this.trigg;
		newAgent.changes = this.changes;
		
		return newAgent;
	}

}
