package com.siolabs.tambola;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

import entities.Score;
import entities.User;
import entities.Round;
import entities.House;
import static com.siolabs.tambola.OfyService.ofy;


public class GameStart extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws IOException {
		HttpSession sess=req.getSession();
		Round r=ofy().load().type(Round.class).id("one").get();
		//String email= (String) sess.getAttribute("email");
		//Score u = ofy().load().type(Score.class).id(email).get();
		
		
		System.out.println("in startgame");
		sess.setAttribute("round1gen", 0);
		sess.setAttribute("round2gen", 0);
		sess.setAttribute("round3gen", 0);
		sess.setAttribute("round4gen", 0);
		sess.setAttribute("round5gen", 0);
		sess.setAttribute("round6gen", 0);
		
		if(r==null)
		{
			r=new Round();
			ofy().save().entity(r);
			sess.setAttribute("round", 1);
			
			resp.sendRedirect("/auth/game.jsp");
			
			System.out.println("round created");
		}
		else
		{
			sess.setAttribute("round", r.rou);
			
			if(r.rou==2)
			{
			sess.setAttribute("round1gen", 1);
			//sess.setAttribute("round2gen", 1);
			}
			else if(r.rou==3)
			{
			sess.setAttribute("round1gen", 1);
			sess.setAttribute("round2gen", 1);
			//sess.setAttribute("round3gen", 1);
			}
			else if(r.rou==4)
			{
			sess.setAttribute("round1gen", 1);
			sess.setAttribute("round2gen", 1);
			sess.setAttribute("round3gen", 1);
			//sess.setAttribute("round4gen", 1);
			}
			else if(r.rou==5)
			{
			sess.setAttribute("round1gen", 1);
			sess.setAttribute("round2gen", 1);
			sess.setAttribute("round3gen", 1);
			sess.setAttribute("round4gen", 1);
			}
			else if(r.rou==6)
			{
			sess.setAttribute("round1gen", 1);
			sess.setAttribute("round2gen", 1);
			sess.setAttribute("round3gen", 1);
			sess.setAttribute("round4gen", 1);
			sess.setAttribute("round5gen", 1);
			}
			House h=ofy().load().type(House.class).id(r.rou).get();
			if(h!=null)
			{
			h=new House(r.rou);
			ofy().save().entity(h);
			resp.sendRedirect("/auth/game.jsp");
		}
			
		
			
		}
		}
		
		
		
		
		
		
}


