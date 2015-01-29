package controller;

import java.util.ArrayList;
import java.util.List;

import sync.IdManager;

public class PokeDeck {
	private List<TCGCard> Deck;
	private IdManager Idm;
	
	public PokeDeck(){
		this.Deck = new ArrayList<TCGCard>();
		this.Idm = new IdManager();
	}
	
	public boolean addCard(String[] cardData){
		if(cardData[0].equals("Energy")){
			this.Deck.add(new EnergyCard(this.Idm.getNextId(),cardData[1],cardData[2],cardData[3]));
		}
		else if(cardData[0].equals("Pokemon")){
			this.Deck.add(new PokemonCard(this.Idm.getNextId(),cardData[1],cardData[2],cardData[3],cardData[4],Integer.parseInt(cardData[5]),cardData[6]));
		}
		else if(cardData[0].equals("Item")){
			this.Deck.add(new TrainerCard(this.Idm.getNextId(),cardData[1],cardData[2],cardData[3],cardData[4],cardData[5],cardData[6]));
		}
		else{
			return false;
		}
		return true;
	}
	public boolean remove(int id){
		for(TCGCard c:Deck){
			if(c.Identify() == id){
				Deck.remove(c);
				return true;
			}
		}
		return false;
	}
}
