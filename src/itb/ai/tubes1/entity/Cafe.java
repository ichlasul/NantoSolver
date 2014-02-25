package itb.ai.tubes1.entity;

public class Cafe extends Tempat {

    private int charm;
    
    public Cafe() {
	super();
	charm = 0;
    }

    public Cafe(int _jumlahEnergi, int money) {
	super(_jumlahEnergi);
	this.charm = money;
    }

    /**
     * @return the charm
     */
    public int getCharm() {
        return charm;
    }

    /**
     * @param charm the charm to set
     */
    public void setCharm(int charm) {
        this.charm = charm;
    }
}
