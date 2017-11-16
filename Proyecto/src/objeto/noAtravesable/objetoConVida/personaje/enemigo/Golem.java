package objeto.noAtravesable.objetoConVida.personaje.enemigo;

import game.gfx.AnimationEnemy;
import game.gfx.ImageLoader;
import logica.Objeto;
import logica.Tile;
import logica.visitor.VisitorEnemigo;
import objeto.noAtravesable.ObjectStateMoving;
import objeto.noAtravesable.objetoConVida.Premios.Bomba;

public class Golem extends Enemigo{
	public Golem(){
		super();
		vida=90;
		maxVida=90;
		velocidadMov=3.0f;
		velocidadAt=2.0f;
		animation = new AnimationEnemy(this, 0 , 0, velocidadAt, velocidadMov ,ImageLoader.golemAtk, ImageLoader.golemMov);
		animation.setYOffset(128);
		image = ImageLoader.golem;
		ancho=1;
		alto=1;
		impacto=50;
		alcance=1;
		velMovMaxima=3.0f;
		velAtMaxima=2.0f;
		puntaje=35;
		coins=350;
		reloj=1;
		v = new VisitorEnemigo(this);
		setState(new ObjectStateMoving());
		premio = new Bomba();
		
	}
	@Override
	public Objeto clone() {
		return new Golem();
	}

}
