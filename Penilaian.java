public class Penilaian {
    Mahasiswa mahasiswa;
    MataKuliah mataKuliah;
    double nilaiTugas, nilaiUTS, nilaiUAS, nilaiAkhir;

    public Penilaian(Mahasiswa mahasiswa, MataKuliah mataKuliah, double tugas, double uts, double uas) {
        this.mahasiswa = mahasiswa;
        this.mataKuliah = mataKuliah;
        this.nilaiTugas = tugas;
        this.nilaiUTS = uts;
        this.nilaiUAS = uas;
        hitungNilaiAkhir();
    }

    public void hitungNilaiAkhir() {
        nilaiAkhir = (0.3 * nilaiTugas) + (0.3 * nilaiUTS) + (0.4 * nilaiUAS);
    }

    public void tampilPenilaian() {
        System.out.println(mahasiswa.getNama() + " | " + mataKuliah.getNamaMK() + " | Nilai Akhir: " + String.format("%.1f", nilaiAkhir));
    }
    
    public double getNilaiAkhir() {
        return nilaiAkhir;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }
}

