import View.gui.CollectionManagerGUI;

import java.awt.EventQueue;

public class Main_Pokedeck {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CollectionManagerGUI window = new CollectionManagerGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
