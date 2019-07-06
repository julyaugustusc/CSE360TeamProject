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
	private float maxPoss = 100;
	private float minPoss = 0;
	
	public FileInput(File file) {
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
	
	public void setMaxPoss(float maxPoss) {
		this.maxPoss = maxPoss;
	}
	
	public void setMinPoss(float minPoss) {
		this.minPoss = minPoss;
	}
	
	public ArrayList<Float> getFloatFileList(){
		return list;
	}

}
