package Magic8BallApp;


import java.util.Scanner;

public class Magic8BallApp {
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		String userQuestion, userAnswer;


		System.out.println("MAGIC 8 BALL APPLICATION");

		System.out
				.print("Ask me any question. When done, you can enter 'q' to quit: ");
		userQuestion = keyboard.nextLine().toLowerCase();
		
		Magic8BallRemembers myMagic = new Magic8BallRemembers();

		do {
			
			if (!userQuestion.equals("q")) {
				
				userAnswer = myMagic.shakeIt(userQuestion);
				System.out.println(userAnswer);
				
				System.out.print("\nAnother question? ");
				userQuestion = keyboard.nextLine().toLowerCase();
			
			}

		} while (!userQuestion.equals("q"));
		
		System.out.println("\nYou have quitted.");
		//myMagic.printHistory();
		myMagic.writeHistory();
		
		
		keyboard.close();
	}

}
