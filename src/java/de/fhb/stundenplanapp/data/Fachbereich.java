package de.fhb.stundenplanapp.data;


import java.util.ArrayList;
import java.util.List;

public class Fachbereich {
	
	private String name;
	private List<Studiengänge> studiengaenge;
	
	public Fachbereich(){
		name="test";
		studiengaenge=new ArrayList<Studiengänge>();
	}
	
	@Override
	public String toString() {
		return "Fachbereich [name=" + name + ", studiengaenge=" + studiengaenge
				+ "]";
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the studiengaenge
	 */
	public List<Studiengänge> getStudiengaenge() {
		return studiengaenge;
	}
	/**
	 * @param studiengaenge the studiengaenge to set
	 */
	public void setStudiengaenge(List<Studiengänge> studiengaenge) {
		this.studiengaenge = studiengaenge;
	}
	
	public void addStudiengaenge(Studiengänge st){
		this.studiengaenge.add(st);
	}

}
