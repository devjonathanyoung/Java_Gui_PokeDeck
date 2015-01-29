package sync;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class IdManager {
	
	private int currentId;
	private List<Integer> freeIds;
	
	public IdManager(){
		this.currentId = 0;
		freeIds = new ArrayList<Integer>();
		URI filePath = Paths.get("Ressources", "idManagerData.txt").toUri();
		try {
			List<String> lines = Files.readAllLines(Paths.get(filePath));
			if(lines.size() > 1){
				this.currentId = Integer.parseInt(lines.get(0));
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
	
	public int getNextId(){
		if(this.freeIds.isEmpty()){
			this.currentId++;
			return this.currentId;
		}
		else{
			return freeIds.remove(0);
		}
	}
	public void newFreeIndex(int i){
		this.freeIds.add(i);
	}
	
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
