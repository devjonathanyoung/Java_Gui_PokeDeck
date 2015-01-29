package sync;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import controller.PokeDeck;

public class Config {
	
	public static PokeDeck poke = new PokeDeck();
	
	public static List<String> getEnergyList(){
		List<String> energyList = new ArrayList<String>();
		energyList.add("Grass");
		energyList.add("Fire");
		energyList.add("Water");
		energyList.add("Lightning");
		energyList.add("Psychic");
		energyList.add("Fightning");
		energyList.add("Darkness");
		energyList.add("Metal");
		energyList.add("Fairy");
		energyList.add("Dragon");
		energyList.add("Colorless");
		return energyList;
	}
	public static List<String> getEvolStageList(){
		List<String> evolStageList = new ArrayList<String>();
		evolStageList.add("Baby Pokemon");
		evolStageList.add("Basic Pokemon");
		evolStageList.add("Stage 1 Pokemon");
		evolStageList.add("Stage 2 Pokemon");
		return evolStageList;
	}
	public static List<String> getExpansionList(){
		List<String> expansionList = new ArrayList<String>();
		URI filePath = Paths.get("Ressources", "ExpansionList.txt").toUri();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for(int i = 0;i<lines.size();i++){
            	expansionList.add((i+1) + " - " + lines.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }		
		return expansionList;
	}
	public static List<String> getTrainerTypeList(){
		List<String> trainerTypeList = new ArrayList<String>();
		URI filePath = Paths.get("Ressources", "TrainerTypeList.txt").toUri();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for(int i = 0;i<lines.size();i++){
            	trainerTypeList.add(lines.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }		
		return trainerTypeList;
	}
	public static Object[][] fetchAllData() {
		Object[][] data = {
			    {new Integer(0), "Energy","Darkness Energy", "Darkness","3/102","Base Set"},
			    {new Integer(1), "Pokemon","Bulbasaur", "Grass","32/104", "Base Set"}
			};
		return data;
	}
	public static Object[][] fetchEnergyCardsData() {
		Object[][] data = {
			    {new Integer(2), "Energy of Darkness", "Darkness",
			    	"1/102","Base Set"},
			    {new Integer(3), "Energy of Grass", "Grass",
			    	"2/102","Base Set"}
			};
		return data;
	}
	public static Object[][] fetchPokemonCardsData() {
		Object[][] data = {
			    {new Integer(3), "Pikachu", "Lightning",new Integer(200), "Basic Pokemon","22/102","Base Set"},
			    {new Integer(4), "Bulbasaur", "Grass",new Integer(150), "Basic Pokemon","32/104", "Base Set"}
			};
		return data;
	}
	public static Object[][] fetchTrainerCardsData() {
		Object[][] data = {
			    {new Integer(5), "Pokeball", "Item",
			    	"Flip a coin. If heads, search your deck for a Pokemon and put it in your hand", 
			    	"You may play as many item card as you like during your turn",
			    	"90/102","Base Set"},
			    {new Integer(6), "Potion", "Item",
			    		"Heal 30 Damage from 1 of your Pokemon",
			    		"You may play as many item card as you like during your turn",
				    	"89/102","Base Set"}
			};
		return data;
	}
	public static JComboBox<String> fillCBoxEnergyList(JComboBox<String> combobox){
		List<String> Elist = Config.getEnergyList();
		for(String energyType:Elist){
			combobox.addItem(energyType);
		}
		return combobox;
	}
	public static JComboBox<String> fillCBoxEvolStageList(JComboBox<String> combobox){
		List<String> EvolList = Config.getEvolStageList();
		for(String evolStage:EvolList){
			combobox.addItem(evolStage);
		}
		return combobox;
	}
	public static JComboBox<String> fillCBoxExpansionList(JComboBox<String> combobox){
		List<String> ExpansionList = Config.getExpansionList();
		for(String expansion:ExpansionList){
			combobox.addItem(expansion);
		}
		return combobox;
	}
	public static JComboBox<String> fillCBoxTrainerTypeList(JComboBox<String> combobox){
		List<String> TrainerTypeList = Config.getTrainerTypeList();
		for(String trainerType:TrainerTypeList){
			combobox.addItem(trainerType);
		}
		return combobox;
	}
	

}
