package projectpbokel;

public class DataParkir {
    int no ;
    String pemilik, nopol, jenis , tanggal;

    public void setNo(int no) {
        this.no = no;
    }

    public void setPemilik(String pemilik) {
        this.pemilik = pemilik;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getNo() {
        return no;
    }

    public String getPemilik() {
        return pemilik;
    }

    public String getNopol() {
        return nopol;
    }

    public String getJenis() {
        return jenis;
    }

    public String getTanggal() {
        return tanggal;
    }

    public DataParkir(int no, String pemilik, String nopol, String jenis, String tanggal) {
        this.no = no;
        this.pemilik = pemilik;
        this.nopol = nopol;
        this.jenis = jenis;
        this.tanggal = tanggal;
    }
}