package com.muhamet.StreamApi;

import java.util.List;
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
		
		
		
		
				
	}// Main
}//Class
