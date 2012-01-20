package de.fhb.stundenplanapp.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.Schedule;
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
		
				if (root == null){
					getStundenplanJSON();
				}
				
			} catch (JSONException e) {
				//Konnte JSON nicht packen!
				e.printStackTrace();
			}
				
			
			
			try {
				//forward(req, resp, "/snippet.jsp");
				response.setCharacterEncoding("utf-8");
				response.getWriter().println(root);
			} catch (IOException e) {
				//Konnte JSON nicht senden!
			}
		} finally {
			if (response.getWriter()!=null) {
				response.getWriter().close();
			}
			
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
	
	@Schedule(minute="0", hour="8")
	public void getStundenplanJSON() throws JSONException{
		List<Fachbereich> fbs = new StundenPlanParser().getFachbereiche();
		
		JSONObject fachbereich;
		JSONObject studiengang;
		JSONObject semester;
		JSONObject gruppe;
		JSONObject tag;
		JSONObject veranstaltung;
		
		int anzahl=0;
		
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
							List<Tag> tage=se.getGruppen().get(0).getTage();
							for (Tag tag2 : tage) {
								anzahl=anzahl + tag2.getVeranstaltungen().size();
								System.out.println(anzahl);
							}
							if (anzahl > 0) {
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
							} else {
								System.out.println("bla");
								veranstaltung = new JSONObject();
								veranstaltung.put("name", "kein Stundenplan vorhanden");
								veranstaltung.put("model", "Gruppe");
								veranstaltung.put("leaf", true);
								gruppe.append("items", veranstaltung);
							}
							anzahl=0;
							semester.append("items", gruppe);
						} 
					} else {
						List<Tag> tage=se.getGruppen().get(0).getTage();
						for (Tag tag2 : tage) {
							anzahl=anzahl + tag2.getVeranstaltungen().size();
							System.out.println(anzahl);
						}
						if (anzahl > 0) {
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
						} else {
							System.out.println("bla");
							veranstaltung = new JSONObject();
							veranstaltung.put("name", "kein Stundenplan vorhanden");
							veranstaltung.put("model", "Gruppe");
							veranstaltung.put("leaf", true);

							semester.append("items", veranstaltung);	
						}
						anzahl=0;
					}
					studiengang.append("items", semester);
				}
				fachbereich.append("items", studiengang);
			}
			root.append("items", fachbereich);
		}
		
	}
	
}
