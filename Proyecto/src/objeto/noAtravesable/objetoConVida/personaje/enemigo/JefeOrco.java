package objeto.noAtravesable.objetoConVida.personaje.enemigo;

import game.gfx.AnimationEnemy;
import game.gfx.ImageLoader;
import logica.Tile;
import logica.visitor.VisitorEnemigo;
import objeto.noAtravesable.ObjectStateMoving;
import objeto.noAtravesable.ObjetoNoAtravesable;
import objeto.noAtravesable.objetoConVida.Premios.Frenzy;
import objeto.noAtravesable.objetoConVida.Premios.VisitorWololo;

public class JefeOrco extends Enemigo{
	//atributos
	protected Tile segundo;
	
	public JefeOrco(){
		super();
		vida=100;
		maxVida=100;
		velocidadAt=1.8f;
		velocidadMov=1.4f;
		animation = new AnimationEnemy(this, 0, 0, velocidadAt, velocidadMov, ImageLoader.jefeOrcoMov, ImageLoader.jefeOrcoMov);
		animation.setYOffset(128);
		image = ImageLoader.jefeOrco;
		ancho=2;
		alto=1;
		impacto=50;
		alcance=1;
		velMovMaxima=1.4f;
		velAtMaxima=1.8f;
		puntaje=20;
		coins=25;
		reloj=1;
		v=new VisitorEnemigo(this);
		state=new ObjectStateMoving();
		premio = new Frenzy();
	}
	public void avanzar(){
		super.avanzar();
		if (miTile.getColumna()>=1){
			if(segundo!=null)
				segundo.setComponente(null);
			segundo = miTile.getLeft();
			segundo.setComponente(this);
		}
	}
	public ObjetoNoAtravesable clone() {
		return new JefeOrco();
	}
	public void accept(VisitorWololo vw, Tile t){
		vw.visit(this, t);
	}
	public void restarVida(int v){
		vida-=v;
		if(vida<=0){ 
			miTile.destruirEnemigo(this);
			miTile = null;
			segundo.setComponente(null);
			segundo=null;
		}
	}

}
