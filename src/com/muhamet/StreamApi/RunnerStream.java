package com.muhamet.StreamApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class RunnerStream {

	public static void main(String[] args) {
		/**
		 * Listelerimizi(Data) iþlerken 2 yol var.
		 * 1- DataBase, bana adý Ahmet olanlarý getir.(çok boyutlu iþlemlerde
		 * hantal kalabilir. sizi yavaþlatabilir.)
		 * 2- Hazýr verileri(Database deki verilerin) bir tablo için tümünü çekerim.
		 * bir listenini içine alýrým.
		 * 
		 */
		Stream<String> boskayit = Stream.empty(); // boþ bir kayýt oluþturur. count->0
		Stream<String> tekKayit = Stream.of("Pazartesi"); // count 1
		Stream<Double> diziKullanim = Stream.of(2d,3d,53d,3d);// count 4
		List<String> gunler = List.of("Pt","Sl","Çr","Pe","Cu","Cum","Pa");
		
		/**
		 * DÝKKAT!!!
		 * bu konuda iþlediðimiz içeriklerin tamamý Stream ile ilgili. Peki bir liste
		 * stream e dönüþtürülebiliyor ise, o zaman tüm listelerde ayrýca Stream nesnesine
		 * atama yapmadan Stream içindeku kavramlar kullanýlabilir.
		 */
		Stream<String> gunlerStream = gunler.stream();
		//System.out.println("*****   1. yöntemle   ****** ");
		//gunlerStream.forEach(System.out::println);// 1. yöntem
		// System.out.println("*****   2. yöntemle   ****** ");
		// gunlerStream.forEach(x-> System.out.println("gün...: "+x)); // 2. yöntem
		gunlerStream.forEach(x->{
			System.out.println("Ek iþlemler");
			System.out.println(x);
			System.out.println("... kayýt için iþlem tamamlandý");
			System.out.println();
		});
		
		/**
		 * Sonsuz Streamler
		 */
		/**
		 * Math::random -> rastgele 0-1 arasý sayý üretir. 
		 */
		Stream<Double> sonsuz1 = Stream.generate(Math::random); // count-> sonsuz
		/**
		 * iterate(seed -> baþlangýç noktanýz, sonraki kaydýn oluþturulma kuralý 
		 */
		Stream<Integer> sonsuz2 = Stream.iterate(500_000, n -> n+100); // sonsuz
		/**
		 * (baþlangýç noktasý, bitme kuralý,sonraki kaydýn oluþturulma kuralý)
		 */
		Stream<Integer> sonsuz3 = Stream.iterate(500_000,n-> n<501_501 ,n -> n+100); // sonsuz
		
		sonsuz3.forEach(System.out::println);
		/**
		 * bir paragraf olsun bunun kelimeleri üzerinde arama ve sorgulama yapacaksýnýz
		 * kullanýlmayan ya da hatalý olan kelimeleri silip paragrafý tekrardan
		 * birleþtireceksiniz diyelim.
		 * String paragraf = "";
		 * String[] pList = paragraf.split(" ");
		 */
		var kelimeDizisi = new String[] {"M","u","r","a","t"};
		String ifade="";
		for(String kelime: kelimeDizisi) ifade += kelime;
		System.out.println(ifade);
	
		Stream<String> streamIfade = Stream.of("M","u","r","a","t");
		/**
		 * Stream içinde var olan listeyi iþleyebileceðimiz methodlar bardýr. bunlardan 
		 * birisi de reduce methodudur. bu method belirlenen bir kurala göre iþlem yapar.
		 * s1-> mevcut kayýt
		 * s2-> sonraki kayýt
		 */
		/**
		 * DÝKKAT!!!!! Ayný deðiþken ayný isimle tekrar tanýmlanamaz
		 * 1-> M+u -> Mu
		 * 2-> Mu+r -> Mur
		 * 3-> Mur+a ->Mura
		 */
		String ifadeYeni = 	streamIfade.reduce("", (s1,s2) -> s1+s2); 
		System.out.println(ifadeYeni);
		
		Stream<Integer> sayiStream = Stream.of(1,2,3,4,5);
		System.out.println(sayiStream.reduce(1, (s1,s2) -> s1*s2));
		
		Stream<String> isimListesi = Stream.of("Ali","Ahmet","Canan", "Bahadýr","Muhammet","Su");
		Optional<String> enKisaIsim = 
				isimListesi.min((MevcutIsim,SonrakiIsim)->MevcutIsim.length()-SonrakiIsim.length());
		enKisaIsim.ifPresent(System.out::println);
		
		/**
		 * Arama -> filitrelemek
		 */
		System.out.println("********** ARAMA  **********");
		Stream<String> isimListesiArama = Stream.of("Ali","Ahmet","Canan", "Bahadýr","Muhammet","Su");
		//isimListesiArama.filter(x-> x.contains("a")).forEach(System.out::println);
		//isimListesiArama.filter(x-> x.startsWith("A")).forEach(System.out::println);
		// isimListesiArama.filter(x-> x.length()<=3).forEach(System.out::println);
		
		/**
		 * Personel Listesi ->
		 */
		List<Personel> personelListesi = new ArrayList<Personel>();
		personelListesi.add(new Personel("Ahmet", "YENÝ"));
		personelListesi.add(new Personel("Canan", "TAÞ"));
		personelListesi.add(new Personel("Selim", "HAKKI"));
		personelListesi.add(new Personel("Hakký", "TURAN"));
		personelListesi.add(new Personel("Tufan", "BELLÝ"));
		personelListesi.add(new Personel("Deniz", "BÜLBÜL"));
		/**
		 *  Adýnda a geçenleri bulalým ????
		 */
		personelListesi.stream()
					   .filter(x->x.getAd().contains("a") && x.getSoyad().toLowerCase().contains("e"))
					   .forEach(System.out::println);
		
	}// Main
}//Class
