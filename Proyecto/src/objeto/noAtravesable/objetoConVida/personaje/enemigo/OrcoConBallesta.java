package objeto.noAtravesable.objetoConVida.personaje.enemigo;

import game.gfx.AnimationEnemy;
import game.gfx.ImageLoader;
import logica.Tile;
import logica.visitor.VisitorEnemigo;
import objeto.noAtravesable.ObjectStateMoving;
import objeto.noAtravesable.ObjetoNoAtravesable;
import objeto.noAtravesable.objetoConVida.Premios.Bomba;
import objeto.noAtravesable.objetoConVida.Premios.VisitorWololo;

public class OrcoConBallesta extends Enemigo{
	public OrcoConBallesta(Tile t){
		super();
		vida=50;
		maxVida=50;
		miTile=t;
		velocidadMov=1.3f;
		velocidadAt=1.2f;
		animation = new AnimationEnemy(this, 0 , t.getFila()*64, velocidadAt, velocidadMov ,ImageLoader.orcoBallestaAtk, ImageLoader.orcoBallestaMov);
		t.setComponente(this);
		image = ImageLoader.orcoBallestero;
		ancho=1;
		alto=1;
		impacto=25;
		alcance=3;
		velMovMaxima=1.3f;
		velAtMaxima=1.2f;
		puntaje=22;
		coins=200;
		reloj=1;
		v = new VisitorEnemigo(this);
		setState(new ObjectStateMoving());
		premio = new Bomba();
		
	}
	public ObjetoNoAtravesable clone(){
		return new OrcoConBallesta(new Tile(null, 0, 0));
	}
	public void accept(VisitorWololo vw, Tile t){
		vw.visit(this, t);
	}
}
