package game.display;

import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Game;

public class Display {
	//atributos
	private JFrame frame;
	private String title;
	private int width, height;
	
	//constructor
	public Display(String title, int width, int height, Game g){
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setVisible(true);
		
		this.title = title;
		this.width = width;
		this.height = height;
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		frame.pack();
	}
}
