package itb.ai.tubes1.entity;

public class University extends Tempat {

	private int brain;

	public University() {
		super();
		energiBerkurang = 15;
		brain = 3;
	}

	public University(int _jumlahEnergi, int money) {
		super(_jumlahEnergi);
		this.brain = money;
	}

	/**
	 * @return the brain
	 */
	public int getBrain() {
		return brain;
	}

	/**
	 * @param brain
	 *            the brain to set
	 */
	public void setBrain(int brain) {
		this.brain = brain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "University [Brain=" + brain + ", EnergiBerkurang="
				+ energiBerkurang + ",Jadwal=" + jadwal + "]";
	}

}
