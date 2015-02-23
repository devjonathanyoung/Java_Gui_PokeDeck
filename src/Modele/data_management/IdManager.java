package Modele.data_management;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/*
 * Each card have an Id when saved
 * So this class makes sure we do not have gap between id
 * but also we do not have 2 different card with the same id
 * unless the user tampers with the files it should be bulletproof 
 */
public class IdManager {
	
	private int currentId;
	private List<Integer> freeIds;
	
	public IdManager(){
		this.currentId = 0;
		freeIds = new ArrayList<Integer>();
		URI filePath = Paths.get("Ressources", "idManagerData.txt").toUri();
		try {
			List<String> lines = Files.readAllLines(Paths.get(filePath));
			if(lines.size() > 0){
				this.currentId = Integer.parseInt(lines.get(0));
			}
			if(lines.size() > 1){
				String lineFreeIds = lines.get(1);
				String[] splited = lineFreeIds.split(",");
				for(String id: splited){
					freeIds.add(Integer.parseInt(id));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Check if we have a freeId (of a card we removed) and returns it
	 * or returns the next id of the current deck
	 */
	public int getNextId(){
		if(this.freeIds.isEmpty()){
			this.currentId++;
			return this.currentId;
		}
		else{
			return freeIds.remove(0);
		}
	}
	
	//When a Card is erased we make sure to store the free Id to avoid gaps between ids
	public void newFreeIndex(int i){
		this.freeIds.add(i);
	}
	
	//Let's make sure next time we open the program we do not lose our ids
	public void saveIdManagerData(){
		Path f = Paths.get("Ressources", "idManagerData.txt");
		try {
			Files.write(f, (this.currentId + "\n").getBytes());
			if(!freeIds.isEmpty()){
				String export = "";
				for(int i:freeIds){
					export += (i + ",");
				}
				export = export.substring(0, export.length() - 1);
				Files.write(f, export.getBytes(), StandardOpenOption.APPEND);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
