package model;

public class KnightsLogic {
	/**
	 * Take damage removes 10 health from knight
	 * if the knight has armor remove armor instead
	 * @param knight
	 * @return current health
	 */
	public int takeDamage(Knight knight) {
		int damage = 10;
		if (knight.getArmour() > 0){
		knight.setArmour(knight.getArmour() - damage);
		return knight.getHealth();
		}
		knight.setHealth(knight.getHealth() - damage);
		return knight.getHealth();
	}
	
	public void giveArmour(Knight knight) {
		int armour = 50;
		knight.setArmour(armour);
	}
	
	public boolean hasArmour(Knight knight) {
		return knight.getArmour() > 0;
	}
}
