package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Parole  {
	
	List<String> parole;
		
	public Parole() {
		parole=new LinkedList<>();
	}
	
	public void addParola(String p) {
		this.parole.add(p);
	}
	
	public List<String> getElenco() {
		List<String> paroleOrdine= new LinkedList<String>(parole);
		Collections.sort(paroleOrdine);//verifica si ain ordine alfabetico
		return paroleOrdine;
	}
	
	public void reset() {
		parole.clear();
	}

	
	
	
}
