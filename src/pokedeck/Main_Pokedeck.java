package pokedeck;

import gui.Main_CollectionManagerGUI;

import java.awt.EventQueue;

public class Main_Pokedeck {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_CollectionManagerGUI window = new Main_CollectionManagerGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
