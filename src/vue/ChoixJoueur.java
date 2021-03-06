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

/**
 * Frame du choix du joueur
 * @author Bianchi Marius
 *
 */
public class ChoixJoueur extends JFrame implements Global {

	// propri?t?s
	private Integer numPerso ;
	private Integer numEquipe;
	private Controle controle ;
	
	// objets graphiques
	private JPanel contentPane;
	private JTextField txtPseudo;
	private JLabel lblPersonnage;
	
	// sons
	private Son select;
	private Son go;

	/**
	 * Affichage du personnage
	 */
	private void affichePerso() {
		if (numEquipe == 1) {
			lblPersonnage.setIcon(new ImageIcon(MONSTER+numPerso+MARCHE+"1d1"+EXTIMAGE));			
		}else {
			lblPersonnage.setIcon(new ImageIcon(KNIGHT+numPerso+MARCHE+"1d1"+EXTIMAGE));	
		}
	}
	
	/**
	 * Clic sur la fl?che "pr?c?dent"
	 */
	private void lblPrecedent_clic() {
		select.play();
		numPerso = ((numPerso+2)%NBPERSOS)+1;
		affichePerso();
	}
	
	/**
	 * Clic sur la fl?che "suivant"
	 */
	private void lblSuivant_clic() {
		select.play();
		numPerso = (numPerso%NBPERSOS)+1 ;
		affichePerso();
	}
	
	/**
	 * Clic sur GO
	 */
	private void lblGo_clic() {
		// contr?le si le pseudo a ?t? saisi
		if (txtPseudo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "La saisie du pseudo est obligatoire");
			txtPseudo.requestFocus();
		}else{
			ChoixEquipe.getWelcome().close();
			ChoixEquipe.getWind().close();
			go.play();
			(new Son(SONAMBIANCE)).playContinue();
			controle.evenementVue(this, PSEUDO+SEPARE+txtPseudo.getText()+SEPARE+numPerso+SEPARE+numEquipe);
		}
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
	public ChoixJoueur(Controle controle,int numEquipe) {
		this.numEquipe = numEquipe;
		setTitle("Choice Character");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrecedent = new JLabel("");
		lblPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblPrecedent_clic();
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
		
		JLabel lblSuivant = new JLabel("");
		lblSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSuivant_clic();
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
		
		JLabel lblGo = new JLabel("");
		lblGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblGo_clic();
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
		
		lblPersonnage = new JLabel("");
		lblPersonnage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonnage.setBounds(133, 73, 129, 132);
		contentPane.add(lblPersonnage);
		
		txtPseudo = new JTextField();
		txtPseudo.setBounds(133, 228, 129, 20);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
		
		lblGo.setBounds(285, 217, 105, 46);
		contentPane.add(lblGo);
		lblSuivant.setBounds(285, 124, 25, 46);
		contentPane.add(lblSuivant);
		lblPrecedent.setBounds(75, 125, 31, 45);
		contentPane.add(lblPrecedent);
		
		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, 400, 275);
		lblFond.setIcon(new ImageIcon(FONDCHOIX));
		contentPane.add(lblFond);
		
		// positionnement sur la zone de saisie
		txtPseudo.requestFocus();
		
		// initialisations
		this.controle = controle ;
		numPerso = 1; // premier personnage par d?faut
		affichePerso(); // affichage du premier personnage
		
		// gestion des sons
		select = new Son(SONSELECT);
		go = new Son(SONGO);
	}
}
