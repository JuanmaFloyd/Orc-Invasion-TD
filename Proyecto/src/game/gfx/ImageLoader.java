package game.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Clase ImageLoader
 * Carga las imagenes del juego
 *
 */
public class ImageLoader {

	private static int width = 64, height = 64;
	private static BufferedImage sheet;
	public static BufferedImage tierra, agua, piedra , arbol, fondo, peste, castillo, barricada;
	public static BufferedImage mago, espadachin, paladin, arquero, monje, campeonEnano, cazadorEnano, druida, oso, treant, torre;
	public static BufferedImage goblin, brujo, grunt, jefeOrco, orcoBallestero, golem;
	public static BufferedImage pBolaDeFuego, pBomba, pEscudo, pFrenzy, pPeste, pWololo;
	public static BufferedImage[] pesteMov = new BufferedImage[4];
	public static BufferedImage[] vida = new BufferedImage[3];
	public static BufferedImage[] goblinMove = new BufferedImage[4];
	public static BufferedImage[] goblinAtk = new BufferedImage[4];
	public static BufferedImage[] mageAtk = new BufferedImage[4];
	public static BufferedImage[] warriorAtk = new BufferedImage[4];
	public static BufferedImage[] monkAtk = new BufferedImage[4];
	public static BufferedImage[] paladinAtk = new BufferedImage[4];
	public static BufferedImage[] arqueroAtk = new BufferedImage[4];
	public static BufferedImage[] dwarfHunterAtk = new BufferedImage[4];
	public static BufferedImage[] warlockAtk = new BufferedImage[4];
	public static BufferedImage[] warlockMove = new BufferedImage[4];
	public static BufferedImage[] gruntAtk = new BufferedImage[4];
	public static BufferedImage[] gruntMove = new BufferedImage[4];
	public static BufferedImage[] portalBlue = new BufferedImage[4];
	public static BufferedImage[] aguaMov = new BufferedImage[4];
	public static BufferedImage[] lava = new BufferedImage[4];
	public static BufferedImage[] portalOrange = new BufferedImage[4];
	public static BufferedImage[] jefeOrcoMov = new BufferedImage[8];
	public static BufferedImage[] orcoBallestaMov = new BufferedImage[4];
	public static BufferedImage[] orcoBallestaAtk = new BufferedImage[4];
	public static BufferedImage[] campeonEnanoAtk = new BufferedImage[4];
	public static BufferedImage[] golemMov = new BufferedImage[4];
	public static BufferedImage[] golemAtk = new BufferedImage[4];
	public static BufferedImage[] treantAtk = new BufferedImage[4];
	public static BufferedImage[] druidAtk = new BufferedImage[4];
	public static BufferedImage[] torreAtk = new BufferedImage[4];
	public static BufferedImage[] efectoMeteorito = new BufferedImage[9];
	public static BufferedImage[] shield = new BufferedImage[4];
	public static BufferedImage[] bomb = new BufferedImage[8];
	public static BufferedImage[] osoAtk = new BufferedImage[1];
	
