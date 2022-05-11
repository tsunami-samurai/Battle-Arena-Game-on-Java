
public class Ninja extends Warrior {

	public String specialMove;
	
	public Ninja() {
		super();
		specialMove = "Shuriken Onslaught";
	}
	
	public boolean specialMoveAttack(final Warrior opponent) {
		opponent.healthPoints -= this.attackLevel;
		return true;	
	}

}
