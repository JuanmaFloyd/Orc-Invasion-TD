package objeto.noAtravesable;


import logica.Objeto;
import logica.Tienda;
import logica.Tile;
import logica.visitor.Visitor;
import objeto.noAtravesable.objetoConVida.Premios.VisitorWololo;

public abstract class ObjetoNoAtravesable extends Objeto {
	
	protected ObjectState state;
	protected ObjectState stateStatic;

	public ObjetoNoAtravesable(){
		super();
		stateStatic = new ObjectStateStatic();
		state = stateStatic;
		state.setObject(this);
	}
	
	public int getVida(){return 0;}
	public int getMaxVida(){return 0;}
	public ObjectState getStaticState(){
		return stateStatic;
	}
	public void accept(Visitor v){}
	public void accept(VisitorWololo vw, Tile t){}
	public void setState(ObjectState newState){
		state = newState;
	}
	public void agregar(Tienda tien, Tile t){
		miTile=t;
		t.setComponente(this);
	}

	
	public abstract void restarVida(int n);
}
