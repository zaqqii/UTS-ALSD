public class MataKuliah {
    String kodeMK, namaMK;
    int sks;

    public MataKuliah(String kodeMK, String namaMK, int sks) {
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
        this.sks = sks;
    }

    public void tampilMatakuliah() {
        System.out.println("Kode MK: " + kodeMK + " | Nama: " + namaMK + " | SKS: " + sks);
    }

    public String getNamaMK() {
        return namaMK;
    }

    public String getKodeMK() {
        return kodeMK;
    }
}

