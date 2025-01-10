public abstract class Kendaraan {
    protected String platNomor;
    protected int durasi;
    protected static int totalKendaraan = 0;
    protected static int kapasitas;

    public Kendaraan(String platNomor, int durasi) {
        this.platNomor = platNomor;
        this.durasi = durasi;
        totalKendaraan++;
    }

    public abstract void hitungBiaya();

    public static boolean cekKapasitas() {
        return totalKendaraan < kapasitas;
    }

    public static void setKapasitas(int kap) {
        kapasitas = kap;
    }

    // Method baru untuk mendapatkan sisa kapasitas
    public static int getSisaKapasitas() {
        return kapasitas - totalKendaraan;
    }

    // Method baru untuk mendapatkan total kapasitas
    public static int getKapasitas() {
        return kapasitas;
    }

    // Method baru untuk mendapatkan total kendaraan
    public static int getTotalKendaraan() {
        return totalKendaraan;
    }
}