	/**
	 * inicializa las imagenes
	 */
 	public static void init(){
 		fondo = loadImage("/Textures/Fondo.png");
 		castillo = loadImage("/Textures/Castillo-Arboles.png");
		sheet = loadImage("/Textures/SpriteSheet3x2.png");
		tierra = sheet.getSubimage(0, 0, width, height);
		agua = sheet.getSubimage(0, height, width, height);
		piedra = sheet.getSubimage(width, 0, width, height);
		peste = sheet.getSubimage(64, 64, 64, 64);
		arbol = loadImage("/Textures/arbol.png");
		lava[0] = sheet.getSubimage(0, 128, 64, 64);
		lava[1] = sheet.getSubimage(0, 128, 64, 64);
		lava[2] = sheet.getSubimage(0, 128, 64, 64);
		lava[3] = sheet.getSubimage(0, 128, 64, 64);
		espadachin = loadImage("/Textures/Personajes/Soldado.png");
		paladin = loadImage("/Textures/Personajes/Paladin.png");
		arquero = loadImage("/Textures/Personajes/Arquero.png");
		monje = loadImage("/Textures/Personajes/Clerigo.png");
		mago = loadImage("/Textures/Personajes/mago.png");
		druida = loadImage("/Textures/Personajes/Druida.png");
		treant = loadImage("/Textures/Personajes/Treant.png");
		goblin=loadImage("/Textures/Personajes/Goblin.png");
		brujo=loadImage("/Textures/Personajes/OrcoBrujo.png");
		orcoBallestero=loadImage("/Textures/Personajes/Orco Ballestero.png");
		campeonEnano=loadImage("/Textures/Personajes/Campeon Enano.png");
		cazadorEnano=loadImage("/Textures/Personajes/Cazador Enano.png");
		oso=loadImage("/Textures/Personajes/Oso.png");
		grunt=loadImage("/Textures/Personajes/Grunt.png");
		jefeOrco = loadImage("/Textures/Personajes/Jefe Orco.png");
		vida[0] =loadImage("/Textures/VidaVerde.png");
		vida[1] =loadImage("/Textures/VidaRoja.png");
		vida[2] =loadImage("/Textures/VidaAzul.png");
		pBolaDeFuego = loadImage("/Textures/Premios/PremioBolaFuego.png");
		pBomba = loadImage("/Textures/Premios/PremioBomba.png");
		pEscudo = loadImage("/Textures/Premios/PremioEscudo.png");
		pFrenzy = loadImage("/Textures/Premios/PremioFrenzy.png");
		pPeste = loadImage("/Textures/Premios/PremioPeste.png");
		pWololo = loadImage("/Textures/Premios/PremioWololo.png");
		pesteMov[0] = peste;
		pesteMov[1] = peste;
		pesteMov[2] = peste;
		pesteMov[3] = peste;
		osoAtk[0] = oso;
		sheet = loadImage("/Textures/Animations/Treant attack.png");
		treantAtk [0] = sheet.getSubimage(0,0,64,64);
		treantAtk [1] = sheet.getSubimage(64,0,64,64);
		treantAtk [2] = sheet.getSubimage(128,0,64,64);
		treantAtk [3] = sheet.getSubimage(192,0,64,64);
		sheet = loadImage("/Textures/Animations/Goblin walk.png");
		goblinMove[0] = sheet.getSubimage(0, 0, 64, 64);
		goblinMove[1] = sheet.getSubimage(64, 0, 64, 64);
		goblinMove[2] = sheet.getSubimage(128, 0, 64, 64);
		goblinMove[3] = sheet.getSubimage(192, 0, 64, 64);
		sheet = loadImage("/Textures/Animations/Goblin attack.png");
		goblinAtk[0] = sheet.getSubimage(0, 0, 64, 64);
		goblinAtk[1] = sheet.getSubimage(64, 0, 64, 64);
		goblinAtk[2] = sheet.getSubimage(128, 0, 64, 64);
		goblinAtk[3] = sheet.getSubimage(192, 0, 64, 64);
		sheet = loadImage("/Textures/Animations/Warrior attack.png");
		warriorAtk[0] = sheet.getSubimage(0, 0, 64, 64);
		warriorAtk[1] = sheet.getSubimage(64, 0, 64, 64);
		warriorAtk[2] = sheet.getSubimage(128, 0, 64, 64);
		warriorAtk[3] = sheet.getSubimage(192, 0, 64, 64);
		sheet = loadImage("/Textures/Animations/Priest attack.png");
		monkAtk[0] = sheet.getSubimage(0, 0, 64, 64);
		monkAtk[1] = sheet.getSubimage(64, 0, 64, 64);
		monkAtk[2] = sheet.getSubimage(128, 0, 64, 64);
		monkAtk[3] = sheet.getSubimage(192, 0, 64, 64);
		sheet = loadImage("/Textures/Animations/Paladin attack.png");
		paladinAtk[0] = sheet.getSubimage(0, 0, 120, 80);
		paladinAtk[1] = sheet.getSubimage(120, 0, 120, 80);
		paladinAtk[2] = sheet.getSubimage(240, 0, 120, 80);
		paladinAtk[3] = sheet.getSubimage(360, 0, 120, 80);
		sheet = loadImage("/Textures/Animations/Druid attack.png");
		druidAtk[0] = sheet.getSubimage(0, 0, 64, 64);
		druidAtk[1] = sheet.getSubimage(64, 0, 64, 64);
		druidAtk[2] = sheet.getSubimage(128, 0, 64, 64);
		druidAtk[3] = sheet.getSubimage(192, 0, 64, 64);
		sheet = loadImage("/Textures/Animations/Archer attack.png");
		arqueroAtk[0] = sheet.getSubimage(0, 0, 64, 64);
		arqueroAtk[1] = sheet.getSubimage(64, 0, 64, 64);
		arqueroAtk[2] = sheet.getSubimage(128, 0, 64, 64);
		arqueroAtk[3] = sheet.getSubimage(192, 0, 64, 64);
		sheet = loadImage("/Textures/Animations/Mage attack.png");
		mageAtk[0] = sheet.getSubimage(0, 0, 64, 64);
		mageAtk[1] = sheet.getSubimage(64, 0, 64, 64);
		mageAtk[2] = sheet.getSubimage(128, 0, 64, 64);
		mageAtk[3] = sheet.getSubimage(192, 0, 64, 64);
		sheet = loadImage("/Textures/Animations/DwarfHunter attack.png");
		dwarfHunterAtk[0] = sheet.getSubimage(0, 0, 64, 64);
		dwarfHunterAtk[1] = sheet.getSubimage(64, 0, 64, 64);
		dwarfHunterAtk[2] = sheet.getSubimage(128, 0, 64, 64);
		dwarfHunterAtk[3] = sheet.getSubimage(192, 0, 64, 64);
		sheet = loadImage("/Textures/Animations/Warlock attack.png");
		warlockAtk[0] = sheet.getSubimage(0, 0, 64, 64);
		warlockAtk[1] = sheet.getSubimage(64, 0, 64, 64);
		warlockAtk[2] = sheet.getSubimage(128, 0, 64, 64);
		warlockAtk[3] = sheet.getSubimage(192, 0, 64, 64);
		sheet = loadImage("/Textures/Animations/Warlock Walk.png");
		warlockMove[0] = sheet.getSubimage(0, 0, 64, 64);
		warlockMove[1] = sheet.getSubimage(64, 0, 64, 64);
		warlockMove[2] = sheet.getSubimage(128, 0, 64, 64);
		warlockMove[3] = sheet.getSubimage(192, 0, 64, 64);
		gruntAtk[0] = grunt;
		gruntAtk[1] = grunt;
		gruntAtk[2] = grunt;
		gruntAtk[3] = grunt;
		sheet = loadImage("/Textures/Animations/OrcoWalk.png");
		gruntMove[0] = sheet.getSubimage(0, 0, 64, 64);
		gruntMove[1] = sheet.getSubimage(64, 0, 64, 64);
		gruntMove[2] = sheet.getSubimage(128, 0, 64, 64);
		gruntMove[3] = sheet.getSubimage(192, 0, 64, 64);
		sheet = loadImage("/Textures/Animations/PortalBlue.png");
		portalBlue[0] = sheet.getSubimage(0, 0, 64, 64);
		portalBlue[1] = sheet.getSubimage(width, 0, 64, 64);
		portalBlue[2] = sheet.getSubimage(2*width, 0, 64, 64);
		portalBlue[3] = sheet.getSubimage(3*width, 0, 64, 64);
		sheet = loadImage("/Textures/Animations/PortalOrange.png");
		portalOrange[0] = sheet.getSubimage(0, 0, 64, 64);
		portalOrange[1] = sheet.getSubimage(1*width, 0, 64, 64);
		portalOrange[2] = sheet.getSubimage(2*width, 0, 64, 64);
		portalOrange[3] = sheet.getSubimage(3*width, 0, 64, 64);
		aguaMov[0] = agua;
		aguaMov[1] = agua;
		aguaMov[2] = agua;
		aguaMov[3] = agua;
		sheet = loadImage("/Textures/Animations/Warchief walk.png");
		jefeOrcoMov[0] = sheet.getSubimage(0,0,120,80);
		jefeOrcoMov[1] = sheet.getSubimage(120, 0, 120, 80);
		jefeOrcoMov[2] = sheet.getSubimage(240, 0, 120, 80);
		jefeOrcoMov[3] = sheet.getSubimage(360, 0, 120, 80);
		jefeOrcoMov[4] = sheet.getSubimage(480, 0, 120, 80);
		jefeOrcoMov[5] = sheet.getSubimage(600, 0, 120, 80);
		jefeOrcoMov[6] = sheet.getSubimage(720, 0, 120, 80);
		jefeOrcoMov[7] = sheet.getSubimage(840, 0, 120, 80);
		orcoBallestaMov[0] = orcoBallestero;
		orcoBallestaMov[1] = orcoBallestero;
		orcoBallestaMov[2] = orcoBallestero;
		orcoBallestaMov[3] = orcoBallestero;
		orcoBallestaAtk[0] = orcoBallestero;
		orcoBallestaAtk[1] = orcoBallestero;
		orcoBallestaAtk[2] = orcoBallestero;
		orcoBallestaAtk[3] = orcoBallestero;
		sheet = loadImage("/Textures/Animations/DwarfChampion attack.png");
		campeonEnanoAtk[0] = sheet.getSubimage(0, 0, 64, 64);
		campeonEnanoAtk[1] = sheet.getSubimage(64, 0, 64, 64);
		campeonEnanoAtk[2] = sheet.getSubimage(128, 0, 64, 64);
		campeonEnanoAtk[3] = sheet.getSubimage(192, 0, 64, 64);	
		golemAtk[0] = loadImage("/Textures/Personajes/Golem.png");
		golemAtk[1] = loadImage("/Textures/Personajes/Golem.png");
		golemAtk[2] = loadImage("/Textures/Personajes/Golem.png");
		golemAtk[3] = loadImage("/Textures/Personajes/Golem.png");
		golemMov[0] = loadImage("/Textures/Personajes/Golem.png");
		golemMov[1] = loadImage("/Textures/Personajes/Golem.png");
		golemMov[2] = loadImage("/Textures/Personajes/Golem.png");
		golemMov[3] = loadImage("/Textures/Personajes/Golem.png");		
		golem = loadImage("/Textures/Personajes/Golem.png");
		barricada = loadImage("/Textures/Barricada.png");
		torre = loadImage("/Textures/Torre.png");
		torreAtk[0] = torre;
		torreAtk[1] = torre;
		torreAtk[2] = torre;
		torreAtk[3] = torre;
		sheet = loadImage("/Textures/Animations/Meteorito.png");
		efectoMeteorito[0] = sheet.getSubimage(0, 0, 200,512);
		efectoMeteorito[1] = sheet.getSubimage(200, 0, 200,512);
		efectoMeteorito[2] = sheet.getSubimage(400, 0, 200,512);
		efectoMeteorito[3] = sheet.getSubimage(600, 0, 200,512);
		efectoMeteorito[4] = sheet.getSubimage(800, 0, 200,512);
		efectoMeteorito[5] = sheet.getSubimage(1000, 0, 200,512);
		efectoMeteorito[6] = sheet.getSubimage(1200, 0, 200,512);
		efectoMeteorito[7] = sheet.getSubimage(1400, 0, 200,512);
		sheet = loadImage("/Textures/Animations/Shield.png");
		shield[0] = sheet.getSubimage(0, 0, 64, 64);
		shield[1] = sheet.getSubimage(64, 0, 64, 64);
		shield[2] = sheet.getSubimage(128, 0, 64, 64);
		shield[3] = sheet.getSubimage(192, 0, 64, 64);
		sheet = loadImage("/Textures/Animations/Explosion.png");
		bomb[0] = sheet.getSubimage(0, 0, 64, 64);
		bomb[1] = sheet.getSubimage(64, 0, 64, 64);
		bomb[2] = sheet.getSubimage(128, 0, 64, 64);
		bomb[3] = sheet.getSubimage(192, 0, 64, 64);
		bomb[4] = sheet.getSubimage(0, 64, 64, 64);
		bomb[5] = sheet.getSubimage(64, 64, 64, 64);
		bomb[6] = sheet.getSubimage(128, 64, 64, 64);
		bomb[7] = sheet.getSubimage(192, 64, 64, 64);
	}
	
 	/**
 	 * Carga una imagen a partir de un path
 	 * @param path
 	 * @return imagen
 	 */
	public static BufferedImage loadImage(String path){
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
}
