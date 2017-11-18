package logica;

import java.util.LinkedList;
import java.util.Random;
import objeto.atravesable.*;
import objeto.noAtravesable.ObjectStateStatic;
import objeto.noAtravesable.objetoConVida.OMConVida.*;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;

/**
 * Clase Logica
 * Representa a la logica de todo el juego
 *
 */
public class Logica {
	
	//atributos
	private LinkedList<Enemigo> listaEnemigos, enemigosABorrar, enemigosAAgregar;
	private LinkedList<Aliado> listaAliados, aliadosABorrar, aliadosAAgregar;
	private LinkedList<ObjetoAtravesable> listaAtravesables, atravesablesABorrar;
	private LinkedList<ObjetoTemporal> objetosTemporales, objetosTemporalesABorrar;
	private Tienda tienda;
	private int score, vidas;
	private Tile[][] tablero;
	private final int filas=6, columnas=12;
	
	private static Logica logica = new Logica();
	
	//constructor
	private Logica(){
		tienda=Tienda.getTienda(this);
		score = 0;
		tablero = new Tile[filas][columnas];
		listaEnemigos = new LinkedList<Enemigo>();
		enemigosABorrar = new LinkedList<Enemigo>();
		enemigosAAgregar = new LinkedList<Enemigo>();
		listaAliados = new LinkedList<Aliado>();
		aliadosABorrar = new LinkedList<Aliado>();
		aliadosAAgregar = new LinkedList<Aliado>();
		listaAtravesables = new LinkedList<ObjetoAtravesable>();
		atravesablesABorrar = new LinkedList<ObjetoAtravesable>();
		objetosTemporales = new LinkedList<ObjetoTemporal>();
		objetosTemporalesABorrar = new LinkedList<ObjetoTemporal>();
	}
	

	//metodos
	public static Logica getLogica(){
		return logica;
	}
	
	/**
	 * Agrega puntos a la partida
	 * @param e puntos a agregar
	 */
	public void agregarPuntos(int e){
		score+=e;
	}
	
	/**
	 * Setea una cantidad de vidas
	 * @param v cantidad de vidas
	 */
	public void setVidas(int v){
		vidas=v;
	}
	
	/**
	 * Consulta la cantidad de vidas restantes
	 * @return vidas
	 */
	public int getVidas(){
		return vidas;
	}
	
	/**
	 * Agrega monedas a la tienda
	 * @param m monedas a agregar
	 */
	public void agregarMonedas(int m){
		tienda.sumarMonedas(m);
	}
	
	/**
	 * Agrega un aliado a la logica
	 * @param a aliado
	 */
	public void agregarAliado(Aliado a){
		aliadosAAgregar.addLast(a);
	}
	
	/**
	 * Agrega un enemigo a la logica en un tile
	 * @param e enemigo
	 * @param t tile
	 */
	public void agregarEnemigo(Enemigo e, Tile t){
		enemigosAAgregar.addLast(e);
		e.setTile(t);
		t.setComponente(e);
	}
	
	/**
	 * Agrega un objeto atravesable a la logica
	 * @param oa objeto atravesable
	 */
	public void agregarAtravesable(ObjetoAtravesable oa){
		listaAtravesables.addLast(oa);
	}
	
	/**
	 * Agrega un aliado para luego ser borrado
	 * @param a aliado
	 */
	public void agregarAliadoABorrar(Aliado a){
		aliadosABorrar.addLast(a);
	}
	
	/**
	 * Agrega un enemigo para luego ser borrado
	 * @param e Enemigo
	 */
	public void agregarEnemigoABorrar(Enemigo e){
		enemigosABorrar.addLast(e);
	}
	
	/**
	 * Agrega un objeto atravesable para luego ser borrado
	 * @param oa objeto atravesable
	 */
	public void agregarAtravesableABorrar(ObjetoAtravesable oa){
		atravesablesABorrar.addLast(oa);
	}
	
	/**
	 * Agrega un objeto temporal a la logica
	 * @param obj objeto temporal
	 */
	public void agregarObjetoTemporal(ObjetoTemporal obj){
		objetosTemporales.addLast(obj);
	}
	
	/**
	 * Agrega un objeto temporal para luego ser borrado
	 * @param obj objeto temporal
	 */
	public void agregarObjetoTemporalABorrar(ObjetoTemporal obj){
		objetosTemporalesABorrar.addLast(obj);
	}
	
