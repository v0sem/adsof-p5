package es.uam.eps.ads.p5.Interfaces;

public interface IMatrixElement<T> {
	public int getI();
	public int getJ();
	public T getElement();
	public void setElement(T element);
	public String toString();
	public boolean equals(Object obj);
}
