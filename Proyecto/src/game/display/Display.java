package game.display;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;
import game.GameState;
import game.MenuState;
import game.UIState;

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
		
		frame.pack();
	}
	public void setJuego(){
		if(panel!=null)
			frame.remove(panel);
		DisplayJuego d = new DisplayJuego(myGame);
		state = new GameState(d);
		panel = d;
		frame.add(panel);
	}
	public void setMenu(){
		if(panel!=null)
			frame.remove(panel);
		Menu m = new Menu(myGame);
		state = new MenuState(m);
		panel = m;
		frame.add(panel);
	}
	public UIState getState(){
		return state;
	}
}
