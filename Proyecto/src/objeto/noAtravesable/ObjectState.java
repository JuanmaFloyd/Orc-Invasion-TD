package objeto.noAtravesable;

import java.awt.Graphics;

import logica.Objeto;
import objeto.noAtravesable.objetoConVida.OMConVida.OMConVida;
import objeto.noAtravesable.objetoConVida.Premios.Premio;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;

public abstract class ObjectState {
	
	protected Object myObject;
	
	public abstract void draw(Graphics g, Enemigo e);
	public abstract void draw(Graphics g, Aliado a);
	public abstract void draw(Graphics g, OMConVida omcv);
	public abstract void draw(Graphics g, Premio p);
	public void setObject(Objeto o){
		myObject = o;
	}
	
}
