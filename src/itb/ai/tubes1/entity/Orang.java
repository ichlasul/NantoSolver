package itb.ai.tubes1.entity;

/**
 * Class Orang
 */
public class Orang {
	
	/**
	 * Strength yang dimiliki
	 */
	protected int strength;
	
	/**
	 * Charm yang dimiliki
	 */
	protected int charm;
	
	/**
	 * Brain yang dimiliki
	 */
	protected int brain;
	
	public Orang() {
		strength = 0;
		charm = 0;
		brain = 0;
	}
	
	public Orang(int strength, int charm, int brain) {
		this.strength = strength;
		this.charm = charm;
		this.brain = brain;
	}
}
