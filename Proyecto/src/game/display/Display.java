package game.display;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;

public class Display {
	//atributos
	private JFrame frame;
	private String title;
	private int width, height;
	private JPanel panel;
	private Game myGame;
	
	//constructor
	public Display(String title, int width, int height, Game g){
		
		myGame = g;

		this.title = title;
		this.width = width;
		this.height = height;
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		frame.pack();
	}
	public void setJuego(){
		panel = new DisplayJuego(myGame);
	}
}
