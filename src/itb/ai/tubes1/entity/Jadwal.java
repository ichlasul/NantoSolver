package itb.ai.tubes1.entity;

import java.util.ArrayList;

/**
 * Class yang menyimpan data jadwal, bisa jadwal cewek atau tempat
 */
public class Jadwal {

	/**
	 * Jumlah minggu, di testcase 2
	 */
	public static int JUMLAH_MINGGU;

	/**
	 * Jumlah hari, default 7
	 */
	public static int JUMLAH_HARI = 7;

	/**
	 * Jumlah jam, default 12
	 */
	public static int JUMLAH_JAM = 12;

	/**
	 * Data array yang menyimpan jadwal
	 */
	private ArrayList<Boolean> data;

	public Jadwal() {
		data = new ArrayList<Boolean>();
	}

	public ArrayList<Boolean> getList() {
		return data;
	}

	public void add(Boolean available) {
		data.add(available);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String buf = "";
		for (Boolean bol : data) {
			if (bol) {
				buf += "1";
			} else {
				buf += "0";
			}
		}
		return "Jadwal [data=" + buf + "]";
	}
}
