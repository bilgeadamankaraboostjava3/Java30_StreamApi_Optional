package com.muhamet.StreamApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class RunnerStream {

	public static void main(String[] args) {
		/**
		 * Listelerimizi(Data) i�lerken 2 yol var.
		 * 1- DataBase, bana ad� Ahmet olanlar� getir.(�ok boyutlu i�lemlerde
		 * hantal kalabilir. sizi yava�latabilir.)
		 * 2- Haz�r verileri(Database deki verilerin) bir tablo i�in t�m�n� �ekerim.
		 * bir listenini i�ine al�r�m.
		 * 
		 */
		Stream<String> boskayit = Stream.empty(); // bo� bir kay�t olu�turur. count->0
		Stream<String> tekKayit = Stream.of("Pazartesi"); // count 1
		Stream<Double> diziKullanim = Stream.of(2d,3d,53d,3d);// count 4
		List<String> gunler = List.of("Pt","Sl","�r","Pe","Cu","Cum","Pa");
		
		/**
		 * D�KKAT!!!
		 * bu konuda i�ledi�imiz i�eriklerin tamam� Stream ile ilgili. Peki bir liste
		 * stream e d�n��t�r�lebiliyor ise, o zaman t�m listelerde ayr�ca Stream nesnesine
		 * atama yapmadan Stream i�indeku kavramlar kullan�labilir.
		 */
		Stream<String> gunlerStream = gunler.stream();
		//System.out.println("*****   1. y�ntemle   ****** ");
		//gunlerStream.forEach(System.out::println);// 1. y�ntem
		// System.out.println("*****   2. y�ntemle   ****** ");
		// gunlerStream.forEach(x-> System.out.println("g�n...: "+x)); // 2. y�ntem
		gunlerStream.forEach(x->{
			System.out.println("Ek i�lemler");
			System.out.println(x);
			System.out.println("... kay�t i�in i�lem tamamland�");
			System.out.println();
		});
		
		/**
		 * Sonsuz Streamler
		 */
		/**
		 * Math::random -> rastgele 0-1 aras� say� �retir. 
		 */
		Stream<Double> sonsuz1 = Stream.generate(Math::random); // count-> sonsuz
		/**
		 * iterate(seed -> ba�lang�� noktan�z, sonraki kayd�n olu�turulma kural� 
		 */
		Stream<Integer> sonsuz2 = Stream.iterate(500_000, n -> n+100); // sonsuz
		/**
		 * (ba�lang�� noktas�, bitme kural�,sonraki kayd�n olu�turulma kural�)
		 */
		Stream<Integer> sonsuz3 = Stream.iterate(500_000,n-> n<501_501 ,n -> n+100); // sonsuz
		
		sonsuz3.forEach(System.out::println);
		/**
		 * bir paragraf olsun bunun kelimeleri �zerinde arama ve sorgulama yapacaks�n�z
		 * kullan�lmayan ya da hatal� olan kelimeleri silip paragraf� tekrardan
		 * birle�tireceksiniz diyelim.
		 * String paragraf = "";
		 * String[] pList = paragraf.split(" ");
		 */
		var kelimeDizisi = new String[] {"M","u","r","a","t"};
		String ifade="";
		for(String kelime: kelimeDizisi) ifade += kelime;
		System.out.println(ifade);
	
		Stream<String> streamIfade = Stream.of("M","u","r","a","t");
		/**
		 * Stream i�inde var olan listeyi i�leyebilece�imiz methodlar bard�r. bunlardan 
		 * birisi de reduce methodudur. bu method belirlenen bir kurala g�re i�lem yapar.
		 * s1-> mevcut kay�t
		 * s2-> sonraki kay�t
		 */
		/**
		 * D�KKAT!!!!! Ayn� de�i�ken ayn� isimle tekrar tan�mlanamaz
		 * 1-> M+u -> Mu
		 * 2-> Mu+r -> Mur
		 * 3-> Mur+a ->Mura
		 */
		String ifadeYeni = 	streamIfade.reduce("", (s1,s2) -> s1+s2); 
		System.out.println(ifadeYeni);
		
		Stream<Integer> sayiStream = Stream.of(1,2,3,4,5);
		System.out.println(sayiStream.reduce(1, (s1,s2) -> s1*s2));
		
		Stream<String> isimListesi = Stream.of("Ali","Ahmet","Canan", "Bahad�r","Muhammet","Su");
		Optional<String> enKisaIsim = 
				isimListesi.min((MevcutIsim,SonrakiIsim)->MevcutIsim.length()-SonrakiIsim.length());
		enKisaIsim.ifPresent(System.out::println);
		
		/**
		 * Arama -> filitrelemek
		 */
		System.out.println("********** ARAMA  **********");
		Stream<String> isimListesiArama = Stream.of("Ali","Ahmet","Canan", "Bahad�r","Muhammet","Su");
		//isimListesiArama.filter(x-> x.contains("a")).forEach(System.out::println);
		//isimListesiArama.filter(x-> x.startsWith("A")).forEach(System.out::println);
		// isimListesiArama.filter(x-> x.length()<=3).forEach(System.out::println);
		
		/**
		 * Personel Listesi ->
		 */
		List<Personel> personelListesi = new ArrayList<Personel>();
		personelListesi.add(new Personel("Ahmet", "YEN�"));
		personelListesi.add(new Personel("Canan", "TA�"));
		personelListesi.add(new Personel("Selim", "HAKKI"));
		personelListesi.add(new Personel("Hakk�", "TURAN"));
		personelListesi.add(new Personel("Tufan", "BELL�"));
		personelListesi.add(new Personel("Deniz", "B�LB�L"));
		/**
		 *  Ad�nda a ge�enleri bulal�m ????
		 */
		personelListesi.stream()
					   .filter(x->x.getAd().contains("a") && x.getSoyad().toLowerCase().contains("e"))
					   .forEach(System.out::println);
		
	}// Main
}//Class
