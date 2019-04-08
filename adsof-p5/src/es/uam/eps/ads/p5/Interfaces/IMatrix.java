package es.uam.eps.ads.p5.Interfaces;

import java.util.List;

import es.uam.eps.ads.p5.Exception.IllegalPositionException;

public interface IMatrix<T> {
	int getCols();
	int getRows();
	boolean isLegalPosition(int i, int j);
	void addElement(IMatrixElement<T> element) throws IllegalPositionException;
	IMatrixElement<T> getElementAt(int i, int j) throws IllegalPositionException;
	List<IMatrixElement<T>> getNeighboursAt(int i, int j) throws IllegalPositionException;
	List<IMatrixElement<T>> asList();
}
