package objeto.noAtravesable.objetoConVida.personaje.aliado;

import java.util.Random;

import game.gfx.Animation;
import game.gfx.ImageLoader;
import logica.Tienda;
import logica.Tile;
import logica.visitor.VisitorAliado;
import objeto.noAtravesable.ObjetoNoAtravesable;

public class Druida extends Aliado{
	//atributos
	protected float velocidadSummon;
	protected float velocidadMaximaSummon;
	protected int relojSummon;
	
	public Druida(Tile t){
		super();
		reloj=0;
		relojSummon=0;
		miTile=t;
		velocidadAt=1.4f;
		velAtMaxima=1.4f;
		velocidadSummon=10f;
		velocidadMaximaSummon=10f;
		t.setComponente(this);
		image=ImageLoader.druida;
		vida=60;
		maxVida=60;
		escudo = 0;
		maxEscudo = (int)(maxVida*0.2);
		ancho=1;
		alto=1;
		impacto=15;
		alcance=3;
		valor=80;
		v=new VisitorAliado(this);
		animation = new Animation(this, t.getFila() * 64,t.getColumna()*64, velocidadAt, ImageLoader.druidAtk);
		animation.setYOffset(128);
	}
	public ObjetoNoAtravesable clone(){
		return new Druida(new Tile(null, 0, 0));
	}
	public void aumentarReloj(){
		reloj=(reloj+1)%(int)(velocidadAt*60);
		relojSummon = (relojSummon+1) % (int)(velocidadSummon*60);
		if(relojSummon == 0){
			Random r = new Random();
			int f = r.nextInt(6);
			int c = r.nextInt(11) + 1;
			Tile ti = miTile.getLogica().getTile(f, c);
			if(ti.getComponente()==null){
				Treant t = new Treant(ti);
				Tienda.getTienda(null).comprar(t);
			}
		}
	}
}
