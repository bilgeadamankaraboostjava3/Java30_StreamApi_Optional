package com.muhamet.StreamApi;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunnerStream2 {

	public static void main(String[] args) {
		
		Stream<Integer> bosListe = Stream.of();
		bosListe = Stream.empty();
		Stream<Integer> tekElemanliListe = Stream.of(8);
		Stream<Integer> cokElemanliListe = Stream.of(1,5,9);
		BinaryOperator<Integer> opr = (a,b)-> a*b;
		/// burada iþlem neticesinde deðer dönmez ise sorun olabilir,
		/// bu nedenle eðer sonuç var ise iþlem yap diyoruz.
		bosListe.reduce(opr).ifPresent(System.out::println);// hiçnirþey yazmamalý
		tekElemanliListe.reduce(opr).ifPresent(System.out::println);// 8
		/**
		 * DÝKKAT!!!
		 * Web, herhangi bir kaynaktan, ... Stream.... herhangi bir stream kullanýp
		 * tükettikten sonra tekrar baþka bir yerde tüketemezsiniz.
		 */
		// cokElemanliListe.reduce(opr).ifPresent(System.out::println);// 45
		// cokElemanliListe.reduce(opr).ifPresent(sonuc-> kareBul(sonuc));
		cokElemanliListe.reduce(opr).ifPresent(sonuc->{
			kareBul(sonuc);
		});
		
		/**
		 * Stream <-----> List  = list.stream();
		 */
		Stream<String> stream = Stream.of("Pazar","Pazartesi","Salý","Çarþamba","Perþembe","Cuma","Cumartesi");
		TreeSet<String> set = stream.collect(TreeSet::new,TreeSet::add,TreeSet::addAll);
		System.out.println(set);
		/**
		 * 2. Yöntem ve sýk kullanýlan yöntem.
		 */
		stream = Stream.of("Pazar","Pazartesi","Salý","Çarþamba","Perþembe","Cuma","Cumartesi");
		TreeSet<String> set1 = stream.collect(Collectors.toCollection(TreeSet::new));
		
		stream = Stream.of("Pazar","Pazartesi","Salý","Çarþamba","Perþembe","Cuma","Cumartesi");
		//List<String> listem = stream.toList();
		
		/**
		 * Bir internet siteniz var insanlar arkadaþlarýný buluyor. arama iþlemi yapýldýðýnda
		 * listeler genellikle sýralý bir þekilde gelir. ancak biz kayýtlarýmýzý sýralý deðil
		 * ekleme önceliðine göre listeleriz. iþte burada elimizde olan liseteleri sýralamamýz
		 * gerekebilir.
		 * 1- yerinde, database üzerinde sýralamak
		 * 2- verileri çektikten sonra ram üzerinde sýralamak
		 * 3- client ta sýralamak.
		 */
		stream = Stream.of("Deniz","Ahmet","Hilal","Büþra","Zeynep","Tülay","Batu","Ahmet","Hilal");
		stream.sorted().forEach(System.out::println); // a..z, 0...9 sýralama
		System.out.println();
		stream = Stream.of("Deniz","Ahmet","Hilal","Büþra","Zeynep","Tülay","Batu","Ahmet","Hilal");
		stream.sorted(Comparator.reverseOrder()) // z..a,  9....0 sýralama
			.forEach(System.out::println);
		/**
		 * tekrar eden kayýtlarý, Set üzerinde çalýþarak iþlem yapabilirsiniz.
		 * stream tekrar eden kayýtlarý teke indiren methodlara da sahiptir.
		 */
		System.out.println("**** Distinct Kullanýmý ile kayýtlarý tek e düþürmek  ******");
		stream = Stream.of("Deniz","Ahmet","Hilal","Büþra","Zeynep","Tülay","Batu","Ahmet","Hilal");
		stream.distinct().sorted().forEach(System.out::println);
		
		
	}///Main
	
	public static void kareBul(int deger) {
		int kare = deger * deger;
		System.out.println("gelen sayýnýn karesi.....: "+ kare);
	}
	
}//Class
