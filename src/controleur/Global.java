package controleur;

/**
 * Regroupement des constantes de l'application
 * @author Bianchi Marius
 *
 */
public interface Global {
	
	public static final Integer PORT = 6666 ;
	
	// fichiers
	public static final String
		SEPARATOR = "//",
		CHEMIN = "media" + SEPARATOR,
		CHEMINFONDS = CHEMIN + "fonds" + SEPARATOR,
		CHEMINPERSOS = CHEMIN + "personnages" + SEPARATOR,
		CHEMINMURS = CHEMIN + "murs" + SEPARATOR,
		CHEMINBOULES = CHEMIN + "boules" + SEPARATOR,
		CHEMINSONS = CHEMIN + "sons/",
		EXTIMAGE = ".gif" ;

	// images
	public static final String
	FONDEQUIPE = CHEMINFONDS + "fondequipe.jpg",
	FONDCHOIX = CHEMINFONDS + "fondchoix.jpg",	
	FONDARENE = CHEMINFONDS+"fondarene.jpg",
	MONSTER = CHEMINPERSOS + "monster",
	KNIGHT = CHEMINPERSOS + "knight",
	BOULE = CHEMINBOULES + "boule.gif",
	MUR = CHEMINMURS + "mur.gif" ;
	
	// sons
	public static final String
	SONSELECT = CHEMINSONS + "select.wav", // clic sur un bouton 
	SONGO = CHEMINSONS + "go.wav", // sur le clic du bouton go
	SONWELCOME = CHEMINSONS + "dintro.wav", // à l'entrée de la frame ChoixJoueur
	SONWIND = CHEMINSONS + "wind2.wav",
	SONAMBIANCE = CHEMINSONS + "ambiance.wav" ; // son d'ambiance dans tout le jeu
	
	public static final Integer
		KNIGHTFIGHT = 0,
		KNIGHTHURT = 1,
		KNIGHTDEATH = 2,
		MONSTERGFIGHT = 3,
		MONSTERGHURT = 4,
		MONSTERGDEATH = 5,
		MONSTERSFIGHT = 6,
		MONSTERSHURT = 7,
		MONSTERSDEATH = 8,
		MONSTERDFIGHT = 9,
		MONSTERDHURT = 10,
		MONSTERDDEATH = 11,
		MONSTERSAFIGHT = 12,
		MONSTERSAHURT = 13,
		MONSTERSADEATH = 14;
	public static final String[] 
		SON = {"Kfight.wav", "Khurt.wav", "Kdeath.wav","M1fight.wav","M1hurt.wav","M1death.wav","M2fight.wav","M2hurt.wav","M2death.wav","M3fight.wav","M3hurt.wav","M3death.wav","M4fight.wav","M4hurt.wav","M4death.wav"} ;

	
	// personnages
	public static final int
		GAUCHE = 0,
		DROITE = 1,
		HAUT = 2,
		BAS = 3,
		TIRE = 4,
		NBETATSMARCHE = 4,
		NBETATSBLESSE = 2,
		NBETATSMORT = 2,
		LEPAS = 10, // nombre de pixels de déplacement d'un pas
		NBPERSOS = 4,
		H_MESSAGE = 8,
		H_PERSO = 44,
		L_PERSO = 39 ;
	public static final String
		MARCHE = "marche",
		BLESSE = "touche",
		MORT = "mort" ;
	
	// messages serveurs
	public static final String SEPARE = "~" ;
	public static final int
		PSEUDO = 0,
		CHAT = 1,
		ACTION = 2 ;
	
	// tailles dans frames
	public static final int
		H_ARENE = 600,
		L_ARENE = 800,
		H_CHAT = 200,
		H_SAISIE = 25,
		MARGE = 5 ; // écarts entre les objets
	
	// murs
	public static final int
		NBMURS = 20, // nombre de murs
		H_MUR = 35, // hauteur du mur
		L_MUR = 34 ; // largeur du mur
	
	// boule
	public static final int
	H_BOULE = 17, // hauteur de la boule
	L_BOULE = 17 ; // largeur de la boule
	
	
}
