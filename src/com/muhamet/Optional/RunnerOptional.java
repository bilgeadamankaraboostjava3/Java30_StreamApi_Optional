package com.muhamet.Optional;

import java.util.Optional;

public class RunnerOptional {
	static Ogrenci ogr2 = null;
	public static void main(String[] args) {
		/**
		 * Optional-> Öðrencinin notlarý olsun ve bu notlarýn hesaplamalarýný yapan bir
		 * method olsun. 100 + 90 = ort->95. hesaplansýn.
		 * daha eðitimin baþýnda öðrenciye notlarýný sorsak
		 */
		Ogrenci ogr = new Ogrenci("Ahmet");
		System.out.println("id....: "+ ogr.getId());
		System.out.println("ad....: "+ ogr.getAd());
		/*
		System.out.println("id....: "+ ogr2.getId()); // Çalýþmaz
		System.out.println("ad....: "+ ogr2.getAd()); // Çalýþmaz
		ogr2 = new Ogrenci("Deniz");
		*/
		/**
		 * empty () -> deðer boþ, bilgim yok demektir.
		 * of([deðer giriniz]) -> her hangi bir deðeri optional ile sarmalamak için kullanýlýr.
		 * isPresent() -> Optional deðerin içinde veri bulunmaktadýr demektir. false/true
		 * isEmpty() -> Optional deðerin içinde veri yoktur demektir. false/true
		 */
		Optional<Double> ortalama = ortalamaHespla(90,65,78); // 77,6
		if(ortalama.isPresent()) {
			System.out.println("Öðrencinin ortalamasý...: "+ ortalama.get());
		}else {
			System.out.println("Öðrencinin henüz sýnav notlarý yoktur.");
		}
		
		if(ortalama.isEmpty()) {
			
		}else {
			
		}
		/**
		 * Eðer Optional içinde deðer var ise iþlem yap gibi bir durum var ise kullanýlýr.
		 */
		ortalama.ifPresent(x-> System.out.println("öðrenci notu...: "+ x));
		

		/**
		 * ifPresend bize Optional deðerin içinde var olan datayý döner bizde bu 
		 * datayý kullanarak iþlem yapabiliriz.
		 * (77.6)
		 */
		ortalama.ifPresent(System.out::println);
		
		/**
		 * Oðrencinin null kontrollü
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
		 * 1. Kullaným, uzun olan
		 */
		// Optional<Ogrenci> optionalOgr = ogr == null ?  Optional.empty() : Optional.of(ogr);		
		// return optionalOgr;
		/**
		 * 2. yöntem
		 */
		return Optional.ofNullable(ogr);		
		
	}
	
	
}//Class
