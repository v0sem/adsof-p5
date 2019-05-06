package es.uam.eps.ads.p5.Classes;

import es.uam.eps.ads.p5.Exception.IllegalPositionException;
import es.uam.eps.ads.p5.Interfaces.IBasicAgent;
import es.uam.eps.ads.p5.Interfaces.IMatrix;
import es.uam.eps.ads.p5.Interfaces.IMatrixElement;

public class BasicSimulator {

	IMatrix<Integer> table;
	
	public BasicSimulator(int rows, int columns) {
		table = new IMatrixDicc<Integer>(rows, columns);
	}
	
	public void create(IBasicAgent agent, int agentNum, int x, int y){
		
		IBasicAgent[] agents = new BasicAgent [agentNum];
		
		agents[0] = agent;
		
		((BasicAgent) agents[0]).setPos(new Cell(x, y));
		
		for(int i = 1; i < agentNum; i++) {
			agents[i] = agent.copy();
		}
		
		IMatrixElement<Integer> element = new IMatrixEle<Integer>(x, y, agentNum); 
		
		try {
			table.addElement(element);
		} catch (IllegalPositionException e) {
			e.printStackTrace();
		}
	}
	
	public void run(int times) {
		for(int t = 0; t < times; t++) {
			printMatrix(t);
		}
	}
	
	private void printMatrix(int t) {
		IMatrixElement<Integer> value = null;
		
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
					System.out.print(" 0| ");
				else
					System.out.print(value.getElement() + "| ");
			}
			
			System.out.println();
		}
	}

}
