package de.fhb.stundenplanapp.data;


import java.util.ArrayList;
import java.util.List;

public class Fachbereich {
	
	private String name;
	private List<Studieng�nge> studiengaenge;
	
	public Fachbereich(){
		name="test";
		studiengaenge=new ArrayList<Studieng�nge>();
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
	public List<Studieng�nge> getStudiengaenge() {
		return studiengaenge;
	}
	/**
	 * @param studiengaenge the studiengaenge to set
	 */
	public void setStudiengaenge(List<Studieng�nge> studiengaenge) {
		this.studiengaenge = studiengaenge;
	}
	
	public void addStudiengaenge(Studieng�nge st){
		this.studiengaenge.add(st);
	}

}
