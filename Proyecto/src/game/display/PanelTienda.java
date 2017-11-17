package game.display;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import game.Game;
import game.Launcher;
import game.gfx.ImageLoader;
import logica.Logica;
import logica.Objeto;
import logica.Portal;
import logica.Tienda;
import logica.Tile;
import objeto.noAtravesable.ObjetoNoAtravesable;
import objeto.noAtravesable.objetoConVida.OMConVida.Barricada;
import objeto.noAtravesable.objetoConVida.OMConVida.OMConVida;
import objeto.noAtravesable.objetoConVida.personaje.aliado.*;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.LinkedList;

/**
 * Clase PanelTienda
 * Extiende a la clase JPanel de Java
 * Representa el panel de la tienda
 *
 */
@SuppressWarnings("serial")
public class PanelTienda extends JPanel {
	
	protected Game myGame;
	protected Tienda tien;
	protected JLabel labelPuntaje;
	protected JPanel pScroll, panelVidas;
	private LinkedList<JLabel> lVidas;
	protected GridBagConstraints c, conVidas;
	protected Objeto prototipo;
	protected JPanel panelPersonajesElfos, panelPersonajesEnanos, panelPremios;
	protected JPanel panelCompraElfos, panelCompraEnanos, panelPre, panelInfo;
	protected BotonCompraPersonaje[] personajesElfos, personajesEnanos, personajesHumanos, objetosTienda;
	protected JPanel panelElves, panelDwarves;
	protected LinkedList<BotonCompra> botones;
	private int cantPremios, vidas;
	private ObjetoNoAtravesable objetoInfo;

