package teamproject;

import java.util.ArrayList;

public class GradeAnalytics {
	
	private ArrayList<Float> list = new ArrayList<Float>();
	private int indexOfList;
	
	//These are the possible max/min
	private float maxPoss;
	private float minPoss;
	
	//These are the actual max/min determined by the txt file
	private float maxValue;
	private float minValue;
	private float averageValue;
	private float medianValue;
	
	private float totalForAve = 0;
	
	private float asCutOff = 89.5f;
	private float bsCutOff = 79.5f;
	private float csCutOff = 69.5f;
	private float dsCutOff = 59.5f;
	
	private int numberOfAs = 0;
	private int numberOfBs = 0;
	private int numberOfCs = 0;
	private int numberOfDs = 0;
	private int numberOfEs = 0;
	
	//first distribution Max Poss
	private int numberOf0sP = 0;
	private int numberOf10sP = 0;
	private int numberOf20sP = 0;
	private int numberOf30sP = 0;
	private int numberOf40sP = 0;
	private int numberOf50sP = 0;
	private int numberOf60sP = 0;
	private int numberOf70sP = 0;
	private int numberOf80sP = 0;
	private int numberOf90sP = 0;
	
	//second distribution Max Value
	private int numberOf0sV = 0;
	private int numberOf10sV = 0;
	private int numberOf20sV = 0;
	private int numberOf30sV = 0;
	private int numberOf40sV = 0;
	private int numberOf50sV = 0;
	private int numberOf60sV = 0;
	private int numberOf70sV = 0;
	private int numberOf80sV = 0;
	private int numberOf90sV = 0;
	
	
	public GradeAnalytics(ArrayList<Float> list) {
		this.list = list;
	}
	
	public float getMaxScore() {
		maxValue = list.get(0);
		for(indexOfList = 0; indexOfList < list.size(); indexOfList++) {
			if(maxValue < list.get(indexOfList)) {
				maxValue = list.get(indexOfList);
			}
		}
		return maxValue;
	}
	
	public float getMinScore() {
		minValue = list.get(0);
		for(indexOfList = 0; indexOfList < list.size(); indexOfList++) {
			if(minValue < list.get(indexOfList)) {
				minValue = list.get(indexOfList);
			}
		}
		return minValue;
	}
	
	public float getAverage() {
		for(indexOfList = 0; indexOfList < list.size(); indexOfList++) {
			totalForAve =+ list.get(indexOfList);
		}
		
		return averageValue;
	}
	
	public float getMedian() {
		//TODO
		return medianValue;
	}
	
	public void determineGrades() {
		//TODO - set amounts of each letter grade
	}
	
	public void setAsCutOff(float asCutOff) {
		this.asCutOff = asCutOff;
		
	}
	
	public void setBsCutOff(float bsCutOff) {
		this.bsCutOff = bsCutOff;
		
	}
	
	public void setCsCutOff(float csCutOff) {
		this.csCutOff = csCutOff;
		
	}
	
	public void setDsCutOff(float dsCutOff) {
		this.dsCutOff = dsCutOff;
		
	}
	
	public void addGrade(float addedGrade) {
		list.add(addedGrade);
	}
	
	/**Finds FIRST grade in list if exists, if not say DNE
	 * 
	 * @param deletedGrade
	 */
	public void deleteGrade(float deletedGrade) {
		indexOfList = 0;
		while (list.get(indexOfList) != deletedGrade || indexOfList < list.size()) {
			indexOfList++;
		}
		if (list.get(indexOfList) == deletedGrade) {
			list.remove(indexOfList);
		} else {
			System.out.println("Value not in List!");
			//Change probably
		}
	}
	
	public void replaceGrade(float deletedGrade, float newGrade) {
		indexOfList = 0;
		while (list.get(indexOfList) != deletedGrade || indexOfList < list.size()) {
			indexOfList++;
		}
		if (list.get(indexOfList) == deletedGrade) {
			list.set(indexOfList, newGrade);
		} else {
			System.out.println("Value not in List!");
			//Change probably
		}
	}
	
	public void distributionMaxPoss() {
		//TODO based on max poss. end in -P 
	}
	
	public void distributionMaxValue() {
		//TODO based on max value end in -V 
	}
	
	public String toString() {
		//TODO Summary of Everything
		return "";
	}
	
	
	
	

}
