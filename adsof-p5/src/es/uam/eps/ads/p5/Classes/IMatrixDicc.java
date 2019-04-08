package es.uam.eps.ads.p5.Classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uam.eps.ads.p5.Exception.IllegalPositionException;
import es.uam.eps.ads.p5.Interfaces.IMatrix;
import es.uam.eps.ads.p5.Interfaces.IMatrixElement;

public class IMatrixDicc<T> implements IMatrix<T> {
	
	/**
	 * Map with: 
	 * 		Key = relative position in the array
	 * 		Value = Element stored
	 */
	private Map<Integer, IMatrixElement<T>> table;
	
	/**
	 * Number of rows
	 */
	int rows;
	
	/**
	 * Number of columns
	 */
	int cols;
	
	/**
	 * Type of element to store
	 */
	T t;
	
	public IMatrixDicc(int rows, int columns, T type) {
		// TODO Auto-generated constructor stub
		this.rows = rows;
		this.cols = columns;
		this.t = type;
		
		this.table = new HashMap<Integer, IMatrixElement<T>>();
	}
	
	@Override
	public int getCols() {
		return cols;
	}

	@Override
	public int getRows() {
		return rows;
	}

	@Override
	public boolean isLegalPosition(int i, int j) {
		return !(i >= rows || j >= cols);
	}

	@Override
	public void addElement(IMatrixElement<T> element) throws IllegalPositionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IMatrixElement<T> getElementAt(int i, int j) throws IllegalPositionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IMatrixElement<T>> getNeighboursAt(int i, int j) throws IllegalPositionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IMatrixElement<T>> asList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Integer calculateKey(int i, int j){
		return getRows() * i + j; 
	}

}
