package vue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controle;
import controleur.Global;
import outils.son.Son;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

/**
 * Frame du choix du joueur
 * @author Bianchi Marius
 *
 */
public class ChoixEquipe extends JFrame implements Global {
	// propriétés
	private Integer numEquipe ;
	private Controle controle ;
	
	private JPanel contentPane;
	
	// sons
	private Son select;
	private static Son welcome;
	private static Son wind;
	
	/**
	 * Clic sur la flèche "précédent"
	 */
	private void lblMonster_clic() {
		select.play();
		controle.evenementVue(this, 1);
	}
	
	/**
	 * Clic sur la flèche "suivant"
	 */
	private void lblKnight_clic() {
		select.play();
		controle.evenementVue(this, 2);
	}
	
	/**
	 * Change l'apparence de la souris en "normal"
	 */
	private void souris_normale() {
		contentPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	
	/**
	 * Change l'apparence de la souris en "doigt"
	 */
	private void souris_doigt() {
		contentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	/**
	 * Create the frame.
	 * @param controle 
	 */
	public ChoixEquipe(Controle controle) {
		setTitle("Choice Team");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMonster = new JLabel("");
		lblMonster.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblMonster_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				souris_doigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				souris_normale();
			}
		});
		
		JLabel lblKnight = new JLabel("");
		lblKnight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblKnight_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				souris_doigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				souris_normale();
			}
		});
		
		lblKnight.setBounds(236, 101, 110, 162);
		contentPane.add(lblKnight);
		lblMonster.setBounds(54, 101, 110, 162);
		contentPane.add(lblMonster);
		
		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, 400, 275);
		lblFond.setIcon(new ImageIcon(FONDEQUIPE));
		contentPane.add(lblFond);
		
		// positionnement sur la zone de saisie
		
		// initialisations
		this.controle = controle ;
		
		// gestion des sons
		select = new Son(SONSELECT);
		welcome = new Son(SONWELCOME);
		wind = new Son(SONWIND);
		welcome.play();
		wind.playContinue();
	}
	
	public static Son getWelcome() {
		return welcome;
	}
	
	public static Son getWind() {
		return wind;
	}
}
