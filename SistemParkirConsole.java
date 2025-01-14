import java.io.Console;
import java.util.regex.Pattern;

public class SistemParkirConsole {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.out.println("Console tidak tersedia!");
            return;
        }

        try {
            String kapasitasStr = console.readLine("Masukkan kapasitas parkir: ");
            int kapasitas = Integer.parseInt(kapasitasStr);
            Kendaraan.setKapasitas(kapasitas);

            boolean lanjut = true;
            while (lanjut) {
                // Menampilkan sisa kapasitas di awal setiap iterasi
                console.format("\nSisa kapasitas parkir: %d\n", Kendaraan.getSisaKapasitas());

                if (!Kendaraan.cekKapasitas()) {
                    console.format("Parkir penuh!\n");
                    break;
                }

                String tipeStr = console.readLine("Masukkan tipe kendaraan (1: Mobil, 2: Motor): ");
                int tipe = Integer.parseInt(tipeStr);

                String platNomor = console.readLine("Masukkan plat nomor (format XX-9999-XXX): ");

                if (!Pattern.matches("[A-Z]{2}-\\d{4}-[A-Z]{3}", platNomor)) {
                    throw new IllegalArgumentException("Format plat nomor tidak valid!");
                }

                String durasiStr = console.readLine("Masukkan durasi parkir (jam): ");
                int durasi = Integer.parseInt(durasiStr);

                String biayaStr = console.readLine("Masukkan biaya per jam: ");
                int biayaPerJam = Integer.parseInt(biayaStr);

                if (tipe == 1) {
                    Mobil mobil = new Mobil(platNomor, durasi, biayaPerJam);
                    mobil.hitungBiaya();
                } else if (tipe == 2) {
                    Motor motor = new Motor(platNomor, durasi, biayaPerJam);
                    motor.hitungBiaya();
                }

                // Menampilkan sisa kapasitas setelah parkir
                console.format("Sisa kapasitas parkir sekarang: %d\n", Kendaraan.getSisaKapasitas());

                String jawaban = console.readLine("Lanjut entry? (y/n): ");
                lanjut = jawaban.equalsIgnoreCase("y");
            }

            // Menampilkan ringkasan akhir
            console.format("\n=== Ringkasan Parkir ===\n");
            console.format("Total kapasitas: %d\n", Kendaraan.getKapasitas());
            console.format("Sisa kapasitas: %d\n", Kendaraan.getSisaKapasitas());
            console.format("Terpakai: %d\n", (Kendaraan.getKapasitas() - Kendaraan.getSisaKapasitas()));

        } catch (NumberFormatException e) {
            console.format("Error: Input harus berupa angka!\n");
        } catch (IllegalArgumentException e) {
            console.format("Error: %s\n", e.getMessage());
        }
    }
}