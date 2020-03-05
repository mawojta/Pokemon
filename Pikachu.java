
public class Pikachu extends Pokemon {

	private static final int thunderBolt = 6;
	private static final int swipe = 3;
	
	public Pikachu(int health, int power, int level) {
		super("Pikachu", health, power, level);
	}
	
	public String toString() {
		return this.name + " [name=" + this.name + ", health=" + this.health + ", power=" + this.power + ", level=" + this.level + "]";
	}
	
	public boolean equals(Object other) {
		if(other instanceof Pokemon) {
			Pokemon o = (Pokemon)other;
			if(this.name.equals(o.getName()) && this.health == o.getHealth() && this.power == o.getPower() && this.level == o.getLevel()) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	//DONE
	/*	The attack method should call the hurt method of the target Pokemon to decrease the health of 
	the target Pokemon. The argument that is going to be passed will be either thunderBolt or fireBall. 
	Both are of type int that represent the amount that will be taken from the target Pokemon’s health 
	for a single hurt. The amount of damage the attacking Pokemon’s special attack does will be	subtracted 
	from their power after they attack. If their power is zero and specialAttack is called, you must call 
	physicalAttack instead. This check can be done in specialAttack method. If either Pokemon isDefeated, 
	meaning health is 0, nothing is to be done.*/
	@Override
	public void specialAttack(Pokemon target) {
		if(this.power > 0 && this.health > 0 && target.isDefeated() == false && this.isDefeated() == false) {
			if(power > thunderBolt) {
				target.hurt(thunderBolt);
				power = power - thunderBolt;
			} else if(this.health > 0){
				target.hurt(power);
				power = 0;
			}
		} else if(target.isDefeated() == false && this.isDefeated() == false) {
			physicalAttack(target);
		}
	}
	
	@Override
	public void physicalAttack(Pokemon target) {
		if(this.health > 0 && target.isDefeated() == false && this.isDefeated() == false) {
			target.hurt(swipe);	
		}
	}
}
