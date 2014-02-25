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
     * Jumlah jam, default 2
     */
    public static int JUMLAH_JAM = 2;
    
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

}
