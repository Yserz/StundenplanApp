package de.fhb.stundenplanapp.data;



import java.util.ArrayList;
import java.util.List;

public class Tage {
	
	private String wochentag;
	private List<Veranstaltungen> veranstaltungen;
	
	@Override
	public String toString() {
		return "Tage [wochentag=" + wochentag + ", veranstaltungen="
				+ veranstaltungen + "]";
	}
	
	public Tage(String wtage){
		this.wochentag=wtage;
		veranstaltungen=new ArrayList<Veranstaltungen>();
	}
	
	/**
	 * @return the wochentag
	 */
	public String getWochentag() {
		return wochentag;
	}
	/**
	 * @param wochentag the wochentag to set
	 */
	public void setWochentag(String wochentag) {
		this.wochentag = wochentag;
	}
	/**
	 * @return the veranstaltungen
	 */
	public List<Veranstaltungen> getVeranstaltungen() {
		return veranstaltungen;
	}
	/**
	 * @param veranstaltungen the veranstaltungen to set
	 */
	public void setVeranstaltungen(List<Veranstaltungen> veranstaltungen) {
		this.veranstaltungen = veranstaltungen;
	}
	
	public void addVeranstaltung(Veranstaltungen veran){
		this.veranstaltungen.add(veran);
	}

}
