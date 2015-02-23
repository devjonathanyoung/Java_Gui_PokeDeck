package Controller.master;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

/* 
 	This class provide the items to Load in each combobox
 	and the path to use to find the Favicon
 */
public class Config {
	
	//Returns the options for the energyList combobox
	public static List<String> getEnergyList(){
		List<String> energyList = new ArrayList<String>();
		energyList.add("Grass");
		energyList.add("Fire");
		energyList.add("Water");
		energyList.add("Lightning");
		energyList.add("Psychic");
		energyList.add("Fighting");
		energyList.add("Darkness");
		energyList.add("Metal");
		energyList.add("Fairy");
		energyList.add("Dragon");
		energyList.add("Colorless");
		return energyList;
	}
	
	//Returns the options for the EvolutionStage combobox
	public static List<String> getEvolStageList(){
		List<String> evolStageList = new ArrayList<String>();
		evolStageList.add("Baby Pokemon");
		evolStageList.add("Basic Pokemon");
		evolStageList.add("Stage 1 Pokemon");
		evolStageList.add("Stage 2 Pokemon");
		return evolStageList;
	}
	
	/*
	 * Read the file containing the list of all expansion
	 * Returns the options for the Expansion combobox read in the file
	 */
	
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
	
	/*
	 * Read the file containing the list of all possible trainer Type
	 * Returns the options for the Trainer Type combobox read in the file
	 */
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
	
	/*
	 *  Next 4 functions fills each Combobox with the options loaded in the previous 
	 *  functions
	 */
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
	
	//Returns the path for application Favicon
	public static String getPathFavicon(){
		return(Paths.get("Ressources", "faviconPokedeck.gif").toString());
	}
}
