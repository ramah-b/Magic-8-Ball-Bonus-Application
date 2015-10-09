package Magic8BallApp;

import java.util.Random;

public class Magic8Ball {
	
	private String[] answersArray = new String[21];
	
	
	public Magic8Ball(){
		
		answersArray[0] = "It is certain";
		answersArray[1] = "It is decidedly so";
		answersArray[2] = "Without a doubt";
		answersArray[3] = "Yes - definitely";
		answersArray[4] = "You may rely on it";
		answersArray[5]= "As I see it, yes";
		answersArray[6] = "Most likely";
		answersArray[7] = "Outlook good";
		answersArray[8] = "Signs point to yes";
		answersArray[9] = "Yes";
		answersArray[10] = "Reply hazy, try again";
		answersArray[11] = "Ask again later";
		answersArray[12] = "Better not tell you now";
		answersArray[13] = "Cannot predict now";
		answersArray[14] = "Concentrate and ask again";
		answersArray[15] = "8-BALL ERROR!";
		answersArray[16] = "Don't count on it";
		answersArray[17] = "My reply is no";
		answersArray[18] = "My sources say no";
		answersArray[19] = "Outlook not so good";
		answersArray[20] = "Very doubtful";

	}



	public String shakeIt() {

		Random r = new Random();

		int randomNum = r.nextInt(20);

			return answersArray[randomNum];

		
	}

}
