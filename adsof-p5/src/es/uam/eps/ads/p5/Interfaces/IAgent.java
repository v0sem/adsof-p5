package es.uam.eps.ads.p5.Interfaces;

import java.util.function.Function;
import java.util.function.Predicate;

import es.uam.eps.ads.p5.Classes.Cell;

public interface IAgent extends IBasicAgent{
	void moveTo(Cell destination); // Mover a una celda adyacente
	void exec(); // Ejecutar comportamiento del agente
	IAgent addBehaviour(Predicate<IAgent> trigger, Function<IAgent, Boolean> behaviour);
	IAgent addBehaviour(Function<IAgent, Boolean> behaviour);
	IAgent copy(); // Realiza una copia del agente
}
