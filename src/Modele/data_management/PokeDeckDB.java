package Modele.data_management;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Modele.data.*;
import Modele.data_management.IdManager;

public class PokeDeckDB {
	private List<TCGCard> Deck;
	private IdManager Idm;
	
	public PokeDeckDB(){
		this.Deck = new ArrayList<TCGCard>();
		this.Idm = new IdManager();
		this.loadDeck();
	}
	
	public boolean addCard(String[] cardData){
		if(cardData[0].equals("Energy")){
			this.Deck.add(new EnergyCard(this.Idm.getNextId(),cardData[1],cardData[2],cardData[3]));
		}
		else if(cardData[0].equals("Pokemon")){
			this.Deck.add(new PokemonCard(this.Idm.getNextId(),cardData[1],cardData[2],cardData[3],cardData[4],Integer.parseInt(cardData[5]),cardData[6]));
		}
		else if(cardData[0].equals("Trainer")){
			this.Deck.add(new TrainerCard(this.Idm.getNextId(),cardData[1],cardData[2],cardData[3],cardData[4],cardData[5],cardData[6]));
		}
		else{
			return false;
		}
		return true;
	}
	
	public boolean remove(int id){
		for(TCGCard c:this.Deck){
			if(Integer.parseInt(c.getData().get("id")) == id){
				this.Deck.remove(c);
				this.Idm.newFreeIndex(id);
				return true;
			}
		}
		return false;
	}
	public List<TCGCard> fetchCards(String cardType){
		List<TCGCard> res = new ArrayList<TCGCard>();
		for(TCGCard c:Deck){
			if(c.getData().get("CardType").equals(cardType)){
				res.add(c);
			}
			else if(cardType.equalsIgnoreCase("all")){
				return Deck;
			}
		}
		return res;
	}
	public void saveDeck(){
		this.Idm.saveIdManagerData();
		Path f = Paths.get("Ressources", "DB_TCGCard.txt");
		String export = "";
		try {
			Files.write(f, "".getBytes());
			for(TCGCard c: Deck){
				export = "";
				Map<String, String> cardData = c.getData();
				for(String key: cardData.keySet()){
					export += (cardData.get(key) + ",");
				}
				export = export.substring(0, export.length() - 1);
				export = export + "\n";
				Files.write(f, export.getBytes(), StandardOpenOption.APPEND);
			}
			
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void loadDeck(){
		URI filePath = Paths.get("Ressources", "DB_TCGCard.txt").toUri();
		String[] splited;
		try {
			List<String> lines = Files.readAllLines(Paths.get(filePath));
			if(lines.size() > 0){
				for(String line:lines){
					splited = line.split(",");
					if(splited[1].equals("Energy")){
						this.Deck.add(new EnergyCard(Integer.parseInt(splited[3]), splited[2], splited[5], splited[4]));
					}
					else if(splited[2].equals("Pokemon")){
						this.Deck.add(new PokemonCard(Integer.parseInt(splited[5]) , splited[0], splited[3], splited[7], splited[6], Integer.parseInt(splited[4]), splited[1]));
					}
					else if(splited[3].equals("Trainer")){
						this.Deck.add(new TrainerCard(Integer.parseInt(splited[5]), splited[1], splited[8], splited[7], splited[0], splited[2], splited[6]));
					}
					else{
						System.err.println("error");
					}
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Object[][] fetchAllData() {
		List<TCGCard> EnergyData = this.fetchCards("All");
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
	
	public Object[][] fetchEnergyCardsData() {
		List<TCGCard> EnergyData = this.fetchCards("Energy");
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
	
	public Object[][] fetchPokemonCardsData() {
		List<TCGCard> EnergyData = this.fetchCards("Pokemon");
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
	public Object[][] fetchTrainerCardsData() {
		List<TCGCard> TrainerData = this.fetchCards("Trainer");
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
}
