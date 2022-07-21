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
		/// burada i�lem neticesinde de�er d�nmez ise sorun olabilir,
		/// bu nedenle e�er sonu� var ise i�lem yap diyoruz.
		bosListe.reduce(opr).ifPresent(System.out::println);// hi�nir�ey yazmamal�
		tekElemanliListe.reduce(opr).ifPresent(System.out::println);// 8
		/**
		 * D�KKAT!!!
		 * Web, herhangi bir kaynaktan, ... Stream.... herhangi bir stream kullan�p
		 * t�kettikten sonra tekrar ba�ka bir yerde t�ketemezsiniz.
		 */
		// cokElemanliListe.reduce(opr).ifPresent(System.out::println);// 45
		// cokElemanliListe.reduce(opr).ifPresent(sonuc-> kareBul(sonuc));
		cokElemanliListe.reduce(opr).ifPresent(sonuc->{
			kareBul(sonuc);
		});
		
		/**
		 * Stream <-----> List  = list.stream();
		 */
		Stream<String> stream = Stream.of("Pazar","Pazartesi","Sal�","�ar�amba","Per�embe","Cuma","Cumartesi");
		TreeSet<String> set = stream.collect(TreeSet::new,TreeSet::add,TreeSet::addAll);
		System.out.println(set);
		/**
		 * 2. Y�ntem ve s�k kullan�lan y�ntem.
		 */
		stream = Stream.of("Pazar","Pazartesi","Sal�","�ar�amba","Per�embe","Cuma","Cumartesi");
		TreeSet<String> set1 = stream.collect(Collectors.toCollection(TreeSet::new));
		
		stream = Stream.of("Pazar","Pazartesi","Sal�","�ar�amba","Per�embe","Cuma","Cumartesi");
		//List<String> listem = stream.toList();
		
		/**
		 * Bir internet siteniz var insanlar arkada�lar�n� buluyor. arama i�lemi yap�ld���nda
		 * listeler genellikle s�ral� bir �ekilde gelir. ancak biz kay�tlar�m�z� s�ral� de�il
		 * ekleme �nceli�ine g�re listeleriz. i�te burada elimizde olan liseteleri s�ralamam�z
		 * gerekebilir.
		 * 1- yerinde, database �zerinde s�ralamak
		 * 2- verileri �ektikten sonra ram �zerinde s�ralamak
		 * 3- client ta s�ralamak.
		 */
		stream = Stream.of("Deniz","Ahmet","Hilal","B��ra","Zeynep","T�lay","Batu","Ahmet","Hilal");
		stream.sorted().forEach(System.out::println); // a..z, 0...9 s�ralama
		System.out.println();
		stream = Stream.of("Deniz","Ahmet","Hilal","B��ra","Zeynep","T�lay","Batu","Ahmet","Hilal");
		stream.sorted(Comparator.reverseOrder()) // z..a,  9....0 s�ralama
			.forEach(System.out::println);
		/**
		 * tekrar eden kay�tlar�, Set �zerinde �al��arak i�lem yapabilirsiniz.
		 * stream tekrar eden kay�tlar� teke indiren methodlara da sahiptir.
		 */
		System.out.println("**** Distinct Kullan�m� ile kay�tlar� tek e d���rmek  ******");
		stream = Stream.of("Deniz","Ahmet","Hilal","B��ra","Zeynep","T�lay","Batu","Ahmet","Hilal");
		stream.distinct().sorted().forEach(System.out::println);
		
		
	}///Main
	
	public static void kareBul(int deger) {
		int kare = deger * deger;
		System.out.println("gelen say�n�n karesi.....: "+ kare);
	}
	
}//Class
