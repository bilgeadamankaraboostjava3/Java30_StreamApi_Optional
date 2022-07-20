package com.muhamet.StreamApi;

import java.util.List;
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
		
		
		
		
				
	}// Main
}//Class