	/**
	 * Create the panel.
	 */
	public PanelTienda(Game g, Tienda t) {
		myGame=g;
		
		t.setPanel(this);
		tien=t;
		
		cantPremios=0;
		
		lVidas= new LinkedList<JLabel>();
		
		botones=new LinkedList<BotonCompra>();
		
		this.setLayout(new GridBagLayout());

		c= new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		c.weightx=0;
		c.weighty=0;
		c.ipady=30;
		c.ipadx=0;
		c.fill=GridBagConstraints.BOTH;

		labelPuntaje = new JLabel("Score: 0    Monedas:0");
		labelPuntaje.setFont(Launcher.fuente(20));
		labelPuntaje.setHorizontalAlignment(JLabel.CENTER);
		add(labelPuntaje, c);
		
		c.gridy=1;
		
		panelVidas = new JPanel(new GridBagLayout());
		conVidas = new GridBagConstraints();
		conVidas.fill=GridBagConstraints.BOTH;
		conVidas.gridx=0;
		conVidas.gridy=0;
		
		add(panelVidas,c);
		
		
		c.gridy=2;
		c.ipady=0;
		c.ipadx=0;
		c.weightx=0.5;
		c.weighty=0.5;
		
		pScroll=new JPanel(new GridBagLayout());
		
		GridBagConstraints conScroll = new GridBagConstraints();
		conScroll.gridx=0;
		conScroll.gridy=0;
		conScroll.fill=GridBagConstraints.BOTH;
		
		JScrollPane scrollPane = new JScrollPane(pScroll);
		scrollPane.setPreferredSize(new Dimension(100, 100));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		JPanel panelHumanos = new JPanel(new GridBagLayout());
		
		GridBagConstraints cs = new GridBagConstraints();
		cs.gridx=0;
		cs.gridy=0;
		cs.gridx=0;
		cs.gridy=0;
		cs.weightx=0;
		cs.weighty=0;
		cs.ipadx=0;
		cs.ipady=10;
		cs.fill=GridBagConstraints.BOTH;
		
		JLabel labelHumanos = new JLabel("Humanos", JLabel.CENTER);
		labelHumanos.setFont(Launcher.fuente(20));
		
		panelHumanos.add(labelHumanos, cs);
		
		cs.gridy=1;
		cs.weightx=0.5;
		cs.weighty=0.5;
		cs.ipady=0;
		
		JPanel panelPersonajesHumanos= new JPanel(new GridLayout(3, 2));
		personajesHumanos = new BotonCompraPersonaje[5];
		
		BotonCompraPersonaje mago = new BotonCompraPersonaje(this, ImageLoader.mago, new Mago(new Tile(null, 0, 0)));
		BotonCompraPersonaje espadachin = new BotonCompraPersonaje(this, ImageLoader.espadachin, new Espadachin(new Tile(null, 0, 0)));
		BotonCompraPersonaje paladin = new BotonCompraPersonaje(this, ImageLoader.paladin, new Paladin(new Tile(null, 0, 0), new Tile(null, 0, 0)));
		BotonCompraPersonaje arquero = new BotonCompraPersonaje(this, ImageLoader.arquero, new Arquero(new Tile(null, 0, 0)));
		BotonCompraPersonaje monje = new BotonCompraPersonaje(this, ImageLoader.monje, new Clerigo(new Tile(null, 0, 0)));
		
		personajesHumanos[0] = espadachin;
		personajesHumanos[1] = paladin;
		personajesHumanos[2] = arquero;
		personajesHumanos[3] = mago;
		personajesHumanos[4] = monje;
		
		for(int i=0; i<personajesHumanos.length; i++){
			panelPersonajesHumanos.add(personajesHumanos[i]);
			botones.addLast(personajesHumanos[i]);
		}
		
		panelHumanos.add(panelPersonajesHumanos, cs);
		
		pScroll.add(panelHumanos, conScroll);
		
		conScroll.gridy=1;
		
		
		JPanel panelElfos = new JPanel(new GridBagLayout());
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx=0;
		c1.gridy=0;
		c1.gridx=0;
		c1.gridy=0;
		c1.weightx=0;
		c1.weighty=0;
		c1.ipadx=0;
		c1.ipady=10;
		c1.fill=GridBagConstraints.BOTH;
		
		JLabel labelElfos = new JLabel("Elfos", JLabel.CENTER);
		labelElfos.setFont(Launcher.fuente(20));
		
		panelElfos.add(labelElfos, c1);
		
		c1.gridy=1;
		c1.weightx=0.5;
		c1.weighty=0.5;
		c1.ipady=0;
		
		panelElves = new JPanel(new CardLayout());
		
			panelPersonajesElfos= new JPanel(new GridLayout(1, 1));
			personajesElfos = new BotonCompraPersonaje[1];
		
			BotonCompraPersonaje druida = new BotonCompraPersonaje(this, ImageLoader.druida, new Druida(new Tile(null, 0, 0)));
		
			personajesElfos[0] = druida;
		
			for(int i=0; i<personajesElfos.length; i++){
				panelPersonajesElfos.add(personajesElfos[i]);
				personajesElfos[i].setEnabled(false);
				personajesElfos[i].setVisible(false);
				botones.addLast(personajesElfos[i]);
			}
			
			panelCompraElfos = new JPanel(new GridLayout(1,1));
			BotonCompraAlianza b = new BotonCompraAlianza(this, 100, "elfos");
			panelCompraElfos.add(b);
			botones.addLast(b);
		
		panelElves.add(panelCompraElfos);
		
			panelCompraElfos.setVisible(true);
			
		
		panelElfos.add(panelElves, c1);
		
		pScroll.add(panelElfos, conScroll);
		
		conScroll.gridy=2;
		
		JPanel panelEnanos = new JPanel(new GridBagLayout());
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx=0;
		c2.gridy=0;
		c2.gridx=0;
		c2.gridy=0;
		c2.weightx=0;
		c2.weighty=0;
		c2.ipadx=0;
		c2.ipady=10;
		c2.fill=GridBagConstraints.BOTH;
		
		JLabel labelEnanos = new JLabel("Enanos", JLabel.CENTER);
		labelEnanos.setFont(Launcher.fuente(20));
		
		panelEnanos.add(labelEnanos, c2);
		
		c2.gridy=1;
		c2.weightx=0.5;
		c2.weighty=0.5;
		c2.ipady=0;
		
		panelDwarves = new JPanel(new CardLayout());
		
			panelPersonajesEnanos= new JPanel(new GridLayout(1, 2));
			personajesEnanos = new BotonCompraPersonaje[2];
		
			BotonCompraPersonaje champ = new BotonCompraPersonaje(this, ImageLoader.campeonEnano, new EnanoCampeon(new Tile(null, 0, 0)));
			BotonCompraPersonaje cazador = new BotonCompraPersonaje(this, ImageLoader.cazadorEnano, new EnanoCazador(new Tile(null, 0, 0)));
		
			personajesEnanos[0] = champ;
			personajesEnanos[1] = cazador;
		
			for(int i=0; i<personajesEnanos.length; i++){
				panelPersonajesEnanos.add(personajesEnanos[i]);
				personajesEnanos[i].setEnabled(false);
				personajesEnanos[i].setVisible(false);
				botones.addLast(personajesEnanos[i]);
			}
			
			panelCompraEnanos = new JPanel(new GridLayout(1,1));
			BotonCompraAlianza b1 = new BotonCompraAlianza(this, 200, "enanos");
			panelCompraEnanos.add(b1);
			botones.addLast(b1);
		
		panelDwarves.add(panelCompraEnanos);
		
			panelCompraEnanos.setVisible(true);
			
		
		panelEnanos.add(panelDwarves, c1);
		
		pScroll.add(panelEnanos, conScroll);
		
		conScroll.gridy=3;
		
		JPanel panelOT = new JPanel(new GridBagLayout());
		
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx=0;
		c3.gridy=0;
		c3.gridx=0;
		c3.gridy=0;
		c3.weightx=0;
		c3.weighty=0;
		c3.ipadx=0;
		c3.ipady=10;
		c3.fill=GridBagConstraints.BOTH;
		
		JLabel labelOT = new JLabel("Objetos", JLabel.CENTER);
		labelOT.setFont(Launcher.fuente(20));
		
		panelOT.add(labelOT, c3);
		
		c3.gridy=1;
		c3.weightx=0.5;
		c3.weighty=0.5;
		c3.ipady=0;
		
		JPanel panelObjetosTienda= new JPanel(new GridLayout(2, 2));
		objetosTienda = new BotonCompraPersonaje[3];
		
		BotonCompraPersonaje portal = new BotonCompraPersonaje(this, ImageLoader.portalBlue[0], new Portal());
		BotonCompraPersonaje barricada = new BotonCompraPersonaje(this, ImageLoader.barricada, new Barricada());
		BotonCompraPersonaje torre = new BotonCompraPersonaje(this, ImageLoader.torre, new Torre(new Tile(null, 0, 0)));
		
		objetosTienda[0] = barricada;
		objetosTienda[1] = torre;
		objetosTienda[2] = portal;
		
		for(int i=0; i<objetosTienda.length; i++){
			panelObjetosTienda.add(objetosTienda[i]);
			botones.addLast(objetosTienda[i]);
		}
		
		panelOT.add(panelObjetosTienda, c3);
		
		pScroll.add(panelOT, conScroll);
		
		conScroll.gridy=4;
		
		panelPremios = new JPanel(new GridBagLayout());
		
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx=0;
		c4.gridy=0;
		c4.weightx=0;
		c4.weighty=0;
		c4.ipadx=0;
		c4.ipady=10;
		c4.fill=GridBagConstraints.BOTH;
		
		JLabel labelPremios = new JLabel("Premios", JLabel.CENTER);
		labelPremios.setFont(Launcher.fuente(20));
		
		panelPremios.add(labelPremios, c4);
		
		c4.gridy=1;
		c4.weightx=0.5;
		c4.weighty=0.5;
		c4.ipady=0;
		
		panelPre= new JPanel(new GridLayout(3, 2));
			
		panelPremios.add(panelPre, c4);
		panelPremios.setVisible(false);
	
		pScroll.add(panelPremios, conScroll);
		
		
		add(scrollPane, c);
		
	}
	
