package de.fhb.stundenplanapp.data;


import java.util.ArrayList;
import java.util.List;

public class Fachbereich {
	
	private String name;
	private List<Studiengang> studiengaenge;
	
	public Fachbereich(){
		name="test";
		studiengaenge=new ArrayList<Studiengang>();
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
	public List<Studiengang> getStudiengaenge() {
		return studiengaenge;
	}
	/**
	 * @param studiengaenge the studiengaenge to set
	 */
	public void setStudiengaenge(List<Studiengang> studiengaenge) {
		this.studiengaenge = studiengaenge;
	}
	
	public void addStudiengaenge(Studiengang st){
		this.studiengaenge.add(st);
	}

}
