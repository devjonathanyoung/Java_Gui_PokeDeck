package controller;

import java.util.Map;

public class PokemonCard extends TCGCard{
		
	private int HP;
	private String EvolStage;
	
	public PokemonCard(int id,String CardName,String EnergyType, String CollectionCardNumber, String Expansion, int HP, String EvolStage) {
		super(id, "Pokemon", CardName, EnergyType, CollectionCardNumber, Expansion);
		this.HP = HP;
		this.EvolStage = EvolStage;
	}
	
	public Map<String, String> getData(){
		Map<String,String> res = super.getData();
		res.put("HP", Integer.toString(this.HP));
		res.put("EvolStage", this.EvolStage);
		return res;
	}
}
