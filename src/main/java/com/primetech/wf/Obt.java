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
  private String aturan;
	private String efek;
	
	public Obt() {
	}
	
	
	public Obt(String nama, String indikasi, String aturan, String efek) {
	  
	  this.nama = nama;
	  this.indikasi = indikasi;
	  this.aturan = aturan;
	  this.efek = efek;
	}

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
  
  public String getAturan() {
    return aturan;
  }
  public void setAturan(String aturanPakai) {
    this.aturan = aturanPakai;
  }  
  
  public String getEfek() {
    return efek;
  }
  public void setEfek(String efekSp) {
    this.efek = efekSp;
  } 
}
