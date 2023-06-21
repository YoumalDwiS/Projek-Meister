package com.astratech.meister.model;


import javax.persistence.*;

@Entity
public class Materi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_materi;
    @JoinColumn(name = "id_section", referencedColumnName = "id_section")
    @ManyToOne
    private Bagian id_section;
    private String nama_materi;
    private String deskripsi;
    private String status;

    public Materi() {
    }

    public int getId_materi() {
        return id_materi;
    }

    public void setId_materi(int id_materi) {
        this.id_materi = id_materi;
    }

    public Bagian getId_section() {
        return id_section;
    }

    public void setId_section(Bagian id_section) {
        this.id_section = id_section;
    }

    public String getNama_materi() {
        return nama_materi;
    }

    public void setNama_materi(String nama_materi) {
        this.nama_materi = nama_materi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
