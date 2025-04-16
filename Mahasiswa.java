public class Mahasiswa {
    String NIM, nama, prodi;

    public Mahasiswa(String NIM, String nama, String prodi) {
        this.NIM = NIM;
        this.nama = nama;
        this.prodi = prodi;
    }

    public void tampilMahasiswa() {
        System.out.println("NIM: " + NIM + " | Nama: " + nama + " | Prodi: " + prodi);
    }

    public String getNIM() {
        return NIM;
    }

    public String getNama() {
        return nama;
    }
}
