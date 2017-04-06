package net.pis.demo.anton.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "berita")
public class Berita {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "waktu_publikasi", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuPublikasi;

    @Column(nullable = false)
    private String judul;

    @Column(nullable = false)
    private String isi;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_berita")
    private List<Komentar> daftarKomentar
            = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getWaktuPublikasi() {
        return waktuPublikasi;
    }

    public void setWaktuPublikasi(Date waktuPublikasi) {
        this.waktuPublikasi = waktuPublikasi;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public List<Komentar> getDaftarKomentar() {
        return daftarKomentar;
    }

    public void setDaftarKomentar(List<Komentar> daftarKomentar) {
        this.daftarKomentar = daftarKomentar;
    }

}
