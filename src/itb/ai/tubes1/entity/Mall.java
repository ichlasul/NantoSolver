package itb.ai.tubes1.entity;

public class Mall extends Tempat {

    private int money;
    
    public Mall() {
	super();
	money = 0;
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

}
