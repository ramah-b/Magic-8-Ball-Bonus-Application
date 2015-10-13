package Magic8BallApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.ArrayList;
import java.util.HashMap;

public class Magic8BallRemembers extends Magic8Ball {
	
	private HashMap<String, String> userQuestions;
	//private ArrayList<String> userAnswers;
	private int indexCounter;
	
	public Magic8BallRemembers(){
		 super();
		 this.userQuestions = new HashMap<String, String>();
		 this.readHistory();
		 //this.userAnswers = new ArrayList<String>();
		 this.indexCounter = 0;
		 
	}
	
	public int getIndexCounter(){
		return this.indexCounter;
	}
	
	public String shakeIt(String userQuestion){
		String userAnswer = "";
		boolean found = false;
		for (String key : userQuestions.keySet()){
			if (key.equals(userQuestion)){
				userAnswer = userQuestions.get(key);
				found = true;
				break;
			}
		}
		if (!found){
		userAnswer = super.shakeIt();
		userQuestions.put(userQuestion, userAnswer);
		
		}
		this.indexCounter++;
		return userAnswer;
		
	}
	
	
	public void printHistory(){
		
			 for (String key : userQuestions.keySet()){
			System.out.println(key + "\n" +  userQuestions.get(key));
			System.out.println();
		
		}
	}
	
	private void readHistory(){
		
		//System.out.println("read from a file");
		String filename = (System.getProperty("user.dir") + File.separatorChar +"magic8BallHistory.txt");
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			while (line != null) {
				//System.out.println(line);
				String[] question_answer_pair = line.split("\t");
				userQuestions.put(question_answer_pair[0], question_answer_pair[1]);
				//System.out.println("KV Pair:" + question_answer_pair[0] + " " + question_answer_pair[1]);
				
				//the key is in key_value_pair[0]
				//the value is in key_value_pair[1]
				// now you could add it back to the hash map if it isn't there already
				
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("File does not exist!");
		}
	}
	
	public void writeHistory(){
	    //System.out.println("writing keys and values to a file");
	    String filename = (System.getProperty("user.dir") + File.separatorChar +"magic8BallHistory.txt");
		//System.out.println(filename);
	        
	    PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File(filename));
			System.out.println("Histry was saved successfully.");
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist!");
		}
		
		//print both the key and the value on same line
		// for each key in the key set write the key, a tab and the value
		for (String key : userQuestions.keySet()) {
			//System.out.println("write this line: " + key);
	    	writer.println(key + "\t" + userQuestions.get(key));
	    }
		writer.close();
	}

}
