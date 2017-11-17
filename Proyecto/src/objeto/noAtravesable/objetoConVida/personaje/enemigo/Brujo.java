package objeto.noAtravesable.objetoConVida.personaje.enemigo;
import logica.*;
import logica.visitor.VisitorEnemigo;
import objeto.noAtravesable.*;
import objeto.noAtravesable.objetoConVida.Premios.VisitorWololo;
import objeto.noAtravesable.objetoConVida.Premios.Wololo;
import game.gfx.AnimationEnemy;
import game.gfx.ImageLoader;

public class Brujo extends Enemigo{
	public Brujo(){
		super();
		vida=50;
		maxVida = 50;
		velocidadMov=2.3f;
		velocidadAt=2.0f;
		animation = new AnimationEnemy(this, 0 , 0, velocidadAt, velocidadMov ,ImageLoader.warlockAtk, ImageLoader.warlockMove);
		animation.setYOffset(128);
		image = ImageLoader.brujo;
		ancho=1;
		alto=1;
		impacto=10;
		alcance=4;
		velMovMaxima=2.3f;
		velAtMaxima=2.0f;
		puntaje=20;
		coins=200;
		reloj=1;
		v = new VisitorEnemigo(this);
		setState(new ObjectStateMoving());
		premio = new Wololo();
		
	}
	public ObjetoNoAtravesable clone(){
		return new Brujo();
	}
	public void accept(VisitorWololo vw, Tile t){
		vw.visit(this, t);
	}
}
