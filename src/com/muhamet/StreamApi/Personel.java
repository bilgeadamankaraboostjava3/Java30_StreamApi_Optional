package com.muhamet.StreamApi;

import java.util.Random;

public class Personel {

	long id;
	String ad;
	String soyad;
	
	
	@Override
	public String toString() {
		return "Personel [id=" + id + ", ad=" + ad + ", soyad=" + soyad + "]";
	}
	public Personel(String ad, String soyad) {
		id = new Random().nextLong();
		this.ad = ad;
		this.soyad = soyad;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	
	
	
}
