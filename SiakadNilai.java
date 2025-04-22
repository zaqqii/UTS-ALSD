import java.util.*;

public class SiakadNilai {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    static ArrayList<MataKuliah> daftarMatkul = new ArrayList<>();
    static ArrayList<Penilaian> daftarPenilaian = new ArrayList<>();

    public static void main(String[] args) {
        inisialisasiData();
        int pilihan;
        do {
            System.out.println("\n=== MENU SISTEM AKADEMIK ===");
            System.out.println("1. Tampilkan Daftar Mahasiswa");
            System.out.println("2. Tampilkan Daftar Mata Kuliah");
            System.out.println("3. Tampilkan Data Penilaian");
            System.out.println("4. Urutkan Mahasiswa Berdasarkan Nilai Akhir");
            System.out.println("5. Cari Mahasiswa Berdasarkan NIM");
            System.out.println("6. Urutkan Mata Kuliah berdasarkan SKS");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1 -> tampilkanMahasiswa();
                case 2 -> tampilkanMatkul();
                case 3 -> tampilkanPenilaian();
                case 4 -> urutkanNilaiAkhir();
                case 5 -> cariMahasiswa();
                case 6 -> urutkanMatkulBerdasarkanSKS();
                case 0 -> System.out.println("Terima kasih!");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    static void inisialisasiData() {
     
        daftarMatkul.add(new MataKuliah("MK001", "Struktur Data", 3));
        daftarMatkul.add(new MataKuliah("MK002", "Basis Data", 3));
        daftarMatkul.add(new MataKuliah("MK003", "Desain Web", 3));
        daftarMatkul.add(new MataKuliah("MK004", "Pemrograman Web", 2));
        daftarMatkul.add(new MataKuliah("MK005", "Sistem Operasi", 2));

        
        Mahasiswa m1 = new Mahasiswa("22001", "Ali Rahman", "Informatika");
        Mahasiswa m2 = new Mahasiswa("22002", "Budi Santoso", "Informatika");
        Mahasiswa m3 = new Mahasiswa("22003", "Citra Dewi", "Sistem Informasi Bisnis");
        Mahasiswa m4 = new Mahasiswa("22004", "Dewi Lestari", "Sistem Informasi Bisnis");
        Mahasiswa m5 = new Mahasiswa("22005", "Eka Kurniawan", "Informatika");

        daftarMahasiswa.add(m1);
        daftarMahasiswa.add(m2);
        daftarMahasiswa.add(m3);
        daftarMahasiswa.add(m4);
        daftarMahasiswa.add(m5);

        daftarPenilaian.add(new Penilaian(m1, daftarMatkul.get(0), 80, 85, 90));
        daftarPenilaian.add(new Penilaian(m1, daftarMatkul.get(1), 60, 75, 70));
        daftarPenilaian.add(new Penilaian(m2, daftarMatkul.get(0), 75, 70, 80));
        daftarPenilaian.add(new Penilaian(m3, daftarMatkul.get(1), 85, 90, 95));
        daftarPenilaian.add(new Penilaian(m3, daftarMatkul.get(2), 80, 90, 65));
        daftarPenilaian.add(new Penilaian(m4, daftarMatkul.get(3), 75, 80, 85));
        daftarPenilaian.add(new Penilaian(m4, daftarMatkul.get(4), 85, 90, 95));
        daftarPenilaian.add(new Penilaian(m5, daftarMatkul.get(0), 70, 75, 80));
        daftarPenilaian.add(new Penilaian(m5, daftarMatkul.get(1), 80, 85, 90));

    }

    static void tampilkanMahasiswa() {
        System.out.println("\nDaftar Mahasiswa:");
        for (Mahasiswa m : daftarMahasiswa) {
            m.tampilMahasiswa();
        }
    }

    static void tampilkanMatkul() {
        System.out.println("\nDaftar Mata Kuliah:");
        for (MataKuliah mk : daftarMatkul) {
            mk.tampilMatakuliah();
        }
    }

    static void tampilkanPenilaian() {
        System.out.println("\nData Penilaian:");
        for (Penilaian p : daftarPenilaian) {
            p.tampilPenilaian();
        }
    }

    static void urutkanNilaiAkhir() {
        for (int i = 0; i < daftarPenilaian.size() - 1; i++) {
            for (int j = 0; j < daftarPenilaian.size() - i - 1; j++) {
                if (daftarPenilaian.get(j).getNilaiAkhir() < daftarPenilaian.get(j + 1).getNilaiAkhir()) {
                    Collections.swap(daftarPenilaian, j, j + 1);
                }
            }
        }
        System.out.println("\nData setelah diurutkan berdasarkan nilai akhir:");
        tampilkanPenilaian();
    }

    static void cariMahasiswa() {
        System.out.print("Masukkan NIM mahasiswa yang dicari: ");
        String nim = sc.nextLine();
        boolean ditemukan = false;
    
        for (Mahasiswa m : daftarMahasiswa) {
            if (m.getNIM().equals(nim)) {
                System.out.println("Mahasiswa Ditemukan: NIM: " + m.getNIM() + " | Nama: " + m.getNama() + " | Prodi: " + m.prodi);
                ditemukan = true;
                break;
            }
        }
    
        if (!ditemukan) {
            System.out.println("Mahasiswa Ditemukan: NIM " + nim + " tidak ditemukan.");
        }
    }

    static void urutkanMatkulBerdasarkanSKS() {
        daftarMatkul.sort(Comparator.comparingInt(mk -> mk.sks));
    
        System.out.println("\nDaftar Mata Kuliah setelah diurutkan berdasarkan SKS (terkecil ke terbesar):");
        for (MataKuliah mk : daftarMatkul) {
            mk.tampilMatakuliah();
        }
    }
    
}


