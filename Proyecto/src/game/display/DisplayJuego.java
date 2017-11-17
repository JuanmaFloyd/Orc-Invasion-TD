package game.display;

import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import game.Game;
import logica.Nivel;
import logica.Objeto;
import logica.Tienda;
import logica.visitor.VisitorClick;

/**
 * Clase DisplayJuego
 * Extiende a la clase JPanel de Java
 * Representa la parte grafica de todo un nivel
 *
 */
@SuppressWarnings("serial")
public class DisplayJuego extends JPanel{
	private Nivel nivel;
	private Canvas canvas;
	private Game myGame;
	private Tienda tienda;
	private JPanel panelCanvas;
	private PanelTienda panelTienda;
	private int offset = 128;
	
	
	public DisplayJuego(Game g, Nivel n, VisitorClick v){
		nivel=n;
		myGame = g;
		tienda = Tienda.getTienda(myGame.getLogica());
		createDisplay();
		v.setPanel(panelTienda);
	}
	
	/**
	 * Crea el display
	 */
	private void createDisplay(){

		setLayout(new GridBagLayout());

		panelTienda = new PanelTienda(myGame, tienda);
		tienda.setMonedas(nivel.getMonedasInicio());
		
		PremioManager.init(panelTienda);
		
		panelCanvas = new JPanel(new CardLayout());
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(864, 512));
		canvas.setMaximumSize(new Dimension(864, 512));
		canvas.setMinimumSize(new Dimension(864, 512));
		
		canvas.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				click(e);
			}
		}
		);
		
		panelCanvas.add(canvas);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		add(panelCanvas,c);
		c.gridx=1;
		c.ipadx=768/4;
		add(panelTienda,c);
		
	}
	
	/**
	 * Retorna el canvas del mapa
	 * @return canvas
	 */
	public Canvas getCanvas(){
		return canvas;
	}
	
	/**
	 * Maneja la interaccion con un click del mapa
	 * @param e MouseEvent
	 */
	public void click(MouseEvent e){

		if(panelTienda.getPrototype()!=null && e.getY()-offset>=0 && (e.getX() <= 768)){
			Objeto o = panelTienda.getPrototype();
			panelTienda.setPrototype(null);
			o.agregar(tienda, myGame.getLogica().getTile((e.getY()-offset)/64, e.getX()/64));
		}
		else
			if(e.getY()-offset>=0 && (e.getX() <= 768)){
				myGame.interaccion(e.getX(), e.getY()-offset);
				panelTienda.setPrototype(null);
			}
	}
	
	/**
	 * Actualiza el puntaje en el panel de la tienda
	 * @param p nuevo puntaje
	 */
	public void actualizarPuntaje(int p){
		panelTienda.actualizarPuntaje(p, tienda.getMonedas());
	}
	
	/**
	 * Retorna el panel de la tienda
	 * @return panelTienda
	 */
	public PanelTienda getPanelTienda(){
		return panelTienda;
	}
	
	/**
	 * Pierde un nivel
	 */
	public void perderNivel() {
		System.out.println("DisplayJuego.perderNivel");
		canvas.setEnabled(false);
		panelTienda.setEnabled(false);
		PanelPerder p=new PanelPerder(myGame);
		panelCanvas.removeAll();
		panelCanvas.add(p);
		panelCanvas.revalidate();
		panelCanvas.repaint();
	}
	
	/**
	 * Gana un nivel
	 */
	public void ganarNivel() {
		System.out.println("DisplayJuego.ganarNivel");
		canvas.setEnabled(false);
		panelTienda.setEnabled(false);
		PanelGanar p= new PanelGanar(myGame, nivel);
		panelCanvas.removeAll();
		panelCanvas.add(p);
		panelCanvas.revalidate();
		panelCanvas.repaint();
	}
}
