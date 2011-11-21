package de.fhb.stundenplanapp.data;


import java.util.ArrayList;
import java.util.List;

public class Studiengänge {
	
	private String name="hallo";
	private String link="test";
	private List<Semester> semester=null;
	
	public Studiengänge(){
		semester=new ArrayList<Semester>();
	}
	
	@Override
	public String toString() {
		return "Studiengänge [name=" + name + ", semester="
				+ semester + "]";
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
	 * @return the gruppe
	 */
	public List<Semester> getSemester() {
		return semester;
	}
	/**
	 * @param gruppe the gruppe to set
	 */
	public void setSemester(List<Semester> semester) {
		this.semester = semester;
	}
	
	public void addSemester(Semester semester){
		this.semester.add(semester);
	}

}
