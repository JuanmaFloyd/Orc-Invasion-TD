package objeto.noAtravesable;

import java.awt.Graphics;

import objeto.noAtravesable.objetoConVida.OMConVida.OMConVida;
import objeto.noAtravesable.objetoConVida.Premios.Premio;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;

public class ObjectStateStatic extends ObjectState {
	
	
	public void draw(Graphics g, Enemigo e){}
	public void draw(Graphics g, Aliado a){ g.drawImage(a.getImage(), a.getTile().getColumna() * 64, a.getTile().getFila() *64, a.getAncho()*64, a.getAlto()*64,null );}
	public void draw(Graphics g, OMConVida omcv){}
	public void draw(Graphics g, Premio p){}
}
