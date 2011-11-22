package de.fhb.stundenplanapp.data;



import java.util.ArrayList;
import java.util.List;

public class Tag {
	
	private String wochentag;
	private List<Veranstaltung> veranstaltungen;
	
	@Override
	public String toString() {
		return "Tage [wochentag=" + wochentag + ", veranstaltungen="
				+ veranstaltungen + "]";
	}
	
	public Tag(String wtage){
		this.wochentag=wtage;
		veranstaltungen=new ArrayList<Veranstaltung>();
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
	public List<Veranstaltung> getVeranstaltungen() {
		return veranstaltungen;
	}
	/**
	 * @param veranstaltungen the veranstaltungen to set
	 */
	public void setVeranstaltungen(List<Veranstaltung> veranstaltungen) {
		this.veranstaltungen = veranstaltungen;
	}
	
	public void addVeranstaltung(Veranstaltung veran){
		this.veranstaltungen.add(veran);
	}

}
