package com.muhamet.Optional;

import java.util.Optional;

public class RunnerOptional {
	static Ogrenci ogr2 = null;
	public static void main(String[] args) {
		/**
		 * Optional-> ��rencinin notlar� olsun ve bu notlar�n hesaplamalar�n� yapan bir
		 * method olsun. 100 + 90 = ort->95. hesaplans�n.
		 * daha e�itimin ba��nda ��renciye notlar�n� sorsak
		 */
		Ogrenci ogr = new Ogrenci("Ahmet");
		System.out.println("id....: "+ ogr.getId());
		System.out.println("ad....: "+ ogr.getAd());
		/*
		System.out.println("id....: "+ ogr2.getId()); // �al��maz
		System.out.println("ad....: "+ ogr2.getAd()); // �al��maz
		ogr2 = new Ogrenci("Deniz");
		*/
		/**
		 * empty () -> de�er bo�, bilgim yok demektir.
		 * of([de�er giriniz]) -> her hangi bir de�eri optional ile sarmalamak i�in kullan�l�r.
		 * isPresent() -> Optional de�erin i�inde veri bulunmaktad�r demektir. false/true
		 * isEmpty() -> Optional de�erin i�inde veri yoktur demektir. false/true
		 */
		Optional<Double> ortalama = ortalamaHespla(90,65,78); // 77,6
		if(ortalama.isPresent()) {
			System.out.println("��rencinin ortalamas�...: "+ ortalama.get());
		}else {
			System.out.println("��rencinin hen�z s�nav notlar� yoktur.");
		}
		
		if(ortalama.isEmpty()) {
			
		}else {
			
		}
		/**
		 * E�er Optional i�inde de�er var ise i�lem yap gibi bir durum var ise kullan�l�r.
		 */
		ortalama.ifPresent(x-> System.out.println("��renci notu...: "+ x));
		

		/**
		 * ifPresend bize Optional de�erin i�inde var olan datay� d�ner bizde bu 
		 * datay� kullanarak i�lem yapabiliriz.
		 * (77.6)
		 */
		ortalama.ifPresent(System.out::println);
		
		/**
		 * O�rencinin null kontroll�
		 */
		//Optional optional = ogr2 == null ?  Optional.empty() : Optional.of(ogr);
		

	}//Main
	
	public static Optional<Double> ortalamaHespla(double... notlar){
		if(notlar.length == 0) return Optional.empty();
		double ort=0;
		for(double not: notlar) {
			ort +=not;
		}
		ort = ort / notlar.length;
		return Optional.of(ort);
	}
	
	public static Optional<Ogrenci> ogrenciOlustur(){
		Ogrenci ogr = null;
		/**
		 * 1. Kullan�m, uzun olan
		 */
		// Optional<Ogrenci> optionalOgr = ogr == null ?  Optional.empty() : Optional.of(ogr);		
		// return optionalOgr;
		/**
		 * 2. y�ntem
		 */
		return Optional.ofNullable(ogr);		
		
	}
	
	
}//Class
