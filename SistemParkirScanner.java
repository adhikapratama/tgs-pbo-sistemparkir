// File: SistemParkirScanner.java

import java.util.Scanner;
import java.util.regex.Pattern;

public class SistemParkirScanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Masukkan kapasitas parkir: ");
            int kapasitas = scanner.nextInt();
            Kendaraan.setKapasitas(kapasitas);

            boolean lanjut = true;
            while (lanjut) {
                if (!Kendaraan.cekKapasitas()) {
                    System.out.println("Parkir penuh!");
                    break;
                }

                System.out.print("Masukkan tipe kendaraan (1: Mobil, 2: Motor): ");
                int tipe = scanner.nextInt();
                scanner.nextLine(); // consume newline

                System.out.print("Masukkan plat nomor (format XX-9999-XXX): ");
                String platNomor = scanner.nextLine();

                if (!Pattern.matches("[A-Z]{2}-\\d{4}-[A-Z]{3}", platNomor)) {
                    throw new IllegalArgumentException("Format plat nomor tidak valid!");
                }

                System.out.print("Masukkan durasi parkir (jam): ");
                int durasi = scanner.nextInt();

                System.out.print("Masukkan biaya per jam: ");
                int biayaPerJam = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (tipe == 1) {
                    Mobil mobil = new Mobil(platNomor, durasi, biayaPerJam);
                    mobil.hitungBiaya();
                } else if (tipe == 2) {
                    Motor motor = new Motor(platNomor, durasi, biayaPerJam);
                    motor.hitungBiaya();
                }

                System.out.print("Lanjut entry? (y/n): ");
                String jawaban = scanner.nextLine();
                lanjut = jawaban.equalsIgnoreCase("y");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
