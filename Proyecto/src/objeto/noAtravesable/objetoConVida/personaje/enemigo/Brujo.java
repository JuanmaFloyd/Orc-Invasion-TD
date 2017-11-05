package objeto.noAtravesable.objetoConVida.personaje.enemigo;
import logica.*;
import logica.visitor.VisitorEnemigo;
import objeto.noAtravesable.*;
import objeto.noAtravesable.objetoConVida.Premios.VisitorWololo;
import objeto.noAtravesable.objetoConVida.Premios.Wololo;
import game.gfx.AnimationEnemy;
import game.gfx.ImageLoader;

public class Brujo extends Enemigo{
	public Brujo(Tile t){
		super();
		vida=50;
		maxVida=50;
		miTile=t;
		velocidadMov=2.3f;
		velocidadAt=1.2f;
		animation = new AnimationEnemy(this, 0 , t.getFila()*64, velocidadAt, velocidadMov ,ImageLoader.warlockAtk, ImageLoader.warlockMove);
		t.setComponente(this);
		image = ImageLoader.brujo;
		ancho=1;
		alto=1;
		impacto=20;
		alcance=4;
		velMovMaxima=2.3f;
		velAtMaxima=1.2f;
		puntaje=20;
		coins=200;
		reloj=1;
		v = new VisitorEnemigo(this);
		setState(new ObjectStateMoving());
		premio = new Wololo();
		
	}
	public ObjetoNoAtravesable clone(){
		return new Brujo(new Tile(null, 0, 0));
	}
	public void accept(VisitorWololo vw, Tile t){
		vw.visit(this, t);
	}
}
