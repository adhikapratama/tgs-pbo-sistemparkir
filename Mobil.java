
public class Mobil extends Kendaraan {

    private int biayaPerJam;

    public Mobil(String platNomor, int durasi, int biayaPerJam) {
        super(platNomor, durasi);
        this.biayaPerJam = biayaPerJam;
    }

    @Override
    public void hitungBiaya() {
        int totalBiaya = durasi * biayaPerJam;
        System.out.println("Biaya parkir Mobil " + platNomor + ": Rp " + totalBiaya);
    }
}
