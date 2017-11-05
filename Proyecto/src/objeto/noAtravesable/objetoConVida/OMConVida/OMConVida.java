package objeto.noAtravesable.objetoConVida.OMConVida;

import java.awt.Graphics;

import game.gfx.ImageLoader;
import logica.visitor.Visitor;
import objeto.noAtravesable.objetoConVida.*;

public abstract class OMConVida extends ObjetoConVida {
	public void accept(Visitor v){
		v.afectar(this);
	}
	public void restarVida(int v){
		vida-=v;
		if(vida<=0){
			miTile.destruirObjeto(this);
			miTile = null;
		}
	}
	
	public void dibujar(Graphics g){
		int c = getTile().getColumna() * 64;
		int f = getTile().getFila() * 64; 
		g.drawImage(image, c, f + 128, 64, 64, null);
		//image.draw(g);
		g.drawImage(ImageLoader.vida[1], c, f, 40, 4, null);
		g.drawImage(ImageLoader.vida[0], c, f, (40*getVida())/getMaxVida(), 4, null);
	}
}
