package com.siolabs.tambola;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;

import entities.Round;
import entities.Score;
import entities.User;
import static com.siolabs.tambola.OfyService.ofy;
import javax.servlet.http.*;




public class Logout extends HttpServlet {
	
	
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws IOException {
		HttpSession session = req.getSession();
		//Round r=ofy().load().type(Round.class).id("one").get();
		String email= (String) session.getAttribute("email");
		Score u = ofy().load().type(Score.class).id(email).get();
		int po=u.points;
		//ofy().delete().entity(u);
		session.invalidate();
		System.out.print("in logout ");
		 resp.sendRedirect("/thanks.jsp?score="+po);
	}

}
	