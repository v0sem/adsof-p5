package es.uam.eps.ads.p5.Classes;

import es.uam.eps.ads.p5.Interfaces.IBasicAgent;

public class BasicAgent implements IBasicAgent {

	private Cell cell;
	
	private String type;
	
	public BasicAgent(String type) {
		this.type = type;
	}
	
	public void setPos(Cell cell) {
		this.cell = cell;
	}
	
	@Override
	public Cell cell() {
		return cell;
	}

	@Override
	public IBasicAgent copy() {
		BasicAgent newAgent = new BasicAgent(type);
		try {
			newAgent.cell = (Cell) this.cell.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newAgent;
	}

}
