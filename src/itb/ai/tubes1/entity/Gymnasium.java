package itb.ai.tubes1.entity;

public class Gymnasium extends Tempat {

    private int strength;
    
    public Gymnasium() {
	super();
	energiBerkurang = 12;
	strength = 2;
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Gymnasium [Strength=" + strength + ", EnergiBerkurang="
		+ energiBerkurang + ", Jadwal=" + jadwal + "]";
    }
}