	/**
	 * Actualiza el puntaje y las monedas
	 * @param p puntaje nuevo
	 * @param m nueva cantidad de monedas
	 */
	public void actualizarPuntaje(int p, int m){
		for(BotonCompra b: botones){
			b.setearComprable(m);
		}
		labelPuntaje.setText("Score: "+p+"   Monedas: "+m);
		int v = Logica.getLogica().getVidas();
		if(v>=0){
		if(vidas<v){
			for (int i=vidas; i<v; i++){
				lVidas.addLast(new JLabel(new ImageIcon(ImageLoader.loadImage("/Textures/vida.png"))));
				panelVidas.add(lVidas.getLast(), conVidas);
				conVidas.gridx++;
			}
			revalidate();
			repaint();
		}
		else
			if(vidas>v){
				for(int i=vidas; i>v; i--){
					panelVidas.remove(lVidas.getLast());
					lVidas.removeLast();
					conVidas.gridx--;
				}
				revalidate();
				repaint();
			}
		}
		if(objetoInfo!=null && objetoInfo.getVida()<=0)
			removerInfo();
		vidas=v;
	}
	
	/**
	 * Setea un nuevo prototipo para agregar en el mapa
	 * @param ob objeto a agregar
	 */
	public void setPrototype(Objeto ob){
		prototipo=ob;
	}
	
