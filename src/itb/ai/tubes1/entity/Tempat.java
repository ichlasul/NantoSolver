package itb.ai.tubes1.entity;

public class Tempat {

    private int energiBerkurang;
    
    private Jadwal jadwal;

    // ctor
    public Tempat() {
	energiBerkurang = 0;
    }

    public Tempat(int _jumlahEnergi) {
	energiBerkurang = _jumlahEnergi;
    }

    public int getEnergi() {
	return energiBerkurang;
    }
    public void setEnergi(int _jumlahEnergi) {
	energiBerkurang = _jumlahEnergi;
    }
    
    /**
     * @return the jadwal
     */
    public Jadwal getJadwal() {
        return jadwal;
    }

    /**
     * @param jadwal the jadwal to set
     */
    public void setJadwal(Jadwal jadwal) {
        this.jadwal = jadwal;
    }

}
