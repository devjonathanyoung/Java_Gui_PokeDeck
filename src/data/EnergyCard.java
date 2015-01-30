package data;

import java.util.Map;

public class EnergyCard extends TCGCard {

	public EnergyCard(int id,String EnergyType, String CollectionCardNumber, String Expansion) {
		super(id, "Energy", GenerateEnergyCardName(EnergyType), EnergyType, CollectionCardNumber, Expansion);
	}
	
	public Map<String, String> getData(){
		return super.getData();
	}
	
	private static String GenerateEnergyCardName(String EnergyType){
		return "Energy of " + EnergyType;
	}
}
