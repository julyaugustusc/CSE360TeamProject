/**
 *  @author Augustus Crosby
 *  Class: CSE 360
 *  Assignment: Team Project
 *  Description: Determines all the analytics associated with the inputed grades
 *  	Takes an arraylist and maxPoss and minPoss in constructor. Can determine maxValue, 
 *  	minValue, average, median, number of each letter grade, and 2 different distributions. 
 */

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
	private ArrayList<Float> orderedList = new ArrayList<Float>();
	private int indexOfOrderedList;
	
	//default values
	private float asCutOff = 89.5f;
	private float bsCutOff = 79.5f;
	private float csCutOff = 69.5f;
	private float dsCutOff = 59.5f;
	
	private float topOfBs = asCutOff - 0.1f;
	private float topOfCs = bsCutOff - 0.1f;
	private float topOfDs = csCutOff - 0.1f;
	private float topOfEs = dsCutOff - 0.1f;
	
	private int numberOfAs;
	private int numberOfBs;
	private int numberOfCs;
	private int numberOfDs;
	private int numberOfEs;
	
	//first distribution Max Poss
	private int numberOf0sP;
	private int numberOf10sP;
	private int numberOf20sP;
	private int numberOf30sP;
	private int numberOf40sP;
	private int numberOf50sP;
	private int numberOf60sP;
	private int numberOf70sP;
	private int numberOf80sP;
	private int numberOf90sP;
	
	//second distribution Max Value
	private int numberOf0sV;
	private int numberOf10sV;
	private int numberOf20sV;
	private int numberOf30sV;
	private int numberOf40sV;
	private int numberOf50sV;
	private int numberOf60sV;
	private int numberOf70sV;
	private int numberOf80sV;
	private int numberOf90sV;
	
	/**Constructor that allows user not to import a txt file
	 * 
	 * @param minPoss
	 * @param maxPoss
	 */
	public GradeAnalytics(float minPoss, float maxPoss) {
		this.minPoss = minPoss;
		this.maxPoss = maxPoss;
	}
	
	/**Constructor that sets minPoss and maxPoss from FileInput (?)
	 * 
	 * @param list
	 * @param minPoss
	 * @param maxPoss
	 */
	public GradeAnalytics(ArrayList<Float> list, float minPoss, float maxPoss) {
		this.list = list;
		this.minPoss = minPoss;
		this.maxPoss = maxPoss;
	}
	
	public void setList(ArrayList<Float> list) {
		this.list = list;
	}
	
	public ArrayList<Float> getList() {
		return list;
	}
	
	/** Determines max score received 
	 * 
	 */
	public void setMaxScore() {
		maxValue = list.get(0);
		for(indexOfList = 0; indexOfList < list.size(); indexOfList++) {
			if(maxValue < list.get(indexOfList)) {
				maxValue = list.get(indexOfList);
			}
		}
	}
	
	/** Determines min score received 
	 * 
	 */
	public void setMinScore() {
		minValue = list.get(0);
		for(indexOfList = 0; indexOfList < list.size(); indexOfList++) {
			if(minValue < list.get(indexOfList)) {
				minValue = list.get(indexOfList);
			}
		}
	}
	
	/** Determines average
	 * 
	 */
	public void setAverage() {
		for(indexOfList = 0; indexOfList < list.size(); indexOfList++) {
			totalForAve =+ list.get(indexOfList);
		}
		averageValue = totalForAve / list.size();
	}
	
	/** Determines median. 
	 * 
	 * Creates an ordered list to do so. Each value of list added to orderedList 
	 * and the index for the ordered list acts as a parse to find where the list 
	 * value should be added each time. Not the most efficient, but could be 
	 * valuable to have orderedList.
	 * 
	 */
	public void setMedian() {
		orderedList.add(list.get(0));
		
		for(indexOfList = 1; indexOfList < list.size(); indexOfList++) {
			indexOfOrderedList = 0;
			
			while (orderedList.get(indexOfOrderedList) != null || 
					list.get(indexOfList) < orderedList.get(indexOfOrderedList)) {
				indexOfOrderedList++;
			}
			//parses list, until find a place to insert. If end, it will see that it's null and exit as well
			//then insert into place
	
			orderedList.add(indexOfOrderedList, list.get(indexOfList));
			//Check cause this might not work? I think it should.
		}
		
		if (orderedList.size() % 2 == 0) { //if even amount of numbers, average between 2 middle numbers
			medianValue = (orderedList.get((orderedList.size() / 2) - 1) + 
					orderedList.get((orderedList.size() / 2) - 1)) / 2; 
		} else { //if odd, get median
			medianValue = orderedList.get(orderedList.size() / 2);
		}
	}
	
	/** 
	 * 
	 * @return maxValue
	 */
	public float getMaxScore() {
		return maxValue;
	}
	
	/**
	 * 
	 * @return minValue
	 */
	public float getMinScore() {
		return minValue;
	}
	
	/**
	 * 
	 * @return averageValue
	 */
	public float getAverage() {
		return averageValue;
	}
	
	/**
	 * 
	 * @return medianValue
	 */
	public float getMedian() {
		return medianValue;
	}
	
	/** Determines the number of each letter grade
	 * 
	 */
	public void determineGrades() {
		//reset
		numberOfAs = 0;
		numberOfBs = 0;
		numberOfCs = 0;
		numberOfDs = 0;
		numberOfEs = 0;
		
		for(indexOfList = 0; indexOfList < list.size(); indexOfList++) {
			if(list.get(indexOfList) / maxPoss < dsCutOff) {
				numberOfEs++;
			} else if(list.get(indexOfList) / maxPoss < csCutOff) {
				numberOfDs++;
			} else if(list.get(indexOfList) / maxPoss < bsCutOff) {
				numberOfCs++;
			} else if(list.get(indexOfList) / maxPoss < asCutOff) {
				numberOfBs++;
			} else {
				numberOfAs++;
			}
			indexOfList++;
		}
		
	}
	
	/**
	 * 
	 * @return numberOfAs
	 */
	public float getNumberofAs() {
		return numberOfAs;
	}
	
	/**
	 * 
	 * @return numberOfBs
	 */
	public float getNumberofBs() {
		return numberOfBs;
	}
	
	/**
	 * 
	 * @return numberOfCs
	 */
	public float getNumberofCs() {
		return numberOfCs;
	}
	
	/**
	 * 
	 * @return numberOfDs
	 */
	public float getNumberofDs() {
		return numberOfDs;
	}
	
	/**
	 * 
	 * @return numberOfEs
	 */
	public float getNumberofEs() {
		return numberOfEs;
	}
	
	/** Sets the cut off for As if applicable. 
	 * 
	 */
	public void setAsCutOff(float asCutOff) {
		this.asCutOff = asCutOff;
		
	}
	
	/** Sets the cut off for Bs if applicable. 
	 * 
	 */
	public void setBsCutOff(float bsCutOff) {
		this.bsCutOff = bsCutOff;
		
	}
	
	/** Sets the cut off for Cs if applicable. 
	 * 
	 */
	public void setCsCutOff(float csCutOff) {
		this.csCutOff = csCutOff;
		
	}
	
	/** Sets the cut off for Ds if applicable. 
	 * 
	 */
	public void setDsCutOff(float dsCutOff) {
		this.dsCutOff = dsCutOff;
		
	}
	
	/** Changes upper range of grades if cutoffs change
	 * 
	 */
	public void determineTop() {
		topOfBs = asCutOff - 0.1f;
		topOfCs = bsCutOff - 0.1f;
		topOfDs = csCutOff - 0.1f;
		topOfEs = dsCutOff - 0.1f;
	}
	
	/**Allows user to add a grade to end of Arraylist.
	 * 
	 * @param addedGrade
	 */
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
	
	/**Replaces first found deletedGrade with newGrade, if DNE outputs DNE
	 * 
	 * @param deletedGrade
	 * @param newGrade
	 */
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
	
	/** Determines distribution as a result of MaxPoss
	 * 
	 */
	public void distributionMaxPoss() {
		//based on max value end in -P 
		//Again, check
		
		//reset
		numberOf0sP = 0;
		numberOf10sP = 0;
		numberOf20sP = 0;
		numberOf30sP = 0;
		numberOf40sP = 0;
		numberOf50sP = 0;
		numberOf60sP = 0;
		numberOf70sP = 0;
		numberOf80sP = 0;
		numberOf90sP = 0;
		
		for(indexOfList = 0; indexOfList < list.size(); indexOfList++) {
			if((list.get(indexOfList) - minPoss) / (maxPoss - minPoss) < 10.0f) {
				numberOf0sP++;
			} else if((list.get(indexOfList) - minPoss) / (maxPoss - minPoss) < 20.0f) {
				numberOf10sP++;
			} else if((list.get(indexOfList) - minPoss) / (maxPoss - minPoss) < 30.0f) {
				numberOf20sP++;
			} else if((list.get(indexOfList) - minPoss) / (maxPoss - minPoss) < 40.0f) {
				numberOf30sP++;
			} else if((list.get(indexOfList) - minPoss) / (maxPoss - minPoss) < 50.0f) {
				numberOf40sP++;
			} else if((list.get(indexOfList) - minPoss) / (maxPoss - minPoss) < 60.0f) {
				numberOf50sP++;
			} else if((list.get(indexOfList) - minPoss) / (maxPoss - minPoss) < 70.0f) {
				numberOf60sP++;
			} else if((list.get(indexOfList) - minPoss) / (maxPoss - minPoss) < 80.0f) {
				numberOf70sP++;
			} else if((list.get(indexOfList) - minPoss) / (maxPoss - minPoss) < 90.0f) {
				numberOf80sP++;
			} else if((list.get(indexOfList) - minPoss) / (maxPoss - minPoss) < 100.0f) {
				numberOf90sP++;
			}
			indexOfList++;
		}
		
		
	}
	
	/** Determines distribution as a result of MaxPoss
	 * 
	 */
	public void distributionMaxValue() {
		//based on max value end in -V 
		//Again, check
		
		//reset
		numberOf0sV = 0;
		numberOf10sV = 0;
		numberOf20sV = 0;
		numberOf30sV = 0;
		numberOf40sV = 0;
		numberOf50sV = 0;
		numberOf60sV = 0;
		numberOf70sV = 0;
		numberOf80sV = 0;
		numberOf90sV = 0;
		
		for(indexOfList = 0; indexOfList < list.size(); indexOfList++) {
			if((list.get(indexOfList) - minValue) / (maxValue - minValue) < 10.0f) {
				numberOf0sV++;
			} else if((list.get(indexOfList) - minValue) / (maxValue - minValue) < 20.0f) {
				numberOf10sV++;
			} else if((list.get(indexOfList) - minValue) / (maxValue - minValue) < 30.0f) {
				numberOf20sV++;
			} else if((list.get(indexOfList) - minValue) / (maxValue - minValue) < 40.0f) {
				numberOf30sV++;
			} else if((list.get(indexOfList) - minValue) / (maxValue - minValue) < 50.0f) {
				numberOf40sV++;
			} else if((list.get(indexOfList) - minValue) / (maxValue - minValue) < 60.0f) {
				numberOf50sV++;
			} else if((list.get(indexOfList) - minValue) / (maxValue - minValue) < 70.0f) {
				numberOf60sV++;
			} else if((list.get(indexOfList) - minValue) / (maxValue - minValue) < 80.0f) {
				numberOf70sV++;
			} else if((list.get(indexOfList) - minValue) / (maxValue - minValue) < 90.0f) {
				numberOf80sV++;
			} else if((list.get(indexOfList) - minValue) / (maxValue - minValue) < 100.0f) {
				numberOf90sV++;
			}
			indexOfList++;
		}		
	}
	
	/** Determines final values of all necessary method to show in summary to be called at any time
	 * 
	 * @return String
	 */
	public String toString() {
		//all of this so that it can be outputted at any time.
		setMaxScore();
		setMinScore();
		setAverage();
		setMedian();
		determineGrades();
		determineTop();
		distributionMaxPoss();
		distributionMaxValue();
		
		return "Summary of Statistics:" 
				+ "\n\nMinimum Possible: " + minPoss + "\tMaximum Possible: " + maxPoss
				+ "\n\nMinimum Recieved: " + minValue + "\tMaximum Recieved: " + maxValue 
				+ "\tAverage: " + averageValue + "\tMedian: " + medianValue
				+ "\n\nGrades:"
				+ "\nNumber of As " + asCutOff + " - 100%: " + numberOfAs
				+ "\nNumber of Bs " + bsCutOff + "% - " + topOfBs + "%: " + numberOfBs
				+ "\nNumber of Cs " + csCutOff + "% - " + topOfCs + "%: " + numberOfCs
				+ "\nNumber of Ds " + dsCutOff + "% - " + topOfDs + "%: " + numberOfDs
				+ "\nNumber of Es " + "0.0% - " + topOfEs + "%: " + numberOfEs
				+ "\n\nDistribution based on Maximum Possible: "
				+ "\nFirst 10%: " + numberOf0sP + "\tSecond 10%: " + numberOf10sP + "\tThird 10%: " + numberOf20sP
				+ "\tFourth 10%: " + numberOf30sP + "\tFifth 10%: " + numberOf40sP
				+ "\nSixth 10%: " + numberOf50sP + "\tSeventh 10%: " + numberOf60sP + "\tEight 10%: " + numberOf70sP
				+ "\tNinth 10%: " + numberOf80sP + "\tLast 10%: " + numberOf90sP
				+ "\n\nDistribution based on Maximum Value: "
				+ "\nFirst 10%: " + numberOf0sV + "\tSecond 10%: " + numberOf10sV + "\tThird 10%: " + numberOf20sV
				+ "\tFourth 10%: " + numberOf30sV + "\tFifth 10%: " + numberOf40sV
				+ "\nSixth 10%: " + numberOf50sV + "\tSeventh 10%: " + numberOf60sV + "\tEight 10%: " + numberOf70sV
				+ "\tNinth 10%: " + numberOf80sV + "\tLast 10%: " + numberOf90sV;
	}
	
	
	
	

}
