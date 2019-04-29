package es.uam.eps.ads.p5.Classes;

import java.util.ArrayList;
import java.util.Comparator;
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
	 * Constructor for tables based in HashMaps
	 * 
	 * @param rows maximum number of elements in one row
	 * @param columns maximum number of elements in one column
	 * @param type of element to store in the table
	 */
	public IMatrixDicc(int rows, int columns) {
		this.rows = rows;
		this.cols = columns;
		
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
		if(!this.isLegalPosition(element.getI(), element.getJ()))
			throw new IllegalPositionException();
		
		int key = this.calculateKey(element.getI(), element.getJ());
		
		table.put(key, element);
	}

	@Override
	public IMatrixElement<T> getElementAt(int i, int j) throws IllegalPositionException {
		if(!this.isLegalPosition(i, j))
			throw new IllegalPositionException();
		
		return this.table.get(calculateKey(i, j));
	}

	@Override
	public List<IMatrixElement<T>> getNeighboursAt(int i, int j) throws IllegalPositionException {
		if(!this.isLegalPosition(i, j))
			throw new IllegalPositionException();
		
		List<IMatrixElement<T>> neighbours = new ArrayList<IMatrixElement<T>>();
		
		int key = calculateKey(i - 1, j); 	//west neighbor
		if(isLegalPosition(i - 1, j) && table.get(key) != null)
			neighbours.add(table.get(key));
		
		key = calculateKey(i + 1, j); 		//east neighbor
		if(isLegalPosition(i + 1, j) && table.get(key) != null)
			neighbours.add(table.get(key));

		key = calculateKey(i, j - 1); 		//north neighbor
		if(isLegalPosition(i, j - 1) && table.get(key) != null)
			neighbours.add(table.get(key));
		
		key = calculateKey(i, j + 1); 		//south neighbor
		if(isLegalPosition(i, j + 1) && table.get(key) != null)
			neighbours.add(table.get(key));
		
		return neighbours;
	}

	@Override
	public List<IMatrixElement<T>> asList() {
		List<IMatrixElement<T>> list = new ArrayList<IMatrixElement<T>>();
		
		for(int key : table.keySet()) {
			list.add(table.get(key));
		}
		
		return null;
	}
	
	public boolean equals(IMatrixDicc<T> matrix) {
		
		if(matrix == null)
			return false;
		
		List<IMatrixElement<T>> listA = this.asList();
		List<IMatrixElement<T>> listB = this.asList();
		
		return listA.equals(listB);
	}
	
	/**
	 * Calculates the key in the map given coordinates
	 * 
	 * @param i row number
	 * @param j column number
	 * 
	 * @return key(i, j)
	 */
	private Integer calculateKey(int i, int j){
		return getRows() * i + j; 
	}

	@Override
	public List<IMatrixElement<T>> asListSortedBy(Comparator<IMatrixElement<T>> c) {
		if(c == null)
			return null;
		
		List<IMatrixElement<T>> list = this.asList(); 
		for (int i = 0; i < list.size() - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < list.size(); j++)
                if (c.compare(list.get(j), list.get(index)) == 1) 
                    index = j;
      
            IMatrixElement<T> smaller = list.get(index);  
            list.add(index, list.get(i));
            list.add(i, smaller);
        }
		
		return list;
	}

}
