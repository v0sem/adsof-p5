package es.uam.eps.ads.p5.Classes;

import java.util.ArrayList;
import java.util.List;

import es.uam.eps.ads.p5.Interfaces.IBasicAgent;

public class Cell implements Cloneable{

	private int x;
	private int y;
	private List<IBasicAgent> agents;
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		this.agents = new ArrayList<>();
	}
	
	public List<Cell> neighbours(){
		
		List<Cell> result = new ArrayList<>();
		
		result.add(new Cell(getX()-1, getY()));
		result.add(new Cell(getX()+1, getY()));
		result.add(new Cell(getX(), getY()-1));
		result.add(new Cell(getX(), getY()+1));
		
		return result;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public void add(IBasicAgent ag) {
		agents.add(ag);
	}
	
	public void add(List<IBasicAgent> agents) {
		this.agents.addAll(agents);
	}
	
	public void remove(IBasicAgent ag) {
		agents.remove(ag);
	}

	public List<IBasicAgent> getAgents() {
		return this.agents;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
