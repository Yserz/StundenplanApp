package de.fhb.stundenplanapp.data;

import java.util.ArrayList;
import java.util.List;


public class Semester {
	
	private String name;
	private List<Gruppe> gruppen;
	
	public Semester(){
		gruppen=new ArrayList<Gruppe>();
	}
	
	@Override
	public String toString() {
		return "Semester [name=" + name + ", gruppen=" + gruppen + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Gruppe> getGruppen() {
		return gruppen;
	}
	public void setGruppen(List<Gruppe> gruppen) {
		this.gruppen = gruppen;
	}
	
	public void addGruppe(Gruppe gruppe){
		this.gruppen.add(gruppe);
	}

}
