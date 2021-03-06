package data;

import java.util.HashMap;
import java.util.Map;

public class TrainerCard extends TCGCard {
	
	private String TrainerType;
	private String Description;
	private String TrainerRule;
	
	public TrainerCard(int id, String CardName, String CollectionCardNumber, String Expansion, String TrainerType, String Description, String TrainerRule) {
		super(id, "Trainer", CardName, "Colorless", CollectionCardNumber, Expansion);
		this.TrainerType = TrainerType;
		this.Description = Description;
		this.TrainerRule = TrainerRule;
	}

	public Map<String, String> getData(){
		Map<String,String> res = new HashMap<String,String>();
		res.put("TrainerType", this.TrainerType);
		res.put("Description", this.Description);
		res.put("TrainerRule", this.TrainerRule);
		res.putAll(super.getData());
		return res;
	}
}
