package objeto.noAtravesable.objetoConVida.personaje.enemigo;

import game.gfx.AnimationEnemy;
import game.gfx.ImageLoader;
import logica.visitor.VisitorEnemigo;
import objeto.noAtravesable.ObjectStateMoving;
import objeto.noAtravesable.ObjetoNoAtravesable;
import objeto.noAtravesable.objetoConVida.Premios.Escudo;
import objeto.noAtravesable.objetoConVida.Premios.VisitorWololo;
import logica.*;

public class Grunt extends Enemigo{
	public Grunt(Tile t){
		super();
		vida=45;
		maxVida=45;
		miTile=t;
		velocidadMov = 2.0f;
		velocidadAt=0.7f;
		animation = new AnimationEnemy(this,0, t.getFila() * 64, velocidadAt, velocidadMov, ImageLoader.gruntAtk, ImageLoader.gruntMove);
		animation.setYOffset(128);
		t.setComponente(this);
		image = ImageLoader.grunt;
		ancho=1;
		alto=1;
		impacto=20;
		alcance=1;
		velMovMaxima=2.0f;
		velAtMaxima=0.7f;
		puntaje=20;
		coins=15;
		reloj=1;
		v = new VisitorEnemigo(this);
		state = new ObjectStateMoving();
		premio = new Escudo();
	}
	public ObjetoNoAtravesable clone(){
		return new Grunt(new Tile(null,0,0));
	}
	public void accept(VisitorWololo vw, Tile t){
		vw.visit(this, t);
	}
}
