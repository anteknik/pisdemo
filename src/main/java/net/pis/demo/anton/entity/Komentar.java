package net.pis.demo.anton.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "komentar")
public class Komentar {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "waktu_publikasi", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuPublikasi;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nama;

    @Column(nullable = false)
    private String isi;

    @ManyToOne
    @JoinColumn(name = "id_berita", insertable = false, updatable = false)
    private Berita berita;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public Berita getBerita() {
        return berita;
    }

    public void setBerita(Berita berita) {
        this.berita = berita;
    }

}
