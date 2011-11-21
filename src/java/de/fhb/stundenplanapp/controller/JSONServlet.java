/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.stundenplanapp.controller;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author MacYser
 */
@WebServlet(name = "JSONServlet", urlPatterns = {"/JSONServlet"})
public class JSONServlet extends HttpServlet {

	/** 
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			JSONObject root = new JSONObject();
			
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
				 */
				root.put("date", new Date(System.currentTimeMillis()));
				root.put("url", "http://test.de/");
				
				
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

				tag.append("kurs", kurs);
				gruppe.append("tag", tag);
				semester.append("gruppe", gruppe);
				fachbereich.append("smester",semester);
				
				root.append("data", fachbereich);
				
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

				tag.append("kurs", kurs);
				gruppe.append("tag", tag);
				semester.append("gruppe", gruppe);
				fachbereich.append("semester",semester);
				
				root.append("data", fachbereich);
				//json.append("comment", new JSONObject(comment));
			} catch (JSONException e) {
				//Konnte JSON nicht packen!
			}
				
			
			response.setContentType("application/json");
			try {
				//forward(req, resp, "/snippet.jsp");
				System.out.println(root);
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
}
