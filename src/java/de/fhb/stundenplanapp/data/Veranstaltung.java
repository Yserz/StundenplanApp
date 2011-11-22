package de.fhb.stundenplanapp.data;



public class Veranstaltung {
	
	private String name;
	private String bemerkung;
	private int begin;
	private int ende;
	
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnde() {
		return ende;
	}
	public void setEnde(int ende) {
		this.ende = ende;
	}
	
	@Override
	public String toString() {
		return "Veranstaltungen [name=" + name + ", bemerkung=" + bemerkung
				+ ", begin=" + begin + ", ende=" + ende + "]";
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
	 * @return the bemerkung
	 */
	public String getBemerkung() {
		return bemerkung;
	}
	/**
	 * @param bemerkung the bemerkung to set
	 */
	public void setBemerkung(String bemerkung) {
		this.bemerkung = bemerkung;
	}
	
	public void nextEnde(){
		this.ende=this.ende+1;
	}
	
	public String getStartTime(){
		return begin + ":00";
	}
	
	public String getEndTime() {
		return ende + ":00";
	}

}
