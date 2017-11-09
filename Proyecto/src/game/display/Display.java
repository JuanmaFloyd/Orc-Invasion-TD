package game.display;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.Game;
import game.GameState;
import game.MenuState;
import game.UIState;
import logica.Objeto;
import logica.visitor.VisitorClick;

public class Display {
	//atributos
	private JFrame frame;
	private JPanel panel;
	private UIState state;
	private Game myGame;
	
	//constructor
	public Display(String title, int width, int height, Game g){
		
		myGame = g;
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLocation(100, 100);
		
		frame.pack();
	}
	public void setJuego(VisitorClick v){
		if(panel!=null)
			frame.remove(panel);
		DisplayJuego d = new DisplayJuego(myGame, v);
		state = new GameState(d);
		panel = d;
		frame.add(panel);
		frame.pack();
	}
	public void setMenu(){
		if(panel!=null)
			frame.remove(panel);
		Menu m = new Menu(myGame);
		state = new MenuState();
		panel = m;
		frame.add(panel);
		frame.pack();
	}
	public UIState getState(){
		return state;
	}
}
