package itb.ai.tubes1.entity;

public class University extends Tempat {

    private int brain;
    
    public University() {
	super();
	brain = 0;
    }

    public University(int _jumlahEnergi, int money) {
	super(_jumlahEnergi);
	this.brain = money;
    }

    /**
     * @return the money
     */
    public int getMoney() {
        return brain;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(int money) {
        this.brain = money;
    }

}
