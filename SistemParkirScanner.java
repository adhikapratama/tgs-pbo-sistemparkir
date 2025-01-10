import java.util.Scanner;
import java.util.regex.Pattern;

public class SistemParkirScanner {
    public SistemParkirScanner() {
    }

    public static void main(String[] var0) {
        Scanner var1 = new Scanner(System.in);

        try {
            System.out.print("Masukkan kapasitas parkir: ");
            int var2 = var1.nextInt();
            Kendaraan.setKapasitas(var2);

            String var15;
            for (boolean var3 = true; var3; var3 = var15.equalsIgnoreCase("y")) {
                // Menampilkan sisa kapasitas parkir
                System.out.println("\nSisa kapasitas parkir: " + Kendaraan.getSisaKapasitas());

                if (!Kendaraan.cekKapasitas()) {
                    System.out.println("Parkir penuh!");
                    break;
                }

                System.out.print("Masukkan tipe kendaraan (1: Mobil, 2: Motor): ");
                int var4 = var1.nextInt();
                var1.nextLine();
                System.out.print("Masukkan plat nomor (format XX-9999-XXX): ");
                String var5 = var1.nextLine();
                if (!Pattern.matches("[A-Z]{2}-\\d{4}-[A-Z]{3}", var5)) {
                    throw new IllegalArgumentException("Format plat nomor tidak valid!");
                }

                System.out.print("Masukkan durasi parkir (jam): ");
                int var6 = var1.nextInt();
                System.out.print("Masukkan biaya per jam: ");
                int var7 = var1.nextInt();
                var1.nextLine();
                if (var4 == 1) {
                    Mobil var8 = new Mobil(var5, var6, var7);
                    var8.hitungBiaya();
                } else if (var4 == 2) {
                    Motor var14 = new Motor(var5, var6, var7);
                    var14.hitungBiaya();
                }

                // Menampilkan sisa kapasitas setelah parkir
                System.out.println("Sisa kapasitas parkir sekarang: " + Kendaraan.getSisaKapasitas());

                System.out.print("Lanjut entry? (y/n): ");
                var15 = var1.nextLine();
            }

            // Menampilkan ringkasan akhir
            System.out.println("\n=== Ringkasan Parkir ===");
            System.out.println("Total kapasitas: " + Kendaraan.getKapasitas());
            System.out.println("Sisa kapasitas: " + Kendaraan.getSisaKapasitas());
            System.out.println("Terpakai: " + (Kendaraan.getKapasitas() - Kendaraan.getSisaKapasitas()));

        } catch (IllegalArgumentException var12) {
            System.out.println("Error: " + var12.getMessage());
        } finally {
            var1.close();
        }
    }
}