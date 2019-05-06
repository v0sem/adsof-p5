package es.uam.eps.ads.p5.Classes;

import java.util.ArrayList;
import java.util.List;

import es.uam.eps.ads.p5.Exception.IllegalPositionException;
import es.uam.eps.ads.p5.Interfaces.IBasicAgent;
import es.uam.eps.ads.p5.Interfaces.IMatrix;
import es.uam.eps.ads.p5.Interfaces.IMatrixElement;

public class Simulator {
	
	IMatrix<Cell> table;
	
	public Simulator(int rows, int columns) {
		this.table = new IMatrixDicc<>(rows, columns);
	}
	
	public void create(IBasicAgent agent, int agentNum, int x, int y) {
		List<IBasicAgent> agents = new ArrayList<>();
		
		agents.add(0, agent);
		
		Cell cell = new Cell(x, y);
		
		((Agent) agents.get(0)).setPos(cell);
		
		for(int i = 1; i < agentNum; i++) {
			agents.add(i, agent.copy());
		}
		
		agents.remove(0);
		
		cell.add(agents);
		
		IMatrixElement<Cell> element = new IMatrixEle<Cell>(x, y, cell); 
		
		try {
			table.addElement(element);
		} catch (IllegalPositionException e) {
			e.printStackTrace();
		}
	}
	
	public void run(int times) {
		for(int t = 0; t < times; t++) {
			printMatrix(t);
			exec();
		}
	}
	
	private void exec() {
		List<IMatrixElement<Cell>> map = table.asList();
		Cell c, origin;
		List<IBasicAgent> agents;
		IMatrixElement<Cell> elementOrigin = null;
		
		for(IMatrixElement<Cell> t : map) {
			agents = new ArrayList<>(t.getElement().getAgents());
			for(IBasicAgent agent : agents) {
				origin = agent.cell();
				try {
					elementOrigin = table.getElementAt(origin.getX(), origin.getY());
				} catch (IllegalPositionException e) {
					e.printStackTrace();
				}
				((Agent) agent).exec();
				c = agent.cell();
				IMatrixElement<Cell> element;
				try {
					element = table.getElementAt(c.getX(), c.getY());
					
					if(element == null) {
						element = new IMatrixEle<Cell>(c.getX(), c.getY(), c);
						table.addElement(element);
					}
					else if(element.getElement() != c){
						((Agent) agent).moveTo(element.getElement());
					}
				} catch (IllegalPositionException e1) {
					((Agent) agent).moveTo(elementOrigin.getElement());
				}
			}
		}
	}
	
	private void printMatrix(int t) {
		IMatrixElement<Cell> value = null;
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Time = " + t);
		
		for(int i = 0; i < table.getRows(); i++) {
			for(int j = 0; j < table.getCols(); j++) {
				try {
					value = table.getElementAt(i, j);
				} catch (IllegalPositionException e) {
					e.printStackTrace();
				}
				
				if(value == null) 
					System.out.print("  0| ");
				else {
					int size = value.getElement().getAgents().size();
					if(size > 99)
						System.out.print(size + "| ");
					else if(size > 9)
						System.out.print(" " + size + "| ");
					else
						System.out.print("  " + size + "| ");
				}
					
			}
			
			System.out.println();
		}
	}
}
