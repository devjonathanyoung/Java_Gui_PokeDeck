package Controller.master;

import java.awt.EventQueue;

import Modele.data_management.PokeDeckDB;
import View.gui.CollectionManagerGUI;

/*
 * This class opens the GUI and contains the link to the Pokedeck Database 
 */
public class Ctrl_Pokedeck {
		
	public static PokeDeckDB DECK;
	
	public Ctrl_Pokedeck(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DECK = new PokeDeckDB();
					CollectionManagerGUI window = new CollectionManagerGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
