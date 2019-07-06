package teamproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInput {
	
	private ArrayList<Float> list = new ArrayList<Float>();
	private String fileName;
	private File file;
	private Scanner scanner;
	
	private float input;
	private float maxPoss;
	private float minPoss;
	
	public FileInput(File file, float maxPoss, float minPoss) {
		this.maxPoss = maxPoss;
		this.minPoss = minPoss;
		
		this.file = file;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list.clear(); // Make sure not adding onto anything else
		
		while (scanner.hasNext()) {
			if (scanner.hasNextFloat()) {
				input = scanner.nextFloat();
				if (input < minPoss || input > maxPoss) {
					//TODO, some sort of error?
				} else {
					list.add(input);
				}
			} else {
				scanner.next();
			}
		}
			
	}
	
	public float getMaxPoss() {
		return maxPoss;
	}
	
	public float getMinPoss() {
		return minPoss;
	}
	
	public ArrayList<Float> getFloatFileList(){
		return list;
	}

}
