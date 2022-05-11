
public class Cowboy extends Warrior {

	public String specialMove;
	
	public Cowboy() {
		super();
		specialMove = "Fast Draw";
	}
	public boolean specialMoveAttack(final Warrior opponent) {
		speed = Battleground.MAX_SPEED;
		int attackHelper = speed / 4;
		
		if (opponent.defenseLevel > this.attackLevel) {
			opponent.defenseLevel -= (DEFENSE_DAMAGE + attackHelper);
			return false;
		}
		
		opponent.healthPoints -= (this.attackLevel + attackHelper) - opponent.defenseLevel;
		return true;
	}
}
