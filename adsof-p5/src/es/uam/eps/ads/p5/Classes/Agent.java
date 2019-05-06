package es.uam.eps.ads.p5.Classes;

import java.util.function.Function;
import java.util.function.Predicate;

import es.uam.eps.ads.p5.Interfaces.IAgent;

public class Agent implements IAgent {

	Cell position;
	
	String type;
	
	Function<IAgent, Boolean> fun;
	
	Predicate<IAgent> trigg;
		
	public Agent(String type) {
		this.type = type;
	}
	
	@Override
	public Cell cell() {
		return this.position;
	}

	@Override
	public void setPos(Cell cell) {
		cell.add(this);
		this.position = cell;
	}
	
	@Override
	public void moveTo(Cell destination) {
		this.position.remove(this);
		this.position = destination;
		destination.add(this);
	}

	@Override
	public void exec() {
		if(fun == null)
			return;
		
		if(trigg == null) {
			this.fun.apply(this);
			return;
		}
		if(trigg.test(this))
			this.fun.apply(this);
	}

	@Override
	public IAgent addBehaviour(Predicate<IAgent> trigger, Function<IAgent, Boolean> behaviour) {
		
		if(trigger == null || behaviour == null)
			return null;
		
		this.trigg = trigger;
		this.fun = behaviour;
		
		return this;
	}

	@Override
	public IAgent addBehaviour(Function<IAgent, Boolean> behaviour) {
		if(behaviour == null)
			return null;
		
		this.fun = behaviour;
		
		return this;
	}

	@Override
	public IAgent copy() {
		Agent newAgent = new Agent(type);
		try {
			newAgent.position = (Cell) this.position.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		newAgent.fun = this.fun;
		newAgent.trigg = this.trigg;
		
		return newAgent;
	}

}
