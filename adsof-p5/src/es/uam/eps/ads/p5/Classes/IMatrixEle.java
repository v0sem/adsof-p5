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
	 * Element
	 */
	private T element;
	
	
	/**
	 * Constructor for generic elements in matrices
	 * 
	 * @param i Position of the element in the rows
	 * @param j Position of the element in the columns
	 * @param type Type of element
	 */
	public IMatrixEle(int i, int j, T element) {
		
		this.i = i;
		this.j = j;
		this.element = element;
		
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
		return element;
	}

	@Override
	public void setElement(T element) {
		this.element = element;
	}
	
	@Override
	public String toString() {
		return "( Fila: " + this.i + ", Columna: " + this.j + ", Elemento: " + this.element;
	}
	
	public boolean equals(IMatrixEle<T> obj) {
		
		if(obj == null)
			return false;
		
		if(this.i == obj.i && this.j == obj.j && this.element == obj.element) 
			return true;
		
		return false;
	}


}
