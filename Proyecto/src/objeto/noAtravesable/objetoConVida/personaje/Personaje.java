package objeto.noAtravesable.objetoConVida.personaje;

import objeto.noAtravesable.objetoConVida.*;
import objeto.noAtravesable.ObjectState;
import objeto.noAtravesable.ObjectStateAttacking;
import objeto.noAtravesable.ObjetoNoAtravesable;

public abstract class Personaje extends ObjetoConVida{
	//atributos
	protected int impacto;
	protected int alcance;
	protected int reloj;
	protected float velocidadAt;
	protected float velAtMaxima;
	protected ObjectState stateAttacking;
	protected int escudo;
	protected int maxEscudo;
	
	public Personaje(){
		super();
		escudo = 0;
		maxEscudo = (int)(maxVida*0.2);
		stateAttacking = new ObjectStateAttacking();
	}
	
	//metodos
	
	public void crearEscudo(){
		escudo=(int)(maxVida*0.2);
		maxEscudo = (int)(maxVida*0.2);
	}
	public abstract void atacar(ObjetoNoAtravesable o);
	
	public int getAlcance(){
		return alcance;
	}
	public int getImpacto(){
		return impacto;
	}
	
	public ObjectState getAttackingState(){
		return stateAttacking;
	}
	
	public void modificarVelocidad(float rall){
		velocidadAt=(rall*velAtMaxima);
	}
	public void normalizarVelocidad(){
		velocidadAt=velAtMaxima;
	}
	public void aumentarReloj(){
		reloj=(reloj+1)%(int)(velocidadAt*60);
	}
	
}
