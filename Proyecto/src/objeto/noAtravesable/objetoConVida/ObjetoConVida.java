package objeto.noAtravesable.objetoConVida;

import objeto.noAtravesable.*;

public abstract class ObjetoConVida extends ObjetoNoAtravesable{
	//atributos
	protected int vida;
	protected int maxVida;
	
	//metodos
	public abstract void restarVida(int v);
	public boolean vivo(){
		return vida>0;
	}
	public boolean fullVida(){
		return vida == maxVida;
	}
	
	public int getVida(){
		return vida;
	}
	
	public int getMaxVida(){
		return maxVida;
	}
}