	/**
	 * Agrega todos los objetos agregados previamente
	 */
	private void agregarObjetos(){
		for(Aliado a : aliadosAAgregar){
			listaAliados.addLast(a);
		}
		aliadosAAgregar.clear();
		for(Enemigo e : enemigosAAgregar){
			listaEnemigos.addLast(e);
		}
		enemigosAAgregar.clear();
	}
	/**
	 * Borra todos los objetos eliminados previamente
	 */
	private void eliminarObjetos(){
		for (ObjetoTemporal obj : objetosTemporalesABorrar){
			objetosTemporales.remove(obj);
		}
		objetosTemporalesABorrar.clear();
		for (Aliado a : aliadosABorrar){
			listaAliados.remove(a);
		}
		aliadosABorrar.clear();
		for (Enemigo e : enemigosABorrar){
			listaEnemigos.remove(e);
		}
		enemigosABorrar.clear();
		for (ObjetoAtravesable oa : atravesablesABorrar){
			listaAtravesables.remove(oa);
		}
		atravesablesABorrar.clear();
	}
	
	/**
	 * Genera un mapa al azar
	 */
	public void generarMapa(){
		
		int r;
		Random random = new Random();
		
		for (int i = 0; i < filas ; i++){
			for (int j = 0; j < columnas; j++){
				tablero[i][j] = new Tile(this,i,j);
			}
		}
		
		for (int i = 0; i < filas ; i++){
			for (int j = 1; j < columnas; j++){
				r = random.nextInt(100);
				if (r < 6) {
					Agua a=new Agua(tablero[i][j]);
					tablero[i][j].setComponenteAtravesable(a);
					listaAtravesables.addLast(a);
				}
				else if ( r < 9) {
					if(tablero[i][j].getComponenteAtravesable()==null){
						Arbol a= new Arbol();
						tablero[i][j].setComponente(a);
						a.setTile(tablero[i][j]);
					}
				}
				else if (r < 12) {
					if(tablero[i][j].getComponenteAtravesable()==null){
						Piedra p=new Piedra();
						tablero[i][j].setComponente(p);
						p.setTile(tablero[i][j]);
					}
				}
				
			}
		}
	}
	
	/**
	 * Actualiza la logica
	 */
	public void actualizar(){
		for(ObjetoTemporal obj: objetosTemporales){
			obj.decrementarReloj();
		}
		eliminarObjetos();
		for(Aliado a:listaAliados){
			boolean encontre = false;
			if(a.getTile()!=null && a.getTile().getColumna()!=0){
				Tile actual = a.getTile().getLeft();
				for(int i=0; !encontre && actual.getColumna()!=0 && i<a.getAlcance(); i++){
					if(actual.getComponente()!=null){
						a.atacar(actual.getComponente());
						encontre = true;
					}
					actual=actual.getLeft();
				}
			}
			if (!encontre)
				a.setState(new ObjectStateStatic());
			a.aumentarReloj();
			eliminarObjetos();
		}
		agregarObjetos();
		for(Enemigo e:listaEnemigos){
			boolean encontre=false;
			Tile actual=e.getTile();
			if (actual.getColumna()==11){
				encontre=true;
				vidas--;
				e.quitar();
			}
			int restantes = 12 - (actual.getColumna()+e.getAlcance());
			for(int i=0; restantes > 0 && i<e.getAlcance() && !encontre; i++){
				actual=actual.getRight();
				if(actual.getComponente()!=null){
					e.atacar(actual.getComponente());
					encontre=true;
				} 
			}
			if(!encontre){
				e.avanzar();
				e.setState(e.getMovingState());
			}
		}
		eliminarObjetos();
		agregarObjetos();
		for(ObjetoAtravesable oa: listaAtravesables){
			if(oa.getTile().getComponente()!=null)
				oa.modificar(oa.getTile().getComponente());
			eliminarObjetos();
		}
	}
	
	/**
	 * Consulta el score
	 * @return score
	 */
	public int getScore(){
		return score;
	}
	
	/**
	 * Setea el score
	 * @param s nuevo score
	 */
	public void setScore(int s){
		score = s;
	}
	
	/**
	 * Retorna un tile en una fila y columna especificas del tablero
	 * @param f fila
	 * @param c columna
	 * @return tile
	 */
	public Tile getTile(int f, int c){
		if (f < tablero.length && c < tablero[0].length){
			return tablero[f][c];
		}
		else{
			return null;
		}
	}
	
	/**
	 * Consulta la cantidad de filas
	 * @return filas
	 */
	public int getFilas(){
		return filas;
	}
	
	/**
	 * Consulta la cantidad de columnas
	 * @return columnas
	 */
	public int getColumnas(){
		return columnas;
	}
	
	/**
	 * Consulta si no hay enemigos en el mapa
	 * @return true si no hay enemigos, false en caso contrario
	 */
	public boolean noHayEnemigos(){
		return listaEnemigos.size() == 0;
	}
	
	/**
	 * vacia todo el mapa de aliados y enemigos
	 */
	public void vaciar() {
		for(Aliado a: listaAliados){
			agregarAliadoABorrar(a);
		}
		for(Enemigo e: listaEnemigos){
			agregarEnemigoABorrar(e);
		}
		eliminarObjetos();
		
	}
}
