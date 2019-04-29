package es.uam.eps.ads.p5.JUnits;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import es.uam.eps.ads.p5.Classes.*;
import es.uam.eps.ads.p5.Exception.IllegalPositionException;
import es.uam.eps.ads.p5.Interfaces.IMatrixElement;


/**
 * Esta clase testea las funciones la clase IMatrixDicc 
 * 
 * @author Juan Martin 
 *
 */
public class IMatrixTest {
	
	
	@Test
	public void testStringMatriz() throws IllegalPositionException{
		
		String temp = "Cadena de ejemplo";
		IMatrixDicc<String> matriz = new IMatrixDicc<String>(4, 8);
		
		//Testeamos getCols()
		assertEquals(8, matriz.getCols());
		
		//Testeamos getRows()
		assertEquals(4, matriz.getRows());
		
		//Testeamos isLegalPosition()
		assertTrue(matriz.isLegalPosition(2, 4));
		assertFalse(matriz.isLegalPosition(7, 9));
		
		IMatrixEle<String> elemento = new IMatrixEle<String>(2, 5, temp);
		
		//Testeamos getElementAt()
		matriz.addElement(elemento);
		assertSame(elemento, matriz.getElementAt(2, 5));
		
		//Testeamos getNeighboursAt()
		IMatrixEle<String> elemento2 = new IMatrixEle<String>(2, 6, temp);
		matriz.addElement(elemento2);
		List<IMatrixElement<String>> neighbours = new ArrayList<IMatrixElement<String>>();
		neighbours.add(elemento2);
		assertEquals(neighbours, matriz.getNeighboursAt(2, 5));
		
		//Testeamos asList()
		List<IMatrixElement<String>> allEles = new ArrayList<IMatrixElement<String>>();
		allEles.add(elemento);
		allEles.add(elemento2);
		assertThat(allEles, is(matriz.asList()));

		
	}
	
	@Test
	public void testIntMatriz() throws IllegalPositionException{
		
		Integer temp = 3;
		IMatrixDicc<Integer> matriz = new IMatrixDicc<Integer>(6, 7);
		
		//Testeamos getCols()
		assertEquals(7, matriz.getCols());
		
		//Testeamos getRows()
		assertEquals(6, matriz.getRows());
		
		//Testeamos isLegalPosition()
		assertTrue(matriz.isLegalPosition(3, 4));
		assertFalse(matriz.isLegalPosition(7, 9));
		
		IMatrixEle<Integer> elemento = new IMatrixEle<Integer>(2, 5, temp);
		
		//Testeamos getElementAt()
		matriz.addElement(elemento);
		assertSame(elemento, matriz.getElementAt(2, 5));
		
		//Testeamos getNeighboursAt()
		IMatrixEle<Integer> elemento2 = new IMatrixEle<Integer>(2, 6, temp);
		matriz.addElement(elemento2);
		List<IMatrixElement<Integer>> neighbours = new ArrayList<IMatrixElement<Integer>>();
		neighbours.add(elemento2);
		assertEquals(neighbours, matriz.getNeighboursAt(2, 5));
		
		//Testeamos asList()
		List<IMatrixElement<Integer>> allEles = new ArrayList<IMatrixElement<Integer>>();
		allEles.add(elemento);
		allEles.add(elemento2);
		//assertEquals(allEles, matriz.asList());

		
	}


	@Test
	public void testIMatrixEle() {
		
		String temp = "Cadena de ejemplo";
		String temp2 = "Tras setElement()";
		IMatrixEle<String> elemento = new IMatrixEle<String>(2, 5, temp);
		IMatrixEle<String> elemento2 = new IMatrixEle<String>(3, 1, temp);
		
		//Testeamos getI() y getJ()
		assertEquals(2, elemento.getI());
		assertEquals(5, elemento.getJ());
		
		//Testeamos getElement()
		assertEquals("Cadena de ejemplo", elemento.getElement());
		
		//Testeamos setElemento()
		elemento.setElement(temp2);
		assertEquals("Tras setElement()", elemento.getElement());
		
		System.out.println(elemento);
		
		//Testeamos equals()
		assertFalse(elemento.equals(elemento2));
		assertTrue(elemento.equals(elemento));
		
	}
	
	



}
