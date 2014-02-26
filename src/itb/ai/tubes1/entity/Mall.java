package itb.ai.tubes1.entity;

public class Mall extends Tempat {

    private int money;
    
    public Mall() {
	super();
	energiBerkurang = 8;
	money = 10000;
    }

    public Mall(int _jumlahEnergi, int money) {
	super(_jumlahEnergi);
	this.money = money;
    }

    /**
     * @return the money
     */
    public int getMoney() {
        return money;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(int money) {
        this.money = money;
        
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Mall [Money=" + money + ", EnergiBerkurang=" + energiBerkurang
		+ ", Jadwal=" + jadwal + "]";
    }
}
