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
	
	public FileInput(String fileName) {
		this.fileName = fileName;
		file = new File(fileName);
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
	
	public FileInput(File selectedFile, float minPoss2, float maxPoss2) {
		// TODO Auto-generated constructor stub
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
