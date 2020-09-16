package model;

public class Knight {
	private String name;
	private int armour;
	private int health;

	public Knight() {
		super();
	}
	public Knight(String name) {
		super();
		this.name = name;
		this.armour = 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getArmour() {
		return armour;
	}
	public void setArmour(int armour) {
		this.armour = armour;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
}
