package com.siolabs.tambola;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import entities.User;
import entities.Score;
import entities.House;
import entities.Round;
import static com.siolabs.tambola.OfyService.ofy;
import javax.servlet.http.*;




public class Core extends HttpServlet {
	
	//Objectify ofy = ObjectifyService.begin();
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws IOException {
		HttpSession session = req.getSession();
		String email=(String)session.getAttribute("email");
		String ind = req.getParameter("ind");
		Score u = ofy().load().type(Score.class).id(email).get();
		
		House h=ofy().load().type(House.class).id((Integer)session.getAttribute("round")).get();
		if(h==null)
		{
			int x=(int)session.getAttribute("round");
			h=new House(x);
		}
		int idx = Integer.parseInt(ind);
		System.out.println("in core");
		Integer numbers=0;
		if(idx==1){//toprow
			//System.out.println("in if core");
			if(h.toprow==false)
			{
				numbers=1;//toprow not claimed
				h.toprow=true;
				h.topwin=email;
				ofy().save().entity(h);
				
				if(u!=null)
				{
				u.points=u.points+20;// top row;
				ofy().save().entity(u);
				}else
				{
				u=new Score(email,20);
				ofy().save().entity(u);
				System.out.println("writen");
				
				
				}
			
			}else
			{
				
				numbers=2;//toprow already claimed
			}
		}
		else if(idx==2){//toprow
			//System.out.println("in if core");
			if(h.middlerow==false)
			{
				numbers=1;//middlerow not claimed
				h.middlerow=true;
				h.midwin=email;
				ofy().save().entity(h);
				
				if(u!=null)
				{
				u.points=u.points+20;// top row;
				ofy().save().entity(u);
				}else
				{
				u=new Score(email,20);
				ofy().save().entity(u);
				System.out.println("writen");
				
				
				}
			
			}else
			{
				
				numbers=2;//middlerow already claimed
			}
		}
		else if(idx==3){//toprow
			//System.out.println("in if core");
			if(h.bottomrow==false)
			{
				numbers=1;//bottomrow not claimed
				h.bottomrow=true;
				h.botwin=email;
				ofy().save().entity(h);
				
				if(u!=null)
				{
				u.points=u.points+20;// bottom row;
				ofy().save().entity(u);
				}else
				{
				u=new Score(email,20);
				ofy().save().entity(u);
				System.out.println("writen");
				
				
				}
			
			}else
			{
				
				numbers=2;//toprow already claimed
			}
		}
		else if(idx==4){//toprow
			//System.out.println("in if core");
			if(h.fullhouse==false)
			{
				numbers=1;//toprow not claimed
				h.fullhouse=true;
				h.fulwin=email;
				
				h.bottomrow=false;
				h.toprow=false;
				h.middlerow=false;
				ofy().save().entity(h);
				
				if(u!=null)
				{
				u.points=u.points+50;// top row;
				ofy().save().entity(u);
				}else
				{
				u=new Score(email,50);
				ofy().save().entity(u);
				System.out.println("writen");
				
				
				}
			
			}else
			{
				
				numbers=2;//toprow already claimed
			}
		}else if(idx==6){
			//ofy().delete().type(House.class).id("one");
			//ifm round<=3 then aage badho
			Round r=ofy().load().type(Round.class).id("one").get();
			r.rou=r.rou+1;
			ofy().save().entity(r);
			
			if(r.rou>6)
			{
				//ofy().delete().type(Round.class).id("one");
				
				int po=u.points;
				numbers=2;
				//ofy().delete().entity(u);
				//session.invalidate();
				//resp.sendRedirect("/thanks.jsp?score="+po);
				
				//TODO logout decalare the winner .. say thanks...... 
			}
			else{
				session.setAttribute("round",r.rou);
				numbers=1;
				//resp.sendRedirect("/auth/game.jsp");
			}
				
			
			
			
		}else if(idx==7){
			if(h.fullhouse)
				{
				numbers=1;
				Round r=ofy().load().type(Round.class).id("one").get();
				r.rou=r.rou+1;
				ofy().save().entity(r);
				
				
				
				
				}
			else
				numbers=2;
		}
		if(numbers!=0)
		{
		PrintWriter out = resp.getWriter();
		out.println(numbers.toString());
		out.close();
		}
		
		if(idx==8){
			//ofy().delete().type(House.class).id("one");
			//ifm round<=3 then aage badho
			//House r=ofy().load().type(House.class).id("one").get();
			//r.rou=r.rou+1;
			//ofy().save().entity(r);
			String x="still to be won";
			if(h.toprow)
			{
				x=h.topwin;
			}
			PrintWriter out = resp.getWriter();
			out.println(x);
			out.close();
		}
		else if(idx==9){
			//ofy().delete().type(House.class).id("one");
			//ifm round<=3 then aage badho
			//House r=ofy().load().type(House.class).id("one").get();
			//r.rou=r.rou+1;
			//ofy().save().entity(r);
			String x="still to be won";
			if(h.middlerow)
			{
				x=h.midwin;
			}
			PrintWriter out = resp.getWriter();
			out.println(x);
			out.close();
		}
		
		else if(idx==10){
			//ofy().delete().type(House.class).id("one");
			//ifm round<=3 then aage badho
			//House r=ofy().load().type(House.class).id("one").get();
			//r.rou=r.rou+1;
			//ofy().save().entity(r);
			String x="still to be won";
			if(h.bottomrow)
			{
				x=h.botwin;
			}
			PrintWriter out = resp.getWriter();
			out.println(x);
			out.close();
		}
		
		else if(idx==11){
			//ofy().delete().type(House.class).id("one");
			//ifm round<=3 then aage badho
			//House r=ofy().load().type(House.class).id("one").get();
			//r.rou=r.rou+1;
			//ofy().save().entity(r);
			
			PrintWriter out = resp.getWriter();
			out.println(Integer.toString(u.points));
			out.close();
		}
		
		
	}

}
	