package itb.ai.tubes1.entity;

public class Gymnasium extends Tempat {

    private int strength;
    
    public Gymnasium() {
	super();
	strength = 0;
    }

    public Gymnasium(int _jumlahEnergi, int money) {
	super(_jumlahEnergi);
	this.strength = money;
    }

    /**
     * @return the strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * @param strength the strength to set
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }
}
