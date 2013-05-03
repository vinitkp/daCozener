package entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;

@Entity
public class Score {
	@Id @Index String email;
	
	//public String name;
	public int points=0;
	
	// no arg constructor so that it can be used by objectify 
	public Score(){
		
	}
	
	public Score(String email, int points){
		this.email = email;
		this.points=points;
		
		
	}
	

}
