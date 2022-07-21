package com.muhamet.ornek;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Runner {

	public static void main(String[] args) throws MalformedURLException, IOException {		
		System.out.println("��lem Ba�lad�......");
		Scanner sc= null;
		sc = new Scanner(new URL("https://randomuser.me/api/?results=5").openStream());
		StringBuilder sb = new StringBuilder();
		while(sc.hasNext()) {
			sb.append(sc.nextLine());
		}
		System.out.println("******    Datalar �ekildi   ********");
		//System.out.println(sb.toString());
		/**
		 * Bilmedi�iniz k�s�m kafan�z� yormay�n �imdilik......
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
				x-> System.out.println(x.name.getFirst()+ " "+ 
						x.name.getLast()+ " "+
						x.getEmail()+ " "+
						x.getPhone()+ " "+
						x.getNat()
				));
		
	}//Main
}//Class
