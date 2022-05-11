import java.util.Scanner;

public class Battleground {

	static final int MAX_HEALTH_POINTS = 100;
	static final int MAX_NUM_ROUNDS = 10;
	static final int MAX_ATK = 50;
	static final int MAX_SPEED = 100;
	
	static final int MIN = 1;
	
	static final int MAX_DEF = 50;
	
	static Warrior firstWarrior;
	static Warrior secondWarrior;
	static Scanner myScan;
	
	public static void main(String[] args) {

		System.out.println("Player 1, build your warrior.");
		firstWarrior = buildWarrior();
		
		System.out.println("Player 2, build your warrior.");
		secondWarrior = buildWarrior();

		int speed1 = firstWarrior.getSpeed();
		int speed2 = secondWarrior.getSpeed();
		if (speed1 < speed2) {			
			Warrior temp = firstWarrior;	
			firstWarrior = secondWarrior;
			secondWarrior = temp;
		}

		boolean isWinner = false;
		for (int i = 0; i < MAX_NUM_ROUNDS && !isWinner; i++) {
			if (i % 2 == 0) {						
				int random = (int)(Math.random()*10);
				if (random > 0) {
					firstWarrior.attack(secondWarrior);
				} else {
					firstWarrior.specialMoveAttack(secondWarrior);
				}
				
				if(determineWinner() != null) {
					isWinner = true;
					break;
				}
			}
			
			if (i % 2 == 1) {
				int random = (int)(Math.random()*10); {
					if (random > 0) {
						secondWarrior.attack(firstWarrior);
					} else {
						secondWarrior.specialMoveAttack(firstWarrior);
					}
				}
				
				if(determineWinner() != null) {
					isWinner = true;
					break;
				}
			}
			
		}

		if (determineWinner() != null) {
			System.out.println("The winner is " + determineWinner().getName());
		} else {
			System.out.println("It's a tie. There is no winner.");
		}
		
	
	}

	public static Warrior buildWarrior() {
		myScan = new Scanner(System.in);
		Warrior myWarrior = new Warrior();
		
		System.out.println("Name your warrior");		
		String name = myScan.nextLine();
		
		boolean isValid = false;
		while (!isValid) {
			System.out.println("Press 1 for a Cowboy, 2 for a Ninja");
			int input = myScan.nextInt();
			
			if (input == 1) {
				myWarrior = new Cowboy();
				myWarrior.setName(name);
				isValid = true;
			} else if (input == 2) {
				myWarrior = new Ninja();
				myWarrior.setName(name);
				isValid = true;
			} else {
				System.out.println("Your input is invalid. Please try again.");
			}
		}
		
		
		isValid = false;
		while (!isValid) {
			System.out.println("Set the attackLevel to an integer between 1 and 50 \n" +
					"Your defenseLevel will be (50 - attackLevel)");
			int myInput = myScan.nextInt();

			if (myInput > MIN && myInput < MAX_ATK) {
				myWarrior.setAttackLevel(myInput);
				myWarrior.setDefenseLevel(MAX_ATK - myInput);
				isValid = true;
			} 
		}
		
		isValid = false;
		while (!isValid) {
			System.out.println("Set your speed to an integer between 1 and 100 \n" +
							"Your healthPoints will be (100 - speed)");
			int myInput = myScan.nextInt();
			
			if (myInput > MIN && myInput < MAX_HEALTH_POINTS) {
				myWarrior.setSpeed(myInput);
				myWarrior.setHealthPoints(MAX_HEALTH_POINTS - myInput);
				isValid = true;
			}
		}
		
		return myWarrior;
	}
	
	public static Warrior determineWinner() {
		if (firstWarrior.getHealthPoints() < 0) {
			return firstWarrior;
		}
		if (secondWarrior.getHealthPoints() < 0) {
			return secondWarrior;
		}
		return null;		
	}

}
