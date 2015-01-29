package controller;

import java.util.HashMap;
import java.util.Map;

public abstract class TCGCard {
	private int id;
	private String CardType;
	private String CardName;
	private String EnergyType;
	private String CollectionCardNumber;
	private String Expansion;
	
	public TCGCard(int id, String CardType, String CardName, String EnergyType,
			String CollectionCardNumber, String Expansion){
		this.id = id;
		this.CardType = CardType;
		this.CardName = CardName;
		this.EnergyType = EnergyType;
		this.CollectionCardNumber = CollectionCardNumber;
		this.Expansion = Expansion;
	}

	protected Map<String, String> getData(){
		Map<String, String> res = new HashMap<String, String>();
		res.put("id", Integer.toString(this.id));
		res.put("CardType", this.CardType);
		res.put("CardName", this.CardName);
		res.put("EnergyType", this.EnergyType);
		res.put("CollectionCardNumber", this.CollectionCardNumber);
		res.put("Expansion", this.Expansion);
		return res;
	}
	
	public int Identify(){
		return this.id;
	}
}
