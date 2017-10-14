package objeto.noAtravesable;

import java.awt.Graphics;

import objeto.noAtravesable.objetoConVida.OMConVida.OMConVida;
import objeto.noAtravesable.objetoConVida.OTConVida.OTConVida;
import objeto.noAtravesable.objetoConVida.personaje.Aliado;
import objeto.noAtravesable.objetoConVida.personaje.Enemigo;

public class ObjectStateStatic extends ObjectState {

	public void draw(Graphics g, Enemigo e){}
	public void draw(Graphics g, Aliado a){}
	public void draw(Graphics g, OTConVida otcv){}
	public void draw(Graphics g, OMConVida omcv){}
	public void draw(Graphics g, Premio p){}
}
