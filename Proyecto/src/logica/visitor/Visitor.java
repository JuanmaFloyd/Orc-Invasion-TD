package logica.visitor;

import objeto.noAtravesable.objetoConVida.OMConVida.*;
import objeto.noAtravesable.objetoConVida.Premios.Premio;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;

public abstract class Visitor {
	public abstract void afectar(Aliado a);
	public abstract void afectar(Enemigo e);
	public abstract void afectar(OMConVida omcv);
	public abstract void afectar(Premio p);
}
