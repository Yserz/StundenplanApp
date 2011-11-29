package de.fhb.stundenplanapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

import de.fhb.stundenplanapp.data.Fachbereich;
import de.fhb.stundenplanapp.data.Gruppe;
import de.fhb.stundenplanapp.data.Semester;
import de.fhb.stundenplanapp.data.Studiengang;
import de.fhb.stundenplanapp.data.Tag;
import de.fhb.stundenplanapp.data.Veranstaltung;
import de.fhb.stundenplanapp.manager.StundenPlanParser;

/**
 *
 * @author MacYser
 */
@WebServlet(name = "JSONServlet", urlPatterns = {"/JSONServlet"})
public class JSONServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSONObject root;

	/** 
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		try {
			
			try {
				/**
				 * root.put("date", new Date(System.currentTimeMillis()));
				root.put("url", "http://test.de/");
				root.put("name", "StundenplanApp");
				
				
				JSONObject fachbereich = new JSONObject();
				fachbereich.put("name", "Informatik");
				fachbereich.put("url", "http://test.de/informatik");
				
				JSONObject semester = new JSONObject();
				semester.put("name", "1. Semester");
				semester.put("url", "http://test.de/informatik/1/");
				
				JSONObject gruppe = new JSONObject();
				gruppe.put("name", "Gruppe 1");
				gruppe.put("url", "http://test.de/informatik/1/g1");
				
				JSONObject tag = new JSONObject();
				tag.put("name", "Montag");
				tag.put("anzKurse", 1);
				
				JSONObject kurs = new JSONObject();
				kurs.put("name", "Java Enterprise Application");
				kurs.put("url", "http://test.de/informatik/1/g1/jee");
				kurs.put("dozent", "Stefan Pratsch");
				kurs.put("raum", "223");
				kurs.put("startTime", "8:00");
				kurs.put("endTime", "12:00");
				tag.put("leaf", true);

				tag.append("items", kurs);
				gruppe.append("items", tag);
				semester.append("items", gruppe);
				fachbereich.append("items",semester);
				
				root.append("items", fachbereich);
				
				fachbereich = new JSONObject();
				fachbereich.put("name", "BWL2");
				fachbereich.put("url", "http://test.de/bwl");
				
				semester = new JSONObject();
				semester.put("name", "1. Semester");
				semester.put("url", "http://test.de/bwl/1/");
				
				gruppe = new JSONObject();
				gruppe.put("name", "Gruppe 1");
				gruppe.put("url", "http://test.de/bwl/1/g1");
				
				tag = new JSONObject();
				tag.put("name", "Montag");
				tag.put("anzKurse", 1);
				
				kurs = new JSONObject();
				kurs.put("name", "BWL");
				kurs.put("url", "http://test.de/bwl/1/g1/jee");
				kurs.put("dozent", "Herr Görmer");
				kurs.put("raum", "223");
				kurs.put("startTime", "8:00");
				kurs.put("endTime", "12:00");
				tag.put("leaf", true);

				tag.append("items", kurs);
				gruppe.append("items", tag);
				semester.append("items", gruppe);
				fachbereich.append("items",semester);
				
				root.append("items", fachbereich);
				 
				//root.put("date", new Date(System.currentTimeMillis()));
				//root.put("url", "http://test.de/");
				
				*/
				/*
				JSONObject fachbereich = new JSONObject();
				fachbereich.put("name", "Informatik");
				fachbereich.put("model", "Fachbereich");
				fachbereich.put("url", "http://test.de/informatik");
				fachbereich.put("leaf", false);
				
				JSONObject semester = new JSONObject();
				semester.put("name", "1. Semester");
				semester.put("model", "Semester");
				semester.put("url", "http://test.de/informatik/1/");
				semester.put("leaf", false);
				
				JSONObject gruppe = new JSONObject();
				gruppe.put("name", "Gruppe 1");
				gruppe.put("model", "Gruppe");
				gruppe.put("url", "http://test.de/informatik/1/g1");
				gruppe.put("leaf", false);
				
				JSONObject tag = new JSONObject();
				tag.put("name", "Montag");
				tag.put("model", "Tag");
				tag.put("anzKurse", 1);
				tag.put("leaf", false);
				
				JSONObject kurs2 = new JSONObject();
				kurs2.put("name", "BWL");
				kurs2.put("model", "Kurs");
				kurs2.put("url", "http://test.de/informatik/1/g1/bwl");
				kurs2.put("dozent", "Herr Görmer");
				kurs2.put("raum", "223");
				kurs2.put("startTime", "1200");
				kurs2.put("endTime", "14:00");
				kurs2.put("leaf", true);
				
				tag.append("items", kurs2);
				
				JSONObject kurs3 = new JSONObject();
				kurs3.put("name", "Programmieren I");
				kurs3.put("model", "Kurs");
				kurs3.put("url", "http://test.de/informatik/1/g1/p1");
				kurs3.put("dozent", "Frau Schmidt");
				kurs3.put("raum", "223");
				kurs3.put("startTime", "500");
				kurs3.put("endTime", "14:00");
				kurs3.put("leaf", true);
				
				tag.append("items", kurs3);
				
				JSONObject kurs = new JSONObject();
				kurs.put("name", "Java Enterprise Application");
				kurs.put("model", "Kurs");
				kurs.put("url", "http://test.de/informatik/1/g1/jee");
				kurs.put("dozent", "Stefan Pratsch");
				kurs.put("raum", "223");
				kurs.put("startTime", "800");
				kurs.put("endTime", "12:00");
				kurs.put("leaf", true);

				tag.append("items", kurs);
				
				
				gruppe.append("items", tag);
				semester.append("items", gruppe);
				fachbereich.append("items",semester);
				
				root.append("items", fachbereich);
				
				fachbereich = new JSONObject();
				fachbereich.put("name", "BWL2");
				fachbereich.put("model", "Fachbereich");
				fachbereich.put("url", "http://test.de/bwl");
				fachbereich.put("leaf", false);
				
				semester = new JSONObject();
				semester.put("name", "1. Semester");
				semester.put("model", "Semester");
				semester.put("url", "http://test.de/bwl/1/");
				semester.put("leaf", false);
				
				gruppe = new JSONObject();
				gruppe.put("name", "Gruppe 1");
				gruppe.put("model", "Gruppe");
				gruppe.put("url", "http://test.de/bwl/1/g1");
				gruppe.put("leaf", false);
				
				tag = new JSONObject();
				tag.put("name", "Montag");
				tag.put("model", "Tag");
				tag.put("anzKurse", 1);
				tag.put("leaf", false);
				
				kurs = new JSONObject();
				kurs.put("name", "BWL");
				kurs.put("model", "Kurs");
				kurs.put("url", "http://test.de/bwl/1/g1/jee");
				kurs.put("dozent", "Herr Görmer");
				kurs.put("raum", "223");
				kurs.put("startTime", "8:00");
				kurs.put("endTime", "12:00");
				kurs.put("leaf", true);

				tag.append("items", kurs);
				gruppe.append("items", tag);
				semester.append("items", gruppe);
				fachbereich.append("items",semester);
				
				root.append("items", fachbereich);
				//json.append("comment", new JSONObject(comment));
				*/
		
				if (root == null){
					getStundenplanJSON();
				}
				
			} catch (JSONException e) {
				//Konnte JSON nicht packen!
				e.printStackTrace();
			}
				
			
			
			try {
				//forward(req, resp, "/snippet.jsp");
				response.getWriter().println(root);
			} catch (IOException e) {
				//Konnte JSON nicht senden!
			}
		} finally {			
			response.getWriter().close();
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/** 
	 * Handles the HTTP <code>GET</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/** 
	 * Handles the HTTP <code>POST</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/** 
	 * Returns a short description of the servlet.
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
	
	public void getStundenplanJSON() throws JSONException{
		List<Fachbereich> fbs = new StundenPlanParser().getFachbereiche();
		
		JSONObject fachbereich;
		JSONObject studiengang;
		JSONObject semester;
		JSONObject gruppe;
		JSONObject tag;
		JSONObject veranstaltung;
		
		root = new JSONObject();
		
		System.out.println(fbs.get(2));
		
		for (Fachbereich fb : fbs) {
			fachbereich = new JSONObject();
			fachbereich.put("name", fb.getName());
			fachbereich.put("leaf", false);
			for (Studiengang st : fb.getStudiengaenge()) {
				studiengang = new JSONObject();
				studiengang.put("name", st.getName());
				studiengang.put("model", "Studiengang");
				studiengang.put("leaf", false);
				studiengang.put("link", st.getLink());
				for (Semester se : st.getSemester()) {
					semester = new JSONObject();
					semester.put("name", se.getName());
					semester.put("model", "Semester");
					semester.put("leaf", false);
					if (se.getGruppen().size()>1){
						for (Gruppe gr : se.getGruppen()) {
							gruppe = new JSONObject();
							gruppe.put("name", gr.getName());
							gruppe.put("model", "Gruppe");
							gruppe.put("leaf", false);
							gruppe.put("link", gr.getLink());
							for (Tag ta : gr.getTage()) {
								tag = new JSONObject();
								tag.put("name", ta.getWochentag());
								tag.put("model", "Tag");
								if (ta.getVeranstaltungen().isEmpty()){
									tag.put("leaf", true);
								} else {
									tag.put("leaf", false);
									for (Veranstaltung ver : ta.getVeranstaltungen()) {
										veranstaltung = new JSONObject();
										veranstaltung.put("name", ver.getName());
										veranstaltung.put("model", "Kurs");
										veranstaltung.put("leaf", true);
										veranstaltung.put("bemerkung", ver.getBemerkung());
										veranstaltung.put("startTime", ver.getStartTime());
										veranstaltung.put("endTime", ver.getEndTime());
										tag.append("items", veranstaltung);
									}
								gruppe.append("items", tag);
								}
							}
							semester.append("items", gruppe);
						} 
					} else {
						for (Tag ta : se.getGruppen().get(0).getTage()) {
							tag = new JSONObject();
							tag.put("name", ta.getWochentag());
							tag.put("model", "Tag");
							if (ta.getVeranstaltungen().isEmpty()){
								tag.put("leaf", true);
							} else {
								tag.put("leaf", false);
								for (Veranstaltung ver : ta.getVeranstaltungen()) {
									veranstaltung = new JSONObject();
									veranstaltung.put("name", ver.getName());
									veranstaltung.put("model", "Kurs");
									veranstaltung.put("leaf", true);
									veranstaltung.put("bemerkung", ver.getBemerkung());
									veranstaltung.put("startTime", ver.getStartTime());
									veranstaltung.put("endTime", ver.getEndTime());
									tag.append("items", veranstaltung);
								}
							semester.append("items", tag);
							}
						}
					}
					studiengang.append("items", semester);
				}
				fachbereich.append("items", studiengang);
			}
			root.append("items", fachbereich);
		}
		
	}
	
}
