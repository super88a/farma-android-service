package com.primetech.wf;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Obt {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  @NotEmpty
  private String nama;
	private String indikasi;
  private String aturanPakai;
	private String efekSp;

  public Long getId() {
    return id;
  }

  public String getNama() {
    return nama;
  }
  public void setNama(String nama) {
    this.nama = nama;
  }

  public String getIndikasi() {
    return indikasi;
  }
  public void setIndikasi(String indikasi) {
    this.indikasi = indikasi;
  }
  
  public String getAturanPakai() {
    return aturanPakai;
  }
  public void setAturanPakai(String aturanPakai) {
    this.aturanPakai = aturanPakai;
  }  
  
  public String getEfekSp() {
    return efekSp;
  }
  public void setEfekSp(String efekSp) {
    this.efekSp = efekSp;
  } 
}
