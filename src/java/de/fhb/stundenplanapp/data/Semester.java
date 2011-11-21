package de.fhb.stundenplanapp.data;

import java.util.ArrayList;
import java.util.List;


public class Semester {
	
	private String name;
	private List<Gruppen> gruppen;
	
	public Semester(){
		gruppen=new ArrayList<Gruppen>();
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
	public List<Gruppen> getGruppen() {
		return gruppen;
	}
	public void setGruppen(List<Gruppen> gruppen) {
		this.gruppen = gruppen;
	}
	
	public void addGruppe(Gruppen gruppe){
		this.gruppen.add(gruppe);
	}

}
