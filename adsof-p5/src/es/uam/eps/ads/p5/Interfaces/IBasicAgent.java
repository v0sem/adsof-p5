package es.uam.eps.ads.p5.Interfaces;

import es.uam.eps.ads.p5.Classes.Cell;

public interface IBasicAgent {
	Cell cell();
	IBasicAgent copy();
	void setPos(Cell cell);
}
