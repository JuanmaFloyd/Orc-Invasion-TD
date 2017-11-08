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
		g.drawImage(image, c, f + 128 - (image.getHeight() - 64), image.getWidth(), image.getHeight(), null);
		g.drawImage(ImageLoader.vida[1], c, f + 128, 40, 4, null);
		g.drawImage(ImageLoader.vida[0], c, f + 128, (40*getVida())/getMaxVida(), 4, null);
	}
}
