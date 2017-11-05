package objeto.noAtravesable.objetoConVida.Premios;

import logica.Tile;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Arquero;
import objeto.noAtravesable.objetoConVida.personaje.aliado.EnanoCampeon;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Espadachin;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Mago;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Paladin;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Brujo;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Goblin;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Grunt;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.JefeOrco;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.OrcoConBallesta;

public class VisitorWololo {
	public void visit(Goblin g, Tile t){
		g.restarVida(1000);
		Espadachin e = new Espadachin(t);
		t.agregarAliado(e);
	}
	public void visit(Grunt g, Tile t){
		g.restarVida(1000);
		EnanoCampeon ec = new EnanoCampeon(t);
		t.agregarAliado(ec);
	}
	public void visit(Brujo b, Tile t){
		b.restarVida(1000);
		Mago m = new Mago(t);
		t.agregarAliado(m);
	}
	public void visit(JefeOrco jo, Tile t){
		jo.restarVida(1000);
		Paladin p = new Paladin(t, t.getRight());
		t.agregarAliado(p);
	}
	public void visit(OrcoConBallesta ocb, Tile t){
		ocb.restarVida(1000);
		Arquero a = new Arquero(t);
		t.agregarAliado(a);
	}
}
