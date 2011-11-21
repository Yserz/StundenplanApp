package de.fhb.stundenplanapp.data;

import java.util.List;

public class Gruppen {
	
	private String name;
	private String link;
	private List<Tage> tage;
	
	
	

	@Override
	public String toString() {
		return "Gruppen [name=" + name + ", tage=" + tage
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
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * @return the tage
	 */
	public List<Tage> getTage() {
		return tage;
	}
	/**
	 * @param tage the tage to set
	 */
	public void setTage(List<Tage> tage) {
		this.tage = tage;
	}

}
