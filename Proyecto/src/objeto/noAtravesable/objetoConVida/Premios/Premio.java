package objeto.noAtravesable.objetoConVida.Premios;

import java.awt.Graphics;

import game.display.BotonCompraPremio;
import logica.Tienda;
import logica.Tile;
import logica.visitor.Visitor;
import objeto.noAtravesable.ObjetoNoAtravesable;

public abstract class Premio extends ObjetoNoAtravesable{
	//atributos
	protected BotonCompraPremio b;
	//metodos
	public void eliminar(){
		miTile.setComponente(null);
	}
	public void accept(Visitor v){
		v.afectar(this);
	}
	public void serClickeado(){
		b.sumarPremio();
	}
	
	public void dibujar(Graphics g){
		g.drawImage(image, miTile.getColumna()*64, miTile.getFila()*64 + 128, 64, 64, null);
	}
	
	public void restarVida(int n){}
	
	public abstract void efecto(Tile t);
	
	public void agregar(Tienda tien, Tile t){
		efecto(t);
		b.restarPremio();
		tien.getPanel().setPrototype(null);
	}
}