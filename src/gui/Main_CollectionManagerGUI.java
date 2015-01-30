package gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import sync.Config;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
public class Main_CollectionManagerGUI {

	private JFrame frmCollectionManager;
	
	public Main_CollectionManagerGUI() {	
		this.GUIinitialize();
		Config conf = new Config();
		this.frmCollectionManager.setVisible(true);
	}
	
	private void GUIinitialize() {
		frmCollectionManager = new JFrame();
		frmCollectionManager.setIconImage(Toolkit.getDefaultToolkit().getImage(Config.getPathFavicon()));
		frmCollectionManager.setTitle("Collection Manager");
		frmCollectionManager.setResizable(false);
		frmCollectionManager.setBounds(100, 100, 600, 450);
		frmCollectionManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCollectionManager.getContentPane().setLayout(null);
		
		JLabel titleMainMenu = new JLabel("Main Menu");
		titleMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		titleMainMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		titleMainMenu.setBounds(0, 16, 580, 20);
		frmCollectionManager.getContentPane().add(titleMainMenu);
		
		JButton btnAddEnergy = new JButton("Add Energy\r\n");
		btnAddEnergy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddEnergy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DialogAddEnergy dialog = new DialogAddEnergy();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAddEnergy.setBounds(30, 120, 150, 64);
		frmCollectionManager.getContentPane().add(btnAddEnergy);
		
		JButton btnAddPokemon = new JButton("Add Pokemon \r\n");
		btnAddPokemon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DialogAddPokemon dialog = new DialogAddPokemon();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnAddPokemon.setBounds(210, 120, 150, 64);
		frmCollectionManager.getContentPane().add(btnAddPokemon);
		
		JButton btnAddItem = new JButton("Add Trainer");
		btnAddItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DialogAddTrainer dialog = new DialogAddTrainer();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAddItem.setBounds(390, 120, 150, 64);
		frmCollectionManager.getContentPane().add(btnAddItem);
		
		JButton buttonDeleteCard = new JButton("Delete Card");
		buttonDeleteCard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonDeleteCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DialogDeleteCard dialog = new DialogDeleteCard();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		buttonDeleteCard.setBounds(30, 280, 150, 64);
		frmCollectionManager.getContentPane().add(buttonDeleteCard);
		
		JButton btnShowAllCards = new JButton("Show All Cards");
		btnShowAllCards.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShowAllCards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DialogShowAllCards dialog = new DialogShowAllCards();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnShowAllCards.setBounds(210, 280, 150, 64);
		frmCollectionManager.getContentPane().add(btnShowAllCards);
		
		JButton btnShowAllEnergy = new JButton("Show All Energy\r\n");
		btnShowAllEnergy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShowAllEnergy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DialogShowAllEnergyCards dialog = new DialogShowAllEnergyCards();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnShowAllEnergy.setBounds(30, 200, 150, 64);
		frmCollectionManager.getContentPane().add(btnShowAllEnergy);
		
		JButton btwShowAllPokemon = new JButton("Show All Pokemons\n");
		btwShowAllPokemon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btwShowAllPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DialogShowAllPokemonCards dialog = new DialogShowAllPokemonCards();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btwShowAllPokemon.setBounds(210, 200, 150, 64);
		frmCollectionManager.getContentPane().add(btwShowAllPokemon);
		
		JButton btnShowAllItem = new JButton("Show All Trainers");
		btnShowAllItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DialogShowAllTrainerCards dialog = new DialogShowAllTrainerCards();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnShowAllItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShowAllItem.setBounds(390, 200, 150, 64);
		frmCollectionManager.getContentPane().add(btnShowAllItem);
		
		frmCollectionManager.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(frmCollectionManager, 
		            "Are you sure to close this window?", "Really Closing?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		        	Config.poke.saveDeck();
		            System.exit(0);
		        }
		    }
		});

	}
}
