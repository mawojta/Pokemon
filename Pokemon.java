
public abstract class Pokemon {
	
	protected String name;
	protected int health;
	protected int power;
	protected int level;
	
	public Pokemon(String name, int health, int power, int level) {
		this.name = name;
		
		if(health >= 0) {
			this.health = health;
		} else {
			health = 0;
		}
		
		if(power >= 0) {
			this.power = power;
		} else {
			power = 0;
		}		
		
		if(level >= 0) {
			this.level = level;
		} else {
			level = 0;
		}		
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public void setHealth(int health) {
		if(health >= 0) {
			this.health = health;
		}
	}
	
	public int getPower() {
		return this.power;
	}
	
	public void setPower(int power) {
		if(power >= 0) {
			this.power = power;
		}
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public void setLevel(int level) {
		if(level >= 0) {
			this.level = level;
		}
	}
	
	boolean isDefeated() {
		if(this.health > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	//TODO
	/*The hurt method takes an int argument (the damage to be dealt) that is to be subtracted from 
	the health only if the argument	passed in is positive and the pokemon isDefeated() returns false. 
	If the value is negative or isDefeated returns true nothing happens, because if we subtracted 
	this value from	the health it would actually heal them or you are attacking something that is dead! 
	If the attack is greater than the current health value, health is set to zero. Health should
	never be negative.*/
	protected void hurt(int damage) {
		if(damage > 0) {
			if(damage > this.health) {
				this.health = 0;
			} else {
				this.health = health - damage;	
			}
		}
	}
	
	//DONE
	/*	The attack method should call the hurt method of the target Pokemon to decrease the health of 
	the target Pokemon. The argument that is going to be passed will be either thunderBolt or fireBall. 
	Both are of type int that represent the amount that will be taken from the target Pokemon’s health 
	for a single hurt. The amount of damage the attacking Pokemon’s special attack does will be	subtracted 
	from their power after they attack. If their power is zero and specialAttack is called, you must call 
	physicalAttack instead. This check can be done in specialAttack method. If either Pokemon isDefeated, 
	meaning health is 0, nothing is to be done.*/
	public abstract void specialAttack(Pokemon target);
	
	//DONE
	/*This method is similar to specialAttack except that it does not need to check its power
	level for how much damage to deal, it always deals the same amount of damage to the
	target based on which Pokemon is attacking. If either Pokemon isDefeated, nothing happens.*/ 
	public abstract void physicalAttack(Pokemon target);	
}