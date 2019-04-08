package es.uam.eps.ads.p5.Exception;

public class IllegalPositionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 201788579680194281L;

	public IllegalPositionException() {
	}
	
	@Override
	public String toString() {
		return "Out of bounds element";
	}
}
