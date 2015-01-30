package data;

import java.util.HashMap;
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
		Map<String,String> res = new HashMap<String,String>();
		res.put("HP", Integer.toString(this.HP));
		res.put("EvolStage", this.EvolStage);
		res.putAll(super.getData());
		return res;
	}
}
