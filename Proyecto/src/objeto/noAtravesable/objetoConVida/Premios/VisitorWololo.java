package objeto.noAtravesable.objetoConVida.Premios;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import logica.Tile;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Arquero;
import objeto.noAtravesable.objetoConVida.personaje.aliado.EnanoCampeon;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Espadachin;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Mago;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Paladin;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Brujo;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Goblin;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Golem;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Grunt;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.JefeOrco;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.OrcoConBallesta;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class VisitorWololo {
	
	public void visit(Goblin g, Tile t){
		g.restarVida(1000);
		Espadachin e = new Espadachin(t);
		t.agregarAliado(e);
		playSound();
	}
	public void visit(Grunt g, Tile t){
		g.restarVida(1000);
		EnanoCampeon ec = new EnanoCampeon(t);
		t.agregarAliado(ec);
		playSound();
	}
	public void visit(Brujo b, Tile t){
		b.restarVida(1000);
		Mago m = new Mago(t);
		t.agregarAliado(m);
		playSound();
	}
	public void visit(JefeOrco jo, Tile t){
		jo.restarVida(1000);
		Paladin p = new Paladin(t, t.getRight());
		t.agregarAliado(p);
		playSound();
	}
	public void visit(OrcoConBallesta ocb, Tile t){
		ocb.restarVida(1000);
		Arquero a = new Arquero(t);
		t.agregarAliado(a);
		playSound();
	}
	public void visit(Golem g, Tile t){
		g.restarVida(1000);
		EnanoCampeon a = new EnanoCampeon(t);
		t.agregarAliado(a);
		playSound();
	}
	
	public void playSound(){
		String audio = "wololo.wav";
		AudioStream music = null;
		try{
			InputStream in = new FileInputStream(audio);
			music = new AudioStream(in);
		} catch(IOException e){}
		AudioPlayer.player.start(music);
	}
}
