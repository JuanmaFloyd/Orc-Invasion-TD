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
		velocidadMov=2.0f;
		animation = new AnimationEnemy(this, 0, 0, velocidadAt, velocidadMov, ImageLoader.jefeOrcoMov, ImageLoader.jefeOrcoMov);
		animation.setYOffset(128);
		image = ImageLoader.jefeOrco;
		ancho=2;
		alto=1;
		impacto=30;
		alcance=1;
		velMovMaxima=2.0f;
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
		super.restarVida(v);
		if(vida<=0){ 
			segundo.setComponente(null);
			segundo=null;
		}
	}
	public void setTile(Tile t){
		super.setTile(t);
		if(t.getColumna()!=0 && t.getLeft().getComponente()!=null){
			segundo = miTile.getLeft();
			segundo.setComponente(this);
		}
	}

}
