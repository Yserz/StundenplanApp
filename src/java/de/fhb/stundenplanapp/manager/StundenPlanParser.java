package de.fhb.stundenplanapp.manager;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import de.fhb.stundenplanapp.data.Fachbereich;
import de.fhb.stundenplanapp.data.Gruppe;
import de.fhb.stundenplanapp.data.Semester;
import de.fhb.stundenplanapp.data.Studiengang;
import de.fhb.stundenplanapp.data.Tag;
import de.fhb.stundenplanapp.data.Veranstaltung;

public class StundenPlanParser {
	
	private String url="http://informatik.fh-brandenburg.de/";
	private List<Fachbereich> fbs;
	private Studiengang st;
	private Semester se;
	private Gruppe gr;
	
	public StundenPlanParser(){
		fbs=new ArrayList<Fachbereich>();
		st=new Studiengang();
	}

	public List<Fachbereich> getFachbereiche() {
		try {
			URL u = new URL(url + "Stundenplan/ws1112/liste-zu.html");
			InputStream is = u.openStream();
			DataInputStream dis = new DataInputStream(new BufferedInputStream(is));
			findTable(dis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return fbs;
	}

	@SuppressWarnings("deprecation")
	private void findTable(DataInputStream in) throws IOException{
		Fachbereich fb=new Fachbereich();
		int hilf=1;
		fb.setName("Wirtschaft");
		String test=in.readLine();
		String speicher="";
		while (!((test.indexOf("<td")>-1)&&(test.indexOf("</td>")>-1))){
			test=in.readLine();
		}
		test=in.readLine();
		while (test!=null){
			if ((test.indexOf("<td")>-1)&&(test.indexOf("</td>")>-1)&&(test.indexOf("href")==-1)){
				fbs.add(fb);
				fb=new Fachbereich();
				if (hilf ==1){
					fb.setName("Informatik");
					hilf=2;
				} else {
					fb.setName("Technik");
				}
				
			}
			if ((test.indexOf("<td")>-1)&&(test.indexOf("</td>")>-1)&&(test.indexOf("href")>-1)){
				getStudiengang(test);
				fb.addStudiengaenge(st);
			}
			if ((test.indexOf("<td")>-1)&&(test.indexOf("</td>")<0)&&(test.indexOf("center")==-1)){
				speicher=test;
			}
			if ((test.indexOf("<td")<0)&&(test.indexOf("</td>")>-1)&&(test.indexOf("center")==-1)){
				speicher=speicher+test;
				getStudiengang(speicher);
				fb.addStudiengaenge(st);
				speicher="";
			}
			test=in.readLine();
		}
	}
	
	private void getStudiengang(String in) throws IOException{
		st=new Studiengang();
		int an,end;
		an=in.indexOf("<strong>");
		end=in.indexOf("</strong>");
		if((an > -1) && (end >-1)){
			//System.out.println(in.substring(an+8, end));
			st.setName(in.substring(an+8, end));
		}
		an=in.indexOf("href");
		end=in.indexOf("target");
		in=in.replace(' ', '#');
		if((an > -1) && (end >-1)){
			in=in.substring(an+6, end);
			end=in.lastIndexOf("l");
			st.setLink(in.substring(0, end+1));
			findSemester(in.substring(0, end+1));
		}
		
	}

	@SuppressWarnings("deprecation")
	private void findSemester(String inURL) throws IOException{
		
		se=new Semester();
		int an;
		URL u = new URL(url + inURL);
		InputStream is = u.openStream();
		DataInputStream in = new DataInputStream(new BufferedInputStream(is));
		
		String test=in.readLine();
		while (test!=null){
			if ((test.indexOf("href")>-1)&&(test.indexOf("Semester")>-1)){
				se=new Semester();
				an=test.indexOf("Semester");
				se.setName(test.substring(an-3,an+8));
				findGruppe(test+"1. Gruppe");
				st.addSemester(se);
			}
			if (test.indexOf("Gruppe")>-1){
				findGruppe(test);
			}
			if ((test.indexOf("Semester")>-1)&&(test.indexOf("href")==-1)){
				se=new Semester();
				st.addSemester(se);
				an=test.indexOf("Semester");
				test=test.substring(an-3,an+8);
				se.setName(test);
			}
			test=in.readLine();

		}
	}

	public void findGruppe(String inText){
		int an,end;
		gr=new Gruppe();
		an=inText.indexOf("Gruppe");
		gr.setName(inText.substring(an-3,an+6));
		an=inText.indexOf("href");
		end=inText.lastIndexOf("\"");
		gr.setLink(inText.substring(an+6,end));
		findPlan(gr.getLink());
		se.addGruppe(gr);
	}
	
	@SuppressWarnings("deprecation")
	public void findPlan(String link){
		List<Tag> tage=new ArrayList<Tag>();
		tage.add(new Tag("Montag"));
		tage.add(new Tag("Dienstag"));
		tage.add(new Tag("Mittwoch"));
		tage.add(new Tag("Donnerstag"));
		tage.add(new Tag("Freitag"));
		tage.add(new Tag("Samstag"));
		
		boolean beenden=false;
		String eingabe="";
		int uhrzeit;
		StringBuilder name;
		Veranstaltung veran=null;
		int begin=0,ende;
		
		try {
			URL u = new URL(url + link);
			InputStream is = u.openStream();
			DataInputStream dis = new DataInputStream(new BufferedInputStream(is));
			eingabe=dis.readLine();
			while ((eingabe.indexOf("</TR>")==-1)&&(!beenden)){
				if (eingabe.indexOf("</body>")>-1){
					beenden = true;
				} else {
				eingabe=dis.readLine();
				}
			}
			
			eingabe=dis.readLine();
			
			while (!beenden){
				if (eingabe.indexOf("</TABLE>")>-1){
					beenden=true;
				} else {
					if (eingabe.indexOf("</TH>")>-1){
						uhrzeit=Integer.parseInt(eingabe.substring(0, 2));
						for(int i=0; i<6;i++){
							eingabe=dis.readLine();
							if ((eingabe.indexOf("<TD")>-1) && (eingabe.indexOf("</TD>")==-1)){
								while ((eingabe.indexOf("<TD")>-1) && (eingabe.indexOf("</TD>")==-1)){
									eingabe = eingabe + dis.readLine();
								}
							}
							if ((eingabe.indexOf("bgcolor")>-1) && (eingabe.indexOf("<br>")>-1)){  //bgcolor
								veran=new Veranstaltung();
								veran.setBegin(uhrzeit);
								veran.setEnde(uhrzeit+1);
								ende=eingabe.indexOf("<br>");
								name=new StringBuilder(eingabe.substring(0, ende));
								while(name.indexOf("<")>-1){
									name.delete(name.indexOf("<"), name.indexOf(">")+1);
								}
								veran.setName(name.toString());
								begin=ende+4;
								ende= eingabe.indexOf("</font>");
								veran.setBemerkung(eingabe.substring(begin,ende));
								tage.get(i).addVeranstaltung(veran);	
							}
							if ((eingabe.indexOf("bgcolor")>-1)&& eingabe.indexOf("<br>")==-1){
								veran=new Veranstaltung();
								veran.setBegin(uhrzeit);
								veran.setEnde(uhrzeit+1);
								name=new StringBuilder(eingabe);
								while(name.indexOf("<")>-1){
									name.delete(name.indexOf("<"), name.indexOf(">")+1);
								}
								veran.setName(name.toString());
								tage.get(i).addVeranstaltung(veran);	
							}
							if (eingabe.length()==0){
								tage.get(i).getVeranstaltungen().get(tage.get(i).getVeranstaltungen().size()-1).nextEnde();							
							}
						}
					}
					eingabe=dis.readLine();
				}
			}		
		gr.setTage(tage);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}