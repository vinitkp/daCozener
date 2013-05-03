package entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;

@Entity
public class Round {
	@Id @Index String ide="one";
	
	//public String name;
	public int rou;
	
	// no arg constructor so that it can be used by objectify 
	public Round(){
		rou=1;
	}
	
	
	

}