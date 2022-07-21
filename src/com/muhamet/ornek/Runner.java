package com.muhamet.ornek;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Format;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Runner {

	public static void main(String[] args) throws MalformedURLException, IOException {		
		System.out.println("Ýþlem Baþladý......");
		Scanner sc= null;
		sc = new Scanner(new URL("https://randomuser.me/api/?results=500").openStream(),"UTF-8");
		StringBuilder sb = new StringBuilder();
		while(sc.hasNext()) {
			sb.append(sc.nextLine());
		}
		System.out.println("******    Datalar Çekildi   ********");
		//System.out.println(sb.toString());
		/**
		 * Bilmediðiniz kýsým kafanýzý yormayýn þimdilik......
		 */
		List<Person> kisiListesi = new ArrayList();
		Gson gson = new Gson();
		JsonElement jsonElement = JsonParser.parseString(sb.toString());
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		JsonArray jsonArray = jsonObject.get("results").getAsJsonArray();
		int size = jsonArray.size();
		for(int i=0; i<size; i++) {
			JsonObject o = jsonArray.get(i).getAsJsonObject();
			Person pp =  gson.fromJson(o,Person.class);
			kisiListesi.add(pp);
		}
		kisiListesi.forEach(
				x-> System.out.println(x.name.getFirst()+ " - "+ 
						x.name.getLast()+ " - "+
						x.getEmail()+ " - "+
						x.getPhone()+ " - "+
						x.getNat()
				));
		/**
		 * 
		 */
		
		/**
		 *  nat   name
		 *  TR    Ahmet
		 *  US    Canan
		 *  TR    Bahar
		 *  US    Jsonh
		 *  TR    Temel
		 *  
		 *  ["TR",{"Ahmet","Bahar","Temel}]
		 */
		
		Map<String,List<Person>> natNameList = kisiListesi.stream()
											.collect(Collectors.groupingBy(
													//Person.Name::getFirst
													Person::getNat,
													TreeMap::new,
													Collectors.toList()
													));
		/**
		 * Dikkat!! 
		 * çekilean data içinde KEY olarak verdiðimiz deðerlerin karþýlýðýný bilmioyurz.
		 * Map -> entrySet() -> Key ve Value listelerini 
		 */
		for(Entry<String, List<Person>> data : natNameList.entrySet()) {
			if(data.getKey().startsWith("T")) {
			System.out.println("********************************************");
			System.out.println("Nat....: "+ data.getKey());
			for(Person person: data.getValue())	
				System.out.println(person.name.getFirst()+" - "+ person.name.getLast());
			System.out.println("*********************************************");
			}
		}
		//System.out.println(natNameList);
		
	}//Main
}//Class
