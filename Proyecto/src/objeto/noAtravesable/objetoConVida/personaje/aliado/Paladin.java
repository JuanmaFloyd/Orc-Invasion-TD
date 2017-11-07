package objeto.noAtravesable.objetoConVida.personaje.aliado;

import game.gfx.Animation;
import game.gfx.ImageLoader;
import logica.Tienda;
import logica.Tile;
import logica.visitor.VisitorAliado;
import objeto.noAtravesable.ObjetoNoAtravesable;

public class Paladin extends Aliado{
	//atributos
	protected Tile segundo;
	
	//constructor
		public Paladin(Tile t, Tile t2){
			super();
			miTile=t;
			if(t2!=null){
				t2.setComponente(this);
				segundo=t2;
			}
			velocidadAt=1.2f;
			velAtMaxima=1.2f;
			t.setComponente(this);
			image=ImageLoader.paladin;
			vida=120;
			maxVida=120;
			escudo = 0;
			maxEscudo = (int)(maxVida*0.2);
			ancho=2;
			alto=1;
			impacto=45;
			alcance=1;
			valor=50;
			v=new VisitorAliado(this);
			animation = new Animation(this, t.getFila() * 64,t.getColumna()*64, velocidadAt, ImageLoader.paladinAtk);
			animation.setYOffset(128);
			
		}
		public void restarVida(int v){
			if(escudo > 0){
				escudo -= v;
				if(escudo < 0){
					vida += escudo;
					escudo = 0;
				}
			}
			else{
				vida-=v;
			}
			if(vida<=0){
				miTile.destruirAliado(this);
				if(segundo!=null){
					segundo.setComponente(null);
					segundo=null;
				}
				miTile = null;
			}
		}
		public void agregar(Tienda tien, Tile t){
			if(t.getColumna()!=11 && t.getRight().getComponente()==null){
				miTile=t;
				t.setComponente(this);
				if(t.getColumna()!=11){
					segundo=t.getRight();
					segundo.setComponente(this);
				}
				tien.comprar(this);
				animation.setPos(t.getColumna(), t.getFila());
			}
		}
		public ObjetoNoAtravesable clone(){
			return new Paladin(new Tile(null, 0, 0), new Tile(null, 0, 0));
		}
}
