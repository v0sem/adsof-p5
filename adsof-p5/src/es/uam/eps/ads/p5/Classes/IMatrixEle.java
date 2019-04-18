package es.uam.eps.ads.p5.Classes;

import es.uam.eps.ads.p5.Interfaces.IMatrixElement;

public class IMatrixEle<T> implements IMatrixElement<T>{

	/**
	 * Position of the element in the rows
	 */
	private int i;
	
	/**
	 * Position of the element in the columns
	 */
	private int j;
	
	/**
	 * Type of element
	 */
	T t;
	
	
	/**
	 * Constructor for generic elements in matrices
	 * 
	 * @param i Position of the element in the rows
	 * @param j Position of the element in the columns
	 * @param type Type of element
	 */
	public IMatrixEle(int i, int j, T type) {
		
		this.i = i;
		this.j = j;
		this.t = type;
		
	}
	
	
	
	@Override
	public int getI() {
		return i;
	}

	@Override
	public int getJ() {
		return j;
	}

	@Override
	public T getElement() {
		// TODO Auto-generated method stub
		return t;
	}

	@Override
	public void setElement(T element) {
		this.t = element;
	}
	
	@Override
	public String toString() {
		return "( Fila: " + this.i + ", Columna: " + this.j + ",Elemento: " + this.t;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this==obj) {
			return true;
		}
		
		return false;
	}


}
