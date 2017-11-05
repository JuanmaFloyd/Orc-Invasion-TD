package game.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;
import logica.Tienda;

@SuppressWarnings("serial")
public class DisplayJuego extends JPanel{
	private Canvas canvas;
	private Game myGame;
	private Tienda tienda;
	private PanelTienda panelTienda;
	private int offset = 128;
	
	
	public DisplayJuego(Game g){
		myGame = g;
		tienda = Tienda.getTienda(myGame.getLogica());
		createDisplay();
	}
	
	private void createDisplay(){

		setLayout(new GridBagLayout());

		panelTienda = new PanelTienda(myGame, tienda);
		
		PremioManager.init(panelTienda);
		
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
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		add(canvas,c);
		c.gridx=1;
		c.ipadx=768/4;
		add(panelTienda,c);
		
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
	
	public void click(MouseEvent e){
		System.out.println(e.getX() + " " + (e.getY()-offset));

		if(panelTienda.getPrototype()!=null && e.getY()-offset>=0){
			panelTienda.getPrototype().agregar(tienda, myGame.getLogica().getTile((e.getY()-offset)/64, e.getX()/64));
		}
		else
			if(e.getY()-offset>=0)
				myGame.interaccion(e.getX(), e.getY()-offset);
	}
	
	public void actualizarPuntaje(int p){
		panelTienda.actualizarPuntaje(p, tienda.getMonedas());
	}
	
	public PanelTienda getPanelTienda(){
		return panelTienda;
	}
}
