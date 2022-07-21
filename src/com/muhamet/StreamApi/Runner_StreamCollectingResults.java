package com.muhamet.StreamApi;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner_StreamCollectingResults {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("Deniz","Ahmet","B��ra","Zeynep","T�lay","Batu","Hilal");
		String isimler = stream.collect(Collectors.joining(" ; "));
		System.out.println(isimler);

		stream = Stream.of("Deniz","Ahmet","B��ra","Zeynep","T�lay","Batu","Hilal","Ahmetnereli");
		Double resultD = stream.collect(Collectors.averagingDouble(String::length));
		System.out.println(resultD);
		
		stream = Stream.of("Deniz","Ahmet","B��ra","Zeynep","T�lay","Batu","Hilal","Ahmetnereli","Batu");
		TreeSet<String> treeset = stream.filter(isim-> isim.startsWith("B"))
										.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(treeset);
		
		/**
		 * D�KKAT!!!!!!!!
		 * Hataya d��t�k Sebep???
		 * Map<K,V> -> Batu,4  ---  Batu,4  hata burada Map i�erisinde Key de�eri benzersiz olaml�d�r.
		 */
		System.out.println("******* Map D�n���m� *******");
		stream = Stream.of("Deniz","Ahmet","B��ra","Zeynep","T�lay","Batu","Hilal","Ahmetnereli","Batu");
		Map<String,Integer> map = stream
				.distinct()
				.collect(Collectors.toMap(s-> s, String::length)); // K,V -> [Deniz,5],[Ahmet,5]
		System.out.println(map);
		//                   5       5       5       6        5      4        5      11            4
		stream = Stream.of("Deniz","Ahmet","B��ra","Zeynep","T�lay","Batu","Hilal","Ahmetnereli","Batu");
		Map<Integer,List<String>> mapUzunlukList = stream.distinct()
											.collect(Collectors.groupingBy(String::length));
		// [5,{Ahmet,Deniz,B��ra,T�lay,Hilal}]
		// 
		System.out.println(mapUzunlukList);
		
		stream = Stream.of("Deniz","Ahmet","B��ra","Zeynep","T�lay","Batu","Hilal","Ahmetnereli","Batu");
		TreeMap<String,List<String>> treeMap = stream.distinct()
				.collect(Collectors.groupingBy(
						s-> s.substring(0,1),
						TreeMap::new,
						Collectors.toList()
						));
		System.out.println(treeMap);
		
		
	}//Main
}//Class
