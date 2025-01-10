import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class SistemParkirBufferedReader {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Masukkan kapasitas parkir: ");
            int kapasitas = Integer.parseInt(reader.readLine());
            Kendaraan.setKapasitas(kapasitas);

            boolean lanjut = true;
            while (lanjut) {
                // Menampilkan sisa kapasitas di awal setiap iterasi
                System.out.println("\nSisa kapasitas parkir: " + Kendaraan.getSisaKapasitas());

                if (!Kendaraan.cekKapasitas()) {
                    System.out.println("Parkir penuh!");
                    break;
                }

                System.out.print("Masukkan tipe kendaraan (1: Mobil, 2: Motor): ");
                int tipe = Integer.parseInt(reader.readLine());

                System.out.print("Masukkan plat nomor (format XX-9999-XXX): ");
                String platNomor = reader.readLine();

                if (!Pattern.matches("[A-Z]{2}-\\d{4}-[A-Z]{3}", platNomor)) {
                    throw new IllegalArgumentException("Format plat nomor tidak valid!");
                }

                System.out.print("Masukkan durasi parkir (jam): ");
                int durasi = Integer.parseInt(reader.readLine());

                System.out.print("Masukkan biaya per jam: ");
                int biayaPerJam = Integer.parseInt(reader.readLine());

                if (tipe == 1) {
                    Mobil mobil = new Mobil(platNomor, durasi, biayaPerJam);
                    mobil.hitungBiaya();
                } else if (tipe == 2) {
                    Motor motor = new Motor(platNomor, durasi, biayaPerJam);
                    motor.hitungBiaya();
                }

                // Menampilkan sisa kapasitas setelah parkir
                System.out.println("Sisa kapasitas parkir sekarang: " + Kendaraan.getSisaKapasitas());

                System.out.print("Lanjut entry? (y/n): ");
                String jawaban = reader.readLine();
                lanjut = jawaban.equalsIgnoreCase("y");
            }

            // Menampilkan ringkasan akhir
            System.out.println("\n=== Ringkasan Parkir ===");
            System.out.println("Total kapasitas: " + Kendaraan.getKapasitas());
            System.out.println("Sisa kapasitas: " + Kendaraan.getSisaKapasitas());
            System.out.println("Terpakai: " + (Kendaraan.getKapasitas() - Kendaraan.getSisaKapasitas()));

        } catch (IOException e) {
            System.out.println("Error membaca input: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Input harus berupa angka!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Error menutup reader: " + e.getMessage());
            }
        }
    }
}