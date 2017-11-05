package game.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import game.Game;
import logica.Tienda;

public class Display {

	private JFrame frame;
	private Canvas canvas;
	private Game myGame;
	private Tienda tienda;
	private String title;
	private int width, height;
	private PanelTienda panelTienda;
	
	
	public Display(String title, int width, int height, Game g){
		this.title = title;
		this.width = width;
		this.height = height;
		myGame = g;
		tienda = Tienda.getTienda(myGame.getLogica());
		createDisplay();
	}
	
	private void createDisplay(){
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setLayout(new GridBagLayout());

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
		frame.add(canvas,c);
		c.gridx=1;
		c.ipadx=width/4;
		frame.add(panelTienda,c);
		frame.pack();
		
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
	
	public void click(MouseEvent e){
		System.out.println(e.getX() + " " + e.getY());

		if(panelTienda.getPrototype()!=null){// && myGame.getLogica().getTile(e.getY()/64, e.getX()/64).getComponente()==null
			panelTienda.getPrototype().agregar(tienda, myGame.getLogica().getTile(e.getY()/64, e.getX()/64));
		}
		else
			myGame.interaccion(e.getX(), e.getY());
	}
	
	public void actualizarPuntaje(int p){
		panelTienda.actualizarPuntaje(p, tienda.getMonedas());
	}
	
	public PanelTienda getPanelTienda(){
		return panelTienda;
	}
}