	/**
	 * Retorna el prototipo actual
	 * @return prototipo
	 */
	public Objeto getPrototype(){
		return prototipo;
	}
	
	/**
	 * Compra una alianza
	 * @param al nombre de la alianza
	 * @param val valor de la compra
	 */
	public void comprarAlianza(String al, int val){
		if(al.equals("elfos")){
			personajesElfos[0].setVisible(true);
			personajesElfos[0].setEnabled(true);
			panelCompraElfos.setVisible(false);
			panelElves.remove(panelCompraElfos);
			panelElves.add(panelPersonajesElfos);
		}
		else if(al.equals("enanos")){
			for(JLabel b: personajesEnanos){
				b.setVisible(true);
				b.setEnabled(true);
			}
			panelCompraEnanos.setVisible(false);
			panelDwarves.remove(panelCompraEnanos);
			panelDwarves.add(panelPersonajesEnanos);
		}
		Tienda.getTienda(myGame.getLogica()).comprarAlianza(val);
	}
	
	/**
	 * Agrega un premio al panel
	 * @param p Boton en el cual se debe agregar
	 */
	public void agregarPremio(BotonCompraPremio p){
		if(!panelPremios.isVisible())
			panelPremios.setVisible(true);
		panelPre.add(p);
		cantPremios++;
		botones.addLast(p);
		revalidate();
		repaint();
	}
	
	/**
	 * Elimina un premio del panel
	 * @param p boton del cual se debe eliminar
	 */
	public void eliminarPremio(BotonCompraPremio p){
		panelPre.remove(p);
		botones.remove(p);
		cantPremios--;
		if(cantPremios==0)
			panelPremios.setVisible(false);
		revalidate();
		repaint();
	}
	
	/**
	 * Muestra la info de un aliado
	 * @param a aliado de la info
	 */
	public void mostrarInfoAliado(Aliado a) {
		if(panelInfo!=null)
			remove(panelInfo);
		c.gridy=3;
		c.ipadx=0;
		c.ipady=0;
		panelInfo = new PanelInfoAliado(a, tien);
		add(panelInfo, c);
		objetoInfo=a;
		revalidate();
		repaint();
	}
	
	/**
	 * Muestra la info de un enemigo
	 * @param e enemigo de la info
	 */
	public void mostrarInfoEnemigo(Enemigo e) {
		if(panelInfo!=null)
			remove(panelInfo);
		c.gridy=3;
		c.ipadx=0;
		c.ipady=0;
		panelInfo = new PanelInfoPersonaje(e);
		add(panelInfo, c);
		objetoInfo=e;
		revalidate();
		repaint();
	}
	
	/**
	 * Muestra la info de un objeto del mapa
	 * @param omcv objeto de la info
	 */
	public void mostrtarInfoOM(OMConVida omcv) {
		if(panelInfo!=null)
			remove(panelInfo);
		c.gridy=3;
		c.ipadx=0;
		c.ipady=0;
		panelInfo = new PanelInfo(omcv);
		add(panelInfo, c);
		objetoInfo=omcv;
		revalidate();
		repaint();
	}
	
	public void setEnabled(boolean bool){
		super.setEnabled(bool);
		for(BotonCompra b: botones){
			b.setEnabled(bool);
		}
	}
	
	/**
	 * Remueve la info que se mostraba hasta el momento
	 */
	public void removerInfo() {
		if(panelInfo!=null)
			remove(panelInfo);
		panelInfo=null;
		revalidate();
		repaint();
	}
}
