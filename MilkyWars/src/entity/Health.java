package entity;

public class Health {

	private double maxHealth;
	private double currentHealth;

	public Health(double maxHealth, double currentHealth) {
		this.maxHealth = maxHealth;
		this.currentHealth = currentHealth;
	}

	public double getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(double maxHealth) {
		this.maxHealth = maxHealth;
	}

	public double getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(double currentHealth) {
		this.currentHealth = currentHealth;
	}

}
