
public class Motor extends Kendaraan {

    private int biayaPerJam;

    public Motor(String platNomor, int durasi, int biayaPerJam) {
        super(platNomor, durasi);
        this.biayaPerJam = biayaPerJam;
    }

    @Override
    public void hitungBiaya() {
        int totalBiaya = durasi * biayaPerJam;
        System.out.println("Biaya parkir Motor " + platNomor + ": Rp " + totalBiaya);
    }
}
