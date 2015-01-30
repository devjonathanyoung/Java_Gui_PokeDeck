package sync;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import data.PokeDeckDB;
import data.TCGCard;

public class Config {
	
	public static PokeDeckDB poke;
	
	public Config(){
		poke = new PokeDeckDB();
	}
	
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
		List<TCGCard> EnergyData = poke.fetchCards("All");
		Object[][] data = new Object[EnergyData.size()][6];
		for(int i = 0; i < EnergyData.size(); i++){
			data[i][0] = new Integer(EnergyData.get(i).getData().get("id"));
			data[i][1] = EnergyData.get(i).getData().get("CardType");
			data[i][2] = EnergyData.get(i).getData().get("CardName");
			data[i][3] = EnergyData.get(i).getData().get("EnergyType");
			data[i][4] = EnergyData.get(i).getData().get("CollectionCardNumber");
			data[i][5] = EnergyData.get(i).getData().get("Expansion");
		}
		return data;
	}
	
	public static Object[][] fetchEnergyCardsData() {
		List<TCGCard> EnergyData = poke.fetchCards("Energy");
		Object[][] data = new Object[EnergyData.size()][5];
		for(int i = 0; i < EnergyData.size(); i++){
			data[i][0] = new Integer(EnergyData.get(i).getData().get("id"));
			data[i][1] = EnergyData.get(i).getData().get("CardName");
			data[i][2] = EnergyData.get(i).getData().get("EnergyType");
			data[i][3] = EnergyData.get(i).getData().get("CollectionCardNumber");
			data[i][4] = EnergyData.get(i).getData().get("Expansion");
		}
		return data;
	}
	
	public static Object[][] fetchPokemonCardsData() {
		List<TCGCard> EnergyData = poke.fetchCards("Pokemon");
		Object[][] data = new Object[EnergyData.size()][7];
		for(int i = 0; i < EnergyData.size(); i++){
			data[i][0] = new Integer(EnergyData.get(i).getData().get("id"));
			data[i][1] = EnergyData.get(i).getData().get("CardName");
			data[i][2] = EnergyData.get(i).getData().get("EnergyType");
			data[i][3] = EnergyData.get(i).getData().get("HP");
			data[i][4] = EnergyData.get(i).getData().get("EvolStage");
			data[i][5] = EnergyData.get(i).getData().get("CollectionCardNumber");
			data[i][6] = EnergyData.get(i).getData().get("Expansion");
		}
		return data;
	}
	public static Object[][] fetchTrainerCardsData() {
		List<TCGCard> TrainerData = poke.fetchCards("Trainer");
		Object[][] data = new Object[TrainerData.size()][7];
		for(int i = 0; i < TrainerData.size(); i++){
			data[i][0] = new Integer(TrainerData.get(i).getData().get("id"));
			data[i][1] = TrainerData.get(i).getData().get("CardName");
			data[i][2] = TrainerData.get(i).getData().get("TrainerType");
			data[i][3] = TrainerData.get(i).getData().get("Description");
			data[i][4] = TrainerData.get(i).getData().get("TrainerRule");
			data[i][5] = TrainerData.get(i).getData().get("CollectionCardNumber");
			data[i][6] = TrainerData.get(i).getData().get("Expansion");
		}
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
	
	public static String getPathFavicon(){
		return(Paths.get("Ressources", "faviconPokedeck.gif").toString());
	}
}
